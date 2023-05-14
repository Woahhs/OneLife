package org.enigma.onelife.profiles;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.enigma.Enigma;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class ProfileManager {


    private Profile profile;
    private Map<UUID, Profile> profileMap = new HashMap<>();
    private Enigma instance = Enigma.getInstance();


    public void removeProfile(Player player){
        profileMap.remove(player.getUniqueId());
    }

    public Profile getProfileByConfig(Player player){


        return profile;
    }

    public Profile getProfileByPlayer(Player player) {
        if(profileMap.get(player.getUniqueId()) == null){
            profile = createProfile(player);
            return profile;
        }
        profileMap.get(player.getUniqueId());
        return profile;
    }

    public Profile createProfile(Player player){
        profile = new Profile(player.getUniqueId());
        profile.setBalance(500);
        profile.setDrachma(10);
        profile.setKills(0);
        profile.setLife(1);
        profileMap.put(player.getUniqueId(), profile);
        return profile;
    }

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
