package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
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

            List<LivingEntity> nearbyEnemies = serverLevel.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(10), entity -> (entity instanceof Player && entity != player) || (entity instanceof Mob));
            for (LivingEntity enemy : nearbyEnemies) {
                if (enemy instanceof Villager villager) {
                    if (villager.getLastAttacker() != player || villager.getLastHurtByMob() != player) {
                        villager.setLastHurtByPlayer(player);
                        villager.getBrain().setMemoryWithExpiry(MemoryModuleType.HURT_BY, player.damageSources().playerAttack(player), 540);
                        villager.getBrain().setMemoryWithExpiry(MemoryModuleType.NEAREST_HOSTILE, player, 540);
                        villager.getBrain().setMemoryWithExpiry(MemoryModuleType.ANGRY_AT, player.getUUID(), 540);
                        villager.getBrain().setMemoryWithExpiry(MemoryModuleType.AVOID_TARGET, player, 540);
                    }
                }

                if (enemy instanceof BaseHenchmenEntity && enemy.getMaxHealth() <= 50 && enemy.getLastAttacker() != player && ((BaseHenchmenEntity) enemy).getTarget() == player) {
                    ((BaseHenchmenEntity) enemy).setTarget(null);
                }

                if (enemy instanceof IronGolem ironGolem && ironGolem.getLastAttacker() != player) {
                    ironGolem.setTarget(player);
                    return true;
                }

                if (enemy instanceof Wolf wolf && !wolf.isAlliedTo(player) && wolf.getLastAttacker() != player) {
                    wolf.setTarget(player);
                    return true;
                }
            }
        }
        return true;
    }
}