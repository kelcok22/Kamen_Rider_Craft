package com.kelco.kamenridercraft.item.misc;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GiftItem extends BaseItem {

	  public static List<Item> GIFTS = new ArrayList<Item>();

	public GiftItem(Properties properties)
	{
		super(properties);
		GIFTS.add(Blocks.CAKE.asItem());
		GIFTS.add(Items.COAL.asItem());
		GIFTS.add(Items.COAL.asItem());
		GIFTS.add(Items.COAL.asItem());
	}

	 private Item  GiftDrop() {
	 		Random generator = new Random();
	 			int rand = generator.nextInt(GIFTS.size());
	 			return GIFTS.get(rand);
	 	}

	public void  useEnergyItem (ItemStack itemstack, Level world,Player playerIn) {
		
			playerIn.drop(new ItemStack(GiftDrop(), 1), true);
			
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