package com.kelco.kamenridercraft.item.client;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.BasicArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class BasicArmorModel extends GeoModel<BasicArmorItem> {

    private static LivingEntity RIDER;
    private final EquipmentSlot slot;

    public BasicArmorModel(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {
        RIDER =  livingEntity;
        slot =  equipmentSlot;
    }

    @Override
    public ResourceLocation getModelResource(BasicArmorItem animatable) {
        if (RIDER.getItemBySlot(slot).getItem() instanceof BasicArmorItem BELT) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+BELT.MODEL+".geo.json");
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BasicArmorItem animatable) {
        if (RIDER.getItemBySlot(slot).getItem() instanceof BasicArmorItem BELT) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/"+BELT.NAME+".png");
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png");
    }


    @Override
    public ResourceLocation getAnimationResource(BasicArmorItem animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/ichigo.animation.json");
    }

    @Override
    public void setCustomAnimations(BasicArmorItem an, long instanceId, AnimationState<BasicArmorItem> state) {
    }
}