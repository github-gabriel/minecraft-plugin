package minecraft_plugin.plugin;

import minecraft_plugin.plugin.commands.*;
import minecraft_plugin.plugin.listener.ChatListener;
import minecraft_plugin.plugin.listener.JoinListener;
import minecraft_plugin.plugin.listener.QuitListener;
import minecraft_plugin.plugin.other.Check;
import minecraft_plugin.plugin.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public PluginManager pluginManager = Bukkit.getPluginManager();
    @Override
    public void onEnable() {

        new Config();
        // Plugin startup logic
        // TODO: /date
        // TODO: JoinListener
        // TODO: QuitListener

        Bukkit.getLogger().fine("Plugin is enabled");

        listenerRegistration();
        commandRegistration();
        Check c = new Check(this);
        c.runTaskTimer(Main.this, 1 , 0 );
    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Plugin is disabled");
    }

    public static String getPrefix(){
        return ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Plugin" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_GRAY;
    }

    private void listenerRegistration(){
        pluginManager.registerEvents(new JoinListener() , this);
        pluginManager.registerEvents(new QuitListener(),this);
        pluginManager.registerEvents(new ChatListener(),this);
    }

    private void commandRegistration(){
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("date").setExecutor(new DateCommand());
        getCommand("name").setExecutor(new ShowNameCommand());
        getCommand("bridge").setExecutor(new BridgeCommand(Main.this));
        getCommand("calculate").setExecutor(new CalculateCommand());
        getCommand("ping").setExecutor(new Pinger());
        getCommand("backpack").setExecutor(new BackpackCommand());
        getCommand("commands").setExecutor(new HelpCommand());
    }
}
