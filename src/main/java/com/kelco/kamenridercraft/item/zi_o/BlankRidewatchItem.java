package com.kelco.kamenridercraft.item.zi_o;

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


public class BlankRidewatchItem extends BaseItem {

	  public static List<Item> RIDEWATCH= new ArrayList<Item>();

	public BlankRidewatchItem (Properties properties)
	{
		super(properties);
	}

	 private Item WatchDrop() {
	 		Random generator = new Random();
	 			int rand = generator.nextInt(RIDEWATCH.size());
	 			return RIDEWATCH.get(rand);
	 	}

	@Override
		public InteractionResultHolder<ItemStack> use(Level world, Player playerIn, InteractionHand p_41434_) {
			ItemStack itemstack = playerIn.getItemInHand(p_41434_);
		
			playerIn.drop(new ItemStack(WatchDrop(), 1), true);
		    if (!playerIn.isCreative()) itemstack.shrink(1);
			return InteractionResultHolder.consume(itemstack);
		}

	}