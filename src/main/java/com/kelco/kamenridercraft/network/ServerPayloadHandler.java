package com.kelco.kamenridercraft.network;

import com.kelco.kamenridercraft.entities.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.entities.summons.LegendarySummonEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.AbilityKeyPayload;
import com.kelco.kamenridercraft.network.payload.BeltKeyPayload;
import com.kelco.kamenridercraft.network.payload.CompleteSwingPayload;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

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
    public static void handleBeltKeyPress(final BeltKeyPayload data, final IPayloadContext context) {
        // Do something with the data, on the network thread
        handleBeltKeyPress((ServerPlayer)context.player());
        
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
        handleAbilityKeyPress((ServerPlayer)context.player());
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

        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getDamageValue()!=player.getItemBySlot(EquipmentSlot.FEET).getMaxDamage()-1) belt.setUseAbility(player, player.getUsedItemHand(), player.getItemBySlot(EquipmentSlot.FEET));
        }
    }

    private static void handleBeltKeyPress(ServerPlayer player) {

		if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
            if (belt.Has_Inventory && player.getItemBySlot(EquipmentSlot.FEET).getDamageValue()!=player.getItemBySlot(EquipmentSlot.FEET).getMaxDamage()-1) belt.openInventory(player, player.getUsedItemHand(), player.getItemBySlot(EquipmentSlot.FEET));
        }
    }
}