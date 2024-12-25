package com.kelco.kamenridercraft.item.geats;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class MissionBoxItem extends BaseItem {

	  public static List<Item> CORE_ID= new ArrayList<Item>();
	  public static List<Item> RAISE_BUCKLE= new ArrayList<Item>();
	  public static List<Item> GIGANT_BUCKLE= new ArrayList<Item>();

	public MissionBoxItem (Properties properties)
	{
		super(properties);
	}

	 private Item ItemDrop() {
	 		Random generator = new Random();
	 		if (this== Geats_Rider_Items.BIKKURI_MISSION_BOX.get()) {
				int rand = generator.nextInt(CORE_ID.size());
				return CORE_ID.get(rand);
			} else if (this==Geats_Rider_Items.HATENA_MISSION_BOX.get()) {
				int rand = generator.nextInt(RAISE_BUCKLE.size());
				return RAISE_BUCKLE.get(rand);
			} else {
				int rand = generator.nextInt(GIGANT_BUCKLE.size());
				return GIGANT_BUCKLE.get(rand);
			}
	 	}

	public void  useEnergyItem (ItemStack itemstack, Level world,Player playerIn) {
		
			playerIn.drop(new ItemStack(ItemDrop(), 1), false);
			
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