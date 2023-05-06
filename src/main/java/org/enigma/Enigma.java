package org.enigma;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Enigma extends JavaPlugin {

    @Getter
    private Enigma enigma;
    @Override
    public void onEnable() {
        enigma = this;
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {

    }





    private void registerListeners(){

    }
    private void registerCommands(){

    }
}
