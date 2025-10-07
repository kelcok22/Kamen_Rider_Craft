package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.KodamaSuikaArmsEntity;
import com.kelco.kamenridercraft.entities.allies.ToraCanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KodamaSuikaArmsModel extends GeoModel<KodamaSuikaArmsEntity> {
    @Override
    public ResourceLocation getModelResource(KodamaSuikaArmsEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/kodama_suika_arms.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KodamaSuikaArmsEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/kodama_suika_arms.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KodamaSuikaArmsEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/kodama_suika_arms.animation.json");
    }

}