package com.kelco.kamenridercraft.abilities.kicks;

import com.kelco.kamenridercraft.entity.base_entities.BaseEffectEntity;
import com.kelco.kamenridercraft.network.payload.AnimPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.Objects;
import java.util.Random;

import static com.kelco.kamenridercraft.abilities.AbilityUtil.cancelAbility;
import static com.kelco.kamenridercraft.abilities.hit_handling.AbilityHitDetection.detectHit;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_COOLDOWN;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.ABILITY_TICK;

public class WizardRiderKicks {
    public static void flameWizardKick(LivingEntity user) {
        if (user.getData(ABILITY_TICK) == 0) {
            user.setData(ABILITY_COOLDOWN, 100);
            PacketDistributor.sendToAllPlayers(new AnimPayload("wizard.kick", "attack", false, user.getStringUUID()));
            user.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 3, true, false));

            BaseEffectEntity magicCircle = new BaseEffectEntity(user.level(), 32, user);
            magicCircle.setGlowing(true);
            magicCircle.setTexture("effects/wizard_circle_flame.png");
            magicCircle.setModel("ground_logo.geo.json");
            magicCircle.moveTo(user.getX(), user.getY(), user.getZ(), 0, 0.0F);
            user.level().addFreshEntity(magicCircle);

            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        if ((user.isUnderWater() || user.isFallFlying()) || user.getData(ABILITY_TICK) >= 400 || (user.getData(ABILITY_TICK) <= 41 && user.fallDistance > 1.5)) {
            Objects.requireNonNull(user.getAttribute(Attributes.ABILITY_METER)).setBaseValue(Objects.requireNonNull(user.getAttribute(Attributes.ABILITY_METER)).getValue() + 100);
            cancelAbility(user, "", 0);
            return;
        }

        if (user.getData(ABILITY_TICK) > 45 && user.onGround()) {
            if (user.fallDistance != 0) {
                user.fallDistance = user.fallDistance * 0.9F;
            }

            double d0 = user.getX() + (double) Mth.randomBetween(user.level().random, -0.7F, 0.7F);
            double d1 = user.getY();
            double d2 = user.getZ() + (double) Mth.randomBetween(user.level().random, -0.7F, 0.7F);

            BlockState blockstate = user.getBlockStateOn();
            ((ServerLevel) user.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), d0, d1, d2, 25, 0, 0, 0, 0);

            Vec3 look = new Vec3(user.getLookAngle().x * 0.05, 0, user.getLookAngle().z * 0.05).scale(20);
            user.setDeltaMovement(look.scale(0.97D));
            user.hurtMarked = true;

            cancelAbility(user, "wizard.land", 0);
            Objects.requireNonNull(user.getAttribute(Attributes.ABILITY_METER)).setBaseValue(Objects.requireNonNull(user.getAttribute(Attributes.ABILITY_METER)).getValue() + 100);
            return;
        } else if (user.getData(ABILITY_TICK) < 20 && !user.onGround()) {
            cancelAbility(user, "", 0);
            Objects.requireNonNull(user.getAttribute(Attributes.ABILITY_METER)).setBaseValue(Objects.requireNonNull(user.getAttribute(Attributes.ABILITY_METER)).getValue() + 100);
            return;
        }

        if (user.getData(ABILITY_TICK) <= 26) {
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.FLAME, user.getX(), user.getY() + .3, user.getZ(), 10, 0, 0, 0, 0.05);
        }

        if (user.getData(ABILITY_TICK) > 56) {
            detectHit(user);
            Random rand = new Random();
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.33F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(0.66F) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            ((ServerLevel) user.level()).sendParticles(ParticleTypes.GUST, user.getX(), user.getY() + (rand.nextFloat(1) * rand.nextInt(-1, 1)), user.getZ(), 1, 0, 0, 0, 0);
            user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
            return;
        }

        switch (user.getData(ABILITY_TICK)) {
            case 26:
                user.push(user.getLookAngle().x * 2, .2, user.getLookAngle().z * 2);
                user.hurtMarked = true;
                break;
            case 32:
                user.push(user.getLookAngle().x * 4, .4, user.getLookAngle().z * 4);
                user.hurtMarked = true;
                break;
            case 43:
                Vec3 initialVec = user.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 1.45D, initialVec.z);
                user.setDeltaMovement(climbVec.scale(0.97D));
                user.hurtMarked = true;
                user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
                break;
            case 56:
                user.setDeltaMovement(0, 0, 0);
                double y = user.getLookAngle().y;
                if (y < 0.5) {
                    y = 0.05d;
                }
                Vec3 look = new Vec3(user.getLookAngle().x * 0.1, y * 0.04, user.getLookAngle().z * 0.1).scale(30);
                user.setDeltaMovement(look.scale(0.97D));
                user.hurtMarked = true;
                break;
            case 58:
                PacketDistributor.sendToAllPlayers(new AnimPayload("wizard.kick_loop", "attack", true, user.getStringUUID()));
                break;
        }
        user.setData(ABILITY_TICK, user.getData(ABILITY_TICK) + 1);
    }
}