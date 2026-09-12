package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class KiramekiEquipmentBeltItem extends OniEquipmentBeltItem {
    public KiramekiEquipmentBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties, DeferredItem<Item> henshinItem, String henshinItemTexture) {
        super(material, rider, baseFormItem, head, torso, legs, properties, henshinItem, henshinItemTexture);
        unlimitedTextures = 2;
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemStack, LivingEntity livingEntity, String riderName, int num) {
        Item ongeki = HibikiRiderItems.ONGEKI_SHINCHO_RETSUBAN.get();
        Item leftHandItem = livingEntity.getMainArm() == HumanoidArm.LEFT? livingEntity.getMainHandItem().getItem() : livingEntity.getOffhandItem().getItem();
        Item rightHandItem = livingEntity.getMainArm() == HumanoidArm.LEFT? livingEntity.getOffhandItem().getItem() : livingEntity.getMainHandItem().getItem();

        if (num == 1 && leftHandItem != ongeki) return "ongeki_shincho_retsuban_l";
        else if (num == 2 && rightHandItem != ongeki) return "ongeki_shincho_retsuban_r";

        return "blank";
    }

    public ResourceLocation getModelResource(ItemStack itemStack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/kirameki.geo.json");
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemStack, EquipmentSlot currentSlot, String part) {
        return currentSlot != EquipmentSlot.FEET;
    }
}