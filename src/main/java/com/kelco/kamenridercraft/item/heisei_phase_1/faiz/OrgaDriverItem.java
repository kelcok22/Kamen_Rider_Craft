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

public class OrgaDriverItem extends RiderDriverItem {
    public OrgaDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedBeltTextures = 1;
    }

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        return rider.isHolding(FaizRiderItems.ORGA_STLANZER.get()) ? "blank" : "orga_stlanzer";
    }

    @Override
    public String getText(ItemStack itemStack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (equipmentSlot == EquipmentSlot.FEET && itemStack.getItem() == FaizRiderItems.ORGA_DRIVER.get()
                && rider.isHolding(FaizRiderItems.ORGA_PHONE.get())) return "belts/orga_driver_belt_empty";
        return super.getText(itemStack, equipmentSlot, rider, riderName);
    }
}