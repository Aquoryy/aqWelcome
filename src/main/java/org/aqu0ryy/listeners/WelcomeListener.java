package org.aqu0ryy.listeners;

import org.aqu0ryy.Loader;
import org.aqu0ryy.utils.ChatUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class WelcomeListener implements Listener {

    @EventHandler
    public void onWelcome(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (String line : Loader.getInst().getConfig().getStringList("welcome-message")) {
            line = line.replace("{player}", player.getName());
            ChatUtil.sendMessage(player, line);
        }

        String[] sound = Objects.requireNonNull(Loader.getInst().getConfig().getString("sound")).split(" ");
        player.playSound(player.getLocation(), Sound.valueOf(sound[0]), Float.parseFloat(sound[1]), Float.parseFloat(sound[2]));
    }
}
