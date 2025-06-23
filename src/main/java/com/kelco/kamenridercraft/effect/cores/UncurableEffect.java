package com.kelco.kamenridercraft.effect.cores;



import java.util.Set;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.neoforge.common.EffectCure;


public class UncurableEffect extends BasicEffect {


	public UncurableEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

    public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
        cures.clear();
    }
	
}