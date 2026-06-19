package com.kelco.kamenridercraft.abilities.hit_handling;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.world.damagesource.RiderDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class AbilityHitProcessing {
    public static void kickHit(LivingEntity user, LivingEntity hitEnemy, String kickType) {
        float damageModifier = 5;
        float pushFactor = 1.5F;
        switch (kickType) {
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
}
