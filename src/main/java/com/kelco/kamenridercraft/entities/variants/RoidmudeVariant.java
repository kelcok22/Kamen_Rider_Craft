package com.kelco.kamenridercraft.entities.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum RoidmudeVariant {
    COBRA(0),
    BAT(1),
    SPIDER(2);

    private static final RoidmudeVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(RoidmudeVariant::getId)).toArray(RoidmudeVariant[]::new);
    private final int id;

    RoidmudeVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static RoidmudeVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
