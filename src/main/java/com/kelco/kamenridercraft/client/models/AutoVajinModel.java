package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.AutoVajinRoboEntity;
import com.kelco.kamenridercraft.entities.bikes.AutoVajinEntity;
import com.kelco.kamenridercraft.entities.summons.ApolloEntity;
import com.kelco.kamenridercraft.entities.summons.LibraEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class AutoVajinModel extends GeoModel<AutoVajinRoboEntity> {
    @Override
    public ResourceLocation getModelResource(AutoVajinRoboEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/auto_vajin_robo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AutoVajinRoboEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/auto_vajin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AutoVajinRoboEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/auto_vajin.animation.json");
    }

    @Override
    public void setCustomAnimations(AutoVajinRoboEntity an, long instanceId, AnimationState<AutoVajinRoboEntity> state) {

    }

}