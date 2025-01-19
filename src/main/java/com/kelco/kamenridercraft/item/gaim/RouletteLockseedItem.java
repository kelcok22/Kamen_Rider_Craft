package com.kelco.kamenridercraft.item.gaim;


import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Random;


public class RouletteLockseedItem extends BaseItem {

	private int TIME = 100;

	public RouletteLockseedItem(Properties properties)
	{
		super(properties);
	}

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		if (!p_41128_.isClientSide()) {

			Random generator = new Random();
			int rand = generator.nextInt(6);

                    p_41129_.getCooldowns().addCooldown(this, TIME);
			p_41129_.sendSystemMessage(Component.literal(Component.translatable("message.kamenridercraft.roulette").getString() + (rand + 1)));

		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}

}