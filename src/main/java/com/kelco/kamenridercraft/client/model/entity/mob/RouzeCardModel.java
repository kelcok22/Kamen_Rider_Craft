package com.kelco.kamenridercraft.client.model.entity.mob;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.projectiles.RouzeCardEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RouzeCardModel extends GeoModel<RouzeCardEntity> {
    @Override
    public ResourceLocation getModelResource(RouzeCardEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/projectiles/card.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RouzeCardEntity animatable) {
        if (animatable.getTexture().isEmpty()) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/projectiles/blank_rouze.png");
        } else {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/projectiles/" + animatable.getTexture() + ".png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(RouzeCardEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/projectile.animation.json");
    }
}