package com.kelco.kamenridercraft.item.heisei_phase_2.ooo;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.Objects;

public class BirthDriverItem extends RiderDriverItem {
    public BirthDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Item.Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);

        extraBaseFormItem = Lists.newArrayList((RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get(), (RiderFormChangeItem) ModdedItemCore.BLANK_FORM.get());
        numBaseFormItems = 7;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        hasBasicBeltInfo = false;
        tooltipComponents.add(Component.translatable("kamenridercraft.name." + riderName));

        if (getFormItem(stack, 2) == OOORiderItems.BIRTH_CORE_BREAST_CANNON.get() & getFormItem(stack, 3)
                == OOORiderItems.BIRTH_CORE_CRANE_ARM.get() & getFormItem(stack, 4)
                == OOORiderItems.BIRTH_CORE_SHOVEL_ARM.get() & getFormItem(stack, 5)
                == OOORiderItems.BIRTH_CORE_CATERPILLAR_LEG.get() & getFormItem(stack, 6)
                == OOORiderItems.BIRTH_CORE_DRILL_ARM.get() & getFormItem(stack, 7)
                == OOORiderItems.BIRTH_CORE_CUTTER_WING.get())
            tooltipComponents.add(Component.translatable("kamenridercraft:birthday.form"));

        else {
            tooltipComponents.add(Component.translatable("kamenridercraft:claws.form"));

            if (getFormItem(stack, 2) == OOORiderItems.BIRTH_CORE_BREAST_CANNON.get())
                tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_breast_cannon.form"));
            if (getFormItem(stack, 3) == OOORiderItems.BIRTH_CORE_CRANE_ARM.get())
                tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_crane_arm.form"));
            if (getFormItem(stack, 4) == OOORiderItems.BIRTH_CORE_SHOVEL_ARM.get())
                tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_shovel_arm.form"));
            if (getFormItem(stack, 5) == OOORiderItems.BIRTH_CORE_CATERPILLAR_LEG.get())
                tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_catepillar_leg.form"));
            if (getFormItem(stack, 6) == OOORiderItems.BIRTH_CORE_DRILL_ARM.get())
                tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_drill_arm.form"));
            if (getFormItem(stack, 7) == OOORiderItems.BIRTH_CORE_CUTTER_WING.get())
                tooltipComponents.add(Component.translatable("kamenridercraft:birth_core_cutter_wing.form"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem) itemstack.getItem()).beltText;
            if (((RiderDriverItem) itemstack.getItem()).beltText == null) {
                belt = getFormItem(itemstack, 1).getBeltTex();
            }
            return "belts/" + belt;

        } else if (equipmentSlot == EquipmentSlot.CHEST) return "birth_claws_1";
        else if (equipmentSlot == EquipmentSlot.LEGS) return "birth_claws_2";
        else return riderName + getFormItem(itemstack, 1).getFormName(false);

    }

    public boolean getGlowForSlot(ItemStack itemstack, EquipmentSlot currentSlot, LivingEntity livingEntity) {
        if (currentSlot == EquipmentSlot.FEET) {
            return getFormItem(itemstack, 1).getIsBeltGlowing();
        }
        if (isTransformed(livingEntity) && currentSlot == EquipmentSlot.HEAD)
            return getFormItem(itemstack, 1).getIsGlowing();
        return false;
    }

    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        switch (slot) {
            case CHEST -> {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/claws_1.geo.json");
            }
            case LEGS -> {
                if (getFormItem(itemstack, 3) == OOORiderItems.BIRTH_CORE_CRANE_ARM.get())
                    return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/claws_2_crane.geo.json");
                else return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/claws_2.geo.json");
            }
            default -> {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + getFormItem(itemstack, 1).getModel(this.riderName));
            }
        }
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {
        switch (currentSlot) {
            case HEAD -> {
                if (Objects.equals(part, "head")) return true;
                if (Objects.equals(part, "body")) return true;
                if (Objects.equals(part, "rightArm")) return true;
                if (Objects.equals(part, "leftArm")) return true;
                if (Objects.equals(part, "leftLeg")) return true;
                if (Objects.equals(part, "rightLeg")) return true;

            }
            case CHEST -> {
                if (Objects.equals(part, "body"))
                    return getFormItem(itemstack, 2) == OOORiderItems.BIRTH_CORE_BREAST_CANNON.get();
                if (Objects.equals(part, "rightArm"))
                    return getFormItem(itemstack, 3) == OOORiderItems.BIRTH_CORE_CRANE_ARM.get();
                if (Objects.equals(part, "leftArm"))
                    return getFormItem(itemstack, 4) == OOORiderItems.BIRTH_CORE_SHOVEL_ARM.get();
                if (Objects.equals(part, "leftLeg") || Objects.equals(part, "rightLeg"))
                    return getFormItem(itemstack, 5) == OOORiderItems.BIRTH_CORE_CATERPILLAR_LEG.get();

            }
            case LEGS -> {
                if (Objects.equals(part, "rightArm"))
                    return getFormItem(itemstack, 6) == OOORiderItems.BIRTH_CORE_DRILL_ARM.get();
                if (Objects.equals(part, "body"))
                    return getFormItem(itemstack, 7) == OOORiderItems.BIRTH_CORE_CUTTER_WING.get();
            }
        }
        return false;
    }
}