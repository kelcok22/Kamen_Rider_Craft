package com.kelco.kamenridercraft.item.zi_o;


import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;


public class RideGadgetItem extends BaseItem {


	private List<Component> TEXT = Lists.newArrayList();
	private Supplier<? extends EntityType<? extends BaseAllyEntity>> BOSS;

	public RideGadgetItem(Properties properties , Component text, Supplier<? extends EntityType<? extends BaseAllyEntity>> boss)
	{super(properties);
		BOSS =boss;
		TEXT.add(text);
	}

	/**
	 * Called when this item is used when targeting a Block
	 */
	public InteractionResult useOn(UseOnContext context) {

		Player player = context.getPlayer();
		ItemStack itemstack = player.getItemInHand(context.getHand());
		Level level = player.level();

		if (!level.isClientSide()) {
			if (level instanceof ServerLevel) {
				BlockPos pos = context.getClickedPos();
				BaseAllyEntity boss = BOSS.get().create(level);
				if (boss != null) {
                    boss.setTame(true, false);
                    boss.setOwnerUUID(player.getUUID());
					boss.moveTo(pos.getX(), pos.getY()+1, pos.getZ(), 0, 0.0F);
					level.addFreshEntity(boss);
					if (!TEXT.isEmpty()) for (Component text : TEXT) player.displayClientMessage(text, true);
					itemstack.consume(1,player);
					player.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
		return InteractionResult.PASS;
	}




}
