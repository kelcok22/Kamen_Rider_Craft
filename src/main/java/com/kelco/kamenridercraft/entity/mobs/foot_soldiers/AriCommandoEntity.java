package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class AriCommandoEntity extends BaseHenchmenEntity {
	
    public AriCommandoEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ari_commando";
        getAttribute(KRCAttributes.REINFORCEMENT_CHANCE).setBaseValue(12D);
    }
}