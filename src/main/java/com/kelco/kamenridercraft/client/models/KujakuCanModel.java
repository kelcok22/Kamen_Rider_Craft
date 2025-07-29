package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.KujakuCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KujakuCanModel extends GeoModel<KujakuCanEntity> {
    @Override
    public ResourceLocation getModelResource(KujakuCanEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/kujaku_can.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KujakuCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/kujaku_can.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KujakuCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/kujaku_can.animation.json");
    }

}