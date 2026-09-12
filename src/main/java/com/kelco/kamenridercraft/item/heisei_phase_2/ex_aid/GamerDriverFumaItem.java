package com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class GamerDriverFumaItem extends RiderDriverItem {
    public GamerDriverFumaItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedTextures = 2;
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemStack, LivingEntity livingEntity, String riderName, int num) {
        Item edge = ExAidRiderItems.FUUMA_SWORD.get();
        Item leftHandItem = livingEntity.getMainArm() == HumanoidArm.LEFT? livingEntity.getMainHandItem().getItem() : livingEntity.getOffhandItem().getItem();
        Item rightHandItem = livingEntity.getMainArm() == HumanoidArm.LEFT? livingEntity.getOffhandItem().getItem() : livingEntity.getMainHandItem().getItem();

        if (num == 1 && leftHandItem != edge) return "fuma_sozanto_l";
        else if (num == 2 && rightHandItem != edge) return "fuma_sozanto_r";

        return "blank";
    }

    public ResourceLocation getModelResource(ItemStack itemStack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/fuma.geo.json");
    }


    @Override
    public boolean getPartsForSlot(ItemStack itemStack, EquipmentSlot currentSlot, String part) {
        return currentSlot != EquipmentSlot.FEET;
    }
}