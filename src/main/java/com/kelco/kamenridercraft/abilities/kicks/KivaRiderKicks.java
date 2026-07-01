package com.kelco.kamenridercraft.abilities.kicks;

import com.kelco.kamenridercraft.network.payload.AnimPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.Random;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.abilities.hit_handling.AbilityHitDetection.detectHit;
import static com.kelco.kamenridercraft.world.attribute.Attributes.CHANGE_KICK_MODEL;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.ABILITY_TICK;

public class KivaRiderKicks {
    public static void kivaRiderKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AnimPayload("kiva.start_kick", "attack", user.getStringUUID()));
            user.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 3, true, false));
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 400) {
            cancelAbility(user, "", 0);
        }

        if (user.getData(ABILITY_TICK) > 80 && user.onGround()) {
            cancelAbility(user, "kiva.land", 0);
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }
            return;
        } else if (user.getData(ABILITY_TICK) < 55 && !user.onGround()) {
            cancelAbility(user, "", 0);
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
            return;
        }

        switch (user.getData(ABILITY_TICK)) {
            case 45:
                user.getAttribute(CHANGE_KICK_MODEL).setBaseValue(1);
                ((ServerLevel) user.level()).sendParticles(ParticleTypes.EXPLOSION, user.getX() + user.getLookAngle().x * 0.75, user.getY() + 1, user.getZ() + user.getLookAngle().x * 0.75, 1, 0, 0, 0, 0);
                break;
            case 60:
                if (user.onGround()) {
                    Vec3 initialVec = user.getDeltaMovement();
                    Vec3 climbVec = new Vec3(initialVec.x, 1.35D, initialVec.z);
                    user.setDeltaMovement(climbVec.scale(0.97D));
                }
                user.hurtMarked = true;
                break;
            case 80:
                PacketDistributor.sendToAllPlayers(new AnimPayload("kiva.kick", "attack", user.getStringUUID()));
                break;
            case 85:
                user.setDeltaMovement(0, 0, 0);
                double y = user.getLookAngle().y;
                if (y < 0.5) y = 0.05d;
                Vec3 look = new Vec3(user.getLookAngle().x * 0.1, y * 0.04, user.getLookAngle().z * 0.1).scale(30);
                user.setDeltaMovement(look.scale(0.97D));
                user.hurtMarked = true;
                break;
        }

        if (user.getData(ABILITY_TICK) > 85) {
            detectHit(user);
            Random rand = new Random();
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.33F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.66F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(1) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
        }

        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }
}