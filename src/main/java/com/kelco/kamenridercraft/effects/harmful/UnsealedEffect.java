package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.UndeadEntity;
import com.kelco.kamenridercraft.util.MiscUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;


public class UnsealedEffect extends MobEffect {
    public UnsealedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Random rand = new Random();
        if (livingEntity.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
            if (((amplifier < 50 ? (rand.nextInt(3000) - (amplifier + 1) * 5) : 0) <= 0)) {
                UndeadEntity undead = MobsCore.UNDEAD.get().create(livingEntity.level());
                if (rand.nextInt(15) == 0) {
                    undead = MobsCore.ACE_UNDEAD.get().create(livingEntity.level());
                }
                MiscUtil.spawnEnemy(livingEntity, undead, 10);
            }
        }
        return true;
    }
}