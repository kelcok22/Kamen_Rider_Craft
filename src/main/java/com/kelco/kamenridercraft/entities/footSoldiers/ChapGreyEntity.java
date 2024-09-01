package com.kelco.kamenridercraft.entities.footSoldiers;


import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ChapGreyEntity extends BaseHenchmenEntity {
	
    public ChapGreyEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="chaps_grey";
    }
}