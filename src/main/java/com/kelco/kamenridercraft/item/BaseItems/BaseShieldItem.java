package com.kelco.kamenridercraft.item.BaseItems;


import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class BaseShieldItem extends ShieldItem {

	private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();
	
	public BaseShieldItem(Properties prop) {
		super(prop.durability(336));
		KamenRiderCraftCore.SHIELD_ITEM.add(this);
	}

	public BaseShieldItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}
	
	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseShieldItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
		return ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(itemAbility);
	}
}