package org.enigma.onelife.profiles;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ProfileListener implements Listener {

    private ProfileManager profileManager = new ProfileManager();
    private Player player;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        player = event.getPlayer();
        if(!player.hasPlayedBefore()){
            profileManager.createProfile(player);
        }





    }



}
