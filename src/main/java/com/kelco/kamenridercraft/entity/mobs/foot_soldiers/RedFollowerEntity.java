package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class RedFollowerEntity extends BaseHenchmenEntity {
	
    public RedFollowerEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="red_follower";
        getAttribute(Attributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
    }
}