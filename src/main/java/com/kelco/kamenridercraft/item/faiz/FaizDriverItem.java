package com.kelco.kamenridercraft.item.faiz;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Faiz_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class FaizDriverItem extends RiderDriverItem {

	public FaizDriverItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
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
		
			if (itemstack.getItem()==Faiz_Rider_Items.FAIZ_DRIVER.get()) {
				if((rider.getMainHandItem().getItem()==Faiz_Rider_Items.FAIZ_PHONE.get()||rider.getOffhandItem().getItem()==Faiz_Rider_Items.FAIZ_PHONE.get())
				||(rider.getMainHandItem().getItem()==Faiz_Rider_Items.FAIZ_PHONE_POINTER.get()||rider.getOffhandItem().getItem()==Faiz_Rider_Items.FAIZ_PHONE_POINTER.get()) ) belt="faiz_driver_belt_b";
			}
			return "belts/"+belt;
		}
		else return riderName+ get_Form_Item(itemstack,1).getFormName(fly);

	}

	public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {

		if (currentSlot== EquipmentSlot.FEET) {
			return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
		}
		if (livingEntity.getItemBySlot(EquipmentSlot.LEGS).getItem() == LEGS){
			if (livingEntity.getItemBySlot(EquipmentSlot.CHEST).getItem() == TORSO){
				if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() == HEAD){
					switch (currentSlot) {
					case HEAD ->{ 
						return get_Form_Item(itemstack, 1).get_Is_Glowing();
					}
					case CHEST -> {
						return get_Form_Item(itemstack, 1).get_Is_Glowing();
					}
					case LEGS -> {
						return get_Form_Item(itemstack, 1).get_Is_Glowing();
					}
					default -> {}
					}
					return false;
				}
			}

		}
		return false;
	}

	public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, get_Form_Item(itemstack, 1).get_Model());
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