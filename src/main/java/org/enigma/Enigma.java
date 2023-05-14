package org.enigma;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.enigma.onelife.config.ConfigFile;
import org.enigma.onelife.essentials.utils.Utils;

public class Enigma extends JavaPlugin {

    @Getter
    private static Enigma instance;
    @Getter
    private Utils utils = new Utils();
    @Getter
    private ConfigFile mainConfig;
    @Getter
    private ConfigFile profileConfig;
    @Override
    public void onEnable() {
        instance = this;
        mainConfig = new ConfigFile(this, "config");
        profileConfig = new ConfigFile(this, "profiles");
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {

    }





    private void registerListeners(){
        PluginManager pluginManager = Bukkit.getPluginManager();

    }
    private void registerCommands(){


    }
}
