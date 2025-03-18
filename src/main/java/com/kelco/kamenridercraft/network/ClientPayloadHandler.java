package com.kelco.kamenridercraft.network;

import com.kelco.kamenridercraft.entities.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.network.payload.CompleteSwingPayload;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientPayloadHandler {
    
    // Decade Complete summon swing mimicry
    public static void handleDataOnMain(final CompleteSwingPayload data, final IPayloadContext context) {
        // Do something with the data, on the network thread
        handle(data.hand(), context.player());
        
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

    private static void handle(int hand, Player player) {
        for (CompleteSummonEntity complete : player.level().getEntitiesOfClass(CompleteSummonEntity.class, player.getBoundingBox().inflate(10), 
                                            entity -> (entity.getOwner() == player))) {
            complete.mimicSwing(player, hand == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
    }
}