package com.kelco.kamenridercraft.effect.cores;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.PlayerEnderChestContainer;


public class ConnectEffect extends InstantenousMobEffect {


	public ConnectEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}



	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof ServerPlayer player) {

					PlayerEnderChestContainer playerenderchestcontainer = player.getEnderChestInventory();
					if (playerenderchestcontainer != null) {
							Component CONTAINER_TITLE = Component.translatable(KamenRiderCraftCore.MOD_ID+".container.enderchest");

							player.openMenu(new SimpleMenuProvider((p_53124_, p_53125_, p_53126_) -> ChestMenu.threeRows(p_53124_, p_53125_, playerenderchestcontainer), CONTAINER_TITLE));
							player.awardStat(Stats.OPEN_ENDERCHEST);
							PiglinAi.angerNearbyPiglins(player, true);

					}

				}
			}
		}
		return false;
	}
}


