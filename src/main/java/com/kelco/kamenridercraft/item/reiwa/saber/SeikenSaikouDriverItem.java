package com.kelco.kamenridercraft.item.reiwa.saber;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.registries.DeferredItem;

public class SeikenSaikouDriverItem extends RiderDriverItem {
    public SeikenSaikouDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
    }

    @Override
    public String getText(ItemStack itemStack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (isTransformed(rider) && getFormItem(itemStack, 1) == SaberRiderItems.KIN_NO_BUKI_GIN_NO_BUKI_WONDER_RIDE_BOOK.get()) {
            if (equipmentSlot == EquipmentSlot.FEET) return "belts/blank";
            else if (rider.isHolding(SaberRiderItems.KOUGOUKEN_SAIKOU.get())) return "blank";
        }
        return super.getText(itemStack, equipmentSlot, rider, riderName);
    }
}