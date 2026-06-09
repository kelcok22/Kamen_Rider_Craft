package com.kelco.kamenridercraft.network;

import com.kelco.kamenridercraft.entity.mobs.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.LegendarySummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.*;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.UUID;

import static com.kelco.kamenridercraft.util.AnimationUtil.canPose;
import static com.kelco.kamenridercraft.util.AnimationUtil.stopPosing;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypeRegistry.*;

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
        if (context.player().getData(IS_POSING)) {
            context.player().setData(IS_POSING, false);
            stopPosing(context.player());
        } else {
            if (canPose(context.player())){
                context.player().setData(IS_POSING, true);
                PacketDistributor.sendToAllPlayers(new StartPosePayload(0, context.player().getStringUUID()));
            }
        }
    }

    public static void handleAttributeChange(final AttributeChangePayload data, final IPayloadContext context) {
            if (context.player().level().getPlayerByUUID(UUID.fromString(data.id())) instanceof LivingEntity entity) {
                if (entity instanceof Player&context.player().getStringUUID().equals(data.id())) {
                   PacketDistributor.sendToAllPlayers(new AttributeChangeClientPayload(data.id(), data.attributeName(), data.valueChange()));
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

    public static void handleClimbing(final ClimbCollisionPayload data, final IPayloadContext context) {
        if (context.player().level().getPlayerByUUID(UUID.fromString(data.id())) instanceof LivingEntity entity) {
            Vec3 initialVec = entity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.1D * (entity.getAttribute(Attributes.CLIMBING).getValue()), initialVec.z);
            entity.setDeltaMovement(climbVec.scale(0.97D));
            entity.hurtMarked = true;
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