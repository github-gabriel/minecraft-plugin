package minecraft_plugin.plugin.other;

import minecraft_plugin.plugin.commands.BridgeCommand;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;


public class PlaceBlock extends BukkitRunnable {

    private final JavaPlugin plugin;
    public static List<Location> playerLocation = new ArrayList<Location>();
    public int i = 0;

    public PlaceBlock(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player all : Bukkit.getServer().getOnlinePlayers()) {
            double x = all.getLocation().getX(); // Spieler Cord. X
            double y = all.getLocation().getY(); // Spieler Cord. Y
            double z = all.getLocation().getZ(); // Spieler Cord. Z
            World world = all.getWorld();
            Location location = new Location(world, x, y - 1, z); // Ort (loc)
            Location location1 = new Location(world, x + 1, y - 1, z); // Ort (loc)
            Location location2 = new Location(world, x - 1, y - 1, z); // Ort (loc)
            Location location3 = new Location(world, x, y - 1, z + 1); // Ort (loc)
            Location location4 = new Location(world, x, y - 1, z - 1); // Ort (loc)
            playerLocation.add(i, new Location(world, x, y, z));
            world.getBlockAt(location).setType(Material.ICE);
            world.getBlockAt(location1).setType(Material.ICE);
            world.getBlockAt(location2).setType(Material.ICE);
            world.getBlockAt(location3).setType(Material.ICE);
            world.getBlockAt(location4).setType(Material.ICE);
            i++;
            if (BridgeCommand.bool) {
                this.cancel();
            }
        }
    }

    public void delete(Player player) {

        World world = player.getWorld();

        for (Location loc : playerLocation) {

            Location location5 = new Location(world, loc.getX(), loc.getY() - 1, loc.getZ()); // Ort (loc)
            Location location6 = new Location(world, loc.getX() + 1, loc.getY() - 1, loc.getZ()); // Ort (loc)
            Location location7 = new Location(world, loc.getX() - 1, loc.getY() - 1, loc.getZ()); // Ort (loc)
            Location location8 = new Location(world, loc.getX(), loc.getY() - 1, loc.getZ() + 1); // Ort (loc)
            Location location9 = new Location(world, loc.getX(), loc.getY() - 1, loc.getZ() - 1); // Ort (loc)

            world.getBlockAt(location5).setType(Material.AIR);
            world.getBlockAt(location6).setType(Material.AIR);
            world.getBlockAt(location7).setType(Material.AIR);
            world.getBlockAt(location8).setType(Material.AIR);
            world.getBlockAt(location9).setType(Material.AIR);
        }
    }
}