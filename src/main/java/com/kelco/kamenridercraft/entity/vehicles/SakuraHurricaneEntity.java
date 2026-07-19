package com.kelco.kamenridercraft.entity.vehicles;

import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class SakuraHurricaneEntity extends baseBikeEntity {



	public SakuraHurricaneEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, GaimRiderItems.SAKURA_HURRICANE.get());
		NAME ="sakura_hurricane";
		NAME_MODEL ="sakura_hurricane";
		}


	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.SAFE_FALL_DISTANCE, 15f).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
