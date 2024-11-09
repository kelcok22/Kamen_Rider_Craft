package com.kelco.kamenridercraft.item.w;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

public class WDriverItem extends RiderDriverItem {


	public WDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack,level,entity,slotId,isSelected);
		if (entity instanceof Player player) {
		if (RiderDriverItem.get_Form_Item(stack, 1)== W_Rider_Items.XTREME_MEMORY.get()&player.fallDistance>10) {
			RiderFormChangeItem alternativeItem_form_change = (RiderFormChangeItem) W_Rider_Items.XTREME_GOLD_MEMORY.get();
			alternativeItem_form_change.use(level, player, InteractionHand.MAIN_HAND);
		}
			}
	}

	@Override
    public void Extra_set_Form_Item(ItemStack belt, Item ITEM,int SLOT,CompoundTag  tag)
    {
		if (get_Form_Item(belt, 1)==W_Rider_Items.XTREME_MEMORY.get()||get_Form_Item(belt, 1)==W_Rider_Items.XTREME_GOLD_MEMORY.get()||get_Form_Item(belt, 1)==W_Rider_Items.XTREME_ACCEL_MEMORY.get()) {
			if (get_Form_Item(belt, 2)!=W_Rider_Items.JOKER_MEMORY.get()) {
				tag.putString("slot_tex" + 1, (W_Rider_Items.CYCLONE_MEMORY.get()).toString());
				tag.putInt("slot" + 1, Item.getId(W_Rider_Items.CYCLONE_MEMORY.get()));
				CustomData.set(DataComponents.CUSTOM_DATA, belt, tag);
			}
		}
		if (get_Form_Item(belt, 2)==W_Rider_Items.CYCLONE_SKULL_MEMORY.get()) {
			if (get_Form_Item(belt, 1)!=W_Rider_Items.CYCLONE_MEMORY.get()) {
				tag.putString("slot_tex" + 2, (W_Rider_Items.JOKER_MEMORY.get()).toString());
				tag.putInt("slot" + 2, Item.getId(W_Rider_Items.JOKER_MEMORY.get()));
				CustomData.set(DataComponents.CUSTOM_DATA, belt, tag);
			}
		}
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {
			
			return "belts/"+get_Form_Item(itemstack,1).getBeltTex();
		}
		else if (equipmentSlot == EquipmentSlot.HEAD){
			if (get_Form_Item(itemstack,2).getFormName(fly)=="_skull") return riderName+get_Form_Item(itemstack,1).getFormName(fly)+"_skull";
			else return riderName+get_Form_Item(itemstack,1).getFormName(fly);
		}
			
		
		else {
			if (get_Form_Item(itemstack,1).getFormName(fly)=="_fang") return riderName+"_fang"+get_Form_Item(itemstack,2).getFormName(fly);
			else if (get_Form_Item(itemstack,1).getFormName(fly)=="_cyclone_xtreme") return riderName+get_Form_Item(itemstack,2).getFormName(fly)+"_xtreme";
			else if (get_Form_Item(itemstack,1).getFormName(fly)=="_cyclone_xtreme_gold") return riderName+get_Form_Item(itemstack,2).getFormName(fly)+"_xtreme_gold";
			else if (get_Form_Item(itemstack,1).getFormName(fly)=="_cyclone_xtreme_accel") return riderName+"_accel_xtreme";
			else return riderName+get_Form_Item(itemstack,2).getFormName(fly);
		}
	}


	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		
		if (slot!= EquipmentSlot.HEAD) {
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
		}else
		return super.getModelResource(itemstack, animatable, slot,rider);
	}
	
	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (part =="head") return true;
			if (part =="body") return true;
			if (part =="rightArm") return true;
			if (part =="rightLeg") return true;
			
		}
		case CHEST -> {
			if (part =="body") return true;

		}
		case LEGS -> {
			if (part =="head") return true;
			if (part =="leftLeg") return true;
			if (part =="leftArm") return true;
		
		}
		default -> {}
		}
		return false;
	}



}