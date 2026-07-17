package com.kelco.kamenridercraft.entity.base_entities;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.event.EventHooks;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class BaseProjectileEntity extends Projectile implements GeoEntity, TraceableEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private String projectile;
    private String model;
    private String texture;
    private float damage;
    private int explosionPower;
    private String[] effects;
    private boolean inGround = false;
    private boolean animStarted = false;

    private static final RawAnimation SKULL_ANIM = RawAnimation.begin().thenPlay("projectile.skull_jostle");
    private static final RawAnimation SPIN_ANIM = RawAnimation.begin().thenPlay("projectile.spinning");
    private static final RawAnimation MEDAL_ANIM = RawAnimation.begin().thenPlay("projectile.medal");

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
        Vec3 vec3 = this.getDeltaMovement();
        double d0 = vec3.horizontalDistance();
        this.setPos(shooter.getX(), shooter.getEyeY() - (double) 0.1F, shooter.getZ());
        this.setYRot((float) (Mth.atan2(vec3.x, vec3.z) * (double) 180.0F / (double) (float) Math.PI));
        this.setXRot((float) (Mth.atan2(vec3.y, d0) * (double) 180.0F / (double) (float) Math.PI));
    }

    public void tick() {
        super.tick();
        Vec3 vec3 = this.getDeltaMovement();
        if (!animStarted) {
            triggerAnim("projectile", "spin");
        }
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            double d0 = vec3.horizontalDistance();
            this.setYRot((float) (Mth.atan2(vec3.x, vec3.z) * (double) 180.0F / (double) (float) Math.PI));
            this.setXRot((float) (Mth.atan2(vec3.y, d0) * (double) 180.0F / (double) (float) Math.PI));
            this.yRotO = this.getYRot();
            this.xRotO = this.getXRot();
        }

        BlockPos blockpos = this.blockPosition();
        BlockState blockstate = this.level().getBlockState(blockpos);
        if (!blockstate.isAir() && !noPhysics) {
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


        if (this.isInWaterOrRain() || blockstate.is(Blocks.POWDER_SNOW) || this.isInFluidType((fluidType, height) -> this.canFluidExtinguish(fluidType))) {
            this.clearFire();
        }

        if (this.inGround && !noPhysics) {
//            if (this.lastState != blockstate && this.shouldFall()) {
//                this.startFalling();
//            } else if (!this.level().isClientSide) {
//                this.tickDespawn();
//            }

            //++this.inGroundTime;
        } else {
            //this.inGroundTime = 0;
            Vec3 vec32 = this.position();
            Vec3 vec33 = vec32.add(vec3);
            HitResult hitresult = this.level().clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            if (hitresult.getType() != HitResult.Type.MISS) {
                vec33 = hitresult.getLocation();
            }

            while (!this.isRemoved()) {
                EntityHitResult entityhitresult = this.findHitEntity(vec32, vec33);
                if (entityhitresult != null) {
                    hitresult = entityhitresult;
                }

                if (hitresult != null && hitresult.getType() == HitResult.Type.ENTITY) {
                    Entity entity = ((EntityHitResult) hitresult).getEntity();
                    Entity entity1 = this.getOwner();
                    if (entity instanceof Player && entity1 instanceof Player && !((Player) entity1).canHarmPlayer((Player) entity)) {
                        hitresult = null;
                        entityhitresult = null;
                    }
                }

                if (hitresult != null && hitresult.getType() != HitResult.Type.MISS && !noPhysics) {
                    if (EventHooks.onProjectileImpact(this, hitresult)) {
                        break;
                    }

                    ProjectileDeflection projectiledeflection = this.hitTargetOrDeflectSelf(hitresult);
                    this.hasImpulse = true;
                    if (projectiledeflection != ProjectileDeflection.NONE) {
                        break;
                    }
                }

                if (entityhitresult == null) {
                    break;
                }

                hitresult = null;
            }

            vec3 = this.getDeltaMovement();
            double d5 = vec3.x;
            double d6 = vec3.y;
            double d1 = vec3.z;

            double d7 = this.getX() + d5;
            double d2 = this.getY() + d6;
            double d3 = this.getZ() + d1;
            double d4 = vec3.horizontalDistance();
            if (noPhysics) {
                this.setYRot((float) (Mth.atan2(-d5, -d1) * (double) 180.0F / (double) (float) Math.PI));
            } else {
                this.setYRot((float) (Mth.atan2(d5, d1) * (double) 180.0F / (double) (float) Math.PI));
            }

            this.setXRot((float) (Mth.atan2(d6, d4) * (double) 180.0F / (double) (float) Math.PI));
            this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
            this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
            float f = 0.99F;
            if (this.isInWater()) {
                for (int j = 0; j < 4; ++j) {
                    float f1 = 0.25F;
                    this.level().addParticle(ParticleTypes.BUBBLE, d7 - d5 * (double) 0.25F, d2 - d6 * (double) 0.25F, d3 - d1 * (double) 0.25F, d5, d6, d1);
                }

                f = this.getWaterInertia();
            }

            this.setDeltaMovement(vec3.scale((double) f));
            if (!noPhysics) {
                this.applyGravity();
            }

            this.setPos(d7, d2, d3);
            this.checkInsideBlocks();
        }

    }

    protected float getWaterInertia() {
        return 0.6F;
    }


    @Nullable
    protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
        return ProjectileUtil.getEntityHitResult(this.level(), this, startVec, endVec, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate((double) 1.0F), this::canHitEntity);
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
        controllers.add(new AnimationController<>(this, "projectile", 0, state -> PlayState.STOP)
                .triggerableAnim("spin", SPIN_ANIM)
                .triggerableAnim("medal", MEDAL_ANIM)
                .triggerableAnim("skull_jostle", SKULL_ANIM));

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
