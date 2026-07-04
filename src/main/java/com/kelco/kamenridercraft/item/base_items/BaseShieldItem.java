package com.kelco.kamenridercraft.item.base_items;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BaseShieldItem extends ShieldItem {

    private Item changedRepairItem = ModdedItemCore.RIDER_CIRCUIT.get();

    public BaseShieldItem(Properties prop) {
        super(prop.durability(336));
        KamenRiderCraftCore.SHIELD_ITEM.add(this);
    }

    public BaseShieldItem changeRepairItem(Item item) {
        changedRepairItem = item;
        return this;
    }

	public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
		return repairItem.getItem() == changedRepairItem;
	}

	public BaseShieldItem addToList(List<Item> TabList, int num) {
		for (int i = 0; i < num; i++) {
			TabList.add(this);
		}
		return this;
	}

	public BaseShieldItem addToList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

    public boolean canPerformAction(@NotNull ItemStack itemStack, @NotNull ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(itemAbility);
    }
}