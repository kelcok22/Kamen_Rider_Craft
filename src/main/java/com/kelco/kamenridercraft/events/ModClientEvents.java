package com.kelco.kamenridercraft.events;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.AttributeChangePayload;
import com.kelco.kamenridercraft.network.payload.CompleteSwingPayload;

import com.kelco.kamenridercraft.world.attribute.AttributeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class ModClientEvents {


    public static class ClientEvents {


        @SubscribeEvent
        public void completeSummonSwing(InputEvent.InteractionKeyMappingTriggered event) {
            if (event.isAttack() && event.shouldSwingHand()) PacketDistributor.sendToServer(new CompleteSwingPayload(event.getHand() == InteractionHand.MAIN_HAND ? 0 : 1));
        }
        @SubscribeEvent
        public void addLivingDamageEvent(LivingEvent.LivingVisibilityEvent event) {


            if (event.getLookingEntity() instanceof LivingEntity entity) {
                //if (entity.getAttribute(AttributeRegistry.IS_TRANSFORMING).getBaseValue()!=0)entity.getAttribute(AttributeRegistry.IS_TRANSFORMING).setBaseValue(entity.getAttribute(AttributeRegistry.IS_TRANSFORMING).getBaseValue()-0.2);
            }
        }
    }
}
