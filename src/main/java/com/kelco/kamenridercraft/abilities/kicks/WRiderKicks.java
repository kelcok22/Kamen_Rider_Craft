package com.kelco.kamenridercraft.abilities.kicks;

import com.kelco.kamenridercraft.network.payload.AnimPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.Random;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.abilities.hit_handling.AbilityHitDetection.detectHit;
import static com.kelco.kamenridercraft.world.attribute.Attributes.CHANGE_KICK_MODEL;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.*;

public class WRiderKicks {
    public static void jokerMemoryKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AnimPayload("w.maximum_drive_start", "attack", user.getStringUUID()));

            if (!user.onGround()) {
                user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
                cancelAbility(user, "", 0);
                return;
            }

            user.hurtMarked = true;
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 180) {
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
            cancelAbility(user, "", 0);
            return;
        }

        if (user.getData(ABILITY_TICK) > 21 && user.onGround()) {
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() - 100);
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }

            cancelAbility(user, "w.joker_extreme_land", 0);
            return;
        }

        switch (user.getData(ABILITY_TICK)) {
            case 20:
                if (user.onGround()) {
                    PacketDistributor.sendToAllPlayers(new AnimPayload("w.joker_extreme_kick_start", "attack", user.getStringUUID()));
                    Vec3 initialVec = user.getDeltaMovement();
                    Vec3 climbVec = new Vec3(initialVec.x, 1.2D, initialVec.z);
                    user.setDeltaMovement(climbVec.scale(0.97D));
                    ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
                    user.hurtMarked = true;
                }
                break;
            case 40:
                PacketDistributor.sendToAllPlayers(new AnimPayload("w.joker_extreme_flip", "attack", user.getStringUUID()));
                break;
            case 48:
                PacketDistributor.sendToAllPlayers(new AnimPayload("w.joker_extreme_kick", "attack", user.getStringUUID()));
                ((ServerLevel) user.level()).sendParticles(ParticleTypes.EXPLOSION_EMITTER, user.getX(), user.getY(), user.getZ(), 10, 0, 0, 0, 0);
                user.getAttribute(CHANGE_KICK_MODEL).setBaseValue(1);
                user.setDeltaMovement(0, 0, 0);
                double y = user.getLookAngle().y;
                if (y < 0.5) y = 0.05d;
                Vec3 look = new Vec3(user.getLookAngle().x * 0.1, y * 0.04, user.getLookAngle().z * 0.1).scale(20);
                user.setDeltaMovement(look.scale(0.97D));
                user.hurtMarked = true;
                break;
        }

        if (user.getData(ABILITY_TICK) > 48) {
            detectHit(user);
            Random rand = new Random();
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.33F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.66F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(1) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
        }

        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }
}