package cc.tianxun.mchatsx;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Globals {
    public static FileConfiguration dataconfig;
    public static File datafile = new File(Main.getProvidingPlugin(Main.class).getDataFolder(), "prefixs.yml");
    static {
        dataconfig = YamlConfiguration.loadConfiguration(datafile);
    }
    public static Plugin getMainPlugin() {
        return Main.getProvidingPlugin(Main.class);
    }
    public static FileConfiguration getMainConfig() {
        return Main.getProvidingPlugin(Main.class).getConfig();
    }
    public static FileConfiguration getDataConfig() {
        return dataconfig;
    }
}