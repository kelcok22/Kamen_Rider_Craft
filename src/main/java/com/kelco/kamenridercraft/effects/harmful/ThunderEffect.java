package com.kelco.kamenridercraft.effects.harmful;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class ThunderEffect extends InstantenousMobEffect {

    public ThunderEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel) {
            Vec3 look = livingEntity.getLookAngle();
            LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT, livingEntity.level());
            thunder.setPos(livingEntity.getX() + look.x * 8, -1 + livingEntity.getY() + look.y * 5, livingEntity.getZ() + look.z * 8);
            livingEntity.level().addFreshEntity(thunder);
        }
        return false;
    }
}