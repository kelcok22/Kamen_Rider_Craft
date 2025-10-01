package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.bosses.TabooDopantEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TabooModel extends GeoModel<TabooDopantEntity> {
    @Override
    public ResourceLocation getModelResource(TabooDopantEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/taboo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TabooDopantEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taboo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TabooDopantEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/taboo.animation.json");
    }

}