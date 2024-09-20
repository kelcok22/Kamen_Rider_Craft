package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.bikes.baseBikeEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class BikeModel extends GeoModel<baseBikeEntity> {
    @Override
    public ResourceLocation getModelResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+animatable.NAME_MODEL+".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/"+animatable.NAME+".png");
    }

    @Override
    public ResourceLocation getAnimationResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/hardboilder.animation.json");
    }

    @Override
    public void setCustomAnimations(baseBikeEntity animatable, long instanceId, AnimationState<baseBikeEntity> animationState) {
  
    }


}