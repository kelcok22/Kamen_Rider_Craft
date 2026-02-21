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

public class OrgaDriverItem extends RiderDriverItem {

	public OrgaDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Unlimited_Belt_Textures = 1;
	}

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
		if (num==1&&!rider.isHolding(Faiz_Rider_Items.ORGA_STLANZER.get())) return "orga_stlanzer";
        return "blank";
    }

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem()==Faiz_Rider_Items.ORGA_DRIVER.get()
				&&rider.isHolding(Faiz_Rider_Items.ORGA_PHONE.get())) return "belts/orga_driver_belt_empty";
		return super.GET_TEXT(itemstack, equipmentSlot, rider, riderName);
	}

}