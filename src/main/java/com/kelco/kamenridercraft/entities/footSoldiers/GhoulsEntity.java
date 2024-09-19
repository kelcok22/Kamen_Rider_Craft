package com.kelco.kamenridercraft.entities.footSoldiers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class GhoulsEntity extends BaseHenchmenEntity {

    public GhoulsEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ghouls";
    }
}