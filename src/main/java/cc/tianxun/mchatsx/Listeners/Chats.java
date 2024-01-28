package cc.tianxun.mchatsx.Listeners;
import cc.tianxun.mchatsx.Globals;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerChatEvent;

public class Chats implements Listener {
   @EventHandler
   public void onPlayerChat(PlayerChatEvent event) {
	   FileConfiguration dconfig = Globals.getDataConfig();
	   FileConfiguration config = Globals.getMainConfig();
	   StringBuilder msg = new StringBuilder();

	   if (dconfig.get(event.getPlayer().getName()) != null) {
       		msg.append(config.get("title_prefix"));
       		msg.append(dconfig.get(event.getPlayer().getName()));
       		msg.append(config.get("title_suffix"));
	   }
	   msg.append(config.getString("chat_format")
			   .replace("{username}", event.getPlayer().getName())
			   .replace("{msg}", event.getMessage()));

	   event.setFormat(msg.toString());
	}
}
