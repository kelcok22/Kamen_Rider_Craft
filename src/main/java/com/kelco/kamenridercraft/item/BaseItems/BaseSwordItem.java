package com.kelco.kamenridercraft.item.BaseItems;


import java.util.List;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
public class BaseSwordItem extends SwordItem {

	private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();
	private Item HenshinBeltItem;
	private Boolean Change_sword = false;
	private Boolean Henshin_item = false;


	public BaseSwordItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));

	}

	public BaseSwordItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseSwordItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public static int Get_Mode (ItemStack itemstack)
	{
		if (!itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) return  0;
		else{
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getInt("item_mode");
		}
	}

	public BaseSwordItem IsHenshinItem(Item item) {
		Henshin_item=true;
		HenshinBeltItem=item;
		return this;
	}

	public BaseSwordItem IsChangeSword() {
		Change_sword=true;
		KamenRiderCraftCore.CHANGE_SWORD_ITEM.add(this);
		return this;
	}

	public static void Set_Mode(ItemStack itemstack)
	{
		if (!itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		CompoundTag  tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
		tag.putInt("item_mode", Get_Mode(itemstack)==0? 1:0);
	}



	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41130_) {
		ItemStack itemstack = player.getItemInHand(p_41130_);
		if (Henshin_item && player.getItemBySlot(EquipmentSlot.FEET)==ItemStack.EMPTY) {
			player.setItemSlot(EquipmentSlot.FEET, new ItemStack(HenshinBeltItem));
			if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() instanceof RiderFormChangeItem form) form.use(level, player, InteractionHand.OFF_HAND);
		}	
		if (Change_sword) {
			if (player.isShiftKeyDown()) {
				Set_Mode(itemstack);
			}

			if (Get_Mode(itemstack)==0) {
				
			
				
			}
		}	
		   return InteractionResultHolder.pass(player.getItemInHand( p_41130_));
	}


}