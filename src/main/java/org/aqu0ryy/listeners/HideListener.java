package org.aqu0ryy.listeners;

import org.aqu0ryy.Loader;
import org.bukkit.GameRule;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.WorldLoadEvent;

public class HideListener implements Listener {

    private static final FileConfiguration config = Loader.getInst().getConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (config.getBoolean("hide-stream")) {
            event.joinMessage(null);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (config.getBoolean("hide-stream")) {
            event.quitMessage(null);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (config.getBoolean("hide-stream")) {
            event.deathMessage(null);
        }
    }

    @EventHandler
    public void onAchive(WorldLoadEvent event) {
        if (config.getBoolean("hide-stream")) {
            event.getWorld().setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        }
    }
}
