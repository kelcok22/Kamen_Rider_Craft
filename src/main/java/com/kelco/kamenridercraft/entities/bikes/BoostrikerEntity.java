package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import com.kelco.kamenridercraft.item.geats.RiderCoreIDItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class BoostrikerEntity extends baseBikeEntity {
	private static final EntityDataAccessor<String> DATA_RIDER_LOGO = SynchedEntityData.defineId(BoostrikerEntity.class, EntityDataSerializers.STRING);

	public BoostrikerEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, Geats_Rider_Items.BOOST_RAISE_BUCKLE.get());
		NAME ="boostriker";
		NAME_MODEL ="boostriker";
		}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_RIDER_LOGO, "geats");
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("riderLogo", this.getRiderLogo());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.entityData.set(DATA_RIDER_LOGO, compound.getString("riderLogo"));
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!this.isVehicle()) {
			if (!level().isClientSide() && player.isShiftKeyDown() && (Objects.equals(this.getRiderLogo(), "geats")||Objects.equals(this.getRiderLogo(), "tycoon")
			||Objects.equals(this.getRiderLogo(), "na_go")||Objects.equals(this.getRiderLogo(), "buffa"))) {
				baseBikeEntity boss = switch (this.getRiderLogo()) {
                    case "geats" -> MobsCore.BOOSTRIKER_GEATS_MODE.get().create(this.level());
                    case "tycoon" -> MobsCore.BOOSTRIKER_TYCOON_MODE.get().create(this.level());
                    case "na_go" -> MobsCore.BOOSTRIKER_NA_GO_MODE.get().create(this.level());
                    case "buffa" -> MobsCore.BOOSTRIKER_BUFFA_MODE.get().create(this.level());
                    default -> null;
                };
                if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
					boss.yRotO = getYRot();
					boss.xRotO = getXRot();
					setRot(getYRot(), getXRot());
					boss.yBodyRot = this.getYRot();
					boss.yHeadRot = this.yBodyRot;
					if (boss.level() instanceof ServerLevel sl) {
						sl.sendParticles(ParticleTypes.GUST,
								boss.getX(), boss.getY() + 1.0,
								boss.getZ(), 1, 0, 0, 0, 1);
					}
					this.level().addFreshEntity(boss);
					this.remove(RemovalReason.DISCARDED);
				}
			} else if (player.getItemInHand(hand).getItem() == Revice_Rider_Items.REX_VISTAMP.get() && (Objects.equals(this.getRiderLogo(), "revi")||Objects.equals(this.getRiderLogo(), "vice"))) {
				if (Objects.equals(this.getRiderLogo(), "revi")) this.setRiderLogo("revi_vicetriker");
				else this.setRiderLogo("vice_vicetriker");
				if (this.level() instanceof ServerLevel sl) {
					sl.sendParticles(ParticleTypes.GUST,
							this.getX(), this.getY() + 1.0,
							this.getZ(), 1, 0, 0, 0, 1);
				}
				MAX_SPEED = 0.015f;
			} else if (!(player.getItemInHand(hand).getItem() instanceof RiderCoreIDItem)) player.startRiding(this);
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

	public String getRiderLogo() {
		return this.entityData.get(DATA_RIDER_LOGO);
	}

	public void setRiderLogo(String p_30404_) {
		this.entityData.set(DATA_RIDER_LOGO, p_30404_);
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
