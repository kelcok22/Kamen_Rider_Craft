package com.kelco.kamenridercraft.client.model.entity.allies;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.HulashakeEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.PotechokinEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HulashakeModel extends GeoModel<HulashakeEntity> {
    @Override
    public ResourceLocation getModelResource(HulashakeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/hulashake.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HulashakeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/hulashake.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HulashakeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/hulashake.animation.json");
    }
}