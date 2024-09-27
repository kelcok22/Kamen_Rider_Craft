package com.kelco.kamenridercraft.item.build;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import net.minecraft.core.Holder;
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
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

public class BuildDriverItem extends RiderDriverItem {


	public BuildDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(stack,level,entity,slotId,isSelected);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {
			
			return "belts/"+get_Form_Item(itemstack,1).getBeltTex();
		}
		else if (isBestMatch(itemstack)&isLegend(itemstack)) return riderName+"_"+((FullBottleItem)get_Form_Item(itemstack,Legend_Slot(itemstack))).get_Is_Legend_Name();
		else if (equipmentSlot == EquipmentSlot.HEAD) return riderName+get_Form_Item(itemstack,1).getFormName(fly);
		else { return riderName+get_Form_Item(itemstack,2).getFormName(fly);
		}
	}

	public int Legend_Slot(ItemStack itemstack) {

		if (get_Form_Item(itemstack, 1) instanceof FullBottleItem form) {
			if (form.get_Is_Legend()) return 1;
		}
		return 2;
	}

	public boolean isLegend(ItemStack itemstack) {

		if (get_Form_Item(itemstack,1) instanceof FullBottleItem form){
			if (form.get_Is_Legend()){return true;}
		}if (get_Form_Item(itemstack,2) instanceof FullBottleItem form){
			if (form.get_Is_Legend()){return true;}
		}
		return false;
	}
	public boolean isBestMatch(ItemStack itemstack) {

		if (get_Form_Item(itemstack,1) instanceof FullBottleItem form){
			if (form.get_Is_Legend()){
				return form.get_Best_Match()==get_Form_Item(itemstack,2);
			}

		}if (get_Form_Item(itemstack,2) instanceof FullBottleItem form){
			return form.get_Best_Match()==get_Form_Item(itemstack,1);
		}
		return false;
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

		int num = 1;
		if (slot == EquipmentSlot.LEGS)num=2;

	 if (isBestMatch(itemstack)&isLegend(itemstack)) return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
		else if (get_Form_Item(itemstack, num).get_Model()=="default.geo.json") {
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rider_plusbelt.geo.json");
		}else return super.getModelResource(itemstack, animatable, slot,rider);
	}
	
	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (part =="head") return true;
			if (part =="body") return true;
			if (part =="rightArm") return true;
			if (part =="leftLeg") return true;
			
		}
		case CHEST -> {

		}
		case LEGS -> {
			if (part =="head") return true;
			if (part =="body") return true;
			if (part =="leftArm") return true;
			if (part =="rightLeg") return true;
		
		}
		default -> {}
		}
		return false;
	}



}