package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.projectile.RocketProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RocketModel extends GeoModel<RocketProjectileEntity> {
    public String textureChoice;
    @Override
    public ResourceLocation getModelResource(RocketProjectileEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/rocket.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RocketProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/rocket.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RocketProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/laser.animation.json");
    }

}