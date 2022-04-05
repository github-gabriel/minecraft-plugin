package minecraft_plugin.plugin.commands;

import minecraft_plugin.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ShowNameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(Main.getPrefix() + ChatColor.GOLD + "Your name is being displayed as: " + player.getDisplayName());
        return false;
    }
}