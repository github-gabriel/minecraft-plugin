package minecraft_plugin.plugin.commands;

import minecraft_plugin.plugin.Main;
import minecraft_plugin.plugin.other.PlaceBlock;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Date;

public class BridgeCommand implements CommandExecutor{
    private final JavaPlugin plugin;
    public static boolean bool = false;

    public BridgeCommand(JavaPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label, String[] args) {
        PlaceBlock place = new PlaceBlock(plugin);
        if (args[0].equalsIgnoreCase("on"))
        {
            bool = false;
            place.runTaskTimer(plugin , 1 , 0 );
        }
        if (args[0].equalsIgnoreCase("off"))
        {
            bool = true;
        }
        if (args[0].equalsIgnoreCase("clear"))
        {
            bool = true;
            sender.sendMessage(ChatColor.GOLD + "ARRAYLIST: " + String.valueOf(PlaceBlock.playerLocation));
            Player player = (Player) sender;
            place.delete(player);
        }
        return false;
    }
}