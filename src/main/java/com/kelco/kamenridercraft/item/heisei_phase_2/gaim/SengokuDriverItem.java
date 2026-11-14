package com.kelco.kamenridercraft.item.heisei_phase_2.gaim;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.FourzeRingRenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.GaimArmsRenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.LevelOneRingRenderLayerInfo;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;

import java.util.List;
import java.util.Objects;

public class SengokuDriverItem extends RiderDriverItem {
    public SengokuDriverItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        boolean fly = Objects.requireNonNull(rider.getAttribute(KRCAttributes.WINGS_OUT)).getBaseValue() == 1;
        if (equipmentSlot == EquipmentSlot.FEET) {
            if (Objects.equals(riderName, "baron") & getFormItem(itemstack, 1) == GaimRiderItems.LORD_BARON.get())
                return "belts/blank";
            if (Objects.equals(riderName, "zangetsu") & getFormItem(itemstack, 1) == GaimRiderItems.WATERMELON_LOCKSEED.get())
                return "belts/sengoku_driver_belt_zangetsu_w";
            if (Objects.equals(riderName, "ryugen") & getFormItem(itemstack, 1) == GaimRiderItems.YOMOTSU_HEGURI_LOCKSEED.get())
                return "belts/sengoku_driver_belt_ryugen_y";
            return "belts/" + getFormItem(itemstack, 2).getBeltTex();
        } else if (isTransformingFromBlank(itemstack,rider)) {
            return "blank";
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
            if (isTransforming(rider)&&!isTransformingFromBlank(itemstack,rider))return "blank_arms";
            else if (getFormItem(itemstack, 2) == GaimRiderItems.JIMBER_GAIM_CORE.get()) {
                return "jimbar_arms_" + riderName;
            } else return "blank";

        if (isTransforming(rider))return "blank_arms";
        else return getFormItem(itemstack, 1).getFormName(fly);
    }

    public double getRenderType(ItemStack stack, double num) {
        if (RiderDriverItem.getFormItem(stack,1,num)==ModdedItemCore.BLANK_FORM.asItem()) return 0;
        return super.getRenderType(stack,num);
    }

    public double getBaseHenshinTick(ItemStack stack, LivingEntity rider){
        if (getFormItem(stack, 1, 60) == ModdedItemCore.BLANK_FORM.asItem())return 60;
        return 30;
    }


    public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
        super.SetUnlimitedModels(layerInfo,itemStack,rider,slot);
        double henshin_tick = getHenshinTick(itemStack, rider);
        if (slot==EquipmentSlot.HEAD&&isTransforming(rider)&&henshin_tick<23)layerInfo.add(new GaimArmsRenderLayerInfo());
        if(slot==EquipmentSlot.FEET){
            String texture;
            RiderFormChangeItem formItem = getFormItem(itemStack, 1);
            if (getFormItem(itemStack, 2) == GaimRiderItems.JIMBER_GAIM_CORE.get()&&itemStack.getItem()instanceof RiderDriverItem belt) layerInfo.add(new RenderLayerInfo("belts/parts/sengoku_driver_" + belt.baseFormItem.getFormName(false),null));
            layerInfo.add(new RenderLayerInfo("belts/parts/sengoku_driver_" + formItem.getFormName(false),null));
        }
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
        double transformingTick = getHenshinTick(itemstack, rider);
        if (slot == EquipmentSlot.LEGS ) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + getFormItem(itemstack, 1, transformingTick).getModel(""));
            }else  if (slot == EquipmentSlot.CHEST&&getFormItem(itemstack, 2) == GaimRiderItems.JIMBER_GAIM_CORE.get()&&itemstack.getItem()instanceof RiderDriverItem belt) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + belt.baseFormItem.getModel(""));
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + getFormItem(itemstack, 2, transformingTick).getModel(this.riderName));
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