package com.kelco.kamenridercraft.item.decade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class BlankCardItem extends BaseItem {

	  public static List<Item> RIDER_CARD= new ArrayList<Item>();

	public BlankCardItem (Properties properties)
	{
		super(properties);
	}

	 private Item CardDrop() {
	 		Random generator = new Random();
	 			int rand = generator.nextInt(RIDER_CARD.size());
	 			return RIDER_CARD.get(rand);
	 	}

	@Override
		public InteractionResultHolder<ItemStack> use(Level world, Player playerIn, InteractionHand p_41434_) {
			ItemStack itemstack = playerIn.getItemInHand(p_41434_);
		
			playerIn.drop(new ItemStack(CardDrop(), 1), true);
		    if (!playerIn.isCreative()) itemstack.shrink(1);
			return InteractionResultHolder.consume(itemstack);
		}

	}