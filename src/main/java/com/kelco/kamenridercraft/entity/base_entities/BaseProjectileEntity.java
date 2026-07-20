package com.kelco.kamenridercraft.entity.base_entities;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameRules;
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
    private String projectile = "laser";
    private String model = "laser";
    private String texture = "yellow_laser";
    private boolean glowing = false;
    private int ttl = 400;

    private float damage;
    private int explosionPower;
    private String[] effects;

    private boolean inGround = false;
    private boolean animStarted = false;

    private static final RawAnimation SKULL_ANIM = RawAnimation.begin().thenPlay("projectile.skull_jostle");
    private static final RawAnimation SPIN_ANIM = RawAnimation.begin().thenPlay("projectile.spinning");
    private static final RawAnimation EFFECT_BALL_ANIM = RawAnimation.begin().thenPlay("projectile.effect_ball");
    private static final RawAnimation MEDAL_ANIM = RawAnimation.begin().thenPlay("projectile.medal");

    private static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(BaseProjectileEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<String> MODEL = SynchedEntityData.defineId(BaseProjectileEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> GLOWING = SynchedEntityData.defineId(BaseProjectileEntity.class, EntityDataSerializers.BOOLEAN);

    public BaseProjectileEntity(EntityType<? extends BaseProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    public BaseProjectileEntity(Level level, LivingEntity shooter, String projectileName, float projDamage, int explosionStrength, String[] projectileEffects) {
        super(MobsCore.BASE_PROJECTILE.get(), level);
        setOwner(shooter);
        projectile = projectileName.toLowerCase();
        damage = projDamage;
        explosionPower = explosionStrength;
        effects = projectileEffects;
        Vec3 vec3 = getDeltaMovement();
        double d0 = vec3.horizontalDistance();
        setPos(shooter.getX(), shooter.getEyeY() - (double) 0.1F, shooter.getZ());
        setYRot((float) (Mth.atan2(vec3.x, vec3.z) * (double) 180.0F / (double) (float) Math.PI));
        setXRot((float) (Mth.atan2(vec3.y, d0) * (double) 180.0F / (double) (float) Math.PI));
    }

    public void tick() {
        super.tick();
        Vec3 vec3 = getDeltaMovement();
        if (ttl > 0) {
            ++ttl;
        } else {
            discard();
        }
        if (!animStarted) {
            switch (projectile.toLowerCase()) {
                case "short_laser", "laser", "long_laser", "rocket":
                    triggerAnim("projectile", "spin");
                    break;
                case "skull":
                    triggerAnim("projectile", "skull_jostle");
                    break;
                case "cell_medal":
                    triggerAnim("projectile", "medal");
                    break;
                case "effect_ball":
                    triggerAnim("projectile", "effect_ball");
                    break;
            }
        }
        if (level() instanceof ServerLevel serverLevel) {
            switch (projectile.toLowerCase()) {
                case "rocket":
                    serverLevel.sendParticles(ParticleTypes.WHITE_SMOKE, getX(), getY(), getZ(), 10, 0, 0, 0, 0.05);
                    break;
                case "effect_ball":
                    System.out.println(texture);
                    if (texture.equalsIgnoreCase("lightning_ball")) {
                        serverLevel.sendParticles(ModParticles.ELECTRIC_SPARK_PARTICLES.get(), getX(), getY(), getZ(), 5, 0, 0, 0, 0);

                    } else if (texture.equalsIgnoreCase("fire_ball")) {
                        serverLevel.sendParticles(ParticleTypes.SMALL_FLAME, getX(), getY(), getZ(), 10, 0, 0, 0, 0.05);
                    }
                    break;
            }
        }

        if (xRotO == 0.0F && yRotO == 0.0F) {
            double d0 = vec3.horizontalDistance();
            setYRot((float) (Mth.atan2(vec3.x, vec3.z) * (double) 180.0F / (double) (float) Math.PI));
            setXRot((float) (Mth.atan2(vec3.y, d0) * (double) 180.0F / (double) (float) Math.PI));
            yRotO = getYRot();
            xRotO = getXRot();
        }

        BlockPos blockpos = blockPosition();
        BlockState blockstate = level().getBlockState(blockpos);
        if (!blockstate.isAir() && !noPhysics) {
            if (projectile.equalsIgnoreCase("rocket")) {
                boolean flag = level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
                this.level().explode(null, this.getX(), this.getY(), this.getZ(), explosionPower, flag, Level.ExplosionInteraction.MOB);
            }
            discard();
//            VoxelShape voxelshape = blockstate.getCollisionShape(level(), blockpos);
//            if (!voxelshape.isEmpty()) {
//                Vec3 vec31 = position();
//
//                for (AABB aabb : voxelshape.toAabbs()) {
//                    if (aabb.move(blockpos).contains(vec31)) {
//                        inGround = true;
//                        break;
//                    }
//                }
//            }
        }


        if (isInWaterOrRain() || blockstate.is(Blocks.POWDER_SNOW) || isInFluidType((fluidType, height) -> canFluidExtinguish(fluidType))) {
            clearFire();
        }

        if (inGround && !noPhysics) {
//            if (lastState != blockstate && shouldFall()) {
//                startFalling();
//            } else if (!level().isClientSide) {
//                tickDespawn();
//            }

            //++inGroundTime;
        } else {
            //inGroundTime = 0;
            Vec3 vec32 = position();
            Vec3 vec33 = vec32.add(vec3);
            HitResult hitresult = level().clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            if (hitresult.getType() != HitResult.Type.MISS) {
                vec33 = hitresult.getLocation();
            }

            while (!isRemoved()) {
                EntityHitResult entityhitresult = findHitEntity(vec32, vec33);
                if (entityhitresult != null) {
                    hitresult = entityhitresult;
                }

                if (hitresult != null && hitresult.getType() == HitResult.Type.ENTITY) {
                    Entity entity = ((EntityHitResult) hitresult).getEntity();
                    Entity entity1 = getOwner();
                    if (entity instanceof Player && entity1 instanceof Player && !((Player) entity1).canHarmPlayer((Player) entity)) {
                        hitresult = null;
                        entityhitresult = null;
                    }
                }

                if (hitresult != null && hitresult.getType() != HitResult.Type.MISS && !noPhysics) {
                    if (EventHooks.onProjectileImpact(this, hitresult)) {
                        break;
                    }

                    ProjectileDeflection projectiledeflection = hitTargetOrDeflectSelf(hitresult);
                    hasImpulse = true;
                    if (projectiledeflection != ProjectileDeflection.NONE) {
                        break;
                    }
                }

                if (entityhitresult == null) {
                    break;
                }

                hitresult = null;
            }

            vec3 = getDeltaMovement();
            double d5 = vec3.x;
            double d6 = vec3.y;
            double d1 = vec3.z;

            double d7 = getX() + d5;
            double d2 = getY() + d6;
            double d3 = getZ() + d1;
            double d4 = vec3.horizontalDistance();
            if (noPhysics) {
                setYRot((float) (Mth.atan2(-d5, -d1) * (double) 180.0F / (double) (float) Math.PI));
            } else {
                setYRot((float) (Mth.atan2(d5, d1) * (double) 180.0F / (double) (float) Math.PI));
            }

            setXRot((float) (Mth.atan2(d6, d4) * (double) 180.0F / (double) (float) Math.PI));
            setXRot(lerpRotation(xRotO, getXRot()));
            setYRot(lerpRotation(yRotO, getYRot()));
            float f = 0.99F;
            if (isInWater()) {
                for (int j = 0; j < 4; ++j) {
                    float f1 = 0.25F;
                    level().addParticle(ParticleTypes.BUBBLE, d7 - d5 * (double) 0.25F, d2 - d6 * (double) 0.25F, d3 - d1 * (double) 0.25F, d5, d6, d1);
                }

                f = getWaterInertia();
            }

            setDeltaMovement(vec3.scale((double) f));
            if (!noPhysics) {
                applyGravity();
            }

            setPos(d7, d2, d3);
            checkInsideBlocks();
        }

    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity hitEntity = result.getEntity();
        if (getOwner() instanceof LivingEntity owner) {
            hitEntity.hurt(hitEntity.damageSources().mobProjectile(this, owner), damage);
        } else {
            hitEntity.hurt(hitEntity.damageSources().generic(), damage);
        }
        if (projectile.equalsIgnoreCase("rocket")) {
            boolean flag = level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
            level().explode(null, getX() + getLookAngle().x * 8, getY() + 1, getZ() + getLookAngle().z * 8, explosionPower, flag, Level.ExplosionInteraction.MOB);
        } else if (texture.equalsIgnoreCase("lightning_ball")) {
            if (hitEntity instanceof LivingEntity hurtLivingEntity) {
                hurtLivingEntity.addEffect(new MobEffectInstance(EffectCore.ELECTRIC_SHOCK, 200, 30, false, false));
            }
        } else if (texture.equalsIgnoreCase("fire_ball")) {
            hitEntity.igniteForSeconds(10);
        }
        discard();
    }

    public BaseProjectileEntity setTexture(String texture) {
        this.texture = texture;
        entityData.set(TEXTURE, texture);
        return this;
    }

    public String getTexture() {
        return entityData.get(TEXTURE);
    }

    public BaseProjectileEntity setModel(String model) {
        this.model = model;
        entityData.set(MODEL, model);
        return this;
    }

    public String getModel() {
        return entityData.get(MODEL);
    }

    public BaseProjectileEntity setGlowing(boolean isGlowing) {
        this.glowing = isGlowing;
        entityData.set(GLOWING, isGlowing);
        return this;
    }

    public boolean isGlowing() {
        return entityData.get(GLOWING);
    }

    protected float getWaterInertia() {
        return 0.6F;
    }


    @Nullable
    protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
        return ProjectileUtil.getEntityHitResult(level(), this, startVec, endVec, getBoundingBox().expandTowards(getDeltaMovement()).inflate((double) 1.0F), this::canHitEntity);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(MODEL, "laser");
        builder.define(TEXTURE, "yellow_laser");
        builder.define(GLOWING, true);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("model", model);
        compound.putString("texture", texture);
        compound.putBoolean("glowing", glowing);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("model") && compound.contains("texture") && compound.contains("glowing") && !level().isClientSide()) {
            entityData.set(MODEL, compound.getString("model"));
            entityData.set(TEXTURE, compound.getString("texture"));
            entityData.set(GLOWING, compound.getBoolean("glowing"));
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "projectile", 0, state -> PlayState.STOP).triggerableAnim("spin", SPIN_ANIM).triggerableAnim("medal", MEDAL_ANIM).triggerableAnim("effect_ball", EFFECT_BALL_ANIM).triggerableAnim("skull_jostle", SKULL_ANIM));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
