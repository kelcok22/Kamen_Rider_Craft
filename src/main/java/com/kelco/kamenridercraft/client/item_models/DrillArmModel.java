package com.kelco.kamenridercraft.client.item_models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.ichigo.DrillArmItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DrillArmModel extends GeoModel<DrillArmItem> {
    @Override
    public ResourceLocation getModelResource(DrillArmItem animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/drill_arm.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DrillArmItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/item/drill_arm.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DrillArmItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/drill_arm.animation.json");
    }

}