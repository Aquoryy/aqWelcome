package org.aqu0ryy;

import org.aqu0ryy.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Commands implements CommandExecutor, TabCompleter {

    private static final FileConfiguration config = Loader.getInst().getConfig();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
                             @NotNull String[] args) {
        if (sender.hasPermission("aqwelcome.admin")) {
            if (args.length != 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    Loader.getInst().reloadConfig();
                    Loader.getInst().saveConfig();
                    ChatUtil.sendMessage(sender, config.getString("commands.reload.success"));
                } else {
                    ChatUtil.sendMessage(sender, config.getString("messages.no-arg"));
                }
            } else {
                for (String line : config.getStringList("messages.help")) {
                    line = line.replace("{label}", label);
                    ChatUtil.sendMessage(sender, line);
                }
            }
        } else {
            ChatUtil.sendMessage(sender, config.getString("messages.no-permission"));
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            if (sender.hasPermission("aqwelcome.admin")) {
                list.add("reload");
            }
            return list;
        }
        return null;
    }
}
