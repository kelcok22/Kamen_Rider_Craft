package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.network.payload.CompleteSwingPayload;

import net.minecraft.client.model.EntityModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class ModClientEvents {


    public static class ClientEvents {


        @SubscribeEvent
        public void completeSummonSwing(InputEvent.InteractionKeyMappingTriggered event) {
            if (event.isAttack() && event.shouldSwingHand()) PacketDistributor.sendToServer(new CompleteSwingPayload(event.getHand() == InteractionHand.MAIN_HAND ? 0 : 1));
        }
    }
}
