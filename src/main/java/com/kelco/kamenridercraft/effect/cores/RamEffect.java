package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.entities.bikes.baseBikeEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

import java.util.List;


public class RamEffect extends InstantenousMobEffect {


    public RamEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide()) {
            if (pLivingEntity.level() instanceof ServerLevel level) {
                if (pLivingEntity instanceof Player player) {
                    if (player.isSprinting() || player.isFallFlying() || player.isPassenger()) {

                        level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, player.getX(), player.getY()+1.25, player.getZ(), 2, 0, 0, 0, 0.15);

                        List<LivingEntity> nearbyEnemies = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(3.5), entity ->
                                (entity instanceof Player && entity != player)
                                        || (entity instanceof Mob));
                        for (LivingEntity enemy : nearbyEnemies) {
                            if (!enemy.isPassengerOfSameVehicle(player) && !enemy.isVehicle() && !enemy.isAlliedTo(player) && !(enemy instanceof baseBikeEntity)) {
                                int mod = 3;
                                if (enemy.distanceTo(player) < 10 ) {
                                    mod = 25;
                                }
                                enemy.push((enemy.getX() - player.getX())/mod, (enemy.getY() - player.getY())/mod, (enemy.getZ() - player.getZ())/mod);
                                enemy.hurt(player.damageSources().playerAttack(player), 5.0F);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}


