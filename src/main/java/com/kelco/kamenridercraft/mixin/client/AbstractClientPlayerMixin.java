package com.kelco.kamenridercraft.mixin.client;

import com.kelco.kamenridercraft.world.attribute.AttributeRegistry;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AbstractClientPlayer.class, priority = 899)
public class AbstractClientPlayerMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        var player = ((LivingEntity) (Object) this);
        if (player.horizontalCollision && player.getAttribute(AttributeRegistry.CLIMBING).getValue() != 0) {
            Vec3 initialVec = player.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.1D * (player.getAttribute(AttributeRegistry.CLIMBING).getValue()), initialVec.z);
            player.setDeltaMovement(climbVec.scale(0.97D));
        }
    }
}
