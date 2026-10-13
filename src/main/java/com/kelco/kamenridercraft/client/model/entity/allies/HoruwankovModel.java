package com.kelco.kamenridercraft.client.model.entity.allies;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.HoruwankovEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.HulashakeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HoruwankovModel extends GeoModel<HoruwankovEntity> {
    @Override
    public ResourceLocation getModelResource(HoruwankovEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/horuwankov.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HoruwankovEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/horuwankov.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HoruwankovEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/horuwankov.animation.json");
    }
}