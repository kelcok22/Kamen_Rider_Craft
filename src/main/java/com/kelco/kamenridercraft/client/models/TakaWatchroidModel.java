package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.TakaWatchroidEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TakaWatchroidModel extends GeoModel<TakaWatchroidEntity> {
    @Override
    public ResourceLocation getModelResource(TakaWatchroidEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/taka_watchroid.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TakaWatchroidEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taka_watchroid.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TakaWatchroidEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/taka_watchroid.animation.json");
    }

}