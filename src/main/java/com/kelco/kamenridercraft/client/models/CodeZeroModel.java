package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.AutoVajinRoboEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.CodeZeroEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class CodeZeroModel extends GeoModel<CodeZeroEntity> {
    @Override
    public ResourceLocation getModelResource(CodeZeroEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/zero.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CodeZeroEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/zero.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CodeZeroEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/auto_vajin.animation.json");
    }

    @Override
    public void setCustomAnimations(CodeZeroEntity an, long instanceId, AnimationState<CodeZeroEntity> state) {

    }

}