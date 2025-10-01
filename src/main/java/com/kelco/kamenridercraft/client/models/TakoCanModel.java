package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.TakoCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TakoCanModel extends GeoModel<TakoCanEntity> {
    @Override
    public ResourceLocation getModelResource(TakoCanEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/tako_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TakoCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tako_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TakoCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/tako_can.animation.json");
    }

}