package com.kelco.kamenridercraft.item.client;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class RiderArmorModel extends GeoModel<RiderArmorItem> {

    private static LivingEntity RIDER;
    private final EquipmentSlot slot;

    public RiderArmorModel(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

        RIDER =  livingEntity;
        slot =  equipmentSlot;
    }

    @Override
    public ResourceLocation getModelResource(RiderArmorItem animatable) {
        if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem BELT) {
            if (slot== EquipmentSlot.FEET) return BELT.getBeltModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);
            else return BELT.getModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RiderArmorItem animatable) {
        ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET);
        if (BELT.getItem() instanceof RiderDriverItem DRIVER && (slot == EquipmentSlot.FEET || DRIVER.isTransformed(RIDER))) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/"+DRIVER.GET_TEXT(BELT,slot,RIDER,DRIVER.Rider)+".png");
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png");
    }


    @Override
    public ResourceLocation getAnimationResource(RiderArmorItem animatable) {
        if (slot== EquipmentSlot.FEET) {
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/riderbelt.animation.json");
        } else if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem BELT) {
            return BELT.getAnimationResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot);
        }
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/ichigo.animation.json");
    }

    @Override
    public void setCustomAnimations(RiderArmorItem an, long instanceId, AnimationState<RiderArmorItem> state) {

        GeoBone front_fork = this.getAnimationProcessor().getBone("front_fork");
        GeoBone front_fork2 = this.getAnimationProcessor().getBone("front_fork2");
        GeoBone b_wheel= this.getAnimationProcessor().getBone("b_wheel");
        GeoBone f_wheel = this.getAnimationProcessor().getBone("f_wheel");
        GeoBone f_wheel2 = this.getAnimationProcessor().getBone("f_wheel2");
        GeoBone poop_ball_vice = this.getAnimationProcessor().getBone("poop_ball_vice");
        GeoBone cape = this.getAnimationProcessor().getBone("cape");

        GeoBone tire = this.getAnimationProcessor().getBone("tire");
        GeoBone tire2 = this.getAnimationProcessor().getBone("tire2");
        GeoBone tire3 = this.getAnimationProcessor().getBone("tire3");

        if (cape!= null&RiderArmorItem.GetCapeRotation(RIDER.getItemBySlot(EquipmentSlot.FEET))<0) cape.setRotX(RiderArmorItem.GetCapeRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (cape!= null&RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET))!=0) cape.setRotY(RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

        if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt){
            belt.setCustomAnimations(an,instanceId,state);

            if (tire != null){
                if(RiderDriverItem.isTransforming(RIDER))tire.setRotX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                if(RiderDriverItem.isTransforming(RIDER))tire.setPosX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET))/2);
                if(RiderDriverItem.isTransforming(RIDER))tire.setPosY(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET))/2);
                if(RiderDriverItem.isTransforming(RIDER))tire.setPosZ(-RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));

                //tire.setHidden(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)) == 0);
            }
            if (tire2 != null){
                if(RiderDriverItem.isTransforming(RIDER))tire2.setRotX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                if(RiderDriverItem.isTransforming(RIDER))tire2.setPosX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET))/2);
                if(RiderDriverItem.isTransforming(RIDER))tire2.setPosY(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET))/2);
                if(RiderDriverItem.isTransforming(RIDER))tire2.setPosZ(-RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            }
            if (tire3 != null){
                if (RiderDriverItem.get_Form_Item(RIDER.getItemBySlot(EquipmentSlot.FEET),1)!= Drive_Rider_Items.SHIFT_PROTO_SPEED_CHASER.asItem()){
                    if(RiderDriverItem.isTransforming(RIDER))tire3.setRotZ(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                    if(RiderDriverItem.isTransforming(RIDER))tire3.setPosX(RiderDriverItem.GetTransforming((RIDER.getItemBySlot(EquipmentSlot.FEET)))/2);
                    if(RiderDriverItem.isTransforming(RIDER))tire3.setPosY(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET))/2);
                    if(RiderDriverItem.isTransforming(RIDER))tire3.setPosZ(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                }else {
                    tire3.setRotZ(state.getPartialTick());
                }
            }
        }

        if (front_fork != null) front_fork.setRotY(RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (front_fork2 != null) front_fork2.setRotY(RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

        if (f_wheel != null) f_wheel.setRotX(RiderArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (f_wheel2 != null) f_wheel2.setRotX(RiderArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (b_wheel != null) b_wheel.setRotX(RiderArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (poop_ball_vice != null){
            poop_ball_vice.setRotX(RiderArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            poop_ball_vice.setRotZ(RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        }
    }
}