package org.enigma.onelife.profiles;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ProfileListener implements Listener {

    private ProfileManager profileManager = new ProfileManager();
    private Player player;
    private Profile profile;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        player = event.getPlayer();
        // If the player has not played before, create them a new profile.
        if(!player.hasPlayedBefore()){
            profileManager.createProfile(player);
        }
        // Otherwise, get their profile from the config and put it into the map.
        profile = profileManager.getProfileByConfig(player);
        profileManager.profileMap.put(player.getUniqueId(), profile);

    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        player = event.getPlayer();
        profileManager.saveProfileConfig();
        profileManager.removeProfileFromMap(player);

    }
    @EventHandler
    public void onPlayerKick(PlayerKickEvent event){
        player = event.getPlayer();
        profileManager.saveProfileConfig();
        profileManager.removeProfileFromMap(player);
    }



}
