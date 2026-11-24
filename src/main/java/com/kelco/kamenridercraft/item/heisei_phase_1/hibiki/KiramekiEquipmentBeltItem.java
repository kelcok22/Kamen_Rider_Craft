package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

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
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        hasBasicBeltInfo = false;
        Item form = getFormItem(stack, 1);
        Item mask = getFormItem(stack, 2);

        tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));
        if (showBeltFormInfo) {
            if (mask == HibikiRiderItems.MASKLESS_ONI.get()) tooltipComponents.add(Component.literal(Component.translatable(form.toString() + ".form").getString()
                    + " " + Component.translatable("kamenridercraft:form.unmasked").getString()));
            else tooltipComponents.add(Component.literal(Component.translatable(form.toString() + ".form").getString()));
        } else super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public double getRenderType(ItemStack stack, double num, LivingEntity rider) {
        RiderFormChangeItem form = getFormItem(stack, 2, num);
        if (form.getShowHead()) return 4;
        return super.getRenderType(stack, num, rider);
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemStack, EquipmentSlot currentSlot, String part) {
        if (Objects.equals(part, "head")) return getFormItem(itemStack, 2) != HibikiRiderItems.MASKLESS_ONI.get();
        return currentSlot != EquipmentSlot.FEET;
    }
}