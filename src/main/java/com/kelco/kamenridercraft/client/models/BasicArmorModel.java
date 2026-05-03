package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.BasicArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class BasicArmorModel extends GeoModel<BasicArmorItem> {


    public BasicArmorModel() {
    }

    @Override
    public ResourceLocation getModelResource(BasicArmorItem animatable) {

        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+ animatable.MODEL+".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BasicArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/"+animatable.MODEL+".png");
    }


    @Override
    public ResourceLocation getAnimationResource(BasicArmorItem animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/default_rider.animation.json");
    }

    @Override
    public void setCustomAnimations(BasicArmorItem an, long instanceId, AnimationState<BasicArmorItem> state) {
    }
}