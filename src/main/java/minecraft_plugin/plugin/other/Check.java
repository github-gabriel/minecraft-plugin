package minecraft_plugin.plugin.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;


public class Check extends BukkitRunnable {

    private final JavaPlugin plugin;

    public Check(JavaPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public void run() {
        for(Player all : Bukkit.getServer().getOnlinePlayers()) {
            if (all.isOp()) {
                all.setDisplayName(ChatColor.RED + "[OP]" + all.getName());
            }else{
                all.setDisplayName(ChatColor.DARK_GRAY +"[" + ChatColor.AQUA + "Player" + ChatColor.DARK_GRAY + "]" + all.getName());
            }
        }
    }
}
