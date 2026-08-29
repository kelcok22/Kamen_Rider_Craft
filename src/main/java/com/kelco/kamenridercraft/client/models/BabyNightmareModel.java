
package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BabyNightmareEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class BabyNightmareModel extends GeoModel<BabyNightmareEntity> {
    @Override
    public ResourceLocation getModelResource(BabyNightmareEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/baby_nightmare.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BabyNightmareEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/baby_nightmare.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BabyNightmareEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/auto_vajin.animation.json");
    }

    @Override
    public void setCustomAnimations(BabyNightmareEntity an, long instanceId, AnimationState<BabyNightmareEntity> state) {

    }

}