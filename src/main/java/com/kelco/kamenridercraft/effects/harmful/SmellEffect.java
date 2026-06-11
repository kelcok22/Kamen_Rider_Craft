package com.kelco.kamenridercraft.effects.harmful;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;

import java.util.List;


public class SmellEffect extends InstantenousMobEffect {


    public SmellEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel serverLevel && livingEntity instanceof Player player) {
            List<LivingEntity> nearbyEnemies = serverLevel.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10), entity ->
                    (entity instanceof Player && entity != player)
                            || (entity instanceof Monster));
            for (LivingEntity enemy : nearbyEnemies) {
                enemy.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0, true, true));
                enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, true, true));
            }
        }
        return true;
    }
}


