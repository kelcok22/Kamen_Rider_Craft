package com.kelco.kamenridercraft.client.model.entity.allies;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.HoruwankovEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.SoftonyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SoftonyaModel extends GeoModel<SoftonyaEntity> {
    @Override
    public ResourceLocation getModelResource(SoftonyaEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/softonya.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SoftonyaEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/softonya.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SoftonyaEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/softonya.animation.json");
    }
}