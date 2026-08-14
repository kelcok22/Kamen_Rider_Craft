package com.kelco.kamenridercraft.client.renderer.layers.render_layer_util;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class RenderLayerInfo {
    private final String model;
    private final RenderType renderType;
    private boolean glowing = false;
    private String glowTexture;

    public RenderLayerInfo(String texture, String model) {
        renderType = RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + texture + ".png"));
        this.model = model;
    }

    public RenderLayerInfo(RenderType texture, String model) {
        renderType = texture;
        this.model = model;
    }

    public RenderLayerInfo setGlowing(String text) {
        glowTexture = text;
        glowing = true;
        return this;
    }

    public RenderType getRenderType() {
        return renderType;
    }

    public String getGlowTexture() {
        return glowTexture;
    }

    public String getModel() {
        return model;
    }

    public boolean isGlowing() {
        return glowing;
    }
}