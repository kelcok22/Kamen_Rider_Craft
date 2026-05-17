package com.kelco.kamenridercraft.item.reiwa.saber;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.Saber_Rider_Items;
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
    public SeikenSaikouDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties.component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
    }

    @Override
    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (isTransformed(rider) && get_Form_Item(itemstack, 1) == Saber_Rider_Items.KIN_NO_BUKI_GIN_NO_BUKI_WONDER_RIDE_BOOK.get()) {
            if (equipmentSlot == EquipmentSlot.FEET) return "belts/blank";
            else if (rider.isHolding(Saber_Rider_Items.KOUGOUKEN_SAIKOU.get())) return "blank";
        }
        return super.GET_TEXT(itemstack, equipmentSlot, rider, riderName);
    }
}