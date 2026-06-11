package com.kelco.kamenridercraft.effects.beneficial;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.List;


public class PullEffect extends InstantenousMobEffect {


    public PullEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel level && livingEntity instanceof Player player) {
            List<ItemEntity> nearbyItem = level.getEntitiesOfClass(ItemEntity.class, player.getBoundingBox().inflate(10), entity ->
                    (entity instanceof ItemEntity));
            for (ItemEntity enemy : nearbyItem) {

                double X = livingEntity.getX() - enemy.getX();
                double Y = livingEntity.getY() - enemy.getY();
                double Z = livingEntity.getZ() - enemy.getZ();

                Vec3 look = new Vec3(X, Y, Z);
                enemy.setDeltaMovement(livingEntity.getDeltaMovement().add(look.x * (0.1 * (1 + amplifier)), look.y * (0.1 * (1 + amplifier)) + livingEntity.getGravity(), look.z * (0.1 * (1 + amplifier))));
            }
        }
        return true;
    }
}


