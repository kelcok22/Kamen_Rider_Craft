package com.kelco.kamenridercraft.item.revice;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.summons.ParaDXSummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.build.FullBottleItem;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import com.kelco.kamenridercraft.item.W_Rider_Items;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.registries.DeferredItem;

public class DemonsDriverItem extends RiderDriverItem {


	public DemonsDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
 
		Extra_Base_Form_Item= Lists.newArrayList((RiderFormChangeItem) Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get(),(RiderFormChangeItem)Modded_item_core.BLANK_FORM.get());
		Num_Base_Form_Item=5;
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		switch (equipmentSlot) {
			case EquipmentSlot.FEET:
				String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
				if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,1).getBeltTex();
				}
				return "belts/"+belt;
			case EquipmentSlot.CHEST:
				if (get_Form_Item(itemstack, 2) != Modded_item_core.BLANK_FORM.get()) return riderName+ get_Form_Item(itemstack,2).getFormName(fly);
				else if (get_Form_Item(itemstack, 3) != Modded_item_core.BLANK_FORM.get()) return riderName+ get_Form_Item(itemstack,3).getFormName(fly);
			case EquipmentSlot.LEGS: // This is gonna break as soon as we add Condor and Scorpion
				if (get_Form_Item(itemstack, 4) != Modded_item_core.BLANK_FORM.get()) return riderName+ get_Form_Item(itemstack,4).getFormName(fly);
				else if (get_Form_Item(itemstack, 5) != Modded_item_core.BLANK_FORM.get()) return riderName+ get_Form_Item(itemstack,5).getFormName(fly);
			default:
				return riderName+ get_Form_Item(itemstack,1).getFormName(fly);
		}	

	}

	public ResourceLocation getModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		int num = 1;
		if (slot == EquipmentSlot.CHEST) num = (get_Form_Item(itemstack, 2) != Modded_item_core.BLANK_FORM.get() ? 2 : 3);
		if (slot == EquipmentSlot.LEGS) num = (get_Form_Item(itemstack, 4) != Modded_item_core.BLANK_FORM.get() ? 4 : 5);
		
		if (get_Form_Item(itemstack, num).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying == true){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_FlyingModel());
		}
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_Model());

	}

	@Override
    public void Extra_set_Form_Item(ItemStack belt, Item ITEM,int SLOT,CompoundTag  tag)
    {
		if (get_Form_Item(belt, 1) != Base_Form_Item) {
			for (int n = 2; n < 6; n++) {
				tag.putString("slot_tex" + n, (Modded_item_core.BLANK_FORM.get()).toString());
				tag.putInt("slot" + n, Item.getId(Modded_item_core.BLANK_FORM.get()));
			}
			CustomData.set(DataComponents.CUSTOM_DATA, belt, tag);
		}
	}
}