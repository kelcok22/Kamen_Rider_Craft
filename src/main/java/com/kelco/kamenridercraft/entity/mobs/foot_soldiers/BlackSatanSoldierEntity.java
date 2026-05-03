package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class BlackSatanSoldierEntity extends BaseHenchmenEntity {
	
    public BlackSatanSoldierEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="black_satan_soldier";
    }
}