package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class AriCommandoEntity extends BaseHenchmenEntity {
	
    public AriCommandoEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ari_commando";
        getAttribute(Attributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
    }
}