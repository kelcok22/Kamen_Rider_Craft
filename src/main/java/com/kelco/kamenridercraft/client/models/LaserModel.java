package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.projectile.LaserProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LaserModel extends GeoModel<LaserProjectileEntity> {
    @Override
    public ResourceLocation getModelResource(LaserProjectileEntity animatable) {
        if (animatable.getShape().isEmpty()) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/laser.geo.json");
        } else {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + animatable.getShape() + "_laser.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(LaserProjectileEntity animatable) {
        if (animatable.getShape().isEmpty()) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/projectiles/laser.png");
        } else {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/projectiles/"  + animatable.getColor() + "_laser.png");
        }

    }

    @Override
    public ResourceLocation getAnimationResource(LaserProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/laser.animation.json");
    }

}