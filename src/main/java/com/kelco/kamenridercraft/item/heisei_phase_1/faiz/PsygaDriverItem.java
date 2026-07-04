package com.kelco.kamenridercraft.item.heisei_phase_1.faiz;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.FaizRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class PsygaDriverItem extends RiderDriverItem {
    public PsygaDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    @Override
    public String getText(ItemStack itemStack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (equipmentSlot == EquipmentSlot.FEET && itemStack.getItem() == FaizRiderItems.PSYGA_DRIVER.get()
                && rider.isHolding(FaizRiderItems.PSYGA_PHONE.get())) return "belts/psyga_driver_belt_empty";
        return super.getText(itemStack, equipmentSlot, rider, riderName);
    }
}