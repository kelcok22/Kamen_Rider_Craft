package com.kelco.kamenridercraft.entities.bikes;

import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import com.kelco.kamenridercraft.item.geats.RiderCoreIDItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

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
		if (!this.isVehicle() && !(player.getItemInHand(hand).getItem() instanceof RiderCoreIDItem)) {
			player.startRiding(this);
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
