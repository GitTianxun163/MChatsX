/*    */ package cc.tianxun.mchatsx.Listeners;
/*    */ 
/*    */ import cc.tianxun.mchatsx.Globals;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerJoinEvent;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ public class PlayerListeners
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onPlayerJoin(PlayerJoinEvent event) {
/* 15 */     FileConfiguration dconfig = Globals.getDataConfig();
/* 16 */     FileConfiguration config = Globals.getMainConfig();
/* 17 */     StringBuilder msg = new StringBuilder("§e欢迎 ");
/*    */     
/* 19 */     if (dconfig.get(event.getPlayer().getName()) != null) {
/* 20 */       msg.append(config.get("title_prefix"));
/* 21 */       msg.append(dconfig.get(event.getPlayer().getName()));
/* 22 */       msg.append(config.get("title_suffix"));
/*    */     } 
/* 24 */     msg.append(event.getPlayer().getName());
/* 25 */     msg.append(" §r§e游玩服务器");
/* 26 */     event.setJoinMessage(msg.toString());
/*    */   }
/*    */   @EventHandler
/*    */   public void onPlayerQuit(PlayerQuitEvent event) {
/* 30 */     FileConfiguration dconfig = Globals.getDataConfig();
/* 31 */     FileConfiguration config = Globals.getMainConfig();
/* 32 */     StringBuilder msg = new StringBuilder();
/*    */     
/* 34 */     if (dconfig.get(event.getPlayer().getName()) != null) {
/* 35 */       msg.append(config.get("title_prefix"));
/* 36 */       msg.append(dconfig.get(event.getPlayer().getName()));
/* 37 */       msg.append(config.get("title_suffix"));
/*    */     } 
/* 39 */     msg.append(event.getPlayer().getName());
/* 40 */     msg.append(" §r§e离开了服务器");
/* 41 */     event.setQuitMessage(msg.toString());
/*    */   }
/*    */ }


/* Location:              E:\Data\插件\MChatsX-1.1.1.jar!\cc\tianxun\mchatsx\Listeners\PlayerListeners.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */