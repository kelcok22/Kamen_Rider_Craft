package com.kelco.kamenridercraft.effect.cores;


import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.Miscellaneous_Rider_Items;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;


public class ChristmasEffect extends MobEffect {


	public ChristmasEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {

					if (pAmplifier!=9){
						//player.drop(new ItemStack(Miscellaneous_Rider_Items.GIFT.get(),pAmplifier+1),true);
						player.addItem(new ItemStack(Miscellaneous_Rider_Items.GIFT.get(),pAmplifier+1));
						player.addEffect(new MobEffectInstance(Effect_core.CHRISTMAS, 5200, 9,false,false));
					}


				}
			}
		}
		return true;
	}
}


