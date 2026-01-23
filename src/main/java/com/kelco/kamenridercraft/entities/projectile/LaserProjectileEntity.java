package com.kelco.kamenridercraft.entities.projectile;

import com.kelco.kamenridercraft.entities.MobsCore;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LaserProjectileEntity extends AbstractArrow implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public LaserProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LaserProjectileEntity(LivingEntity shooter, Level level) {
        super(MobsCore.LASER_PROJECTILE.get(), shooter, level, new ItemStack(Items.APPLE), new ItemStack(Items.BOW));

    }

    @Override
    protected void onHitEntity(EntityHitResult result){
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().arrow(this, this.getOwner()), (4));
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
        return this.cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

        RawAnimation BLAST = RawAnimation.begin().thenLoop("blast");

        controllers.add(new AnimationController<>(this, "blast", 0, state -> state.setAndContinue(BLAST)));
    }
}
