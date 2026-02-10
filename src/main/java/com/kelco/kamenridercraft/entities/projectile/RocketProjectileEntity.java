package com.kelco.kamenridercraft.entities.projectile;

import com.kelco.kamenridercraft.entities.MobsCore;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class RocketProjectileEntity extends AbstractArrow implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public float blastRadius = 4F;

    public RocketProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public RocketProjectileEntity(LivingEntity shooter, Level level) {
        super(MobsCore.ROCKET_PROJECTILE.get(), shooter, level, new ItemStack(Items.APPLE), new ItemStack(Items.BOW));
    }

    @Override
    protected void onHitEntity(EntityHitResult result){
        super.onHitEntity(result);
        boolean flag = this.level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
        Vec3 look = this.getLookAngle();
        this.level().explode(null, this.getX(), this.getY(),this.getZ(), blastRadius, flag, Level.ExplosionInteraction.MOB);
        this.discard();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return null;
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.CHAIN_HIT;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        boolean flag = this.level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
        Vec3 look = this.getLookAngle();
        this.level().explode(null, this.getX(), this.getY(),this.getZ(), blastRadius, flag, Level.ExplosionInteraction.MOB);
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
