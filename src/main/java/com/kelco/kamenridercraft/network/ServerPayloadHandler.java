package com.kelco.kamenridercraft.network;

import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.LegendarySummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.*;
import com.kelco.kamenridercraft.world.attribute.AttributeRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import static com.kelco.kamenridercraft.util.AnimationUtil.canPose;
import static com.kelco.kamenridercraft.util.AnimationUtil.stopPosing;

public class ServerPayloadHandler {



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
        //TODO add gamerule for allow particles, sounds, and cooldown length
        if (context.player().getAttribute(AttributeRegistry.POSING).getValue() == 1) {
            context.player().getAttribute(AttributeRegistry.POSING).setBaseValue(0);
            stopPosing(context.player());
        } else {
            if (canPose(context.player())){
                context.player().getAttribute(AttributeRegistry.POSING).setBaseValue(1);
                PacketDistributor.sendToAllPlayers(new StartPosePayload(0, context.player().getStringUUID()));
            }
        }
    }

    public static void handleAttributeChange(final AttributeChangePayload data, final IPayloadContext context) {
        if (!data.valueChange().isNaN()) {
            switch (data.attributeName()) {
            case "ball_rotation_old" -> context.player().getAttribute(AttributeRegistry.BALL_ROT_OLD).setBaseValue(data.valueChange());
            case "wheel_rotation_old" -> context.player().getAttribute(AttributeRegistry.WHEEL_ROT_OLD).setBaseValue(data.valueChange());
            case "cape_rotation_old" -> context.player().getAttribute(AttributeRegistry.CAPE_ROT_OLD).setBaseValue(data.valueChange());
            case "ball_rotation" -> context.player().getAttribute(AttributeRegistry.BALL_ROT).setBaseValue(data.valueChange());
            case "wheel_rotation" -> context.player().getAttribute(AttributeRegistry.WHEEL_ROT).setBaseValue(data.valueChange());
            case "cape_rotation" -> context.player().getAttribute(AttributeRegistry.CAPE_ROT).setBaseValue(data.valueChange());
            case "wing_out" -> context.player().getAttribute(AttributeRegistry.WINGS_OUT).setBaseValue(data.valueChange());
        }}
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

    public static void handleClimbing(final ClimbCollisionPayload data, final IPayloadContext context) {
        Vec3 initialVec = context.player().getDeltaMovement();
        Vec3 climbVec = new Vec3(initialVec.x, 0.1D * (context.player().getAttribute(AttributeRegistry.CLIMBING).getValue()), initialVec.z);
        context.player().setDeltaMovement(climbVec.scale(0.97D));
        context.player().hurtMarked=true;
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