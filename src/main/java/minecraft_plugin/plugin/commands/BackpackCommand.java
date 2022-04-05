package minecraft_plugin.plugin.commands;

import minecraft_plugin.plugin.Main;
import minecraft_plugin.plugin.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

public class BackpackCommand implements CommandExecutor {

    private Inventory inventory;

    public BackpackCommand() {

        int slots = 27;

        if(Config.contains("command.backpack.slots")){
            slots = (int) Config.get("command.backpack.slots");
        }else{
            try {
                Config.set("command.backpack.slots" , 27);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.inventory = Bukkit.createInventory(null, slots , "§6Backpack");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            player.openInventory(inventory);
        }else{
            sender.sendMessage(Main.getPrefix() + ChatColor.RED + "Dieser Befehl kann nur von einem Spieler ausgeführt werden");
        }
        return false;
    }
}
