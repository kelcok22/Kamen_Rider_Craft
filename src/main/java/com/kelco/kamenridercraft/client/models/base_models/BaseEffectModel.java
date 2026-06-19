package com.kelco.kamenridercraft.client.models.base_models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.base_renderers.BaseEffectRenderer;
import com.kelco.kamenridercraft.entity.base_entities.BaseEffectEntity;
import com.kelco.kamenridercraft.entity.base_entities.BaseProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import javax.annotation.Nullable;

import static software.bernie.geckolib.cache.texture.GeoAbstractTexture.appendToPath;

public class BaseEffectModel extends GeoModel<BaseEffectEntity> {
    @Override
    public ResourceLocation getModelResource(BaseEffectEntity animatable) {
        if (animatable.getModel().isEmpty()) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default.geo.json");
        } else {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/" + animatable.getModel());
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