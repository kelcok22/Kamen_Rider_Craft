package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.bikes.HardboilderEntity;
import com.kelco.kamenridercraft.entities.bikes.baseBikeEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BikeModel extends GeoModel<baseBikeEntity> {
    private long lastRenderedInstance = -1L;

    @Override
    public ResourceLocation getModelResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/"+animatable.NAME_MODEL+".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/"+animatable.NAME+".png");
    }

    @Override
    public ResourceLocation getAnimationResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/hardboilder.animation.json");
    }


    @Override
    public void setCustomAnimations(baseBikeEntity an, long instanceId, AnimationState<baseBikeEntity> state) {


        GeoBone front_fork = this.getAnimationProcessor().getBone("front_fork");
        GeoBone b_wheel= this.getAnimationProcessor().getBone("b_wheel");
        GeoBone f_wheel = this.getAnimationProcessor().getBone("f_wheel");
        EntityModelData entityData = (EntityModelData) state.getData(DataTickets.ENTITY_MODEL_DATA);
        baseBikeEntity entityData2 = (baseBikeEntity) state.getData(DataTickets.ENTITY);


        baseBikeEntity  animatable= state.getAnimatable();
        if (front_fork != null) {
            front_fork.setRotY(entityData.headPitch());
        }
        if (b_wheel != null & f_wheel != null) {
            if (entityData.isSitting()) {

               // f_wheel.setRotX(entityData2.yHeadRot);
               // b_wheel.setRotX(entityData2.yHeadRot);
            }
        }
    }
}