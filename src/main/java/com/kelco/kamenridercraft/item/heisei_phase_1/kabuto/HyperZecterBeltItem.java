package com.kelco.kamenridercraft.item.heisei_phase_1.kabuto;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class HyperZecterBeltItem extends RiderDriverItem {
    public HyperZecterBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    public ResourceLocation getBeltModelResource(ItemStack itemStack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        if ((getFormItem(itemStack, 1).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/hyper_zecters"))))) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/belt_with_hyper.geo.json");
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/riderbelt.geo.json");
    }
}