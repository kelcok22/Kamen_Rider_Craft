package com.kelco.kamenridercraft.item.heisei_phase_1.hibiki;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.HibikiRiderItems;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
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

public class HibikiEquipmentBeltItem extends RiderDriverItem {
    public HibikiEquipmentBeltItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        unlimitedTextures = 2;
        unlimitedBeltTextures = 3;
    }

    @Override
    public String getUnlimitedTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        Item ongeki = HibikiRiderItems.ONGEKIBO_REKKA.get();
        Item leftHandItem = rider.getMainArm() == HumanoidArm.LEFT? rider.getMainHandItem().getItem() : rider.getOffhandItem().getItem();
        Item rightHandItem = rider.getMainArm() == HumanoidArm.LEFT? rider.getOffhandItem().getItem() : rider.getMainHandItem().getItem();

        if (getFormItem(itemStack, 1) == HibikiRiderItems.HENSHIN_ONSA_ARMED.get()) {
            if (num == 1 && leftHandItem != ongeki) return "ongekibo_rekka_l";
            else if (num == 2 && rightHandItem != ongeki) return "ongekibo_rekka_r";
        }
        return "blank";
    }

    @Override
    public String getUnlimitedBeltTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        if (num == 1 && !rider.isHolding(HibikiRiderItems.HENSHIN_ONSA.get())) return "henshin_onsa";
        else if (getFormItem(itemStack, 1) != HibikiRiderItems.HENSHIN_ONSA_ARMED.get()) {
            Item ongeki = HibikiRiderItems.ONGEKIBO_REKKA.get();
            Item leftHandItem = rider.getMainArm() == HumanoidArm.LEFT? rider.getMainHandItem().getItem() : rider.getOffhandItem().getItem();
            Item rightHandItem = rider.getMainArm() == HumanoidArm.LEFT? rider.getOffhandItem().getItem() : rider.getMainHandItem().getItem();

            if (num == 2 && leftHandItem != ongeki) return "ongekibo_rekka_l";
            else if (num == 3 && rightHandItem != ongeki) return "ongekibo_rekka_r";
        } else if (num == 2 && !rider.isHolding(HibikiRiderItems.ARMED_SABER.get())) return "armed_saber";

        return "blank";
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
