package com.kelco.kamenridercraft.effects.beneficial;

import com.kelco.kamenridercraft.entity.vehicles.baseBikeEntity;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;


public class RamEffect extends InstantenousMobEffect {


    public RamEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel serverLevel && livingEntity instanceof Player player) {
            if (player.isSprinting() || !player.onGround() || player.isPassenger()) {
                if (player.onGround()) {
                    double d0 = livingEntity.getX() + (double) Mth.randomBetween(serverLevel.random, -0.7F, 0.7F);
                    double d1 = livingEntity.getY();
                    double d2 = livingEntity.getZ() + (double) Mth.randomBetween(serverLevel.random, -0.7F, 0.7F);

                    BlockState blockstate = livingEntity.getBlockStateOn();
                    serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), d0, d1, d2, 25, 0, 0, 0, 0);
                } else {
                    serverLevel.sendParticles(ParticleTypes.CRIMSON_SPORE, livingEntity.getX(), livingEntity.getEyeY() - livingEntity.getScale() * 0.75, livingEntity.getZ(), 10, 0, 0, 0, 0);
                }

                List<LivingEntity> nearbyEnemies = serverLevel.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(1.5), entity ->
                        (entity instanceof Player && entity != player)
                                || (entity instanceof Mob));
                for (LivingEntity enemy : nearbyEnemies) {
                    if (!enemy.isPassengerOfSameVehicle(player) && !enemy.isVehicle() && !enemy.isAlliedTo(player) && !(enemy instanceof baseBikeEntity)) {
                        double subX = enemy.getX() - player.getX();
                        double subY = enemy.getY() - player.getY();
                        double subZ = enemy.getZ() - player.getZ();
                        float r = Mth.sqrt((float) (Mth.square(subX) + Mth.square(subY) + Mth.square(subZ))) * 8;
                        enemy.push(subX / r, subY / r, subZ / r);
                        enemy.hurt(player.damageSources().playerAttack(player), 2.0F);
                    }
                }
            }
        }
        return true;
    }
}