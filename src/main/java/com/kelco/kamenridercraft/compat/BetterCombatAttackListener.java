package com.kelco.kamenridercraft.compat;

import com.kelco.kamenridercraft.network.payload.CompleteSwingPayload;

import net.bettercombat.api.AttackHand;
import net.bettercombat.api.client.BetterCombatClientEvents;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class BetterCombatAttackListener {
    @SubscribeEvent
    public static void register() {
        BetterCombatClientEvents.ATTACK_START.register((LocalPlayer player, AttackHand hand) -> {
            PacketDistributor.sendToServer(new CompleteSwingPayload(hand.isOffHand() ? 1 : 0));
        });
    }
}