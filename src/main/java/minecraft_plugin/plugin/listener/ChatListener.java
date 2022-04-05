package minecraft_plugin.plugin.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

        if(player.isOp()){
            event.setFormat(ChatColor.RED + "[OP] " + "%1$s: " + "%2$s");
        }else{
            event.setFormat(ChatColor.DARK_GRAY +"[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA + "%1$s: " + ChatColor.DARK_GRAY + "%2$s");
        }
    }
}
