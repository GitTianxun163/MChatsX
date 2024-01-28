package cc.tianxun.mchatsx;
import cc.tianxun.mchatsx.Commands.Prefixs;
import cc.tianxun.mchatsx.Listeners.Chats;
import cc.tianxun.mchatsx.Listeners.PlayerListeners;
import java.io.IOException;
import java.util.Objects;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public void onEnable() {
        saveDefaultConfig();
        saveResource("prefixs.yml", false);

        Prefixs cmd_prefixs = new Prefixs();
        Objects.requireNonNull(getCommand("setprefix")).setExecutor(cmd_prefixs);
        Objects.requireNonNull(getCommand("setprefix")).setTabCompleter(cmd_prefixs);
        Objects.requireNonNull(getCommand("setmyprefix")).setExecutor(cmd_prefixs);
        Objects.requireNonNull(getCommand("setmyprefix")).setTabCompleter(cmd_prefixs);
        getServer().getPluginManager().registerEvents(new Chats(), this);
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);

        System.out.println("Plugin enabled.");
    }
    public void onDisable() {
        saveConfig();
        try {
            Globals.getDataConfig().save(Globals.datafile);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Plugin disabled.");
    }
}
