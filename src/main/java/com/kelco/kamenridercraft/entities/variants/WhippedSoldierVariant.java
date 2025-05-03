package com.kelco.kamenridercraft.entities.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum WhippedSoldierVariant {
    NORMAL(0),
    CHOCO(1),
    ZAKU(2),
    ICE(3);

    private static final WhippedSoldierVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(WhippedSoldierVariant::getId)).toArray(WhippedSoldierVariant[]::new);
    private final int id;

    WhippedSoldierVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static WhippedSoldierVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
