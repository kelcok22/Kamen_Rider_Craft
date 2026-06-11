package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.List;


public class PushEffect extends InstantenousMobEffect {


    public PushEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel level && livingEntity instanceof Player player) {
            List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(2 + (amplifier * 2)), entity ->
                    (entity instanceof Mob));
            for (LivingEntity enemy : nearbyEnemies) {

                double X = enemy.getX() - livingEntity.getX();
                double Y = enemy.getY() - livingEntity.getY();
                double Z = enemy.getZ() - livingEntity.getZ();

                Vec3 look = new Vec3(X, Y, Z);
                enemy.setDeltaMovement(livingEntity.getDeltaMovement().add(look.x * (0.1 * (1 + amplifier)), look.y * (0.1 * (1 + amplifier)) + livingEntity.getGravity(), look.z * (0.1 * (1 + amplifier))));
            }
        }
        return true;
    }
}