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

public class FaizDriverNextItem extends RiderDriverItem {

	public FaizDriverNextItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem()==Faiz_Rider_Items.FAIZ_DRIVER_NEXT.get()
			&&(rider.isHolding(Faiz_Rider_Items.FAIZ_PHONE_20_PLUS_BURST_MODE.get())||(rider.isHolding(Faiz_Rider_Items.FAIZ_PHONE_20_PLUS_KNUCKLE_MODE.get())))) return "belts/faiz_driver_next_belt_empty";

		return super.GET_TEXT(itemstack, equipmentSlot, rider, riderName);

	}

}