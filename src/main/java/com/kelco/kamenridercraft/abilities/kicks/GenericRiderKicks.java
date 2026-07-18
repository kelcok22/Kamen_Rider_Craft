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
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.*;

public class GenericRiderKicks {
    public static void genericRiderKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AnimPayload(user.onGround() ? "default.rider_floor_jump" : "default.rider_jump", "attack", false, user.getStringUUID()));

            if (!user.onGround()) {
                Vec3 initialVec = user.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 1.125D, initialVec.z);
                user.setDeltaMovement(climbVec.scale(0.97D));
            }

            user.hurtMarked = true;
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 180) {
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() + 100);
            cancelAbility(user, "", 0);
            return;
        }

        if (user.getData(ABILITY_TICK) > 17 && user.onGround()) {
            user.getAttribute(Attributes.ABILITY_METER).setBaseValue(user.getAttribute(Attributes.ABILITY_METER).getValue() + 100);
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }

            if (user.getData(USED_ABILITY).equalsIgnoreCase("flipped_rider_kick")) {
                cancelAbility(user, "default.flipped_land", 0);
                return;
            }
            cancelAbility(user, "default.land", 0);
            return;
        }

        switch (user.getData(ABILITY_TICK)) {
            case 2:
                if (user.onGround()) {
                    Vec3 initialVec = user.getDeltaMovement();
                    Vec3 climbVec = new Vec3(initialVec.x, 1.3D, initialVec.z);
                    user.setDeltaMovement(climbVec.scale(0.97D));
                    ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
                    user.hurtMarked = true;
                }
                break;
            case 16:
                PacketDistributor.sendToAllPlayers(new AnimPayload("default.flip", "attack", true, user.getStringUUID()));
                break;
            case 24:
                if (user.getData(USED_ABILITY).equalsIgnoreCase("flipped_rider_kick")) {
                    PacketDistributor.sendToAllPlayers(new AnimPayload("default.flipped_kick", "attack", false, user.getStringUUID()));
                } else {
                    PacketDistributor.sendToAllPlayers(new AnimPayload("default.kick", "attack", false, user.getStringUUID()));
                }
                break;
            case 25:
                user.setDeltaMovement(0, 0, 0);
                double y = user.getLookAngle().y;
                if (y < 0.5) {
                    y = 0.05d;
                }
                Vec3 look = new Vec3(user.getLookAngle().x * 0.1, y * 0.04, user.getLookAngle().z * 0.1).scale(20);
                user.setDeltaMovement(look.scale(0.97D));
                user.hurtMarked = true;
                break;
            case 40:
                if (user.getData(USED_ABILITY).equalsIgnoreCase("flipped_kick")) {
                     PacketDistributor.sendToAllPlayers(new AnimPayload("default.flipped_kick_loop", "attack", false,user.getStringUUID()));
                } else {
                    PacketDistributor.sendToAllPlayers(new AnimPayload("default.kick_loop", "attack", false,user.getStringUUID()));
                }
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