package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DogmaFighterEntity extends BaseHenchmenEntity {
	
    public DogmaFighterEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="dogma_fighter";
        getAttribute(KRCAttributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
    }
}