package com.kelco.kamenridercraft.abilities.punches;

import com.kelco.kamenridercraft.network.payload.AnimPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.Objects;
import java.util.Random;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.abilities.hit_handling.AbilityHitDetection.detectHit;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_TICK;
import static com.kelco.kamenridercraft.world.attribute.Attributes.CHANGE_KICK_MODEL;

public class GenericRiderPunches {
    public static void groundRiderPunch(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AnimPayload("default.tojima_punch", "attack", false, user.getStringUUID()));
            user.push(user.getLookAngle().scale(1.3));
            user.hurtMarked = true;
            user.setInvulnerable(true);
        }

        if (user.getData(ABILITY_TICK) >= 24) {
            cancelAbility(user, "", 0);
            return;
        }

        if (user.getData(ABILITY_TICK) > 3 && user.getData(ABILITY_TICK) < 18) {
            detectHit(user);
        }

        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }


    public static void genericRiderPunch(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            Objects.requireNonNull(user.getAttribute(CHANGE_KICK_MODEL)).setBaseValue(1);
            PacketDistributor.sendToAllPlayers(new AnimPayload(user.onGround() ? "default.rider_floor_jump" : "default.rider_jump", "attack", false, user.getStringUUID()));

            if (!user.onGround()) {
                Vec3 initialVec = user.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 1.2D, initialVec.z);
                user.setDeltaMovement(climbVec.scale(0.97D));
            }

            user.hurtMarked = true;
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 180) {
            cancelAbility(user, "", 0);
        }

        if (user.getData(ABILITY_TICK) > 17 && user.onGround()) {
            cancelAbility(user, "default.land", 0);
            Objects.requireNonNull(user.getAttribute(Attributes.ABILITY_METER)).setBaseValue(Objects.requireNonNull(user.getAttribute(Attributes.ABILITY_METER)).getValue() + 100);
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }
            return;
        }

        switch (user.getData(ABILITY_TICK)) {
            case 3:
                if (user.onGround()) {
                    Vec3 initialVec = user.getDeltaMovement();
                    Vec3 climbVec = new Vec3(initialVec.x, 0.85D, initialVec.z);
                    user.setDeltaMovement(climbVec.scale(0.97D));
                    user.hurtMarked = true;
                    ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
                }
                break;
            case 7:
                PacketDistributor.sendToAllPlayers(new AnimPayload("default.flip", "attack", false, user.getStringUUID()));
                break;
            case 17:
                PacketDistributor.sendToAllPlayers(new AnimPayload("default.punch", "attack", false, user.getStringUUID()));
                break;
            case 21:
                user.setDeltaMovement(0, 0, 0);
                double y = user.getLookAngle().y;
                if (y < 0.5) {
                    y = 0.05d;
                }
                Vec3 look = new Vec3(user.getLookAngle().x * 0.1, y * 0.04, user.getLookAngle().z * 0.1).scale(20);
                user.setDeltaMovement(look.scale(0.97D));
                user.hurtMarked = true;
                break;
            case 25:
                PacketDistributor.sendToAllPlayers(new AnimPayload("default.punch_loop", "attack", false, user.getStringUUID()));
                break;
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
}
