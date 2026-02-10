package com.kelco.kamenridercraft.item.blade;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Blade_Rider_Items;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class BlayBuckleItem extends RiderDriverItem {

    public BlayBuckleItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if (get_Form_Item(itemstack, 1) == Blade_Rider_Items.FUSION_EAGLE.get() | get_Form_Item(itemstack, 1) == Blade_Rider_Items.FUSION_PEACOCK.get() |
                get_Form_Item(itemstack, 1) == Blade_Rider_Items.EVOLUTION_CAUCASUS.get() | get_Form_Item(itemstack, 1) == Blade_Rider_Items.EVOLUTION_GIRAFFA.get() |
                get_Form_Item(itemstack, 1) == Blade_Rider_Items.SILVER_EVOLUTION_CAUCASUS.get() | get_Form_Item(itemstack, 1) == Blade_Rider_Items.EVOLUTION_TARANTULA.get()) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/belt_with_brace.geo.json");
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/riderbelt.geo.json");
    }
}