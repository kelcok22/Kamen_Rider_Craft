package com.kelco.kamenridercraft.client.model.entity.allies;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.BurgermealEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.PotechokinEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PotechokinModel extends GeoModel<PotechokinEntity> {
    @Override
    public ResourceLocation getModelResource(PotechokinEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/potechokin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PotechokinEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/potechokin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PotechokinEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/potechokin.animation.json");
    }
}