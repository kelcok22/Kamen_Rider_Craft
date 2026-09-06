package com.kelco.kamenridercraft.mixin.client.renderer;

import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = LivingEntityRenderer.class)
public class PlayerRendererMixin {
    @ModifyReturnValue(method = "getAttackAnim", at = @At("RETURN"))
    public float renderArmWithItemMixin(float original, @Local(argsOnly = true) LivingEntity livingBase) {
        if (livingBase instanceof LivingEntity livingEntity && livingEntity.getAttribute(Attributes.IS_TRANSFORMING).getValue() > 0) return 0F;
        return original;
    }
}