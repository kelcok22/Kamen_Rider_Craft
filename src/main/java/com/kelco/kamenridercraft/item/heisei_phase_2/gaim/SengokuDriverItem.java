package com.kelco.kamenridercraft.item.heisei_phase_2.gaim;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;

public class SengokuDriverItem extends RiderDriverItem {
    public SengokuDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        boolean fly = Objects.requireNonNull(rider.getAttribute(Attributes.WINGS_OUT)).getBaseValue() == 1;
        if (equipmentSlot == EquipmentSlot.FEET) {
            if (Objects.equals(riderName, "baron") & getFormItem(itemstack, 1) == GaimRiderItems.LORD_BARON.get())
                return "belts/blank";
            if (Objects.equals(riderName, "zangetsu") & getFormItem(itemstack, 1) == GaimRiderItems.WATERMELON_LOCKSEED.get())
                return "belts/sengoku_driver_belt_zangetsu_w";
            if (Objects.equals(riderName, "ryugen") & getFormItem(itemstack, 1) == GaimRiderItems.YOMOTSU_HEGURI_LOCKSEED.get())
                return "belts/sengoku_driver_belt_ryugen_y";
            return "belts/" + getFormItem(itemstack, 2).getBeltTex();
        } else if (equipmentSlot == EquipmentSlot.HEAD) {
            if (Objects.equals(riderName, "baron") & getFormItem(itemstack, 1) == GaimRiderItems.LORD_BARON.get())
                return "baron_lord_baron";
            else if (Objects.equals(riderName, "ryugen") & getFormItem(itemstack, 1) == GaimRiderItems.YOMOTSU_HEGURI_LOCKSEED.get())
                return "ryugen_yomi";
            else if (Objects.equals(riderName, "duke") & getFormItem(itemstack, 1) == GaimRiderItems.DRAGON_FRUITS_ENERGY_LOCKSEED.get())
                return "duke_hex";
            else if (Objects.equals(riderName, "zangetsu") & getFormItem(itemstack, 1) == GaimRiderItems.WATERMELON_LOCKSEED.get())
                return "zangetsu_watermelon";
            else if (Objects.equals(riderName, "zangetsu") & getFormItem(itemstack, 1) == GaimRiderItems.ZANGETSU_KACHIDOKI_LOCKSEED.get())
                return "zangetsu_kachidoki";
            else if (Objects.equals(riderName, "gridon") & getFormItem(itemstack, 1) == GaimRiderItems.LYCHEE_LOCKSEED.get())
                return "gridon_lychee";
            else if (Objects.equals(riderName, "gaim") & getFormItem(itemstack, 1) == GaimRiderItems.FRESH_ORANGE_LOCKSEED.get())
                return "gaim_fresh";
            else if (Objects.equals(riderName, "gaim") & getFormItem(itemstack, 1) == GaimRiderItems.DRIVE_LOCKSEED.get())
                return "gaim_drive";
            else if (Objects.equals(riderName, "gaim") & getFormItem(itemstack, 1) == GaimRiderItems.KACHIDOKI_LOCKSEED.get())
                return "gaim_kachidoki";
            else if (Objects.equals(riderName, "gaim") & getFormItem(itemstack, 1) == GaimRiderItems.KIWAMI_LOCKSEED.get())
                return "gaim_kiwami";
            else if (Objects.equals(riderName, "bravo") & getFormItem(itemstack, 1) == GaimRiderItems.KING_DURIAN_LOCKSEED.get())
                return "bravo_king";
            else if (Objects.equals(riderName, "bujin_gaim") & getFormItem(itemstack, 1) == GaimRiderItems.OCHIMUSHA_LOCKSEED.get())
                return "bujin_gaim_ochimusha";
            else return riderName + getFormItem(itemstack, 2).getFormName(fly);
        } else if (equipmentSlot == EquipmentSlot.CHEST)
            if (getFormItem(itemstack, 2) == GaimRiderItems.JIMBER_GAIM_CORE.get()) {
                return "jimbar_arms_" + riderName;
            } else return "blank";

        else return getFormItem(itemstack, 1).getFormName(fly);
    }

    public boolean getGlowForSlot(ItemStack itemstack, EquipmentSlot currentSlot, LivingEntity livingEntity) {

        if (currentSlot == EquipmentSlot.FEET) {
            return getFormItem(itemstack, 1).getIsBeltGlowing();
        }
        if (isTransformed(livingEntity)) {
            switch (currentSlot) {
                case HEAD -> {
                    return false;
                }
                case LEGS, CHEST -> {
                    return true;
                }
                default -> {
                }
            }
            return false;
        }
        return false;
    }


    public ResourceLocation getModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

        if (slot == EquipmentSlot.LEGS || slot == EquipmentSlot.CHEST) {
            if (getFormItem(itemstack, 1) == GaimRiderItems.KACHIDOKI_LOCKSEED.get() | getFormItem(itemstack, 1) == GaimRiderItems.ZANGETSU_KACHIDOKI_LOCKSEED.get()) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gaim_kachidoki_arms.geo.json");
            } else if (Objects.equals(getFormItem(itemstack, 1).getModel(this.riderName), "default.geo.json")) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/lockseed_arms.geo.json");
            }
        }
        return super.getModelResource(itemstack, animatable, slot, rider);
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {

        switch (currentSlot) {
            case HEAD, LEGS -> {
                return true;
            }
            case CHEST -> {
                if (Objects.equals(part, "head")) return true;
                if (Objects.equals(part, "body")) return true;
            }
        }
        return false;
    }
}