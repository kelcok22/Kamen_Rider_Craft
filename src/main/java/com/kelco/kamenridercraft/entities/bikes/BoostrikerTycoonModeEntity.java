package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BoostrikerTycoonModeEntity extends baseBikeEntity {
	public BoostrikerTycoonModeEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, Geats_Rider_Items.BOOST_RAISE_BUCKLE.get());
		NAME ="boostriker_tycoon_mode";
		NAME_MODEL ="boostriker_geats_mode";
		NAME_ANIMATIONS ="boostriker_geats_mode";
		}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!this.isVehicle()) {
			if (player.isShiftKeyDown()) {
                BoostrikerEntity boss = MobsCore.BOOSTRIKER.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
					boss.yRotO = getYRot();
					boss.xRotO = getXRot();
					setRot(getYRot(), getXRot());
					boss.yBodyRot = this.getYRot();
					boss.yHeadRot = this.yBodyRot;
					boss.setRiderLogo("tycoon");
					if (boss.level() instanceof ServerLevel sl) {
						sl.sendParticles(ParticleTypes.GUST,
								boss.getX(), boss.getY() + 1.0,
								boss.getZ(), 1, 0, 0, 0, 1);
					}
					this.level().addFreshEntity(boss);
					this.remove(RemovalReason.DISCARDED);
				}
			} else player.startRiding(this);
		}
		return InteractionResult.PASS;
	}

	@Override
	public void positionRider(Entity entity, MoveFunction moveFunction) {
		if (entity instanceof LivingEntity passenger) {
			moveFunction.accept(entity, getX(), getY() + 0.4f, getZ());

			this.xRotO = passenger.xRotO;
		}
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
