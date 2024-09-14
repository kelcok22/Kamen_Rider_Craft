package com.kelco.kamenridercraft.item.wizard;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Wizard_Rider_Items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class UnknownWizardRingItem extends BaseItem {

	public static final List<Item> amber_wizard_ring = new ArrayList<Item>();
	public static final List<Item> red_wizard_ring = new ArrayList<Item>();
	public static final List<Item> blue_wizard_ring = new ArrayList<Item>();
	public static final List<Item> yellow_wizard_ring = new ArrayList<Item>();
	public static final List<Item> green_wizard_ring = new ArrayList<Item>();
	public static final List<Item> cyan_wizard_ring = new ArrayList<Item>();
	public static final List<Item> violet_wizard_ring = new ArrayList<Item>();
	public static final List<Item> black_wizard_ring = new ArrayList<Item>();
	public static final List<Item> beast_wizard_ring = new ArrayList<Item>();

	public UnknownWizardRingItem(Properties properties)
	{
		super(properties);
	}


	private Item RingDrop(Item num) {
		Random generator = new Random();
		if (num== Wizard_Rider_Items.UNKNOWN_AMBER_RING.get()){
			int rand = generator.nextInt(amber_wizard_ring.size());
			return amber_wizard_ring.get(rand);
		} else if (num==Wizard_Rider_Items.UNKNOWN_BLACK_RING.get()){
			int rand = generator.nextInt(black_wizard_ring.size());
			return black_wizard_ring.get(rand);
		} else if (num==Wizard_Rider_Items.UNKNOWN_BLUE_RING.get()){
			int rand = generator.nextInt(blue_wizard_ring.size());
			return blue_wizard_ring.get(rand);
		} else if (num==Wizard_Rider_Items.UNKNOWN_CYAN_RING.get()){
			int rand = generator.nextInt(cyan_wizard_ring.size());
			return cyan_wizard_ring.get(rand);
		} else if (num==Wizard_Rider_Items.UNKNOWN_GREEN_RING.get()){
			int rand = generator.nextInt(green_wizard_ring.size());
			return green_wizard_ring.get(rand);
		} else if (num==Wizard_Rider_Items.UNKNOWN_RED_RING.get()){
			int rand = generator.nextInt(red_wizard_ring.size());
			return red_wizard_ring.get(rand);
		} else if (num==Wizard_Rider_Items.UNKNOWN_VIOLET_RING.get()){
			int rand = generator.nextInt(violet_wizard_ring.size());
			return violet_wizard_ring.get(rand);
		} else if (num==Wizard_Rider_Items.UNKNOWN_YELLOW_RING.get()){
			int rand = generator.nextInt(yellow_wizard_ring.size());
			return yellow_wizard_ring.get(rand);
		} else if (num==Wizard_Rider_Items.UNKNOWN_BEAST_RING.get()){
			int rand = generator.nextInt(beast_wizard_ring.size());
			return beast_wizard_ring.get(rand);
		} else {
			int rand = generator.nextInt(amber_wizard_ring.size());
			return amber_wizard_ring.get(rand);
		}
	}

	public void  useEnergyItem (ItemStack itemstack, Level world,Player playerIn) {
			playerIn.drop(new ItemStack(RingDrop(itemstack.getItem()), 1), true);
			itemstack.shrink(1);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int num, boolean flag) {
		if (entity instanceof Player playerIn) this.useEnergyItem(itemstack,world, playerIn);
	}

	}