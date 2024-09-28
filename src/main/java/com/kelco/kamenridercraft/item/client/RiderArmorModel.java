package com.kelco.kamenridercraft.item.client;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.GeoModel;

public class RiderArmorModel extends GeoModel<RiderArmorItem> {

    private static LivingEntity RIDER;
    private final EquipmentSlot slot;

    public RiderArmorModel(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

        RIDER =  livingEntity;
        slot =  equipmentSlot;
    }

    @Override
    public ResourceLocation getModelResource(RiderArmorItem animatable) {
        if (slot== EquipmentSlot.FEET) {
            RiderDriverItem BELT = (RiderDriverItem)RIDER.getItemBySlot(EquipmentSlot.FEET).getItem();
            return BELT.getBeltModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);
        } else if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem BELT) {
            return BELT.getModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RiderArmorItem animatable) {
        ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET);
        if (BELT.getItem() instanceof RiderDriverItem DRIVER && (slot == EquipmentSlot.FEET || DRIVER.isTransformed(RIDER))) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/"+DRIVER.GET_TEXT(BELT,slot,RIDER,DRIVER.Rider)+".png");
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png");
    }



    @Override
    public ResourceLocation getAnimationResource(RiderArmorItem animatable) {
        if (slot== EquipmentSlot.FEET) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/riderbelt.animation.json");
        }else {

            if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem BELT) {
                return BELT.getAnimationResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot);

            }else return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/ichigo.animation.json");
        }

    }
}