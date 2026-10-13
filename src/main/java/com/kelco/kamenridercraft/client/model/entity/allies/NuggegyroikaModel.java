package com.kelco.kamenridercraft.client.model.entity.allies;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.NuggegyroikaEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.SoftonyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NuggegyroikaModel extends GeoModel<NuggegyroikaEntity> {
    @Override
    public ResourceLocation getModelResource(NuggegyroikaEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/entity/nuggegyroika.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NuggegyroikaEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/nuggegyroika.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NuggegyroikaEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/nuggegyroika.animation.json");
    }
}