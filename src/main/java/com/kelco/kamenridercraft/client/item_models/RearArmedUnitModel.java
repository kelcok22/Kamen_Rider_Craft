package com.kelco.kamenridercraft.client.item_models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid.RearArmedUnitItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RearArmedUnitModel extends GeoModel<RearArmedUnitItem> {
    @Override
    public ResourceLocation getModelResource(RearArmedUnitItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/item/rear_armed_unit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RearArmedUnitItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/item/rear_armed_unit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RearArmedUnitItem animatable) {
        return null;
    }
}