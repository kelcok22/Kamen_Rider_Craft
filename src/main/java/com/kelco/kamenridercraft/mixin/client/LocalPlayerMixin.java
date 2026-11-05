package com.kelco.kamenridercraft.mixin.client;

import com.kelco.kamenridercraft.network.payload.AttributeChangePayload;
import com.kelco.kamenridercraft.network.payload.ClimbCollisionPayload;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = LocalPlayer.class, priority = 899)
public class LocalPlayerMixin {
    @ModifyReturnValue(method = "isCrouching", at = @At("RETURN"))
    public boolean isCrouching(boolean original) {
        var rider = ((LocalPlayer) (Object) this);
        if (rider.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 0) return false;
        return original;
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        var rider = ((LocalPlayer) (Object) this);
        if (rider.horizontalCollision && Objects.requireNonNull(rider.getAttribute(KRCAttributes.CLIMBING)).getValue() != 0) {
            PacketDistributor.sendToServer(new ClimbCollisionPayload(rider.getStringUUID()));
        }
        if (Minecraft.getInstance().level != null && Minecraft.getInstance().level.isClientSide()) {
            if (rider instanceof LocalPlayer pl && (pl.getAbilities().flying || rider.isFallFlying())) {
                PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), 1.0, rider.xxa, rider.zza));
            } else {
                PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), 0.0, rider.xxa, rider.zza));
            }
        }
    }
}