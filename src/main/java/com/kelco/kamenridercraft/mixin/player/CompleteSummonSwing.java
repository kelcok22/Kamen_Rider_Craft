package com.kelco.kamenridercraft.mixin.player;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.kelco.kamenridercraft.entities.summons.CompleteSummonEntity;

@Mixin(value = ServerPlayer.class)
public class CompleteSummonSwing {
    @Inject(method = "swing", at = @At(value = "TAIL"))

    private void swing(InteractionHand hand, CallbackInfo ci) {
        ServerPlayer player = ((ServerPlayer)(Object)this);
        for (CompleteSummonEntity complete : player.serverLevel().getEntitiesOfClass(CompleteSummonEntity.class, player.getBoundingBox().inflate(10), 
                                            entity -> (entity.getOwner() == player))) {
            complete.mimicSwing(player, hand);
        }
    }
}

