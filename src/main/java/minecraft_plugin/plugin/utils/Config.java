package minecraft_plugin.plugin.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static File file;
    private static YamlConfiguration config;

    public Config() {

        File dir = new File(".plugins/PluginInfo/");
        if(!dir.exists()){
            dir.mkdirs();
        }

        file = new File(dir, "config.yal");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public static boolean contains(String path){
        return  config.contains(path);
    }

    public static void set(String path, Object value) throws IOException {
        config.set(path , value);
        config.save(file);
    }

    public static Object get(String path){
        if(!contains(path)){
            return null;
        }
        return config.get(path);
    }
}
