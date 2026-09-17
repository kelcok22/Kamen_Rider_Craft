package com.kelco.kamenridercraft.client.model.base_model;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.base_entities.BaseEffectEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BaseEffectModel extends GeoModel<BaseEffectEntity> {
    @Override
    public ResourceLocation getModelResource(BaseEffectEntity animatable) {
        if (animatable.getModel().isEmpty()) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default.geo.json");
        } else {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/effects/" + animatable.getModel());
        }
    }

    @Override
    public ResourceLocation getTextureResource(BaseEffectEntity animatable) {
        if (animatable.getTexture().isEmpty()) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/shocker_combatman.png");
        } else {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/" + animatable.getTexture());
        }
    }

    @Override
    public ResourceLocation getAnimationResource(BaseEffectEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/effects.animation.json");
    }
}