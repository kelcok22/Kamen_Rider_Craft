package com.kelco.kamenridercraft.abilities.kicks;

import com.kelco.kamenridercraft.network.payload.AnimPayload;
import com.kelco.kamenridercraft.particle.ModParticles;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.network.PacketDistributor;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.abilities.hit_handling.AbilityHitDetection.detectHit;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_TICK;

public class KabutoRiderKicks {
    public static void kabutoKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AnimPayload("kabuto.rider_kick_wait", "attack", false, user.getStringUUID()));
            user.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 20, true, false));
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        if (!user.onGround() || user.isInWater() || user.getData(ABILITY_TICK) >= 90) {
            cancelAbility(user, "", 0);
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
            return;
        }

        if (user.getData(ABILITY_TICK) > 10 && user.getData(ABILITY_TICK) < 60) {
            ((ServerLevel) user.level()).sendParticles(ModParticles.ELECTRIC_SPARK_PARTICLES.get(), user.getX(), user.getEyeY() - user.getScale() * 0.75, user.getZ(), 5, 0, 0, 0, 0);
        }

        switch (user.getData(ABILITY_TICK)) {
            case 50:
                user.setInvulnerable(true);
                user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
                return;
            case 60:
                PacketDistributor.sendToAllPlayers(new AnimPayload("kabuto.rider_kick", "attack", true, user.getStringUUID()));
                user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
                return;
        }

        if (user.getData(ABILITY_TICK) > 65 && user.getData(ABILITY_TICK) < 70) {
            detectHit(user);
        }

        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);

    }
}