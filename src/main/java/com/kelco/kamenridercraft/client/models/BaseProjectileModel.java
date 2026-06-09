package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.projectiles.BaseProjectileEntity;
import com.kelco.kamenridercraft.entity.projectiles.CellMedalProjectileEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BaseProjectileModel extends GeoModel<BaseProjectileEntity> {
    @Override
    public ResourceLocation getModelResource(BaseProjectileEntity animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/cell_medal.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BaseProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/projectiles/cell_medal.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BaseProjectileEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/cell_medal.animation.json");
    }

}