package com.kelco.kamenridercraft.item.heisei_phase_1.decade;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class NeoDecadriverItem extends RiderDriverItem {

	public NeoDecadriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Unlimited_Belt_Textures = 1;
	}

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemstack, LivingEntity rider, String riderName ,int num) {
			if (num==1&&!rider.isHolding(DecadeRiderItems.RIDE_BOOKER.get())) return "decadriver_belt_rb";
        return "blank";

    }
    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/decade_belt.geo.json");
    }
    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
    {
        if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem()== DecadeRiderItems.NEO_DECADRIVER.get()) {
            if((getFormItem(itemstack, 1)== DecadeRiderItems.K_TOUCH_21.get()
                    &&((rider.isHolding(DecadeRiderItems.K_TOUCH_21.get()))))) return "belts/decadriver_belt_k_touch_21_empty";
        }
        return super.getText(itemstack, equipmentSlot, rider, riderName);
    }
}

