package com.kelco.kamenridercraft.mixin.client.renderer;

import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LivingEntityRenderer.class)
public class LivingEntityRendererMixin<T> {

    @Inject(method = "getAttackAnim", at = @At("HEAD"), cancellable = true)
    public void renderArmWithItemMixin(LivingEntity livingBase, float partialTickTime, CallbackInfoReturnable<Float> cir) {
        if (livingBase instanceof LivingEntity livingEntity && livingEntity.getAttribute(Attributes.IS_TRANSFORMING).getValue() > 0) {
            cir.setReturnValue(0F);
        }
    }
}