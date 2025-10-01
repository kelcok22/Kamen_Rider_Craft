package com.kelco.kamenridercraft.item.faiz;

import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Faiz_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
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
		if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem()==Faiz_Rider_Items.FAIZ_DRIVER.get()) {
			if(get_Form_Item(itemstack, 1)!=Faiz_Rider_Items.FAIZ_GOLD_BLASTER_MISSION_MEMORY.get()
				&&((rider.isHolding(Faiz_Rider_Items.FAIZ_PHONE.get())||(rider.isHolding(Faiz_Rider_Items.FAIZ_PHONE_POINTER.get()))))) return "belts/faiz_driver_belt_b";
		}
		return super.GET_TEXT(itemstack, equipmentSlot, rider, riderName);

	}

}