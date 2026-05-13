package com.kelco.kamenridercraft.item.heisei_phase_1.decade;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.heisei_phase_1.Faiz_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;

public class DecadriverItem extends RiderDriverItem {

	public DecadriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Unlimited_Belt_Textures = 1;
	}

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
			if (num==1&&!rider.isHolding(Decade_Rider_Items.RIDE_BOOKER.get())) return "decadriver_belt_rb";
        return "blank";

    }
    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/decade_belt.geo.json");

    }
    @Override
    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider,String riderName)
    {
        if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem()==Decade_Rider_Items.DECADRIVER.get()) {
            if((get_Form_Item(itemstack, 1)==Decade_Rider_Items.K_TOUCH.get()
           ||get_Form_Item(itemstack, 1)==Decade_Rider_Items.K_TOUCH_STRONGEST.get())
                    &&((rider.isHolding(Decade_Rider_Items.K_TOUCH.get())))) return "belts/decadriver_belt_k_touch_empty";
        }
        return super.GET_TEXT(itemstack, equipmentSlot, rider, riderName);
    }
}

