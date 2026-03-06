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

public class NextKaixaDriverItem extends RiderDriverItem {

	public NextKaixaDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem()==Faiz_Rider_Items.NEXT_KAIXA_DRIVER.get()
			&&rider.isHolding(Faiz_Rider_Items.KAIXA_PHONE_XX.get())) return "belts/next_kaixa_driver_belt_empty";

		return super.GET_TEXT(itemstack, equipmentSlot, rider, riderName);
	}

}