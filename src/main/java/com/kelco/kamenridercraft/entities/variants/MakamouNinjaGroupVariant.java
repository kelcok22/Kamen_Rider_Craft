package com.kelco.kamenridercraft.entities.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum MakamouNinjaGroupVariant {
    BENIGITSUNE(0),
    BYAKKO(1);

    private static final MakamouNinjaGroupVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(MakamouNinjaGroupVariant::getId)).toArray(MakamouNinjaGroupVariant[]::new);
    private final int id;

    MakamouNinjaGroupVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static MakamouNinjaGroupVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
