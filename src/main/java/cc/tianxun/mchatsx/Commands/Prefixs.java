package cc.tianxun.mchatsx.Commands;
import cc.tianxun.mchatsx.Globals;
import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Prefixs implements CommandExecutor, TabExecutor {
    private static final HashMap<String, String> colors = new HashMap<>();
    static {
        colors.put("black", "§0");
        colors.put("blue", "§1");
        colors.put("green", "§2");
        colors.put("bright-blue", "§3");
        colors.put("red", "§4");
        colors.put("purple", "§5");
        colors.put("yellow", "§6");
        colors.put("argent", "§7");
        colors.put("gray", "§8");
        colors.put("deep-blue", "§9");
        colors.put("deep-green", "§a");
        colors.put("sky-blue", "§b");
        colors.put("bright-red", "§c");
        colors.put("deep-purple", "§d");
        colors.put("gold", "§e");
        colors.put("white", "§f");
        colors.put("no-style", "§r");
        colors.put("bold", "§l");
        colors.put("deleted", "§m");
        colors.put("underlined", "§n");
        colors.put("italic", "§o");
    }
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        FileConfiguration config = Globals.getDataConfig();

        if (label.equals("setprefix")) {
            if (args.length < 2) {
                return false;
            }
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                commandSender.sendMessage("Didn't find the player");
                return true;
            }
            StringBuilder new_title = new StringBuilder();
            for (int i = 2; i < args.length; i++) {
                if (colors.get(args[i]) == null) {
                    commandSender.sendMessage("§l§4错误的颜色: §n", args[i]);
                }
                new_title.append(colors.get(args[i]));
            }
            new_title.append(args[1]);
            config.set(args[0], new_title.toString());
        }

        if (label.equals("setmyprefix")) {
            if (args.length < 1) {
                return false;
            }
            if (commandSender instanceof Player) {
                Player player = (Player)commandSender;
                StringBuilder new_title = new StringBuilder();

                // 屏蔽词
                if (!player.isOp()) for (String word : config.getStringList("shield_words")) {
                    if (args[0].matches(String.format("*%s*",word))) {
                        player.sendMessage("§l§4涉嫌屏蔽词");
                        return true;
                    }
                }

                for (int i = 1; i < args.length; i++) {
                    if (colors.get(args[i]) == null) {
                        player.sendMessage("§l§4错误的颜色: §n", args[i]);
                    }
                    new_title.append(colors.get(args[i]));
                }
                new_title.append(args[0]);
                config.set(player.getName(), new_title.toString());
            }
            else {
                commandSender.sendMessage("You can't use the command.");
            }
        }
        return true;
    }
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tabs = new ArrayList<>();
        if (label.equals("setprefix")) {
            switch (args.length) {
				case 0: break;
                case 1:
                    if (Bukkit.isWhitelistEnforced()) {
                        for (OfflinePlayer player : Bukkit.getWhitelistedPlayers()) {
                            tabs.add(player.getName());
                        }
                        break;
                    }
                    for (OfflinePlayer player : Bukkit.getWhitelistedPlayers()) {
                        tabs.add(player.getName());
                    }
				break;

                case 2: tabs.add(Globals.getDataConfig().getString(sender.getName()));break;
                default: tabs.addAll(colors.keySet());break;
			}

        }
        if (label.equals("setmyprefix")) {
            switch (args.length) {
                case 0: break;
                case 1: tabs.add(Globals.getDataConfig().getString(sender.getName()));break;
            }
            tabs.addAll(colors.keySet());
        }
		return tabs;
    }
}
