package minecraft_plugin.plugin.commands;

import minecraft_plugin.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Date;

public class DateCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label, String[] args) {
        Date date = new Date();
        sender.sendMessage(Main.getPrefix()+ ChatColor.GOLD + "Date: " + date.toString());
        return false;
    }
}
