package com.kelco.kamenridercraft.item.heisei_phase_2.zi_o;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;

public class AnotherArcleItem extends RiderDriverItem {
    public AnotherArcleItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem) itemstack.getItem()).beltText;
            if (((RiderDriverItem) itemstack.getItem()).beltText == null) {
                belt = getFormItem(itemstack, 1).getBeltTex();
            }

            if (Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/belts/another_arclebelt.geo.json") && !isTransformed(rider)) {
                belt = getFormItem(itemstack, 1).getBeltTex() + "_un";
            }

            return "belts/" + belt;
            }
        return riderName + getFormItem(itemstack, 1).getFormName(false);

    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

        if (Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/belts/another_arclebelt.geo.json") && !isTransformed(rider)) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/belts/riderbelt.geo.json");
        }

        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, getFormItem(itemstack, 1).getBeltModel());
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {

        switch (currentSlot) {
            case CHEST ,HEAD -> {
                return true;
            }
            default -> {
            }
        }
        return false;
    }

}