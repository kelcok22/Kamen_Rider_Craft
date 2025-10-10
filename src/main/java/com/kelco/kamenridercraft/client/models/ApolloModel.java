package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.summons.ApolloEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ApolloModel extends GeoModel<ApolloEntity> {
    @Override
    public ResourceLocation getModelResource(ApolloEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/catboy_double_robot_dude.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ApolloEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/apollo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ApolloEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/catboy_double_robot_dude.animation.json");
    }

}