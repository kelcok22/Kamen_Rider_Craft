package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class DestronCombatmanEntity extends BaseHenchmenEntity {
	
    public DestronCombatmanEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="destron_combatman";
    }
}