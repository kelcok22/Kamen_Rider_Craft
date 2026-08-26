package com.kelco.kamenridercraft.client.block_models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.blockentity.MindDoorBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MindDoorModel extends GeoModel<MindDoorBlockEntity> {
    @Override
    public ResourceLocation getModelResource(MindDoorBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/block/mind_door.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MindDoorBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/block/mind_door.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MindDoorBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/door.animation.json");
    }

}