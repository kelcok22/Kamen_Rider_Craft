package com.kelco.kamenridercraft.network;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.entities.summons.LegendarySummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.network.payload.AbilityKeyPayload;
import com.kelco.kamenridercraft.network.payload.BeltKeyPayload;
import com.kelco.kamenridercraft.network.payload.CompleteSwingPayload;

import com.kelco.kamenridercraft.network.payload.PoseKeyPayload;
import com.kelco.kamenridercraft.util.ComplexFormCheck;
import com.zigythebird.playeranim.animation.PlayerAnimResources;
import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationAccess;
import com.zigythebird.playeranimcore.animation.Animation;
import com.zigythebird.playeranimcore.animation.layered.modifier.AbstractFadeModifier;
import com.zigythebird.playeranimcore.easing.EasingType;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem.get_Form_Item;
import static com.zigythebird.playeranim.PlayerAnimLibMod.ANIMATION_LAYER_ID;

public class ServerPayloadHandler {

    public static void stopKickAnimation() {
        PlayerAnimationController controller = (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(Minecraft.getInstance().player, ANIMATION_LAYER_ID);
        controller.stopTriggeredAnimation();
    }

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

    public static void handlePoseKeyPress(final PoseKeyPayload data, final IPayloadContext context) {
        if (context.player().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) {

            RiderFormChangeItem formChangeItemOne = get_Form_Item(context.player().getItemBySlot(EquipmentSlot.FEET), 1);

            String formItemName = formChangeItemOne.toString().replace("kamenridercraft:", "");
            String riderName = driverItem.Rider.toLowerCase();

            Animation animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, riderName + ".pose"));

            if (formChangeItemOne.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "animation/form_specific_pose")))) {
                animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, riderName + "." + formItemName + ".pose"));
            }

            if (riderName.equals("ooo")) {
                RiderFormChangeItem formChangeItemTwo = get_Form_Item(context.player().getItemBySlot(EquipmentSlot.FEET), 2);
                RiderFormChangeItem formChangeItemThree = get_Form_Item(context.player().getItemBySlot(EquipmentSlot.FEET), 3);
                String comboName = ComplexFormCheck.oooComboCheck(formChangeItemOne.toString(), formChangeItemTwo.toString(), formChangeItemThree.toString());
                if (!comboName.isEmpty()) {
                    animation = PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, riderName + "." + comboName + ".pose"));
                }
            }

            try {
                context.player().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,60, 2,true,false));
                PlayerAnimationController controller = (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(Minecraft.getInstance().player, ANIMATION_LAYER_ID);
                controller.addModifierBefore(AbstractFadeModifier.standardFadeIn(15, EasingType.EASE_IN_ELASTIC));
                controller.triggerAnimation(animation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void handleBeltKeyPress(final BeltKeyPayload data, final IPayloadContext context) {
        // Do something with the data, on the network thread
        handleBeltKeyPress((ServerPlayer) context.player());

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

    public static void handleAbilityKeyPress(final AbilityKeyPayload data, final IPayloadContext context) {
        handleAbilityKeyPress((ServerPlayer) context.player());
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

    private static void handleAbilityKeyPress(ServerPlayer player) {

        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
                && !player.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.parse("kamenridercraft:belts/blade_armor"))) && !player.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.parse("kamenridercraft:belts/wizard_armor"))))
            RiderDriverItem.setUseAbility(player.getItemBySlot(EquipmentSlot.FEET));
    }

    private static void handleBeltKeyPress(ServerPlayer player) {

        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
            if (belt.Has_Inventory && player.getItemBySlot(EquipmentSlot.FEET).getDamageValue() != player.getItemBySlot(EquipmentSlot.FEET).getMaxDamage() - 1)
                belt.openInventory(player, player.getUsedItemHand(), player.getItemBySlot(EquipmentSlot.FEET));
        }
    }
}