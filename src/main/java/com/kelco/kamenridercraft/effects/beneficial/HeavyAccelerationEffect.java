package com.kelco.kamenridercraft.effects.beneficial;

import com.kelco.kamenridercraft.effects.EffectCore;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Random;


public class HeavyAccelerationEffect extends InstantenousMobEffect {


    public HeavyAccelerationEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel level) {

            List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, livingEntity.getBoundingBox().inflate(15), entity ->
                    (entity instanceof Player && entity != livingEntity) || (entity instanceof Mob));
            for (LivingEntity enemy : nearbyEnemies) {

                Random generator = new Random();
                if (generator.nextInt(10) == 1) {
                    enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 8, true, true));
                    enemy.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3, 8, true, true));
                    enemy.addEffect(new MobEffectInstance(EffectCore.LOW_GRAVITY, 3, 8, true, true));
                }
            }
        }
        return true;
    }
}


