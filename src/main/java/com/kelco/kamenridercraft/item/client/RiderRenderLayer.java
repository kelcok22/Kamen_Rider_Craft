package com.kelco.kamenridercraft.item.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;


public class RiderRenderLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    private final ResourceLocation TEXT;

    public RiderRenderLayer(GeoRenderer<T> renderer, ResourceLocation text ) {
        super(renderer);
         TEXT=text;
    }

    protected ResourceLocation getTextureResource(T animatable) {
        return TEXT;
    }


    @Nullable
    protected RenderType getRenderType(T animatable, @Nullable MultiBufferSource bufferSource) {
        return RenderType.armorCutoutNoCull(getTextureResource(animatable));
    }

    /**
     * This is the method that is actually called by the render for your render layer to function
     * <p>
     * This is called <i>after</i> the animatable has been rendered, but before supplementary rendering like nametags
     */
    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        renderType = getRenderType(animatable,null);

        if (renderType != null) {
            getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderType,
                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
        }
    }
}


