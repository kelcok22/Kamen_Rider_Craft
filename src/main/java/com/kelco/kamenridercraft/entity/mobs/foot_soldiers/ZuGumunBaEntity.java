package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ZuGumunBaEntity extends BaseHenchmenEntity {
	
    public ZuGumunBaEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="zu_gumun_ba";
        getAttribute(Attributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
    }
}