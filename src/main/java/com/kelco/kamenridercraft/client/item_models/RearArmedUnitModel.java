package com.kelco.kamenridercraft.client.item_models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.GeoBlasterItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RearArmedUnitModel extends GeoModel<GeoBlasterItem> {
    @Override
    public ResourceLocation getModelResource(GeoBlasterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/item/rear_armed_unit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeoBlasterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/item/rear_armed_unit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeoBlasterItem animatable) {
        return null;
    }
}