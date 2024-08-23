package com.kelco.kamenridercraft.item.ride_kamens;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class gasha_ticket extends BaseItem {

	  public static List<Item> CHAOS_RING= new ArrayList<Item>();

	public gasha_ticket (Properties properties)
	{
		super(properties);
	}

	 private Item RingDrop() {
	 		Random generator = new Random();
	 			int rand = generator.nextInt(CHAOS_RING.size());
	 			return CHAOS_RING.get(rand);
	 	}

	public void  useEnergyItem (ItemStack itemstack, Level world,Player playerIn) {
		
			playerIn.drop(new ItemStack(RingDrop(), 1), true);
			
		if	(!playerIn.isCreative()) {
			itemstack.shrink(1);
		}
	}


	@Override
		public InteractionResultHolder<ItemStack> use(Level world, Player playerIn, InteractionHand p_41434_) {
			ItemStack itemstack = playerIn.getItemInHand(p_41434_);

			this.useEnergyItem(itemstack,world, playerIn);
			return InteractionResultHolder.consume(itemstack);
		}

	}