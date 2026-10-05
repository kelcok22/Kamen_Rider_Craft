package com.kelco.kamenridercraft.abilities.kicks;

import com.kelco.kamenridercraft.network.payload.AnimPayload;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.Random;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.abilities.hit_handling.AbilityHitDetection.detectHit;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_TICK;
import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.getFormItem;
import static com.kelco.kamenridercraft.item.heisei_phase_2.FourzeRiderItems.DRILL_ASTROSWITCH;
import static com.kelco.kamenridercraft.item.heisei_phase_2.FourzeRiderItems.FOURZE_DRIVER;

public class FourzeRiderKicks {
    public static void fourzeRiderKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AnimPayload(user.onGround() ? "fourze.rocket_jump" : "default.rocket_jump_fly", "attack", false, user.getStringUUID()));

            if (!user.onGround()) {
                Vec3 initialVec = user.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 1.225D, initialVec.z);
                user.setDeltaMovement(climbVec.scale(0.97D));
            }

            user.hurtMarked = true;
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 180) {
            user.getAttribute(KRCAttributes.ABILITY_METER).setBaseValue(user.getAttribute(KRCAttributes.ABILITY_METER).getValue() + 100);
            cancelAbility(user, "", 0);
            return;
        }

        if (user.getData(ABILITY_TICK) > 17 && user.onGround()) {
            user.getAttribute(KRCAttributes.ABILITY_METER).setBaseValue(user.getAttribute(KRCAttributes.ABILITY_METER).getValue() + 100);
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }

            if (user.getItemBySlot(EquipmentSlot.FEET).getItem() == FOURZE_DRIVER.get()
                    && (getFormItem(user.getItemBySlot(EquipmentSlot.FEET), 3).asItem() == DRILL_ASTROSWITCH.get())) {
                cancelAbility(user, "fourze.land", 0);

            } else {
                cancelAbility(user, "default.land", 0);

            }
            return;
        }

        switch (user.getData(ABILITY_TICK)) {
            case 2:
                if (user.onGround()) {
                    Vec3 initialVec = user.getDeltaMovement();
                    Vec3 climbVec = new Vec3(initialVec.x, 1.225D, initialVec.z);
                    user.setDeltaMovement(climbVec.scale(0.97D));
                    ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
                    user.hurtMarked = true;
                }
                break;
            case 18:
                PacketDistributor.sendToAllPlayers(new AnimPayload("fourze.kick", "attack", true, user.getStringUUID()));
                break;
            case 19:
                user.setDeltaMovement(0, 0, 0);
                double y = user.getLookAngle().y;
                if (y < 0.5) {
                    y = 0.05d;
                }
                Vec3 look = new Vec3(user.getLookAngle().x * 0.1, y * 0.04, user.getLookAngle().z * 0.1).scale(20);
                user.setDeltaMovement(look.scale(0.97D));
                user.hurtMarked = true;
                break;
        }

        if (user.getData(ABILITY_TICK) > 3) {
            detectHit(user);
            Random rand = new Random();
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.33F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.66F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(1) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
        }

        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }

    public static void meteorRiderKick(LivingEntity user) {
        user.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2, 4, true, false));


        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);

            user.hurtMarked = true;
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 180) {
            user.getAttribute(KRCAttributes.ABILITY_METER).setBaseValue(user.getAttribute(KRCAttributes.ABILITY_METER).getValue() + 100);
            cancelAbility(user, "", 0);
            return;
        }

        if (user.getData(ABILITY_TICK) > 4 && user.onGround()) {
            user.getAttribute(KRCAttributes.ABILITY_METER).setBaseValue(user.getAttribute(KRCAttributes.ABILITY_METER).getValue() + 100);
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }

            cancelAbility(user, "default.land", 0);
            return;
        }

        switch (user.getData(ABILITY_TICK)) {
            case 1:
                Vec3 initialVec = user.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 2.5D, initialVec.z);
                user.setDeltaMovement(climbVec.scale(0.97D));
                ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + 1.0, user.getZ(), 1, 0, 0, 0, 0);
                user.hurtMarked = true;
                break;
            case 2:
                PacketDistributor.sendToAllPlayers(new AnimPayload("meteor.kick", "attack", true, user.getStringUUID()));
                user.setDeltaMovement(0, 0, 0);
                double y = user.getLookAngle().y;
                if (y < 0.5) {
                    y = 0.05d;
                }
                Vec3 look = new Vec3(user.getLookAngle().x * 0.1, y * 0.04, user.getLookAngle().z * 0.1).scale(35);
                user.setDeltaMovement(look.scale(0.97D));
                user.hurtMarked = true;
                break;
        }

        if (user.getData(ABILITY_TICK) > 3) {
            detectHit(user);
            Random rand = new Random();
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.33F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.66F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(1) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
        }

        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }
}