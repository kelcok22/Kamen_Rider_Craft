package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.GorillaCanEntity;
import com.kelco.kamenridercraft.entities.allies.ToraCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GorillaCanModel extends GeoModel<GorillaCanEntity> {
    @Override
    public ResourceLocation getModelResource(GorillaCanEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/gorilla_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GorillaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/gorilla_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GorillaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/gorilla_can.animation.json");
    }

}