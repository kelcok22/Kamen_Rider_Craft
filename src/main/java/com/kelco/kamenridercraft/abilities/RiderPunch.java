package com.kelco.kamenridercraft.abilities;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.AttackAnimPayload;
import com.kelco.kamenridercraft.network.payload.EndAttackAnimationPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.List;
import java.util.Random;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.world.attribute.Attributes.CHANGE_KICK_MODEL;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.ABILITY_TICK;

public class RiderPunch {
    public static void tojimaPunch(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload("default.tojima_punch", user.getStringUUID()));
            user.push(user.getLookAngle().scale(1.3));
            user.hurtMarked = true;
            user.setInvulnerable(true);
        }
        if (user.getData(ABILITY_TICK) > 3 && user.getData(ABILITY_TICK) < 18) {
            detectHit(user);
        }
        if (user.getData(ABILITY_TICK) >= 24) {
            cancelAbility(user, "", 0);
            return;
        }
        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }



    public static void genericRiderPunch(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            if (user.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) {
                user.getAttribute(CHANGE_KICK_MODEL).setBaseValue(1);
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
            Vec3 climbVec = new Vec3(initialVec.x, 0.85D, initialVec.z);
            user.setDeltaMovement(climbVec.scale(0.97D));
            user.hurtMarked = true;
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
        }

        if (user.getData(ABILITY_TICK) == 17) {
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload("default.punch", user.getStringUUID()));
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 180) {
            cancelAbility(user, "", 0);
        }

        if (user.getData(ABILITY_TICK) > 17 && user.onGround()) {
            cancelAbility(user, "default.land", 0);
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }
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

        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }


    public static void punchHit(LivingEntity user, LivingEntity hitEnemy) {
        user.hurtMarked = true;
        float damageModifier = 5;

        if (user.hasEffect(EffectCore.PUNCH)) {
            damageModifier = damageModifier + user.getEffect(EffectCore.PUNCH).getAmplifier() + 1;
        }

        if (user.hasEffect(MobEffects.DAMAGE_BOOST)) {
            damageModifier = damageModifier + (user.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() + 1) * 3;
        }

        if (user.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SCALE).getValue() > 0) {
            damageModifier = (float) (damageModifier * user.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SCALE).getValue());
        }

        hitEnemy.hurt(user.damageSources().mobAttack(user), damageModifier);
        hitEnemy.push(user.getLookAngle().scale(3));
        user.push(user.getLookAngle().scale(-1.05));
        ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST_EMITTER_SMALL, user.getX(), user.getEyeY(), user.getZ(), 1, 0, 0, 0, 0.05);
        if (hitEnemy.getHealth() < hitEnemy.getMaxHealth() / 3) {
            hitEnemy.addEffect(new MobEffectInstance(EffectCore.EXPLODE, 40, 3, false, true));
        }
    }


    public static void detectHit(LivingEntity user) {
        boolean enemyDetected = false;
        List<LivingEntity> nearbyEnemies = user.level().getEntitiesOfClass(LivingEntity.class, user.getBoundingBox().inflate(0.5 + user.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.SCALE).getValue()), enemy -> (enemy != user));
        for (LivingEntity enemy : nearbyEnemies) {
            enemyDetected = true;
            punchHit(user, enemy);
        }
        if (enemyDetected) {
            cancelAbility(user, "", 10);
        }
    }
}
