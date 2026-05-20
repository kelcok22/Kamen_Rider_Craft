package com.kelco.kamenridercraft.entity.vehicles;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class NeoBaseBikeEntity extends VehicleEntity implements GeoEntity {
    private Boolean canFly = false;
    private Boolean canFloat = false;
    //TODO add idle sounds, driving sounds, accelerating sounds, sharp turning sounds, braking sounds, startup sounds, crash sounds, and transformation sounds

    private static final EntityDataAccessor<Boolean> FORWARDS = SynchedEntityData.defineId(NeoBaseBikeEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BACKWARDS = SynchedEntityData.defineId(NeoBaseBikeEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEFT = SynchedEntityData.defineId(NeoBaseBikeEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(NeoBaseBikeEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> JUMPING = SynchedEntityData.defineId(NeoBaseBikeEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DRIFTING = SynchedEntityData.defineId(NeoBaseBikeEntity.class, EntityDataSerializers.BOOLEAN);

    private String bikeModel = "generic_bike";
    private String bikeSound = "generic_bike";
    private String bikeAnimations = "generic_bike";

    private String primaryAbility = "kickOffBike";
    private String secondaryAbility = "superBoost";


    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public NeoBaseBikeEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.blocksBuilding = true;
        this.setDamage(-20);
        this.showVehicleHealth();
        this.dismountsUnderwater();
    }


    public InteractionResult interact(Player player, InteractionHand hand) {
        InteractionResult interactionresult = super.interact(player, hand);
        if (interactionresult != InteractionResult.PASS) {
            return interactionresult;
        } else if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else if (true) {
            if (!this.level().isClientSide) {
                return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
            } else {
                return InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
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
    public void tick() {
        if (this.getHurtTime() > 0) {
            this.setHurtTime(this.getHurtTime() - 1);
        }

        if (this.getDamage() > 0.0F) {
            this.setDamage(this.getDamage() - 1.0F);
        }

        super.tick();
        boolean jump = false;
        float friction = 0.075F;
        if (this.getFirstPassenger() != null) {
            if (entityData.get(JUMPING) && this.onGround()) {
                jump = true;
            }
            if (entityData.get(DRIFTING) && this.onGround()) {
                friction = 0.05F;
            }
            this.controlVehicle();
            this.getFirstPassenger().hurtMarked = true;
        } else {
            this.entityData.set(FORWARDS, false);
            this.entityData.set(BACKWARDS, false);
            this.entityData.set(LEFT, false);
            this.entityData.set(RIGHT, false);
            this.entityData.set(JUMPING, false);
            this.entityData.set(DRIFTING, false);
        }
        this.applyGravity();
        this.addDeltaMovement(this.getDeltaMovement().reverse().scale(friction));
        if (jump) {
            this.addDeltaMovement(new Vec3(0, .5, 0));
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.hurtMarked = true;
    }

    private void controlVehicle() {
        float f = 0.0F;
        float deltaRotation = 0.0F;
        if (entityData.get(LEFT) && this.onGround()) {
            deltaRotation = deltaRotation - 7.5F;
        }
        if (entityData.get(RIGHT) && this.onGround()) {
            deltaRotation = deltaRotation + 7.5F;
        }
        if (entityData.get(RIGHT) && this.onGround() || entityData.get(LEFT) && this.onGround()) {
            this.setYRot(this.getYRot() + deltaRotation);
        }
        if (entityData.get(FORWARDS) && this.onGround()) {
            f += 0.04F;
        }
        if (entityData.get(BACKWARDS) && this.onGround()) {
            f -= 0.005F;
        }
        this.setDeltaMovement(this.getDeltaMovement().add((double) (Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f), (double) 0.0F, (double) (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f)));
    }

    public void updateControls(boolean forwards, boolean backwards, boolean left, boolean right, boolean jumping, boolean drifting) {
        this.entityData.set(FORWARDS, forwards);
        this.entityData.set(BACKWARDS, backwards);
        this.entityData.set(LEFT, left);
        this.entityData.set(RIGHT, right);
        this.entityData.set(JUMPING, jumping);
        this.entityData.set(DRIFTING, drifting);
        this.hurtMarked = true;
    }


    public Boolean getForwards() {
        return this.entityData.get(FORWARDS);
    }

    public Boolean getBackwards() {
        return this.entityData.get(BACKWARDS);
    }

    public Boolean getLeft() {
        return this.entityData.get(LEFT);
    }

    public Boolean getRight() {
        return this.entityData.get(RIGHT);
    }

    public Boolean getJumping() {
        return this.entityData.get(JUMPING);
    }

    public Boolean getDrifting() {
        return this.entityData.get(DRIFTING);
    }

    protected double getDefaultGravity() {
        if (!this.onGround() && !this.isInWater()) {
            return 0.04;
        } else if (this.isInWater()) {
            return 0.04;
        } else {
            return 0.04;
        }
    }

    @Override
    public float maxUpStep() {
        return 1.1F;
    }

    protected MovementEmission getMovementEmission() {
        return MovementEmission.EVENTS;
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

    public void animateHurt(float yaw) {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    public boolean isPickable() {
        return !this.isRemoved();
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FORWARDS, false);
        builder.define(BACKWARDS, false);
        builder.define(LEFT, false);
        builder.define(RIGHT, false);
        builder.define(JUMPING, false);
        builder.define(DRIFTING, false);
    }

    public void remove(RemovalReason reason) {
        super.remove(reason);
    }

    @Override
    protected Item getDropItem() {
        return MobsCore.HARDBOILER_SPAWN_EGG.get();
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }
}
