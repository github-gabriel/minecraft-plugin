package minecraft_plugin.plugin.commands;

import minecraft_plugin.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GOLD + "Commands: " + ChatColor.WHITE + "" +
                    ChatColor.AQUA + "\n/date: "+ ChatColor.WHITE + "Zeigt das aktuelle Datum an\n" +
                    ChatColor.AQUA + "/heal: " + ChatColor.WHITE+ "Heilt den Spieler\n" +
                    ChatColor.AQUA + "/name: " + ChatColor.WHITE+ " Zeigt den jetzigen Spielernamen an\n" +
                    ChatColor.AQUA + "/bridge: " + ChatColor.WHITE+ " Baut eine Brücke unter dem Spieler(on/off/clear)\n" +
                    ChatColor.AQUA + "/calculate: " +ChatColor.WHITE + "Rechnet Therme aus\n" +
                    ChatColor.AQUA + "/ping: " + ChatColor.WHITE+ " Pingt einen Server(nur für Windows)\n" +
                    ChatColor.AQUA + "/backpack: " +ChatColor.WHITE + " Öffnet den Rucksack des Spielers\n");
        }
        return false;
    }
}
