package com.kelco.kamenridercraft.entities.footSoldiers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class GODWarfareAgentEntity extends BaseHenchmenEntity {
	
    public GODWarfareAgentEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "god_warfare_agents";
    }
}