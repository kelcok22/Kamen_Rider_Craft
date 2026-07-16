package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.ToraCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ToraCanModel extends GeoModel<ToraCanEntity> {
    @Override
    public ResourceLocation getModelResource(ToraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/tora_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ToraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tora_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ToraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/tora_can.animation.json");
    }

}