package com.kelco.kamenridercraft.item.BaseItems;


import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entities.bikes.baseBikeEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;


public class SummonBikeItem extends BaseItem {


	private List<Component> TEXT = Lists.newArrayList();
	private Supplier<? extends EntityType<? extends baseBikeEntity>> BOSS;

	public SummonBikeItem(Properties properties, Supplier<? extends EntityType<? extends baseBikeEntity>> boss)
	{super(properties);
		BOSS =boss;
		//TEXT.add(text);
	}

	public InteractionResult useOn(UseOnContext context) {

		Player player = context.getPlayer();
		ItemStack itemstack = player.getItemInHand(context.getHand());
		Level level = player.level();

		if (!level.isClientSide()) {
			if (level instanceof ServerLevel) {
				BlockPos pos = context.getClickedPos();
                baseBikeEntity boss = BOSS.get().create(level);
				if (boss != null) {
					boss.moveTo(pos.getX(), pos.getY()+1, pos.getZ(), 0, 0.0F);
					level.addFreshEntity(boss);
					if (!TEXT.isEmpty()) for (Component text : TEXT) player.displayClientMessage(text, true);
					itemstack.consume(1,player);
				}
			}
		}
		return InteractionResult.PASS;
	}




}