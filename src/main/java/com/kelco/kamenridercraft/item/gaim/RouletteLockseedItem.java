package com.kelco.kamenridercraft.item.gaim;


import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;


public class RouletteLockseedItem extends BaseItem {
	public RouletteLockseedItem(Properties properties)
	{
		super(properties);
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		if (!p_41128_.isClientSide()) {
			Random generator = new Random();
			int rand = generator.nextInt(6);

            p_41129_.getCooldowns().addCooldown(this, 100);
			p_41129_.sendSystemMessage(Component.literal(Component.translatable("message.kamenridercraft.roulette").getString() + (rand + 1)));
            p_41129_.awardStat(Stats.ITEM_USED.get(this));
		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

}