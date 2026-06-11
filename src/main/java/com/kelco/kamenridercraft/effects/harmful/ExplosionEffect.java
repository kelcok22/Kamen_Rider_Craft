package com.kelco.kamenridercraft.effects.harmful;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class ExplosionEffect extends InstantenousMobEffect {


    public ExplosionEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel) {
            Vec3 look = livingEntity.getLookAngle();
            boolean flag = livingEntity.level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
            livingEntity.level().explode(null, livingEntity.getX() + look.x * 8, livingEntity.getY() + 1, livingEntity.getZ() + look.z * 8, amplifier, flag, Level.ExplosionInteraction.MOB);
        }
        return false;
    }
}