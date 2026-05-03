package com.kelco.kamenridercraft.effects;


import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.neoforge.common.EffectCure;

import java.util.Set;


public class UncurableEffect extends BasicEffect {


	public UncurableEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

    public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
        cures.clear();
    }
	
}