package com.kelco.kamenridercraft.client.model.entity.allies;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.AutoVajinRoboEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AutoVajinModel extends GeoModel<AutoVajinRoboEntity> {
    @Override
    public ResourceLocation getModelResource(AutoVajinRoboEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/auto_vajin_robo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AutoVajinRoboEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/auto_vajin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AutoVajinRoboEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/auto_vajin.animation.json");
    }
}