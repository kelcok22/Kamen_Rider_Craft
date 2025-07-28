package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.DenkiunagiCanEntity;
import com.kelco.kamenridercraft.entities.allies.ToraCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DenkiunagiCanModel extends GeoModel<DenkiunagiCanEntity> {
    @Override
    public ResourceLocation getModelResource(DenkiunagiCanEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/unagi_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DenkiunagiCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/unagi_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DenkiunagiCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/unagi_can.animation.json");
    }

}