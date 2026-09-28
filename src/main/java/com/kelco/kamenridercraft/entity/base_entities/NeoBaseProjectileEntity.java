package com.kelco.kamenridercraft.entity.base_entities;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
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
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import software.bernie.geckolib.animatable.GeoEntity;

import javax.annotation.Nullable;

public abstract class NeoBaseProjectileEntity extends Projectile implements GeoEntity, TraceableEntity {
    public String projectile;
    private String model;
    private String texture;
    private boolean glowing = false;
    public int ttl = 400;

    private float damage;
    private int explosionPower;
    private String[] effects;

    private boolean animStarted = false;

    private static final EntityDataAccessor<String> PROJECTILE = SynchedEntityData.defineId(NeoBaseProjectileEntity.class,
            EntityDataSerializers.STRING);
    private static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(NeoBaseProjectileEntity.class,
            EntityDataSerializers.STRING);
    private static final EntityDataAccessor<String> MODEL = SynchedEntityData.defineId(NeoBaseProjectileEntity.class,
            EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> GLOWING = SynchedEntityData.defineId(NeoBaseProjectileEntity.class,
            EntityDataSerializers.BOOLEAN);

    public NeoBaseProjectileEntity(EntityType<? extends NeoBaseProjectileEntity> entityType, Level level) {
        super(entityType, level);
    }

    public NeoBaseProjectileEntity(Level level, LivingEntity shooter, String projectileName, float projDamage,
                                   int explosionStrength, String[] projectileEffects) {
        super(MobsCore.BASE_PROJECTILE.get(), level);
        setOwner(shooter);
        projectile = projectileName.toLowerCase();
        entityData.set(PROJECTILE, projectileName.toLowerCase());
        damage = projDamage;
        explosionPower = explosionStrength;
        effects = projectileEffects;
        Vec3 vec3 = getDeltaMovement();
        double d0 = vec3.horizontalDistance();
        setPos(shooter.getX(), shooter.getEyeY() - (double) 0.1F, shooter.getZ());
        setYRot((float) (Mth.atan2(vec3.y, vec3.z) * (double) 180.0F / (double) (float) Math.PI));
        setXRot((float) (Mth.atan2(vec3.y, d0) * (double) 180.0F / (double) (float) Math.PI));
    }

    public void tick() {
        super.tick();
        Vec3 vec3 = getDeltaMovement();
        if (ttl > 0) {
            ++ttl;
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

        if (isInWaterOrRain() || blockstate.is(Blocks.POWDER_SNOW) || isInFluidType((fluidType, height) -> canFluidExtinguish(fluidType))) {
            clearFire();
        }

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
                level().addParticle(ParticleTypes.BUBBLE, d7 - d5 * (double) 0.25F, d2 - d6 * (double) 0.25F,
                        d3 - d1 * (double) 0.25F, d5, d6, d1);
            }

            f = getWaterInertia();
        }

        setDeltaMovement(vec3.scale(f));
        if (!noPhysics) {
            applyGravity();
        }

        setPos(d7, d2, d3);
        checkInsideBlocks();
    }

    protected void onHitEntity(EntityHitResult result) {
        Entity hitEntity = result.getEntity();
        super.onHitEntity(result);
        discard();
    }

    public NeoBaseProjectileEntity setTexture(String texture) {
        this.texture = texture;
        entityData.set(TEXTURE, texture);
        return this;
    }

    public String getTexture() {
        return entityData.get(TEXTURE);
    }

    public NeoBaseProjectileEntity setModel(String model) {
        this.model = model;
        entityData.set(MODEL, model);
        return this;
    }

    public String getModel() {
        return entityData.get(MODEL);
    }

    public NeoBaseProjectileEntity setProjectile(String projectile) {
        this.projectile = projectile;
        entityData.set(PROJECTILE, projectile);
        return this;
    }

    public String getProjectile() {
        return entityData.get(PROJECTILE);
    }

    public NeoBaseProjectileEntity setGlowing(boolean isGlowing) {
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
        return ProjectileUtil.getEntityHitResult(level(), this, startVec, endVec,
                getBoundingBox().expandTowards(getDeltaMovement()).inflate((double) 1.0F), this::canHitEntity);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(MODEL, "");
        builder.define(TEXTURE, "");
        builder.define(PROJECTILE, "");
        builder.define(GLOWING, true);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("model", model);
        compound.putString("texture", texture);
        compound.putString("projectile", projectile);
        compound.putBoolean("glowing", glowing);

    }

    public void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("model") && compound.contains("texture") && compound.contains("glowing") && !level().isClientSide()) {
            entityData.set(MODEL, compound.getString("model"));
            entityData.set(TEXTURE, compound.getString("texture"));
            entityData.set(GLOWING, compound.getBoolean("glowing"));
        }
    }
}