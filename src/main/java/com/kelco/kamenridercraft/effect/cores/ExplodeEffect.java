package com.kelco.kamenridercraft.effect.cores;



import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForgeEventHandler;


public class ExplodeEffect extends MobEffect {


	public ExplodeEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}

	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {


		if (!pLivingEntity.level().isClientSide) {

			if (pLivingEntity.getEffect(Effect_core.EXPLODE).getDuration() < 5) {
				//boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(pLivingEntity.level(), pLivingEntity);
				boolean flag = pLivingEntity.level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();

				pLivingEntity.level().explode(null, pLivingEntity.getX(), pLivingEntity.getY() + 2, pLivingEntity.getZ(), pAmplifier, flag, Level.ExplosionInteraction.MOB);

			}
		}
		return true;
	}


}


