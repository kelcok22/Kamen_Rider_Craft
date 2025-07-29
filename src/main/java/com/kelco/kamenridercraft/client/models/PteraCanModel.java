package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.PteraCanEntity;
import com.kelco.kamenridercraft.entities.allies.ToraCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PteraCanModel extends GeoModel<PteraCanEntity> {
    @Override
    public ResourceLocation getModelResource(PteraCanEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/ptera_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PteraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/ptera_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PteraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/ptera_can.animation.json");
    }

}