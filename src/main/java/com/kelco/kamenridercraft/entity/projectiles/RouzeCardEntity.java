package com.kelco.kamenridercraft.entity.projectiles;

import com.kelco.kamenridercraft.entity.base_entities.NeoBaseProjectileEntity;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.UndeadEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_STATE;
import static com.kelco.kamenridercraft.item.heisei_phase_1.BladeRiderItems.BLANK_ROUZECARD;

public class RouzeCardEntity extends NeoBaseProjectileEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation CARD_ANIM = RawAnimation.begin().thenPlay("projectile.card");
    boolean startedAnim = false;

    public String projectile;

    public RouzeCardEntity(Level level, LivingEntity shooter, String projectileName, float projDamage,
                           int explosionStrength, String[] projectileEffects) {
        super(MobsCore.ROUZE_CARD.get(), level);
        setOwner(shooter);
        projectile = projectileName.toLowerCase();
        Vec3 vec3 = getDeltaMovement();
        double d0 = vec3.horizontalDistance();
        setPos(shooter.getX(), shooter.getEyeY() - (double) 0.1F, shooter.getZ());
        setYRot((float) (Mth.atan2(vec3.y, vec3.z) * (double) 180.0F / (double) (float) Math.PI));
        setXRot((float) (Mth.atan2(vec3.y, d0) * (double) 180.0F / (double) (float) Math.PI));
    }

    public RouzeCardEntity(EntityType<? extends RouzeCardEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void tick() {
        if (!startedAnim) {
            triggerAnim("projectile", "card");
            startedAnim = true;
        }
        if (!level().getBlockState(blockPosition()).isAir()) {
            setPos(getX(), getY(), getZ());
            ItemEntity card = new ItemEntity(level(), getX(), getY(), getZ(),
                    new ItemStack(BLANK_ROUZECARD.get(), 1), 0, 0, 0);
            card.noPhysics = true;
            card.setPickUpDelay(0);
            level().addFreshEntity(card);
            card.absMoveTo(getOwner().getX(), getOwner().getY(), getOwner().getZ());
            discard();
        }
        super.tick();
    }



    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity hitEntity = result.getEntity();
        if (getProjectile().equals("blank_rouze") && getOwner() instanceof ServerPlayer sealer &&
                hitEntity.getData(MOB_STATE).contains("sealable")) {
            if (hitEntity instanceof UndeadEntity undeadEntity) {
                undeadEntity.sealUndead(sealer);
                undeadEntity.discard();
            }
        } else {
            ItemEntity card = new ItemEntity(level(), getX(), getY(), getZ(),
                    new ItemStack(BLANK_ROUZECARD.get(), 1), 0, 0, 0);
            card.setPickUpDelay(0);
            level().addFreshEntity(card);
            card.absMoveTo(getOwner().getX(), getOwner().getY(), getOwner().getZ());
        }
        discard();
        super.onHitEntity(result);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "projectile", 0,
                state -> PlayState.STOP).triggerableAnim("card", CARD_ANIM));
    }
}