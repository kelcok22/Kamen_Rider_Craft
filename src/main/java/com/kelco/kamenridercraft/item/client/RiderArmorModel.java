package com.kelco.kamenridercraft.item.client;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import com.kelco.kamenridercraft.world.attributeGenerator;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class RiderArmorModel extends GeoModel<RiderArmorItem> {


    public RiderArmorModel() {
    }

    @Override
    public ResourceLocation getModelResource(RiderArmorItem animatable, @Nullable GeoRenderer<RiderArmorItem> renderer) {
        if (renderer instanceof RiderArmorRenderer riderRenderer) {
            LivingEntity RIDER = riderRenderer.GetEntity();
            EquipmentSlot slot= riderRenderer.getCurrentSlot();
            if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem BELT) {
                if (slot == EquipmentSlot.FEET)
                    return BELT.getBeltModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET), animatable, slot, RIDER);
                else return BELT.getModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET), animatable, slot, RIDER);
            }
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default.geo.json");
    }

    @Override
    public ResourceLocation getModelResource(RiderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/default.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RiderArmorItem animatable, @Nullable GeoRenderer<RiderArmorItem> renderer) {
        if (renderer instanceof RiderArmorRenderer riderRenderer) {
            LivingEntity RIDER = riderRenderer.GetEntity();
            EquipmentSlot slot = riderRenderer.getCurrentSlot();
            ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET);
            if (BELT.getItem() instanceof RiderDriverItem DRIVER && (slot == EquipmentSlot.FEET || DRIVER.isTransformed(RIDER))) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + DRIVER.GET_TEXT(BELT, slot, RIDER, DRIVER.Rider) + ".png");
            }
        }
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png");
    }

    @Override
    public ResourceLocation getTextureResource(RiderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png");
    }


    @Override
    public ResourceLocation getAnimationResource(RiderArmorItem animatable) {
        return  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/default_rider.animation.json");
    }

    @Override
    public void setCustomAnimations(RiderArmorItem an, long instanceId, AnimationState<RiderArmorItem> state) {


        Entity entity = state.getData(DataTickets.ENTITY);
if (entity instanceof LivingEntity RIDER) {
    GeoBone front_fork = this.getAnimationProcessor().getBone("front_fork");
    GeoBone front_fork2 = this.getAnimationProcessor().getBone("front_fork2");
    GeoBone b_wheel = this.getAnimationProcessor().getBone("b_wheel");
    GeoBone f_wheel = this.getAnimationProcessor().getBone("f_wheel");
    GeoBone f_wheel2 = this.getAnimationProcessor().getBone("f_wheel2");
    GeoBone poop_ball_vice = this.getAnimationProcessor().getBone("poop_ball_vice");
    GeoBone cape = this.getAnimationProcessor().getBone("cape");

    GeoBone tire = this.getAnimationProcessor().getBone("tire");
    GeoBone tire2 = this.getAnimationProcessor().getBone("tire2");
    GeoBone tire3 = this.getAnimationProcessor().getBone("tire3");

    GeoBone bipedHead = this.getAnimationProcessor().getBone("bipedHead");
    if (bipedHead != null) {
        bipedHead.setScaleX((float) RIDER.getAttribute(attributeGenerator.HEAD_SIZE).getValue());
        bipedHead.setScaleY((float) RIDER.getAttribute(attributeGenerator.HEAD_SIZE).getValue());
        bipedHead.setScaleZ((float) RIDER.getAttribute(attributeGenerator.HEAD_SIZE).getValue());
    }

    if (cape != null & RiderArmorItem.GetCapeRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)) < 0)
        cape.setRotX(RiderArmorItem.GetCapeRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
    if (cape != null & RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)) != 0)
        cape.setRotY(RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

    if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
        belt.setCustomAnimations(an, instanceId, state);

        GeoBone wizard_circle = this.getAnimationProcessor().getBone("wizard_circle");
        if (wizard_circle != null) {
            if (RiderDriverItem.isTransforming(RIDER)) {
                    wizard_circle.setScaleX(1.1f);
                    wizard_circle.setScaleY(1.1f);
                    wizard_circle.setScaleZ(1.1f);

                wizard_circle.setPosX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET))-10);
                wizard_circle.setHidden(false);
            }else {
                wizard_circle.setHidden(true);
                wizard_circle.setPosX(0);
            }
        }
        GeoBone wizard_circle2 = this.getAnimationProcessor().getBone("wizard_circle2");
        if (wizard_circle2 != null) {
            if (RiderDriverItem.isTransforming(RIDER)) {
                wizard_circle2.setScaleX(1.1f);
                wizard_circle2.setScaleY(1.1f);
                wizard_circle2.setScaleZ(1.1f);

                wizard_circle2.setPosX(30-RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                wizard_circle2.setHidden(false);
            }else {
                wizard_circle2.setHidden(true);
                wizard_circle2.setPosX(0);
            }
        }
        GeoBone wizard_circle3 = this.getAnimationProcessor().getBone("wizard_circle3");
        if (wizard_circle3 != null) {
            if (RiderDriverItem.isTransforming(RIDER)) {
                wizard_circle3.setScaleX(1.1f);
                wizard_circle3.setScaleY(1.1f);
                wizard_circle3.setScaleZ(1.1f);

                wizard_circle3.setPosY(35-RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                wizard_circle3.setHidden(false);
            }else {
                wizard_circle3.setHidden(true);
                wizard_circle3.setPosY(0);
            }
        }
        GeoBone wizard_circle4 = this.getAnimationProcessor().getBone("wizard_circle4");
        if (wizard_circle4 != null) {
            if (RiderDriverItem.isTransforming(RIDER)) {
                wizard_circle4.setScaleX(1.1f);
                wizard_circle4.setScaleY(1.1f);
                wizard_circle4.setScaleZ(1.1f);

                wizard_circle4.setPosY(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                wizard_circle4.setHidden(false);
            }else {
                wizard_circle4.setHidden(true);
                wizard_circle4.setPosY(0);
            }
        }
        if (tire != null) {
            if (RiderDriverItem.isTransforming(RIDER))
                tire.setRotX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            if (RiderDriverItem.isTransforming(RIDER))
                tire.setPosX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)) / 2);
            if (RiderDriverItem.isTransforming(RIDER))
                tire.setPosY(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)) / 2);
            if (RiderDriverItem.isTransforming(RIDER))
                tire.setPosZ(-RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));

            //tire.setHidden(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)) == 0);
        }
        if (tire2 != null) {
            if (RiderDriverItem.isTransforming(RIDER))
                tire2.setRotX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            if (RiderDriverItem.isTransforming(RIDER))
                tire2.setPosX(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)) / 2);
            if (RiderDriverItem.isTransforming(RIDER))
                tire2.setPosY(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)) / 2);
            if (RiderDriverItem.isTransforming(RIDER))
                tire2.setPosZ(-RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        }
        if (tire3 != null) {
            if (RiderDriverItem.get_Form_Item(RIDER.getItemBySlot(EquipmentSlot.FEET), 1) != Drive_Rider_Items.SHIFT_PROTO_SPEED_CHASER.asItem()) {
                if (RiderDriverItem.isTransforming(RIDER))
                    tire3.setRotZ(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                if (RiderDriverItem.isTransforming(RIDER))
                    tire3.setPosX(RiderDriverItem.GetTransforming((RIDER.getItemBySlot(EquipmentSlot.FEET))) / 2);
                if (RiderDriverItem.isTransforming(RIDER))
                    tire3.setPosY(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)) / 2);
                if (RiderDriverItem.isTransforming(RIDER))
                    tire3.setPosZ(RiderDriverItem.GetTransforming(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            } else {
                tire3.setRotZ(state.getPartialTick());
            }
        }
    }

    if (front_fork != null) front_fork.setRotY(RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
    if (front_fork2 != null)
        front_fork2.setRotY(RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

    if (f_wheel != null) f_wheel.setRotX(RiderArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
    if (f_wheel2 != null) f_wheel2.setRotX(RiderArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
    if (b_wheel != null) b_wheel.setRotX(RiderArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
    if (poop_ball_vice != null) {
        poop_ball_vice.setRotX(RiderArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        poop_ball_vice.setRotZ(RiderArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
    }
}
    }
}