package com.kelco.kamenridercraft.entity.base_entities;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.UUID;

public class BaseEffectEntity extends Entity implements GeoEntity, TraceableEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int timeToLive = 255;
    private String model = "";
    private String texture = "";
    private boolean glowing = false;
    private boolean startAnimation = false;

    private static final RawAnimation LOGO_SPIN = RawAnimation.begin().thenPlay("effects.logo_spin");
    private static final RawAnimation LOGO_GROW = RawAnimation.begin().thenPlay("logo_grow");
    private static final RawAnimation EXCEED_CHARGE = RawAnimation.begin().thenPlay("exceed_charge");

    private LivingEntity owner;
    private UUID ownerUUID;

    private static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(BaseEffectEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<String> MODEL = SynchedEntityData.defineId(BaseEffectEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> GLOWING = SynchedEntityData.defineId(BaseEffectEntity.class, EntityDataSerializers.BOOLEAN);

    public BaseEffectEntity(EntityType<BaseEffectEntity> entityType, Level level) {
        super(entityType, level);
    }

    public BaseEffectEntity(Level level, int TTL, LivingEntity user) {
        super(MobsCore.BASE_EFFECT.get(), level);
        this.noPhysics = true;
        this.timeToLive = TTL;
        this.owner = user;
        this.ownerUUID = user.getUUID();
    }


    public void refreshDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.refreshDimensions();
        this.setPos(d0, d1, d2);
    }


    public BaseEffectEntity setTexture(String texture) {
        this.texture = texture;
        this.entityData.set(TEXTURE, texture);
        return this;
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }

    public BaseEffectEntity setModel(String model) {
        this.model = model;
        this.entityData.set(MODEL, model);
        return this;
    }

    public String getModel() {
        return this.entityData.get(MODEL);
    }

    public BaseEffectEntity setGlowing(boolean isGlowing) {
        this.glowing = true;
        this.entityData.set(GLOWING, isGlowing);
        return this;
    }

    public boolean isGlowing() {
        return this.entityData.get(GLOWING);
    }

    public void setOwner(@javax.annotation.Nullable LivingEntity owner) {
        this.owner = owner;
        this.ownerUUID = owner == null ? null : owner.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUUID != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel) this.level()).getEntity(this.ownerUUID);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity) entity;
            }
        }
        return this.owner;
    }


    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            if (!this.startAnimation && this.getTexture().contains("wizard_circle")) {
                triggerAnim("effect", "logo_spin");
                this.startAnimation = true;
            }

            if (this.timeToLive <= 0) {
                this.discard();
            }
            this.timeToLive--;
        }


        Vec3 vec3 = this.getDeltaMovement();
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        this.setDeltaMovement(vec3);

        if (!noPhysics) {
            this.applyGravity();
        }

        double d7 = this.getX() + vec3.x;
        double d2 = this.getY() + vec3.y;
        double d3 = this.getZ() + vec3.z;

        this.setPos(d7, d2, d3);
        this.checkInsideBlocks();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(MODEL, "");
        builder.define(TEXTURE, "");
        builder.define(GLOWING, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("model", this.model);
        compound.putString("texture", this.texture);
        compound.putBoolean("glowing", this.glowing);
        if (this.ownerUUID != null) {
            compound.putUUID("Owner", this.ownerUUID);
        }
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("model") && compound.contains("texture") && compound.contains("glowing") && !this.level().isClientSide()) {
            this.entityData.set(MODEL, compound.getString("model"));
            this.entityData.set(TEXTURE, compound.getString("texture"));
            this.entityData.set(GLOWING, compound.getBoolean("glowing"));
        }
        if (compound.hasUUID("Owner")) {
            this.ownerUUID = compound.getUUID("Owner");
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if (DATA_POSE.equals(key)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(key);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "effect", 0, state -> PlayState.STOP).triggerableAnim("logo_spin", LOGO_SPIN));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
