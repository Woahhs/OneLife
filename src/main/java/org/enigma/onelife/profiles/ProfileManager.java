package org.enigma.onelife.profiles;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.enigma.onelife.OneLife;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class ProfileManager {


    private Profile profile;
    public Map<UUID, Profile> profileMap = new HashMap<>();
    private OneLife instance = OneLife.getInstance();

    // Removes the players profile from the map.
    public void removeProfileFromMap(Player player){
        profileMap.remove(player.getUniqueId());
    }

    // Gets the players profile from the config.
    public Profile getProfileByConfig(Player player){
        YamlConfiguration profileConfig = instance.getProfileConfig().getConfiguration();
        profile.setLife(profileConfig.getInt(player.getUniqueId() + ".Life"));
        profile.setBalance(profileConfig.getLong(player.getUniqueId() + ".Balance"));
        profile.setDrachma(profileConfig.getInt(player.getUniqueId() + ".Drachma"));
        profile.setKills(profileConfig.getInt(player.getUniqueId() + ".Kills"));
        return profile;
    }

    // Saves the players profile to the profile config.
    public void saveProfileToConfig(Player player){
        profile = getProfileByPlayer(player);
        YamlConfiguration profileConfig = instance.getProfileConfig().getConfiguration();
        profileConfig.set(player.getUniqueId() + ".Life", profile.getLife());
        profileConfig.set(player.getUniqueId() + ".Balance", profile.getBalance());
        profileConfig.set(player.getUniqueId() + ".Drachma", profile.getDrachma());
        profileConfig.set(player.getUniqueId() + ".Kills", profile.getKills());
        saveProfileConfig();
    }

    // Gets the players profile from the player themselves
    public Profile getProfileByPlayer(Player player) {
        if(profileMap.get(player.getUniqueId()) == null){
            profile = createProfile(player);
            return profile;
        }
        profileMap.get(player.getUniqueId());
        return profile;
    }

    // Creates a default profile for the player.
    public Profile createProfile(Player player){
        profile = new Profile(player.getUniqueId());
        profile.setBalance(500);
        profile.setDrachma(10);
        profile.setKills(0);
        profile.setLife(1);
        profileMap.put(player.getUniqueId(), profile);
        return profile;
    }


    // Async method to save the profile config to save thread usage.
    public void saveProfileConfig(){
        new BukkitRunnable(){
            @Override
            public void run() {
                try {
                    instance.getConfig().save(instance.getProfileConfig().getFile());
                } catch (IOException e) {
                    instance.getLogger().log(Level.WARNING, "Error:// Could not save profile config!");
                    throw new RuntimeException(e);
                }
            }
        }.runTaskAsynchronously(instance);
    }







}
