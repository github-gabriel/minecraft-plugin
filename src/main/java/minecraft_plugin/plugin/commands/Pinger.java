package minecraft_plugin.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class Pinger implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args) {
        Player player = (Player) sender;
        String ipAddress = args[0];
        InetAddress inet = null;
        try {
            inet = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        player.sendMessage("Sending Ping Request to " + "'" + ipAddress + "'");
            long timeToRespond = 0;
            Date start = new Date();
        try {
            if (inet.isReachable(5000)) {
                Date stop = new Date();
                timeToRespond = (stop.getTime() - start.getTime());

                if(timeToRespond > 1000){
                    player.sendMessage("\n" + "'" + ipAddress + "'" + " is reachable in " + timeToRespond + "s");
                }else{
                    player.sendMessage("\n" + "'" + ipAddress + "'" + " is reachable in " + timeToRespond + "ms");
                }

            } else {
                player.sendMessage(ipAddress + " NOT reachable.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
