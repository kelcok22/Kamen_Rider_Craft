package com.kelco.kamenridercraft.entities.footSoldiers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class RedFollowerEntity extends BaseHenchmenEntity {
	
    public RedFollowerEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="red_follower";
    }
}