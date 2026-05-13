package com.kelco.kamenridercraft.mixin.client;

import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import com.kelco.kamenridercraft.network.payload.ClimbCollisionPayload;
import com.kelco.kamenridercraft.world.attribute.AttributeRegistry;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.network.PacketDistributor;
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
            PacketDistributor.sendToServer(new ClimbCollisionPayload(0));
        }
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem().toString().equals("kamenridercraft:ichigo_mask") && player.hasEffect(EffectCore.RIDER_SPIRIT)){
            player.level().addParticle(ParticleTypes.RAIN, player.getX(), player.getEyeY(), player.getZ(), 0, 1, 0);
        }
    }
}
