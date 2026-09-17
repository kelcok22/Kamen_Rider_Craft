package com.kelco.kamenridercraft.client.renderer.armor.render_layer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.base_model.EffectModel;
import com.kelco.kamenridercraft.client.renderer.armor.RiderArmorRenderer;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.Objects;


public class WindRenderLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    public WindRenderLayer(GeoRenderer<T> renderer) {
        super(renderer);
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.02F;
    }

    public GeoModel<T> getGeoModel() {
        return new EffectModel<>();
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType,
                       MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (getRenderer() instanceof RiderArmorRenderer renderer2) {
            LivingEntity livingEntity = renderer2.GetEntity();
            if (livingEntity != null && Objects.requireNonNull(livingEntity.getAttribute(Attributes.WIND)).getBaseValue() > 0) {
                float f = (float) livingEntity.tickCount + partialTick;
                renderType = RenderType.breezeWind(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,
                        "textures/render_layer/wind.png"), xOffset(f) % 1.0F, 0.0F);
                poseStack.mulPose(Axis.YP.rotationDegrees(-(f * 22 - 45.0F)));
                getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, renderType,
                        bufferSource.getBuffer(renderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                        getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());

                poseStack.scale(1.3f, 1.3f, 1.3f);
                poseStack.mulPose(Axis.YP.rotationDegrees(f * 24 - 45.0F));
                getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, renderType,
                        bufferSource.getBuffer(renderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                        getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
            }
        }
    }
}