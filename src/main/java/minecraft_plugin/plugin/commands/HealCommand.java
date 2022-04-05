package minecraft_plugin.plugin.commands;

import minecraft_plugin.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.setHealth(20);
            player.setFoodLevel(20);
            player.sendMessage(Main.getPrefix() + ChatColor.GOLD +  player.getName() + " got healed");
        }
        return false;
    }

}