package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.entities.allies.AnkhEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class AnkhModel extends GeoModel<AnkhEntity> {
    @Override
    public ResourceLocation getModelResource(AnkhEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/ankh.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnkhEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/ankh.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnkhEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/ankh.animation.json");
    }

    @Override
    public void setCustomAnimations(AnkhEntity animatable, long instanceId, AnimationState<AnkhEntity> animationState) {
  
    }
}