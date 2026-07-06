package com.kelco.kamenridercraft.abilities.misc_abilities;

import com.kelco.kamenridercraft.abilities.AbilityUtil;
import com.kelco.kamenridercraft.effects.EffectCore;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_TICK;

public class MiscAbilities {
    public static void flightBoost(LivingEntity user) {
        if (!user.level().isClientSide()) {
            user.setData(ABILITY_COOLDOWN, 75);
            user.setData(ABILITY_TICK, 1);
            if (!user.isFallFlying() && user instanceof Player player) {
                user.teleportTo(user.getX(), user.getY() + 2, user.getZ());
                user.jumpFromGround();
                player.startFallFlying();
            }
            user.setDeltaMovement(user.getDeltaMovement().add(user.getLookAngle().scale(2)));
            user.hurtMarked = true;
            AbilityUtil.cancelAbility(user, "", 0);
        }
    }

    public static void clockUp(LivingEntity user) {
        if (!user.level().isClientSide()) {
            user.setData(ABILITY_COOLDOWN, 100);
            if (user.getData(ABILITY_TICK) == 0) {
                user.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250, 20, true, false));
                if (user instanceof Player player) {
                    player.displayClientMessage(Component.translatable("attack.kamenridercraft.clock_up"), true);
                }
            }
            if (user.getData(ABILITY_TICK) >= 250) {
                if (user instanceof Player player) {
                    player.displayClientMessage(Component.translatable("attack.kamenridercraft.clock_over"), true);
                }
                AbilityUtil.cancelAbility(user, "", 0);
            }
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
        }
    }

    public static void grow(LivingEntity user) {
        if (!user.level().isClientSide()) {
            user.setData(ABILITY_COOLDOWN, 50);
            if (user.getData(ABILITY_TICK) == 0) {
                user.addEffect(new MobEffectInstance(EffectCore.BIG, 300, 2, true, false));
            }
            if (user.getData(ABILITY_TICK) >= 50) {
                AbilityUtil.cancelAbility(user, "", 0);
            }
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
        }
    }


    public static void specialTurbo(LivingEntity user) {
        if (!user.level().isClientSide()) {
            user.setData(ABILITY_COOLDOWN, 300);
            if (user.getData(ABILITY_TICK) == 0) {
                if (user instanceof Player player) {
                    player.displayClientMessage(Component.translatable("attack.kamenridercraft.special_turbo"), true);
                }
                user.addEffect(new MobEffectInstance(EffectCore.FIRE_SLASH, 200, 0, true, false));
                user.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1, true, false));
                user.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2, true, false));
                user.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1, true, false));
            }

            ((ServerLevel) user.level()).sendParticles(ParticleTypes.FLAME, user.getX(), user.getY() + 1, user.getZ(), 10, 0, 0, 0, 0.05);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.WHITE_SMOKE, user.getX(), user.getY() + 1, user.getZ(), 2, 0, 0, 0, 0.05);


            if (user.getData(ABILITY_TICK) >= 200) {
                AbilityUtil.cancelAbility(user, "", 0);
            }
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
        }
    }
}