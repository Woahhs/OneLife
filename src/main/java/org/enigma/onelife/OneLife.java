package org.enigma.onelife;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.enigma.onelife.config.ConfigFile;
import org.enigma.onelife.essentials.utils.Utils;
import org.enigma.onelife.profiles.Profile;
import org.enigma.onelife.profiles.ProfileListener;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OneLife extends JavaPlugin {

    @Getter
    private static OneLife instance;
    @Getter
    private Utils utils = new Utils();
    @Getter
    private ConfigFile mainConfig;
    @Getter
    private ConfigFile profileConfig;
    @Getter
    private Map<UUID, Profile> profileMap;
    @Override
    public void onEnable() {
        instance = this;
        profileMap = new HashMap<>();
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
        pluginManager.registerEvents(new ProfileListener(), this);

    }
    private void registerCommands(){


    }
}
