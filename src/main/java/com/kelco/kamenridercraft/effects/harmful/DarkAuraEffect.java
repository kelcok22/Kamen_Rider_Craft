package com.kelco.kamenridercraft.effects.harmful;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;

import java.util.List;


public class DarkAuraEffect extends InstantenousMobEffect {


    public DarkAuraEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel serverLevel && livingEntity instanceof Player player && !(player.isCreative() || player.isSpectator())) {

            List<LivingEntity> nearbyEnemies = serverLevel.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10), entity ->
                    (entity instanceof Player && entity != player)
                            || (entity instanceof Mob));
            for (LivingEntity enemy : nearbyEnemies) {
                if (enemy instanceof Villager villager) {
                    if (villager.getLastAttacker() != player || villager.getLastHurtByMob() != player) {
                        enemy.hurt(player.damageSources().playerAttack(player), 0F);
                        villager.setLastHurtByPlayer(player);
                        villager.setUnhappyCounter(100);
                        villager.getBrain().setMemoryWithExpiry(MemoryModuleType.AVOID_TARGET, livingEntity, 6000);
                        villager.refreshBrain(serverLevel);
                    }
                }

                if (enemy instanceof IronGolem ironGolem) {
                    if (ironGolem.getLastAttacker() != player) {
                        ironGolem.setTarget(player);
                    }
                }

                if (enemy instanceof Wolf wolf) {
                    if (wolf.getLastAttacker() != player) {
                        wolf.setTarget(player);
                    }
                }
            }
        }
        return true;
    }
}