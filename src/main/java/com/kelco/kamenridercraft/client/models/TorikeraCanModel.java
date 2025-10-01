package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.TorikeraCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TorikeraCanModel extends GeoModel<TorikeraCanEntity> {
    @Override
    public ResourceLocation getModelResource(TorikeraCanEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/tricera_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TorikeraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tricera_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TorikeraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/tricera_can.animation.json");
    }

}