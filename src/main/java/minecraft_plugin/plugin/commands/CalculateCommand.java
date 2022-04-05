package minecraft_plugin.plugin.commands;

import minecraft_plugin.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculateCommand implements CommandExecutor {
    public String rechnung;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args[0].equalsIgnoreCase("clear")){
                rechnung = "";
            }else{
                rechnung = args[0];
            }

            Player player = (Player) sender;
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            String foo = rechnung;

            try {
                player.sendMessage(Main.getPrefix() + String.valueOf(engine.eval(foo)));
            } catch (ScriptException error) {
                error.printStackTrace();
            }
        }
        return false;
    }

}
