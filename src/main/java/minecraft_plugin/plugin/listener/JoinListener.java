package minecraft_plugin.plugin.listener;

import minecraft_plugin.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        World world = Bukkit.getWorld("world");

        if(player.isOp()){
            player.setDisplayName(ChatColor.RED + "[OP]" + player.getName());
        }else{
            player.setDisplayName(ChatColor.DARK_GRAY +"[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + player.getName());
        }
        player.sendMessage(Main.getPrefix() + ChatColor.BLUE + "Welcome " + player.getName() + "!");
        event.setJoinMessage(Main.getPrefix() + player.getName() + " joined the server!");
    }
}
