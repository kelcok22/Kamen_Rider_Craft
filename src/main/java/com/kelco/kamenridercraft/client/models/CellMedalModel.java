package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.projectile.CellMedalProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CellMedalModel extends GeoModel<CellMedalProjectileEntity> {
    public String textureChoice;
    @Override
    public ResourceLocation getModelResource(CellMedalProjectileEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/cell_medal.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CellMedalProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/cell_medal.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CellMedalProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/cell_medal.animation.json");
    }

}