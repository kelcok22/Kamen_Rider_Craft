package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.BattaCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BattaCanModel extends GeoModel<BattaCanEntity> {
    @Override
    public ResourceLocation getModelResource(BattaCanEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/batta_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BattaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/batta_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BattaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/batta_can.animation.json");
    }

}