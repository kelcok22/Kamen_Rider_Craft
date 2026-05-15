package com.kelco.kamenridercraft.network;

import com.kelco.kamenridercraft.entity.mobs.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.LegendarySummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.network.payload.*;

import com.kelco.kamenridercraft.world.attribute.AttributeRegistry;
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
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.UUID;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.get_Form_Item;
import static com.kelco.kamenridercraft.util.AnimationUtil.*;
import static com.zigythebird.playeranim.PlayerAnimLibMod.ANIMATION_LAYER_ID;

public class ClientPayloadHandler {

    // Decade Complete summon swing mimicry
    public static void handleCompleteSwing(final CompleteSwingPayload data, final IPayloadContext context) {
        // Do something with the data, on the network thread
        handleCompleteSwing(data.hand(), context.player());

        // Do something with the data, on the main thread
        //context.enqueueWork(() -> {
        //    handle(data.hand());
        //})
        //.exceptionally(e -> {
        //    // Handle exception
        //    context.disconnect(Component.translatable("kamenridercraft.networking.failed", e.getMessage()));
        //    return null;
        //});
    }

    public static void handleAttributeCLientChange(final AttributeChangeClientPayload data, final IPayloadContext context) {
        if (context.player().level().getPlayerByUUID(UUID.fromString(data.id())) instanceof LivingEntity entity){
            if (entity instanceof Player&!context.player().getStringUUID().equals(data.id())||!(entity instanceof Player)) {
                switch (data.attributeName()) {
                    case "ball_rot" ->{
                        entity.getAttribute(AttributeRegistry.BALL_ROT_OLD).setBaseValue( entity.getAttribute(AttributeRegistry.BALL_ROT).getBaseValue());
                        entity.getAttribute(AttributeRegistry.BALL_ROT).setBaseValue(data.valueChange());
                    }
                    case "wheel_rot" ->{
                        entity.getAttribute(AttributeRegistry.WHEEL_ROT_OLD).setBaseValue( entity.getAttribute(AttributeRegistry.WHEEL_ROT).getBaseValue());
                        entity.getAttribute(AttributeRegistry.WHEEL_ROT).setBaseValue(data.valueChange());
                    }
                    case "cape_rot" ->{
                        entity.getAttribute(AttributeRegistry.CAPE_ROT_OLD).setBaseValue( entity.getAttribute(AttributeRegistry.CAPE_ROT).getBaseValue());
                        entity.getAttribute(AttributeRegistry.CAPE_ROT).setBaseValue(data.valueChange());
                    }
                    case "wing_out" -> entity.getAttribute(AttributeRegistry.WINGS_OUT).setBaseValue(data.valueChange());
                }
            }
        }
    }


    private static void handleCompleteSwing(int hand, Player player) {
        for (CompleteSummonEntity complete : player.level().getEntitiesOfClass(CompleteSummonEntity.class, player.getBoundingBox().inflate(10),
                entity -> (entity.getOwner() == player))) {
            complete.mimicSwing(player, hand == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
        for (LegendarySummonEntity legend : player.level().getEntitiesOfClass(LegendarySummonEntity.class, player.getBoundingBox().inflate(10),
                entity -> (entity.getOwner() == player && entity.getTarget() == null))) {
            legend.mimicSwing(player, hand == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
    }

    public static void startPoseAnimations(final StartPosePayload data, final IPayloadContext context) {
        LivingEntity posingRider = context.player().level().getPlayerByUUID(UUID.fromString(data.UUID()));
        assert posingRider != null;
        Animation animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, "default.pose"));

        if (posingRider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) {

            RiderFormChangeItem formChangeItemOne = get_Form_Item(posingRider.getItemBySlot(EquipmentSlot.FEET), 1);

            String formItemName = formChangeItemOne.toString().replace("kamenridercraft:", "");
            String riderName = getAnimRiderName(driverItem);

            animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, riderName + ".pose"));

            if (formChangeItemOne.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "animation/form_specific_pose")))) {
                animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, riderName + "." + formItemName + ".pose"));
            }

            if (riderName.equals("ooo")) {
                RiderFormChangeItem formChangeItemTwo = get_Form_Item(posingRider.getItemBySlot(EquipmentSlot.FEET), 2);
                RiderFormChangeItem formChangeItemThree = get_Form_Item(posingRider.getItemBySlot(EquipmentSlot.FEET), 3);
                String comboName = oooComboCheck(formChangeItemOne.toString(), formChangeItemTwo.toString(), formChangeItemThree.toString());

                if (comboName.equals("tajadol_eternity")) {
                    comboName = "tajadol";
                }
                if (!comboName.isEmpty()) {
                    animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, riderName + "." + comboName + ".pose"));
                }
            }

            if (animation == null) {
                animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, "default.pose"));
            }
        } else if (posingRider.getItemBySlot(EquipmentSlot.HEAD).getItem().toString().equals("kamenridercraft:ferbus")) {
            animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, "ferbus.dance"));
        }
        try {
            AbstractClientPlayer animationTarget = (AbstractClientPlayer) Minecraft.getInstance().level.getPlayerByUUID(UUID.fromString(data.UUID()));
            PlayerAnimationController controller = (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, ANIMATION_LAYER_ID);

            controller.addModifierBefore(AbstractFadeModifier.standardFadeIn(15, EasingType.EASE_IN_ELASTIC));
            controller.triggerAnimation(animation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void endPoseAnimations(final EndPosePayload data, final IPayloadContext context) {
        try {
            assert Minecraft.getInstance().level != null;
            AbstractClientPlayer animationTarget = (AbstractClientPlayer) Minecraft.getInstance().level.getPlayerByUUID(UUID.fromString(data.UUID()));
            assert animationTarget != null;
            PlayerAnimationController controller = (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(animationTarget, ANIMATION_LAYER_ID);
            if (controller != null && controller.isPlayingTriggeredAnimation()) {
                controller.stopTriggeredAnimation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}