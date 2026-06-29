package com.kelco.kamenridercraft.client.models;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.RiderArmorRenderer;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;

import com.kelco.kamenridercraft.item.heisei_phase_1.KivaRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.DriveRiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
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

import static com.kelco.kamenridercraft.world.attribute.Attributes.CHANGE_KICK_MODEL;
import static com.kelco.kamenridercraft.world.attribute.Attributes.WINGS_OUT;

public class RiderArmorModel extends GeoModel<RiderArmorItem> {


    public RiderArmorModel() {
    }

    @Override
    public ResourceLocation getModelResource(RiderArmorItem animatable, @Nullable GeoRenderer<RiderArmorItem> renderer) {
        if (renderer instanceof RiderArmorRenderer riderRenderer) {
            LivingEntity RIDER = riderRenderer.GetEntity();
            EquipmentSlot slot = riderRenderer.getCurrentSlot();
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
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + DRIVER.getText(BELT, slot, RIDER, DRIVER.Rider) + ".png");
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
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animations/default_rider.animation.json");
    }

    @Override
    public void setCustomAnimations(RiderArmorItem an, long instanceId, AnimationState<RiderArmorItem> state) {


        Entity entity = state.getData(DataTickets.ENTITY);

        if (entity instanceof LivingEntity RIDER) {

            double GetTransforming = RIDER.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue();

            double GetBallOld = RIDER.getAttribute(Attributes.BALL_ROT_OLD).getBaseValue();
            double GetBall = RIDER.getAttribute(Attributes.BALL_ROT).getBaseValue();
            double GetWheelOld = RIDER.getAttribute(Attributes.WHEEL_ROT_OLD).getBaseValue();
            double GetWheel = RIDER.getAttribute(Attributes.WHEEL_ROT).getBaseValue();
            double GetCapeOld = RIDER.getAttribute(Attributes.CAPE_ROT_OLD).getBaseValue();
            double GetCape = RIDER.getAttribute(Attributes.CAPE_ROT).getBaseValue();

            Float Transforming = (float) Mth.lerp(1, GetTransforming, (GetTransforming - 1) - state.getPartialTick());
            Float wheel = (float) Mth.lerp(state.getPartialTick(), GetWheelOld, GetWheel);
            Float ball = (float) Mth.lerp(state.getPartialTick(), GetBallOld, GetBall);
            Float Cape = (float) Mth.lerp(state.getPartialTick(), GetCapeOld, GetCape);

            GeoBone front_fork = this.getAnimationProcessor().getBone("front_fork");
            GeoBone front_fork2 = this.getAnimationProcessor().getBone("front_fork2");
            GeoBone b_wheel = this.getAnimationProcessor().getBone("b_wheel");
            GeoBone f_wheel = this.getAnimationProcessor().getBone("f_wheel");
            GeoBone f_wheel2 = this.getAnimationProcessor().getBone("f_wheel2");
            GeoBone poop_ball_vice = this.getAnimationProcessor().getBone("poop_ball_vice");
            GeoBone cape = this.getAnimationProcessor().getBone("cape");
            GeoBone cape2 = this.getAnimationProcessor().getBone("cape2");

            GeoBone tire = this.getAnimationProcessor().getBone("tire");
            GeoBone tire2 = this.getAnimationProcessor().getBone("tire2");
            GeoBone tire3 = this.getAnimationProcessor().getBone("tire3");

            GeoBone bipedHead = this.getAnimationProcessor().getBone("armorHead");
            if (bipedHead != null) {
                bipedHead.setScaleX((float) RIDER.getAttribute(Attributes.HEAD_SIZE).getValue());
                bipedHead.setScaleY((float) RIDER.getAttribute(Attributes.HEAD_SIZE).getValue());
                bipedHead.setScaleZ((float) RIDER.getAttribute(Attributes.HEAD_SIZE).getValue());
            }

            if (cape != null & Cape < 0) cape.setRotX(Cape);
            if (cape != null & ball != 0) cape.setRotY(ball);

            if (cape2 != null & Cape < 0) cape2.setRotX(Cape);
            if (cape2 != null & ball != 0) cape2.setRotY(ball);

            if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                belt.setCustomAnimations(an, instanceId, state);

                GeoBone parkaGhost = this.getAnimationProcessor().getBone("parkaGhost");
                if (parkaGhost != null) {
                    if (RiderDriverItem.isTransforming(RIDER)) {
                        float X =-Transforming-1;
                            if (Transforming>20) {
                                X = X -((Transforming-20)-1);
                            }
                        parkaGhost.setPosX(X);
                        if (Transforming>5) {
                            float Y = (10-(Transforming-10)/2);
                            parkaGhost.setPosY(Y);
                        }else parkaGhost.setPosY((Transforming+1)*2);


                        if (Transforming>20) {
                            float size = 1-((Transforming-20)/10);
                            parkaGhost.setScaleX(size);
                            parkaGhost.setScaleY(size);
                            parkaGhost.setScaleZ(size);
                        }else {
                            parkaGhost.setScaleX(1f);
                            parkaGhost.setScaleY(1f);
                            parkaGhost.setScaleZ(1f);
                        }
                        parkaGhost.setRotY((-Transforming-1) / 6);
                        parkaGhost.setRotX((-Transforming-1) / 15);

                    } else {
                        parkaGhost.setRotX(0);
                        parkaGhost.setRotY(0);
                        parkaGhost.setScaleX(1f);
                        parkaGhost.setScaleY(1f);
                        parkaGhost.setScaleZ(1f);
                        parkaGhost.setPosZ(0);
                        parkaGhost.setPosX(0);
                        parkaGhost.setPosY(0);
                    }
                }


                GeoBone wizard_circle = this.getAnimationProcessor().getBone("wizard_circle");
                if (wizard_circle != null) {
                    if (RiderDriverItem.isTransforming(RIDER)) {
                        wizard_circle.setScaleX(1.1f);
                        wizard_circle.setScaleY(1.1f);
                        wizard_circle.setScaleZ(1.1f);

                        wizard_circle.setPosX(Transforming - 10);
                        wizard_circle.setHidden(false);
                    } else {
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

                        wizard_circle2.setPosX(30 - Transforming);
                        wizard_circle2.setHidden(false);
                    } else {
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

                        wizard_circle3.setPosY(35 - Transforming);
                        wizard_circle3.setHidden(false);
                    } else {
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

                        wizard_circle4.setPosY(Transforming);
                        wizard_circle4.setHidden(false);
                    } else {
                        wizard_circle4.setHidden(true);
                        wizard_circle4.setPosY(0);
                    }
                }
                GeoBone wizard_circle5 = this.getAnimationProcessor().getBone("wizard_circle5");
                if (wizard_circle5 != null) {
                    if (RiderDriverItem.isTransforming(RIDER)) {
                        wizard_circle5.setScaleX(1.1f);
                        wizard_circle5.setScaleY(1.1f);
                        wizard_circle5.setScaleZ(1.1f);
                        wizard_circle5.setPosX(2.5f);
                        wizard_circle5.setPosZ(30 - Transforming);
                        wizard_circle5.setHidden(false);
                    } else {
                        wizard_circle5.setHidden(true);
                        wizard_circle5.setPosZ(0);
                    }
                }

                GeoBone wizard_circle6 = this.getAnimationProcessor().getBone("wizard_circle6");
                if (wizard_circle6 != null) {
                    if (RiderDriverItem.isTransforming(RIDER)) {
                        wizard_circle6.setScaleX(1.1f);
                        wizard_circle6.setScaleY(1.1f);
                        wizard_circle6.setScaleZ(1.1f);
                        wizard_circle6.setPosZ(Transforming);
                        wizard_circle6.setHidden(false);
                    } else {
                        wizard_circle6.setHidden(true);
                        wizard_circle6.setPosY(0);
                    }
                }

                GeoBone wizard_circle7 = this.getAnimationProcessor().getBone("wizard_circle7");
                if (wizard_circle7 != null) {
                    if (RiderDriverItem.isTransforming(RIDER)) {
                        wizard_circle7.setScaleX(1.1f);
                        wizard_circle7.setScaleY(1.1f);
                        wizard_circle7.setScaleZ(1.1f);
                        wizard_circle7.setPosZ(25 - Transforming);
                        wizard_circle7.setRotY(-Transforming / 3);
                        wizard_circle7.setHidden(false);
                    } else {
                        wizard_circle7.setHidden(true);
                        wizard_circle7.setPosZ(0);
                    }
                }

                GeoBone wizard_circle8 = this.getAnimationProcessor().getBone("wizard_circle8");
                if (wizard_circle8 != null) {
                    if (RiderDriverItem.isTransforming(RIDER)) {
                        wizard_circle8.setScaleX(1.1f);
                        wizard_circle8.setScaleY(1.1f);
                        wizard_circle8.setScaleZ(1.1f);
                        wizard_circle8.setRotX(Transforming / 2);
                        wizard_circle8.setPosY(Transforming);
                        wizard_circle8.setHidden(false);
                    } else {
                        wizard_circle8.setHidden(true);
                        wizard_circle8.setPosY(0);
                    }
                }

                GeoBone headKick = this.getAnimationProcessor().getBone("headKick");
                GeoBone headKickRemove = this.getAnimationProcessor().getBone("headKickRemove");
                GeoBone bodyKick = this.getAnimationProcessor().getBone("bodyKick");
                GeoBone bodyKickRemove = this.getAnimationProcessor().getBone("bodyKickRemove");
                GeoBone rightArmKick = this.getAnimationProcessor().getBone("rightArmKick");
                GeoBone rightArmKickRemove = this.getAnimationProcessor().getBone("rightArmKickRemove");
                GeoBone leftArmKick = this.getAnimationProcessor().getBone("leftArmKick");
                GeoBone leftArmKickRemove = this.getAnimationProcessor().getBone("leftArmKickRemove");
                GeoBone rightLegKick = this.getAnimationProcessor().getBone("rightLegKick");
                GeoBone rightLegKickRemove = this.getAnimationProcessor().getBone("rightLegKickRemove");
                GeoBone leftLegKick = this.getAnimationProcessor().getBone("leftLegKick");
                GeoBone leftLegKickRemove = this.getAnimationProcessor().getBone("leftLegKickRemove");

                boolean isKicking = RIDER.getAttribute(CHANGE_KICK_MODEL).getValue() == 1;
                        if (headKick != null) headKick.setHidden(!isKicking );
                        if (headKickRemove != null) headKickRemove.setHidden(isKicking);
                        if (rightArmKick != null) rightArmKick.setHidden(!isKicking);
                        if (rightArmKickRemove != null) rightArmKickRemove.setHidden(isKicking );
                        if (leftArmKick != null) leftArmKick.setHidden(!isKicking);
                        if (leftArmKickRemove != null) leftArmKickRemove.setHidden(isKicking );
                        if (leftLegKick != null) leftLegKick.setHidden(!isKicking);
                        if (leftLegKickRemove != null) leftLegKickRemove.setHidden(isKicking );
                        if (rightLegKick != null) rightLegKick.setHidden(!isKicking);
                        if (rightLegKickRemove != null) rightLegKickRemove.setHidden(isKicking );

                GeoBone joker = this.getAnimationProcessor().getBone("joker");
                if (joker != null) {
                    if (isKicking){
                        joker.setPosY(-5);
                        joker.setPosX(2);
                    }
                    else{
                        joker.setPosY(0);
                        joker.setPosX(0);
                    }
                }
                GeoBone cyclone = this.getAnimationProcessor().getBone("cyclone");
                if (joker != null) {
                    if (isKicking){
                        joker.setPosY(-5);
                        joker.setPosX(2);
                    }
                    else{
                        joker.setPosY(0);
                        joker.setPosX(0);
                    }
                }

                GeoBone WingsOut = this.getAnimationProcessor().getBone("WingsOut");
                GeoBone WingsOutRemove = this.getAnimationProcessor().getBone("WingsOutRemove");

                boolean areWingsOut = RIDER.getAttribute(WINGS_OUT).getValue() == 1;

                if (WingsOut != null) WingsOut.setHidden(!areWingsOut);
                if (WingsOutRemove != null) WingsOutRemove.setHidden(areWingsOut);



                if (tire != null) {
                    if (RiderDriverItem.isTransforming(RIDER))
                        tire.setRotX(Transforming);
                    if (RiderDriverItem.isTransforming(RIDER))
                        tire.setPosX(Transforming / 2);
                    if (RiderDriverItem.isTransforming(RIDER))
                        tire.setPosY(Transforming / 2);
                    if (RiderDriverItem.isTransforming(RIDER))
                        tire.setPosZ(-Transforming);
                }
                if (tire2 != null) {
                    if (RiderDriverItem.isTransforming(RIDER))
                        tire2.setRotX(Transforming);
                    if (RiderDriverItem.isTransforming(RIDER))
                        tire2.setPosX(Transforming / 2);
                    if (RiderDriverItem.isTransforming(RIDER))
                        tire2.setPosY(Transforming / 2);
                    if (RiderDriverItem.isTransforming(RIDER))
                        tire2.setPosZ(-Transforming);
                }
                if (tire3 != null) {
                    if (RiderDriverItem.getFormItem(RIDER.getItemBySlot(EquipmentSlot.FEET), 1) != DriveRiderItems.SHIFT_PROTO_SPEED_CHASER.asItem()) {
                        if (RiderDriverItem.isTransforming(RIDER))
                            tire3.setRotZ(Transforming);
                        if (RiderDriverItem.isTransforming(RIDER))
                            tire3.setPosX(Transforming / 2);
                        if (RiderDriverItem.isTransforming(RIDER))
                            tire3.setPosY(Transforming / 2);
                        if (RiderDriverItem.isTransforming(RIDER))
                            tire3.setPosZ(Transforming);
                    } else {
                        tire3.setRotZ(state.getPartialTick());
                    }
                }
            }

            if (front_fork != null) front_fork.setRotY(ball);
            if (front_fork2 != null)
                front_fork2.setRotY(ball);

            if (f_wheel != null) f_wheel.setRotX(wheel);
            if (f_wheel2 != null) f_wheel2.setRotX(wheel);
            if (b_wheel != null) b_wheel.setRotX(wheel);
            if (poop_ball_vice != null) {
                poop_ball_vice.setRotX(wheel);
                poop_ball_vice.setRotZ(ball);
            }
        }
    }
}