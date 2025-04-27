package com.kelco.kamenridercraft.entities.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum ReaperVariant {
    COBRA(0),
    BAT(1),
    SPIDER(2);

    private static final ReaperVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(ReaperVariant::getId)).toArray(ReaperVariant[]::new);
    private final int id;

    ReaperVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ReaperVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
