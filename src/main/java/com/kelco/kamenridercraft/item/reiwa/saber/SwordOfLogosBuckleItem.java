package com.kelco.kamenridercraft.item.reiwa.saber;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class SwordOfLogosBuckleItem extends RiderDriverItem {


    public SwordOfLogosBuckleItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedTextures = 1;
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity livingEntity, String riderName, int num) {
        if (livingEntity.isHolding(SaberRiderItems.DOGOUKEN_GEKIDO.get())) return "blank";
        return "dogouken_gekido";
    }


    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/buster.geo.json");
    }


    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {
        switch (currentSlot) {
            case HEAD, LEGS, CHEST -> {
                return true;
            }
        }
        return false;
    }
}