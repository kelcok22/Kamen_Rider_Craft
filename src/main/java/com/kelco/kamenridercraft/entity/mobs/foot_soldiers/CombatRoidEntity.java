package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CombatRoidEntity extends BaseHenchmenEntity {
	
    public CombatRoidEntity(EntityType<? extends BaseHenchmenEntity > type, Level level) {
        super(type, level);
        NAME="combatroid";
    }

}