package com.kelco.kamenridercraft.entities.projectile;

import com.kelco.kamenridercraft.entities.MobsCore;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LaserProjectileEntity extends AbstractArrow implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public  float damageValue = 4F;
    public  int timer = 0;

    private static final EntityDataAccessor<String> COLOR_DATA =
            SynchedEntityData.defineId(LaserProjectileEntity.class, EntityDataSerializers.STRING);

    private static final EntityDataAccessor<String> SHAPE_DATA =
            SynchedEntityData.defineId(LaserProjectileEntity.class, EntityDataSerializers.STRING);

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(COLOR_DATA, "");
        builder.define(SHAPE_DATA, "");
    }

    public LaserProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LaserProjectileEntity(LivingEntity shooter, Level level) {
        super(MobsCore.LASER_PROJECTILE.get(), shooter, level, new ItemStack(Items.APPLE), new ItemStack(Items.BOW));
    }

    public void setColor(String color) {
        this.entityData.set(COLOR_DATA, color);
    }

    public String getColor() {
       return this.entityData.get(COLOR_DATA);
    }

    public void setShape(String shape) {
        this.entityData.set(SHAPE_DATA, shape);
    }

    public String getShape() {
        return this.entityData.get(SHAPE_DATA);
    }

@Override
    public void tick() {
        super.tick();
        if (timer == 240) {
            this.discard();
        }
        timer += 1;
        if (this.isInLiquid() || this.isInPowderSnow){
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result){
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().arrow(this, this.getOwner()), this.damageValue);
        this.discard();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return null;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.discard();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

        RawAnimation BLAST = RawAnimation.begin().thenLoop("blast");

        controllers.add(new AnimationController<>(this, "blast", 0, state -> state.setAndContinue(BLAST)));
    }
}
