package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.bikes.BoostrikerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class BoostrikerRenderer extends BikeRenderer<BoostrikerEntity> {
    public BoostrikerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager);
        addRenderLayer(new GeoRenderLayer<>(this) {
            @Override
            protected ResourceLocation getTextureResource(BoostrikerEntity animatable) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/boostriker/logo_"+animatable.getRiderLogo()+".png");
            }

            @Override
            public void render(PoseStack poseStack, BoostrikerEntity animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
                RenderType logo = RenderType.entityTranslucent(getTextureResource(animatable));

                if (renderType != null) {
                    getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, logo,
                            bufferSource.getBuffer(logo), partialTick, packedLight, packedOverlay,
                            getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                }
            }
        });
    }
}
