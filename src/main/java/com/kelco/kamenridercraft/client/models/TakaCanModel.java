package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.AnkhEntity;
import com.kelco.kamenridercraft.entities.allies.TakaCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class TakaCanModel extends GeoModel<TakaCanEntity> {
    @Override
    public ResourceLocation getModelResource(TakaCanEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/taka_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TakaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taka_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TakaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/taka_can.animation.json");
    }

}