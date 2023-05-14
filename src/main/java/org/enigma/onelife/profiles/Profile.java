package org.enigma.onelife.profiles;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Profile {

    @Getter @Setter
    private UUID uuid;
    @Getter @Setter
    private long balance;
    @Getter @Setter
    private int life;
    @Getter @Setter
    private int kills;
    @Getter @Setter
    private int drachma;
    public Profile(UUID uuid) {
        this.uuid = uuid;
    }







}
