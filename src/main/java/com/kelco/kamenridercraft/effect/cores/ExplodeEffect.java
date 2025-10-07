package com.kelco.kamenridercraft.effect.cores;



import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;

import java.util.Optional;


public class ExplodeEffect extends MobEffect {
	public ExplodeEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Level level = pLivingEntity.level();
		if (!level.isClientSide && pLivingEntity.getEffect(Effect_core.EXPLODE).getDuration() < 2) {
            ExplosionDamageCalculator damageCalc = new SimpleExplosionDamageCalculator(false, true, Optional.of(1.5F), Optional.empty());
            if (pAmplifier < 255) level.explode(null, level.damageSources().explosion(null, pLivingEntity), damageCalc, pLivingEntity.getX(), pLivingEntity.getY() + 2, pLivingEntity.getZ(), pAmplifier, false, Level.ExplosionInteraction.MOB);
            /*Added this line just for you Kelco, you're welcome*/ else level.explode(null, pLivingEntity.getX(), pLivingEntity.getY() + 2, pLivingEntity.getZ(), pAmplifier, true, Level.ExplosionInteraction.MOB);
		}
		return true;
	}


}


