package com.kelco.kamenridercraft.abilities;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.network.payload.AttackAnimPayload;
import com.kelco.kamenridercraft.world.damagesource.RiderDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.List;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.ABILITY_TICK;

public class RiderKick {
    public static void genericRiderKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload(user.onGround() ? "default.floor_start_kick" : "default.air_start_kick", user.getStringUUID()));

            if (!user.onGround()) {
                Vec3 initialVec = user.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 1.1D, initialVec.z);
                user.setDeltaMovement(climbVec.scale(0.97D));
            }
            user.hurtMarked = true;
        }
        if (user.isUnderWater() || user.isFallFlying()) {
            cancelAbility(user);
        }

        if (user.onGround() && user.getData(ABILITY_TICK) == 3) {
            Vec3 initialVec = user.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 1.25D, initialVec.z);
            user.setDeltaMovement(climbVec.scale(0.97D));
            user.hurtMarked = true;
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
        }

        if (user.getData(ABILITY_TICK) == 17) {
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload("default.kick", user.getStringUUID()));
        }

        if (user.getData(ABILITY_TICK) > 17) {
            detectHit(user);
            if (user.getData(ABILITY_TICK) >= 60 || user.onGround()) {
                cancelAbility(user);
                return;
            }
            if (user.getData(ABILITY_TICK) == 21) {
                user.setDeltaMovement(0, 0, 0);
                Double y = user.getLookAngle().y;
                if (y < 0.5) y = 0.05d;
                Vec3 look = new Vec3(user.getLookAngle().x * 0.1, y * 0.04, user.getLookAngle().z * 0.1).scale(20);
                user.setDeltaMovement(look.scale(0.97D));
                user.hurtMarked = true;
            }
            if (user.getData(ABILITY_TICK) > 22) {
                ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 0, user.getZ(), 1, 0, 0, 0, 0);
                ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
                ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 0.5, user.getZ(), 1, 0, 0, 0, 0);
            }
        }


        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }

    public static void kickHit(LivingEntity user, LivingEntity hitEnemy) {
        float damageModifier = 5 + user.fallDistance;

        if (user.hasEffect(EffectCore.PUNCH)) {
            damageModifier = damageModifier + user.getEffect(EffectCore.PUNCH).getAmplifier() + 1;
        }

        if (user.hasEffect(MobEffects.DAMAGE_BOOST)) {
            damageModifier = damageModifier + (user.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() + 1) * 3;
        }
        DamageSource damageSource = new DamageSource(
                user.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(RiderDamageTypes.RIDER_KICK), user, user, user.position());

        hitEnemy.hurt(damageSource, damageModifier);
        hitEnemy.push(user.getLookAngle().scale(3));
        ((ServerLevel) user.level()).sendParticles(ParticleTypes.EXPLOSION, user.getX(), user.getY() + 0.5, user.getZ(), 1, 0, 0, 0, 0);

        if (hitEnemy.getHealth() < hitEnemy.getMaxHealth() / 3) {
            hitEnemy.addEffect(new MobEffectInstance(EffectCore.EXPLODE, 40, 3, false, true));
        }
        user.resetFallDistance();
        user.hurtMarked = true;
        cancelAbility(user);
    }

    public static void detectHit(LivingEntity user) {
        List<LivingEntity> nearbyEnemies = user.level().getEntitiesOfClass(LivingEntity.class, user.getBoundingBox().inflate(1.5), enemy -> (enemy != user));
        for (LivingEntity enemy : nearbyEnemies) {
            kickHit(user, enemy);
        }
    }
}
