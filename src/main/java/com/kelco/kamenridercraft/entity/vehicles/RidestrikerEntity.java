package com.kelco.kamenridercraft.entity.vehicles;

import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class RidestrikerEntity extends baseBikeEntity {



	public RidestrikerEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, ZiORiderItems.RIDESTRIKER_RIDEWATCH.get());
		NAME ="ridestriker";
		NAME_MODEL ="ridestriker";
		}


	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.SAFE_FALL_DISTANCE, 15f).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
