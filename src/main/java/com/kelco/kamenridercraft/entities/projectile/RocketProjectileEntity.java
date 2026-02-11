package com.kelco.kamenridercraft.entities.projectile;

import com.kelco.kamenridercraft.entities.MobsCore;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
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
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        boolean flag = this.level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
        Vec3 look = this.getLookAngle();
        this.level().explode(null, this.getX(), this.getY(), this.getZ(), blastRadius, flag, Level.ExplosionInteraction.MOB);
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
        this.level().explode(null, this.getX(), this.getY(), this.getZ(), blastRadius, flag, Level.ExplosionInteraction.MOB);
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();
        boolean flag = this.isNoPhysics();
        Vec3 vec3 = this.getDeltaMovement();
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            double d0 = vec3.horizontalDistance();
            this.setYRot((float) (Mth.atan2(vec3.x, vec3.z) * (double) 180.0F / (double) (float) Math.PI));
            this.setXRot((float) (Mth.atan2(vec3.y, d0) * (double) 180.0F / (double) (float) Math.PI));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        if (this.level() instanceof ServerLevel serverlevel) {
            serverlevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getX(), this.getY(), this.getZ(), 10, 0, 0, 0, 0.05);
            serverlevel.sendParticles(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 10, 0, 0, 0, 0.05);
        }

        BlockPos blockpos = this.blockPosition();
        BlockState blockstate = this.level().getBlockState(blockpos);
        if (!blockstate.isAir() && !flag) {
            VoxelShape voxelshape = blockstate.getCollisionShape(this.level(), blockpos);
            if (!voxelshape.isEmpty()) {
                Vec3 vec31 = this.position();

                for (AABB aabb : voxelshape.toAabbs()) {
                    if (aabb.move(blockpos).contains(vec31)) {
                        this.inGround = true;
                        break;
                    }
                }
            }
        }
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
