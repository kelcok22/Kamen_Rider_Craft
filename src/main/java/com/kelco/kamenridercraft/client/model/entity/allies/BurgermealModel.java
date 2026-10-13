package com.kelco.kamenridercraft.client.model.entity.allies;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.BattaCanEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.BurgermealEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BurgermealModel extends GeoModel<BurgermealEntity> {
    @Override
    public ResourceLocation getModelResource(BurgermealEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/burgermeal.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BurgermealEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/burgermeal.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BurgermealEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/burgermeal.animation.json");
    }
}