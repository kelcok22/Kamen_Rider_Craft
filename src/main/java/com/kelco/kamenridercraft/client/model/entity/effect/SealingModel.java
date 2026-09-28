package com.kelco.kamenridercraft.client.model.entity.effect;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.effect.SealingEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SealingModel extends GeoModel<SealingEntity> {
    @Override
    public ResourceLocation getModelResource(SealingEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/effects/empty.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SealingEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/projectiles/blank_rouze.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SealingEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/projectile.animation.json");
    }
}