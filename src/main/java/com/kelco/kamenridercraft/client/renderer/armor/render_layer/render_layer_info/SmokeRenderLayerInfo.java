package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;


public class SmokeRenderLayerInfo extends RenderLayerInfo {
    private final String texture;

    public SmokeRenderLayerInfo(String texture, String model) {
        super(texture, model);
        this.texture = texture;
    }

    @Override
    public RenderType getRenderType(float partialTick, LivingEntity RIDER) {
        float f = (float) RIDER.tickCount + partialTick;
        return RenderType.breezeWind(ResourceLocation
                .fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/render_layer/"
                        + texture + ".png"), 0.0F, xOffset(f) % 1.0F);
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.02F;
    }
}