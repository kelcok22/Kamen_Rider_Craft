package com.kelco.kamenridercraft.entity.projectiles;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

public class BaseProjectileEntity extends Projectile implements GeoEntity, TraceableEntity {
    private String projectile;
    private String model;
    private String texture;
    private float damage;
    private int explosionPower;
    private String[] effects;

    public BaseProjectileEntity(EntityType<? extends BaseProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    public BaseProjectileEntity(Level level, LivingEntity shooter, String projectileName, String modelName, String textureName, float projDamage, int explosionStrength, String[] projectileEffects) {
        super(MobsCore.BASE_PROJECTILE.get(), level);
        this.setOwner(shooter);
        this.projectile = projectileName.toLowerCase();
        this.model = modelName.toLowerCase();
        this.texture = textureName.toLowerCase();
        this.damage = projDamage;
        this.explosionPower = explosionStrength;
        this.effects = projectileEffects;
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }
}
