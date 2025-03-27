package com.kelco.kamenridercraft.entities.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum AgentVariant {
    WHITE_A(0),
    WHITE_B(1),
    BLUE_A(2),
    BLUE_B(3);

    private static final AgentVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(AgentVariant::getId)).toArray(AgentVariant[]::new);
    private final int id;

    AgentVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static AgentVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

}
