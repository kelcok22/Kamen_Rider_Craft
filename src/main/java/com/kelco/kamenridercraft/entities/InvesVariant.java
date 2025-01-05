package com.kelco.kamenridercraft.entities;

import java.util.Arrays;
import java.util.Comparator;

public enum InvesVariant {
    RED(0),
    BLUE(1),
    GREEN(2);

    private static final InvesVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(InvesVariant::getId)).toArray(InvesVariant[]::new);
    private final int id;

    InvesVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static InvesVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
