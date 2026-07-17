package com.kelco.kamenridercraft.client.models.base_models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.base_entities.BaseProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BaseProjectileModel extends GeoModel<BaseProjectileEntity> {
    @Override
    public ResourceLocation getModelResource(BaseProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/projectiles/laser.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BaseProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/projectiles/red_laser.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BaseProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/projectile.animation.json");
    }

}