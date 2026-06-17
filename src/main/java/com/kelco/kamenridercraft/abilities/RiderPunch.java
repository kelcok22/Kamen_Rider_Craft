package com.kelco.kamenridercraft.abilities;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.network.payload.AttackAnimPayload;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.List;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.ABILITY_TICK;

public class RiderPunch {
    public static void tojimaPunch(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload("default.tojima_punch2", user.getStringUUID()));
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
            PacketDistributor.sendToAllPlayers(new AttackAnimPayload(user.onGround() ? "default.ground_punch" : "default.air_punch", user.getStringUUID()));

            user.push(user.getLookAngle().scale(1.3));
            user.hurtMarked = true;
            user.setInvulnerable(true);
        }
        if (user.getData(ABILITY_TICK) > 3 && user.getData(ABILITY_TICK) < 18) {
            detectHit(user);
        }
        if (user.getData(ABILITY_TICK) >= 40) {
            cancelAbility(user, "", 0);
            return;
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
        user.push(user.getLookAngle().scale(-1.1));
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
