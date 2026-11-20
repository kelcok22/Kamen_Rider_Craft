package com.kelco.kamenridercraft.mixin.client.renderer;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.zigythebird.playeranim.accessors.IAnimatedPlayer;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
    @ModifyReturnValue(method = "getAttackAnim", at = @At("RETURN"))
    public float renderArmWithItemMixin(float original, @Local(argsOnly = true) LivingEntity livingEntity) {
        if (livingEntity instanceof AbstractClientPlayer player && ((IAnimatedPlayer) player).playerAnimLib$getAnimProcessor() != null
                && ((IAnimatedPlayer) player).playerAnimLib$getAnimManager().isActive()) {
            return 0F;
        }
        return original;
    }
}