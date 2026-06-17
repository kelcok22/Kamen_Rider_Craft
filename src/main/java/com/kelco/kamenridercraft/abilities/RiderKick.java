package com.kelco.kamenridercraft.abilities;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.AttackAnimPayload;
import com.kelco.kamenridercraft.network.payload.EndAttackAnimationPayload;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.kelco.kamenridercraft.world.damagesource.RiderDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.List;
import java.util.Random;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.*;

public class RiderKick {
    public static void genericRiderKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            if (user.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) {
                driverItem.kickModelModifier = true;
            }
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload(user.onGround() ? "default.floor_start_kick" : "default.air_start_kick", user.getStringUUID()));

            if (!user.onGround()) {
                Vec3 initialVec = user.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 1.125D, initialVec.z);
                user.setDeltaMovement(climbVec.scale(0.97D));
            }

            user.hurtMarked = true;
        }

        if (user.onGround() && user.getData(ABILITY_TICK) == 3) {
            Vec3 initialVec = user.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 1.2D, initialVec.z);
            user.setDeltaMovement(climbVec.scale(0.97D));
            user.hurtMarked = true;
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
        }

        if (user.getData(ABILITY_TICK) == 17) {
            PacketDistributor.sendToAllPlayers(new EndAttackAnimationPayload(user.getStringUUID()));
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload("default.kick", user.getStringUUID()));
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 180 ) {
            cancelAbility(user, "", 0);
        }

        if (user.getData(ABILITY_TICK) > 17 && user.onGround()) {
            cancelAbility(user, "land", 0);
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
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
            detectHit(user);
            Random rand = new Random();
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.33F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.66F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(1) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
        }

        if (user.getData(ABILITY_TICK) == 36) {
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload("default.kick_loop", user.getStringUUID()));
        }

        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }



    public static void kabutoKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload("kabuto.rider_kick_wait", user.getStringUUID()));
            user.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 20, true, false));
            user.setInvulnerable(true);
        }
        if (!user.onGround() || user.isInWater()) {
            cancelAbility(user, "", 0);
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
            return;
        }

        if (user.getData(ABILITY_TICK) > 10 && user.getData(ABILITY_TICK) < 60) {
            ((ServerLevel) user.level()).sendParticles(ModParticles.ELECTRIC_SPARK_PARTICLES.get(), user.getX(), user.getEyeY() - user.getScale() * 0.75, user.getZ(), 5, 0, 0, 0, 0);
        }
        if (user.getData(ABILITY_TICK) == 60) {
            PacketDistributor.sendToAllPlayers(new EndAttackAnimationPayload(user.getStringUUID()));
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload("kabuto.rider_kick", user.getStringUUID()));
        }
        if (user.getData(ABILITY_TICK) > 65 && user.getData(ABILITY_TICK) < 70) {
            detectHit(user);
        }
        if (user.getData(ABILITY_TICK) >= 70) {
            cancelAbility(user, "", 0);
            return;
        }
        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }



    public static void kickHit(LivingEntity user, LivingEntity hitEnemy, String kickType) {
        float damageModifier = 5;
        float pushFactor = 1.5F;
        switch (kickType){
            case "kabuto":
                damageModifier += 5;
                pushFactor = 2;
            default:
                damageModifier = damageModifier + user.fallDistance;
                user.resetFallDistance();
            break;
        }

        hitEnemy.push(user.getLookAngle().scale(pushFactor));
        user.hurtMarked = true;

        if (user.hasEffect(EffectCore.PUNCH)) {
            damageModifier = damageModifier + user.getEffect(EffectCore.PUNCH).getAmplifier() + 1;
        }

        if (user.hasEffect(MobEffects.DAMAGE_BOOST)) {
            damageModifier = damageModifier + (user.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() + 1) * 3;
        }

        if (user.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SCALE).getValue() > 0) {
            damageModifier = (float) (damageModifier * user.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SCALE).getValue());
        }

        DamageSource damageSource = new DamageSource(
                user.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(RiderDamageTypes.RIDER_KICK), user, user, user.position());

        hitEnemy.hurt(damageSource, damageModifier);
        ((ServerLevel) user.level()).sendParticles(ParticleTypes.EXPLOSION, user.getX(), user.getY() + 0.5, user.getZ(), 1, 0, 0, 0, 0);

        if (hitEnemy.getHealth() < hitEnemy.getMaxHealth() / 3) {
            hitEnemy.addEffect(new MobEffectInstance(EffectCore.EXPLODE, 40, 3, false, true));
        }
    }



    public static void detectHit(LivingEntity user) {
        List<LivingEntity> nearbyEnemies = user.level().getEntitiesOfClass(LivingEntity.class, user.getBoundingBox().inflate(0.5 + user.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SCALE).getValue()), enemy -> (enemy != user));
        boolean enemyDetected = false;
        for (LivingEntity enemy : nearbyEnemies) {
            enemyDetected = true;
            switch (user.getData(USED_ABILITY)) {
                case "kabuto_rider_kick":
                    kickHit(user, enemy, "kabuto");
                    break;
                case "kiva_rider_kick":
                    kickHit(user, enemy, "kiva_logo");
                default:
                    kickHit(user, enemy, "normal");
            }
        }
        if (enemyDetected && !user.getData(USED_ABILITY).equals("kabuto_rider_kick")) {
            cancelAbility(user, "land", 10);
        } else if (enemyDetected) {
            cancelAbility(user, "", 10);
        }
    }
}
