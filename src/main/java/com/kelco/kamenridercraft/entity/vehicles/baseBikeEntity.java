package com.kelco.kamenridercraft.entity.vehicles;


import com.kelco.kamenridercraft.network.payload.BikeMovePayload;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;


public class baseBikeEntity extends Mob implements GeoEntity, PlayerRideableJumping {

    private static final EntityDataAccessor<Float> WHEEL_ROT = SynchedEntityData.defineId(baseBikeEntity.class, EntityDataSerializers.FLOAT);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public String NAME = "skullboilder";
    public String NAME_MODEL = "hardboilder";
    public String NAME_ANIMATIONS = "hardboilder";
    public float MAX_SPEED = 0.01f;
    private boolean animationStarted = false;
    public float wheelRot = 0F;

    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;
    private boolean inputLeft;
    private boolean inputRight;
    private boolean inputUp;
    private boolean inputDown;
    private float playerJumpPendingScale;
    private boolean isJumping = false;


    public RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.model.idle");
    public RawAnimation DRIVE = RawAnimation.begin().thenLoop("animation.model.walk");
    public RawAnimation DRIVE_BACKWARDS = RawAnimation.begin().thenLoop("animation.model.walk_backwards");
    private static final RawAnimation TRANSFORM = RawAnimation.begin().thenPlay("animation.model.transform");


    public Item VEHICLE_DROP;


    public baseBikeEntity(EntityType<? extends Mob> entityType, Level level, Item drop) {
        super(entityType, level);
        this.setPersistenceRequired();
        this.VEHICLE_DROP = drop;
    }

