
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

public class DiendBeltItem extends RiderDriverItem {

    public DiendBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedBeltTextures = 1;
    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/belts/diend_belt.geo.json");

    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity livingEntity, String riderName) {
        if (equipmentSlot == EquipmentSlot.FEET && itemstack.getItem() == DecadeRiderItems.DIEND_BELT.get()) {
            if ((getFormItem(itemstack, 1) == DecadeRiderItems.K_TOUCH_DIEND.get()
                    && ((livingEntity.isHolding(DecadeRiderItems.K_TOUCH_DIEND.get())))))
                return "belts/diend_belt_k_touch_empty";
        }
        return super.getText(itemstack, equipmentSlot, livingEntity, riderName);
    }
}