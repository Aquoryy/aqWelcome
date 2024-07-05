package org.aqu0ryy;

import org.aqu0ryy.listeners.HideListener;
import org.aqu0ryy.listeners.WelcomeListener;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Loader extends JavaPlugin {

    private static Loader inst;

    @Override
    public void onEnable() {
        inst = this;
        saveDefaultConfig();

        loadListeners();
        loadCommands();
        loadCompleter();
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
    }

    public static Loader getInst() {
        return inst;
    }

    public void loadListeners() {
        Bukkit.getPluginManager().registerEvents(new WelcomeListener(), this);
        Bukkit.getPluginManager().registerEvents(new HideListener(), this);
    }

    public void loadCommands() {
        getCommand("aqwelcome").setExecutor(new Commands());
    }

    public void loadCompleter() {
        getCommand("aqwelcome").setTabCompleter(new Commands());
    }
}