    boolean shouldSourceDestroy(DamageSource source) {
        return false;
    }

    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(WHEEL_ROT, 0f);
    }

    public Float getWheelRotation() {
        return this.entityData.get(WHEEL_ROT);
    }

    public baseBikeEntity SetWheelRotation(Float Name) {
        this.entityData.set(WHEEL_ROT, Name + getWheelRotation());
        this.wheelRot = Name + getWheelRotation();
        return this;
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("wheel_rotation", wheelRot);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(WHEEL_ROT, compound.getFloat("wheel_rotation"));
    }


    public static AttributeSupplier.Builder setAttributes() {
        return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor p_34297_, @NotNull DifficultyInstance p_34298_, @NotNull MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);

        return p_34300_;
    }

    @Override
    public void tick() {
//        if (getControllingPassenger() != null && !this.animationStarted && getControllingPassenger() instanceof Player player ) {
//            PacketDistributor.sendToAllPlayers(new AnimPayload("default.riding", "position", false, player.getStringUUID()));
//            this.animationStarted = true;
//        } else if (this.animationStarted && getControllingPassenger() == null) {
//            this.animationStarted = false;
//        }
        super.tick();
        this.tickLerp();

        if (this.isControlledByLocalInstance()) {
            this.move(MoverType.SELF, this.getDeltaMovement());
        } else {
            this.setDeltaMovement(Vec3.ZERO);
        }

        super.tick();
    }

    public double lerpTargetX() {
        return this.lerpSteps > 0 ? this.lerpX : this.getX();
    }

    public double lerpTargetY() {
        return this.lerpSteps > 0 ? this.lerpY : this.getY();
    }

    public double lerpTargetZ() {
        return this.lerpSteps > 0 ? this.lerpZ : this.getZ();
    }

    public float lerpTargetXRot() {
        return this.lerpSteps > 0 ? (float) this.lerpXRot : this.getXRot();
    }

    public float lerpTargetYRot() {
        return this.lerpSteps > 0 ? (float) this.lerpYRot : this.getYRot();
    }

    public @NotNull Direction getMotionDirection() {
        return this.getDirection().getClockWise();
    }

    protected double getDefaultGravity() {
        return 0.04;
    }


    private void tickLerp() {
        if (this.isControlledByLocalInstance()) {
            this.lerpSteps = 0;
            this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
        }

        if (this.lerpSteps > 0) {
            this.lerpPositionAndRotationStep(this.lerpSteps, this.lerpX, this.lerpY, this.lerpZ, this.lerpYRot, this.lerpXRot);
            --this.lerpSteps;
        }

    }


    protected void clampRotation(Entity entityToUpdate) {
        entityToUpdate.setYBodyRot(this.getYRot());
        float f = Mth.wrapDegrees(entityToUpdate.getYRot() - this.getYRot());
        float f1 = Mth.clamp(f, -105.0F, 105.0F);
        entityToUpdate.yRotO += f1 - f;
        entityToUpdate.setYRot(entityToUpdate.getYRot() + f1 - f);
        entityToUpdate.setYHeadRot(entityToUpdate.getYRot());
    }


    public void onPassengerTurned(Entity entityToUpdate) {
        this.clampRotation(entityToUpdate);
    }


    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.isVehicle()) {
            player.startRiding(this);
        }
        //PacketDistributor.sendToAllPlayers(new AnimPayload("default.riding", "position", player.getStringUUID()));
        return super.mobInteract(player, hand);
    }

    public boolean canCollideWith(@NotNull Entity entity) {
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


    public @NotNull Vec3 getRelativePortalPosition(Direction.@NotNull Axis axis, BlockUtil.@NotNull FoundRectangle portal) {
        return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(axis, portal));
    }


    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        return super.hurt(source, source.is(DamageTypes.PLAYER_ATTACK) && !this.hasControllingPassenger() ? this.getMaxHealth() : amount);
    }


    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
    }


    @Override
    public void travel(@NotNull Vec3 pos) {
        if (this.level().isClientSide) {
            if (this.isAlive()) {
                float z = 0;
                this.fallDistance = 0;
                if (this.isVehicle()) {
                    LivingEntity passenger = getControllingPassenger();
                    if (passenger != null) {
                        this.yRotO = getYRot();
                        this.xRotO = getXRot();
                        z = passenger.zza;
                        if (z <= 0) {
                            z *= 0.25f;
                        }
                        if (this.onGround()) {
                            if (z > 0) {
                                if (this.getSpeed() < 0.6) {
                                    this.setSpeed(this.getSpeed() + MAX_SPEED);
                                }
                                setYRot(yRotO - passenger.xxa * 5F);
                                setXRot(passenger.getXRot() * 3f);
                                setRot(getYRot(), getXRot());
                                this.yBodyRot = this.getYRot();
                                this.yHeadRot = this.yBodyRot;
                            } else if (z < 0) {
                                if (this.getSpeed() < 1) {
                                    this.setSpeed(this.getSpeed() + MAX_SPEED);
                                }
                                setYRot(yRotO + passenger.xxa * 5F);
                                setXRot(-passenger.getXRot() * 3f);

                                setRot(getYRot(), getXRot());
                                this.yBodyRot = this.getYRot();
                                this.yHeadRot = this.yBodyRot;
                            } else {
                                if (this.getSpeed() != 0) {
                                    this.setSpeed(0f);
                                }
                            }
                            this.setIsJumping(false);
                            if (this.playerJumpPendingScale > 0.0F && !isJumping) {
                                this.executeRidersJump(this.playerJumpPendingScale, new Vec3(0, pos.y, z));
                            }

                            this.playerJumpPendingScale = 0.0F;
                        }

                    }
                }
                super.travel(new Vec3(0, pos.y, z));
                PacketDistributor.sendToServer(new BikeMovePayload(this.getId(), this.yBodyRot, this.yHeadRot, this.getWheelRotation(), this.getSpeed()));
            }
        }
    }


    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        return getFirstPassenger() instanceof LivingEntity entity ? entity : null;
    }


    protected Entity.@NotNull MovementEmission getMovementEmission() {
        return MovementEmission.EVENTS;
    }


    @Override
    public void positionRider(@NotNull Entity entity, @NotNull MoveFunction moveFunction) {
        if (entity instanceof LivingEntity passenger) {
            moveFunction.accept(entity, getX(), getY() + 0.3f, getZ());
            passenger.setYBodyRot(this.getXRot());
            this.xRotO = passenger.xRotO;
        }
    }


    @Override
    public void die(@NotNull DamageSource damageSource) {
        super.die(damageSource);
        if (!this.level().isClientSide()) {
            this.spawnAtLocation(this.VEHICLE_DROP);
        }

    }


    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
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


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "Transform", 0, state -> PlayState.STOP).triggerableAnim("transform", TRANSFORM));

        controllers.add(new AnimationController<>(this, "controller", 2, state -> {
            EntityModelData entityData = state.getData(DataTickets.ENTITY_MODEL_DATA);
            float front_fork = 0;
            float wheel = 0;
            if (this.getControllingPassenger() != null) {
                if (this.getControllingPassenger().xxa < 0) {
                    front_fork = -0.25f;
                }
                if (this.getControllingPassenger().xxa > 0) {
                    front_fork = 0.25f;
                }
                if (this.getControllingPassenger().zza > 0) {
                    wheel = -0.1f;
                }
                if (this.getControllingPassenger().zza < 0) {
                    wheel = 0.05f;
                }
            }

            SetWheelRotation(wheel);

            assert entityData != null;
            EntityModelData newEntityData = new EntityModelData(false, false, entityData.netHeadYaw() + wheel, front_fork);
            state.setData(DataTickets.ENTITY_MODEL_DATA, newEntityData);

            if (getControllingPassenger() != null) {
                if (getControllingPassenger().zza != 0) {
                    if (getControllingPassenger().zza > 0) {
                        return state.setAndContinue(DRIVE);
                    } else {
                        return state.setAndContinue(DRIVE_BACKWARDS);
                    }
                } else {
                    return state.setAndContinue(IDLE);
                }
            } else {

                return state.setAndContinue(IDLE);
            }
        }).setSoundKeyframeHandler(event -> {
        }));
    }

    @Override
    public void onPlayerJump(int jumpPower) {
        if (jumpPower >= 90) {
            this.playerJumpPendingScale = 1.0F;
        } else {
            this.playerJumpPendingScale = 0.4F + 0.4F * (float) jumpPower / 90.0F;
        }
    }

    public void setIsJumping(boolean jumping) {
        this.isJumping = jumping;
    }

    @Override
    public boolean canJump() {
        return (!this.isInWater());
    }

    @Override
    public void handleStartJump(int i) {
        this.playJumpSound();
    }

    private void playJumpSound() {
        this.playSound(SoundEvents.BREEZE_JUMP, 0.4F, 1.0F);
    }

    @Override
    public void handleStopJump() {
    }

    protected void executeRidersJump(float playerJumpPendingScale, Vec3 travelVector) {
        double d0 = this.getJumpPower(playerJumpPendingScale);
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, d0, vec3.z);
        this.setIsJumping(true);
        this.hasImpulse = true;
        CommonHooks.onLivingJump(this);
        if (travelVector.z > (double)0.0F) {
            float f = Mth.sin(this.getYRot() * ((float)Math.PI / 180F));
            float f1 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F));
            this.setDeltaMovement(this.getDeltaMovement().add((-0.4F * f * playerJumpPendingScale), 0.0F, (0.4F * f1 * playerJumpPendingScale)));
        }

    }
}