package com.kelco.kamenridercraft.item.client;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

import java.io.IOException;


public class NonNullGlowingLayer extends AutoGlowingGeoLayer<RiderArmorItem> {
    public NonNullGlowingLayer(GeoRenderer<RiderArmorItem> renderer) {
        super(renderer);
    }

    /**
     * Like {@link #AutoGlowingGeoLayer#getRenderType()}, but disables rendering automatically if an emissive resource does not exist.
     * This solves the issue of the glowlayer rendering as pure black when a hero's form is not emissive
     * @return The render type to use for this glowlayer renderer, or null if there is no resource for it to use
     */
    @Nullable
    protected RenderType getRenderType(RiderArmorItem animatable, @Nullable MultiBufferSource bufferSource) {
        try {
            Minecraft.getInstance().getResourceManager().getResourceOrThrow(AutoGlowingTexture.getEmissiveResource(getTextureResource(animatable)));
            return super.getRenderType(animatable, bufferSource);
        } catch (IOException ioexception) {
            return null;
        }
    }
}


