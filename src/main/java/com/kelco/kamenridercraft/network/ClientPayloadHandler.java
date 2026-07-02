package com.kelco.kamenridercraft.network;

import com.kelco.kamenridercraft.entity.mobs.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.LegendarySummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.network.payload.*;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.zigythebird.playeranim.animation.PlayerAnimResources;
import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationAccess;
import com.zigythebird.playeranimcore.animation.Animation;
import com.zigythebird.playeranimcore.animation.layered.modifier.AbstractFadeModifier;
import com.zigythebird.playeranimcore.easing.EasingType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.UUID;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static com.kelco.kamenridercraft.client.KamenRiderCraftClient.*;
import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.getFormItem;
import static com.kelco.kamenridercraft.util.AnimationUtil.*;
import static com.zigythebird.playeranim.PlayerAnimLibMod.ANIMATION_LAYER_ID;

@Mod(value = MOD_ID, dist = Dist.CLIENT)
public class ClientPayloadHandler {

    // Decade Complete summon swing mimicry
    public static void handleCompleteSwing(final CompleteSwingPayload data, final IPayloadContext context) {
        Player player = context.player();
        int hand = data.hand();
        for (CompleteSummonEntity complete : player.level().getEntitiesOfClass(CompleteSummonEntity.class, player.getBoundingBox().inflate(10),
                entity -> (entity.getOwner() == player))) {
            complete.mimicSwing(player, hand == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
        for (LegendarySummonEntity legend : player.level().getEntitiesOfClass(LegendarySummonEntity.class, player.getBoundingBox().inflate(10),
                entity -> (entity.getOwner() == player && entity.getTarget() == null))) {
            legend.mimicSwing(player, hand == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
    }

    public static void handleAttributeClientChange(final AttributeChangeClientPayload data, final IPayloadContext context) {
        if (context.player().level().getPlayerByUUID(UUID.fromString(data.id())) instanceof LivingEntity entity) {
            if (!context.player().getStringUUID().equals(data.id())) {
                switch (data.attributeName()) {
                    case "ball_rot" -> {
                        entity.getAttribute(Attributes.BALL_ROT_OLD).setBaseValue(entity.getAttribute(Attributes.BALL_ROT).getBaseValue());
                        entity.getAttribute(Attributes.BALL_ROT).setBaseValue(data.valueChange());
                    }
                    case "wheel_rot" -> {
                        entity.getAttribute(Attributes.WHEEL_ROT_OLD).setBaseValue(entity.getAttribute(Attributes.WHEEL_ROT).getBaseValue());
                        entity.getAttribute(Attributes.WHEEL_ROT).setBaseValue(data.valueChange());
                    }
                    case "cape_rot" -> {
                        entity.getAttribute(Attributes.CAPE_ROT_OLD).setBaseValue(entity.getAttribute(Attributes.CAPE_ROT).getBaseValue());
                        entity.getAttribute(Attributes.CAPE_ROT).setBaseValue(data.valueChange());
                    }
                    case "wing_out" -> entity.getAttribute(Attributes.WINGS_OUT).setBaseValue(data.valueChange());
                }
            }
        }
    }

    public static void startPoseAnimations(final StartPosePayload data, final IPayloadContext context) {
        LivingEntity posingRider = context.player().level().getPlayerByUUID(UUID.fromString(data.UUID()));
        assert posingRider != null;
        Animation animation = getAnim("default.pose");
        if (data.poseName().isEmpty()) {
            if (posingRider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) {

                RiderFormChangeItem formChangeItemOne = getFormItem(posingRider.getItemBySlot(EquipmentSlot.FEET), 1);
                String formItemName = formChangeItemOne.toString().replace("kamenridercraft:", "");
                String riderName = getAnimRiderName(driverItem);

                if (getAnim(riderName + ".pose") != null) {
                    animation = getAnim(riderName + ".pose");
                }


                if (formChangeItemOne.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "animation/form_specific_pose")))) {
                    animation = getAnim(riderName + "." + formItemName + ".pose");
                }

                if (riderName.equals("ooo")) {
                    animation = oooAnimCheck(posingRider);
                } else if (riderName.equals("ghost") || riderName.equals("specter") || riderName.equals("necrom")) {
                    if(posingRider.getAttribute(Attributes.POSE_MODEL_MODIFIER).getValue() >= 1) {
                        animation = getAnim("default.hoodie_off");
                    } else {
                        animation = getAnim("default.hoodie_on");
                    }
                }

            } else if (getMaskPose(posingRider) != null) {
                animation = getMaskPose(posingRider);
            }
        } else {
            animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, data.poseName()));
        }
        try {
            AbstractClientPlayer animationTarget = (AbstractClientPlayer) Minecraft.getInstance().level.getPlayerByUUID(UUID.fromString(data.UUID()));
            PlayerAnimationController controller = (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, POSE_LAYER_ID);

            assert controller != null;
            controller.addModifierBefore(AbstractFadeModifier.standardFadeIn(8, EasingType.EASE_IN_ELASTIC));
            controller.triggerAnimation(animation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startAnim(final AnimPayload data, final IPayloadContext context) {
        LivingEntity posingRider = context.player().level().getPlayerByUUID(UUID.fromString(data.UUID()));
        if (posingRider != null) {
            Animation animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, data.move()));
            try {
                AbstractClientPlayer animationTarget = (AbstractClientPlayer) Minecraft.getInstance().level.getPlayerByUUID(UUID.fromString(data.UUID()));
                PlayerAnimationController controller = switch (data.controller()) {
                    case "attack" ->
                            (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, ATTACK_LAYER_ID);
                    case "pose" ->
                            (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, POSE_LAYER_ID);
                    case "position" ->
                            (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, RIDER_POSITIONING_ID);
                    default ->
                            (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, ANIMATION_LAYER_ID);
                };
                controller.addModifierBefore(AbstractFadeModifier.standardFadeIn(3, EasingType.EASE_IN_ELASTIC));
                controller.triggerAnimation(animation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void endAnimations(final EndAnimationPayload data, final IPayloadContext context) {
        try {
            assert Minecraft.getInstance().level != null;
            AbstractClientPlayer animationTarget = (AbstractClientPlayer) Minecraft.getInstance().level.getPlayerByUUID(UUID.fromString(data.UUID()));
            if (animationTarget != null) {
                PlayerAnimationController controller = switch (data.controller()) {
                    case "attack" ->
                            (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, ATTACK_LAYER_ID);
                    case "pose" ->
                            (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, POSE_LAYER_ID);
                    case "position" ->
                            (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, RIDER_POSITIONING_ID);
                    default ->
                            (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, ANIMATION_LAYER_ID);
                };

                if (controller != null && controller.isPlayingTriggeredAnimation()) {
                    controller.stopTriggeredAnimation();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}