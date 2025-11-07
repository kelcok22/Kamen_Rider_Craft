package com.kelco.kamenridercraft.entities.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum MalgamVariant {
    MANTIS(0),
    SKATEBOARD(1),
    POISONOUS_MUSHROOM(2);

    private static final MalgamVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(MalgamVariant::getId)).toArray(MalgamVariant[]::new);
    private final int id;

    MalgamVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static MalgamVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
