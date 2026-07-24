package com.kelco.kamenridercraft.client.item_models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid.FrontArmedUnitItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FrontArmedUnitModel extends GeoModel<FrontArmedUnitItem> {
    @Override
    public ResourceLocation getModelResource(FrontArmedUnitItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/item/front_armed_unit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrontArmedUnitItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/item/front_armed_unit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FrontArmedUnitItem animatable) {
        return null;
    }
}