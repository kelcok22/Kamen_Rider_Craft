package com.kelco.kamenridercraft.mixin.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = LevelRenderer.class, priority = 899)
public class LevelRendererMixin {
    @Shadow
    private ClientLevel level;

    @WrapOperation(method = "renderSky", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V", ordinal = 1))
    public void renderEarth(int shaderTexture, ResourceLocation textureId, Operation<Void> original) {
        ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:moon"));
        if (this.level.dimension() == MOON) {
            RenderSystem.setShaderTexture(shaderTexture, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/environment/earth_phases.png"));
        } else original.call(shaderTexture, textureId);
    }
}
