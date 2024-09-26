package com.kelco.kamenridercraft.item.ooo;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class OOODriverItem extends RiderDriverItem {


	public OOODriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);

	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;
		if (equipmentSlot == EquipmentSlot.FEET) {
			
			
				String belt = ((RiderDriverItem)itemstack.getItem()).BELT_TEXT;
				if (((RiderDriverItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,1).getBeltTex();
				}
				return "belts/"+belt;
			
		}
	
		else if (equipmentSlot == EquipmentSlot.HEAD&get_Form_Item(itemstack,1).getFormName(false)=="_taka"&get_Form_Item(itemstack,2).getFormName(false)=="_kujaku"&get_Form_Item(itemstack,3).getFormName(false)=="_condor") return riderName+ "_taka_tajado";
		else if (equipmentSlot == EquipmentSlot.HEAD&rider.getMainHandItem().getItem()== OOO_Rider_Items.MEDAGABURYU.get()&rider.getItemBySlot(EquipmentSlot.FEET).getItem()==OOO_Rider_Items.OOODRIVER.get()&get_Form_Item(itemstack,1).getFormName(false)=="_taka"&get_Form_Item(itemstack,2).getFormName(false)=="_tora"&get_Form_Item(itemstack,3).getFormName(false)=="_batta") return riderName+ "_taka_purple";
		
		else if (equipmentSlot == EquipmentSlot.HEAD&get_Form_Item(itemstack,2)==OOO_Rider_Items.GREEED_ABSORPTION_CORE.get()) return riderName+ get_Form_Item(itemstack,1).getFormName(fly)+ "_greeed_absorption";
		else if (equipmentSlot == EquipmentSlot.LEGS&get_Form_Item(itemstack,2)==OOO_Rider_Items.GREEED_ABSORPTION_CORE.get()) return riderName+ get_Form_Item(itemstack,3).getFormName(fly)+ "_greeed_absorption";
		
		else if (equipmentSlot == EquipmentSlot.HEAD) return riderName+ get_Form_Item(itemstack,1).getFormName(fly);
		else if (equipmentSlot == EquipmentSlot.CHEST) return riderName+ get_Form_Item(itemstack,2).getFormName(fly);
		else return riderName+ get_Form_Item(itemstack,3).getFormName(fly);

	}

	public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/ooo_belt.geo.json");
	}

	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
		}
		if (isTransformed(livingEntity)){
			switch (currentSlot) {
				case HEAD ->{ 
					return false;
				}
				case CHEST -> {
					return get_Form_Item(itemstack, 2).get_Is_Glowing();
				}
				case LEGS -> {
					return false;
				}
			}
			return false;
		}
		return false;
	}

	public ResourceLocation getModelResource(ItemStack itemstack,RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		int num = 1;
		if (slot == EquipmentSlot.CHEST)num=2; 
		if (slot == EquipmentSlot.LEGS)num=3;
		
		if (get_Form_Item(itemstack, num).HasWingsIfFlying() && rider instanceof Player player && player.getAbilities().flying == true){
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_FlyingModel());
	 }else if (get_Form_Item(itemstack, num).get_Model()=="default.geo.json") {
			return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/ooo.geo.json");
		 }else   
			 return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+get_Form_Item(itemstack, num).get_Model());

	}
	
	@Override
	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (part =="head") return true;
			if (part =="body") return true;
			
		}
		case CHEST -> {
			if (part =="body") return true;
			if (part =="rightArm") return true;
			if (part =="leftArm") return true;
			
		}
		case LEGS -> {
			if (part =="body") return true;
			if (part =="leftLeg") return true;
			if (part =="rightLeg") return true;
			
		
		}
		default -> {}
		}
		return false;
	}

}