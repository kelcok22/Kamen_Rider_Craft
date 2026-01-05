package com.kelco.kamenridercraft.entities.bikes;


import javax.annotation.Nullable;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.util.GeckoLibUtil;


public class baseBikeEntity extends Mob implements GeoEntity {


	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public String NAME ="skullboilder";
	public String NAME_MODEL ="hardboilder";
	public String NAME_ANIMATIONS ="hardboilder";
	public float MAX_SPEED = 0.01f;

	public RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.model.idle");
	public RawAnimation DRIVE = RawAnimation.begin().thenLoop("animation.model.walk");
	public RawAnimation DRIVE_BACKWARDS = RawAnimation.begin().thenLoop("animation.model.walk_backwards");

	public Item VEHICLE_DROP;


	public baseBikeEntity(EntityType<? extends Mob> entityType, Level level, Item drop) {
		super(entityType, level);
		this.setPersistenceRequired();
		this.VEHICLE_DROP = drop;
	}
	boolean shouldSourceDestroy(DamageSource source) {
		return false;
	}


	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F)
				.add(Attributes.MAX_HEALTH, 20.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	// Let the player ride the entity
	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!this.isVehicle()) {
			player.startRiding(this);
			return super.mobInteract(player, hand);
		}

		return super.mobInteract(player, hand);
	}

	public boolean canCollideWith(Entity entity) {
		return canVehicleCollide(this, entity);
	}

	public static boolean canVehicleCollide(Entity vehicle, Entity entity) {
		return (entity.canBeCollidedWith() || entity.isPushable()) && !vehicle.isPassengerOfSameVehicle(entity);
	}


	public boolean canBeCollidedWith() {
		return true;
	}

	public boolean isPushable() {
		return true;
	}

	public Vec3 getRelativePortalPosition(Direction.Axis axis, BlockUtil.FoundRectangle portal) {
		return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(axis, portal));
	}

	public void push(Entity entity) {
		if (entity instanceof Boat) {
			if (entity.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.push(entity);
			}
		} else if (entity.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.push(entity);
		}

	}

	@Override
    public boolean hurt(DamageSource source, float amount) {
		return super.hurt(source, source.is(DamageTypes.PLAYER_ATTACK) && !this.hasControllingPassenger() ? this.getMaxHealth() : amount);
    }

	// Turn off step sounds since it's a bike
	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
	}

	// Apply player-controlled movement
	@Override
	public void travel(Vec3 pos) {

		if (this.isAlive()) {
            float z = 0;
			this.fallDistance=0;
			if (this.isVehicle()) {


				LivingEntity passenger = getControllingPassenger();
				if (passenger!=null){
				this.yRotO = getYRot();
				this.xRotO = getXRot();

				 z = passenger.zza;

				if (z <= 0) z *= 0.25f;
if (this.onGround()){
				if (z>0) {
					this.playSound(SoundEvents.BOAT_PADDLE_LAND, this.getSoundVolume()/4, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F + 1.0F);
					if (this.getSpeed() <0.2){
						if (level() instanceof ServerLevel sl) {
							sl.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
									this.getX(), this.getY() ,
									this.getZ(), 10, 0, 0, 0, 0);
						}

						//this.playSound(SoundEvents.ALLAY_THROW, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
					}

					if (this.getSpeed()<0.6) this.setSpeed(this.getSpeed()+MAX_SPEED);
					setYRot(yRotO - passenger.xxa * 5F);
					setXRot(passenger.getXRot() * 3f);

					setRot(getYRot(), getXRot());
					this.yBodyRot = this.getYRot();
					this.yHeadRot = this.yBodyRot;

				}else if (z<0) {
					this.playSound(SoundEvents.BOAT_PADDLE_LAND, this.getSoundVolume()/4, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F + 1.0F);

					if (this.getSpeed()<1) this.setSpeed(this.getSpeed()+MAX_SPEED);
					setYRot(yRotO + passenger.xxa * 5F);
					setXRot(-passenger.getXRot() * 3f);

					setRot(getYRot(), getXRot());
					this.yBodyRot = this.getYRot();
					this.yHeadRot = this.yBodyRot;
				}else{
					if (this.getSpeed()!=0) {
						if (this.getSpeed() >0.6)this.playSound(SoundEvents.BOAT_PADDLE_LAND, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
						if (level() instanceof ServerLevel sl) {
							sl.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
									this.getX(), this.getY() ,
									this.getZ(), 10, 0, 0, 0, 0);
						}
						this.setSpeed(0f);
					}
				}
}

			}
			}
            super.travel(new Vec3(0, pos.y, z));
		}
	}

	// Get the controlling passenger
	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		return getFirstPassenger() instanceof LivingEntity entity ? entity : null;
	}

	protected Entity.MovementEmission getMovementEmission() {
		return MovementEmission.EVENTS;
	}

	@Override
	public boolean isControlledByLocalInstance() {
		return true;
	}

	
	   
	// Adjust the rider's position while riding
	@Override
	public void positionRider(Entity entity, MoveFunction moveFunction) {
		if (entity instanceof LivingEntity passenger) {
			moveFunction.accept(entity, getX(), getY() + 0.3f, getZ());

			this.xRotO = passenger.xRotO;
		}
	}

	@Override
	public void die(DamageSource p_21809_) {
		super.die(p_21809_);
		if (!this.level().isClientSide()) this.spawnAtLocation(this.VEHICLE_DROP);

	}


protected SoundEvent getHurtSound(DamageSource p_30424_) {
	return SoundEvents.METAL_BREAK;
}

protected SoundEvent getDeathSound() {
	return SoundEvents.METAL_BREAK;
}

	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
		return 0.5F;
	}
	
		@Override
		public AnimatableInstanceCache getAnimatableInstanceCache() {
			return this.cache;
		}
	
		@Override
		public boolean shouldDropExperience() {
			return false;
		}


	// Add our idle/moving animation controller
	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

		controllers.add(new AnimationController<>(this, "controller", 2, state -> {
			EntityModelData entityData = state.getData(DataTickets.ENTITY_MODEL_DATA);
			Entity entityData2 = state.getData(DataTickets.ENTITY);
			float front_fork=0;
			float wheel=0;
			if (this.getControllingPassenger() != null) {
				if (this.getControllingPassenger().xxa < 0) front_fork = -0.25f;
				if (this.getControllingPassenger().xxa > 0) front_fork = 0.25f;
				if (this.getControllingPassenger().zza > 0) wheel=- 0.1f;
				if (this.getControllingPassenger().zza < 0) wheel= 0.05f;
			}
			EntityModelData newEntityData = new EntityModelData(false,false,entityData.netHeadYaw()+wheel,front_fork);
			state.setData(DataTickets.ENTITY_MODEL_DATA,newEntityData);

			if (getControllingPassenger() != null) {
				if (getControllingPassenger().zza!=0) {
				if (getControllingPassenger().zza>0)return state.setAndContinue(DRIVE);
				else return state.setAndContinue(DRIVE_BACKWARDS);
				} else {
					return state.setAndContinue(IDLE);
				}
			}
			else {
				return state.setAndContinue(IDLE);
			}
			// Handle the sound keyframe that is part of our animation json
		}).setSoundKeyframeHandler(event -> {
			// We don't have a sound for this yet :(
		}));
	}




}
