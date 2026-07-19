package com.kelco.kamenridercraft.entity.vehicles;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class RidoronEntity extends baseBikeEntity {



	public RidoronEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, MobsCore.RIDORON_SPAWN_EGG.get());
		NAME ="ridoron";
		NAME_MODEL ="ridoron";
		}

	// Adjust the rider's position while riding
	@Override
	public void positionRider(@NotNull Entity entity, @NotNull MoveFunction moveFunction) {
		if (entity instanceof LivingEntity passenger) {
			moveFunction.accept(entity, getX(), getY() + 0.2f, getZ());

			this.xRotO = passenger.xRotO;
		}
	}
	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.SAFE_FALL_DISTANCE, 15f).add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
