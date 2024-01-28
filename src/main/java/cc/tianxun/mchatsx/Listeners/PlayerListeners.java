package cc.tianxun.mchatsx.Listeners;

import cc.tianxun.mchatsx.Globals;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
		FileConfiguration dconfig = Globals.getDataConfig();
		FileConfiguration config = Globals.getMainConfig();
		StringBuilder msg = new StringBuilder("§e欢迎 ");

		if (dconfig.get(event.getPlayer().getName()) != null) {
			msg.append(config.get("title_prefix"));
			msg.append(dconfig.get(event.getPlayer().getName()));
			msg.append(config.get("title_suffix"));
		}
		msg.append(event.getPlayer().getName());
		msg.append(" §r§e游玩服务器");
		event.setJoinMessage(msg.toString());
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		FileConfiguration dconfig = Globals.getDataConfig();
		FileConfiguration config = Globals.getMainConfig();
		StringBuilder msg = new StringBuilder();

		if (dconfig.get(event.getPlayer().getName()) != null) {
			msg.append(config.get("title_prefix"));
			msg.append(dconfig.get(event.getPlayer().getName()));
			msg.append(config.get("title_suffix"));
		}
		msg.append(event.getPlayer().getName());
		msg.append(" §r§e离开了服务器");
		event.setQuitMessage(msg.toString());
	}
}
