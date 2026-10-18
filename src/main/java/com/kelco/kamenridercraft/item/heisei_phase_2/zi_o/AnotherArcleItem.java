package com.kelco.kamenridercraft.item.heisei_phase_2.zi_o;

import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.ParaDXSummonEntity;
import com.kelco.kamenridercraft.item.ModdedItemCore;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;

import java.util.List;
import java.util.Objects;

public class AnotherArcleItem extends RiderDriverItem {
    public AnotherArcleItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RiderDriverItem) itemstack.getItem()).beltText;
            if (((RiderDriverItem) itemstack.getItem()).beltText == null) {
                belt = getFormItem(itemstack, 1).getBeltTex();
            }

            if (Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/belts/another_arclebelt.geo.json") && !isTransformed(rider)) {
                belt = getFormItem(itemstack, 1).getBeltTex() + "_un";
            }

            return "belts/" + belt;
            }
        return riderName + getFormItem(itemstack, 1).getFormName(false);

    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack, RiderArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {

        if (Objects.equals(getFormItem(itemstack, 1).getBeltModel(), "geo/belts/another_arclebelt.geo.json") && !isTransformed(rider)) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/belts/riderbelt.geo.json");
        }

        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, getFormItem(itemstack, 1).getBeltModel());
    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack, EquipmentSlot currentSlot, String part) {

        switch (currentSlot) {
            case CHEST ,HEAD -> {
                return true;
            }
            default -> {
            }
        }
        return false;
    }

}