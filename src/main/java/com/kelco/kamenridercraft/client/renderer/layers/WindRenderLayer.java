package com.kelco.kamenridercraft.client.renderer.layers;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.base_models.EffectModel;
import com.kelco.kamenridercraft.client.renderer.RiderArmorRenderer;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
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
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (this.getRenderer() instanceof RiderArmorRenderer renderer2) {
            LivingEntity RIDER = renderer2.GetEntity();
            if (RIDER != null && Objects.requireNonNull(RIDER.getAttribute(Attributes.WIND)).getBaseValue() > 0) {
                float f = (float) RIDER.tickCount + partialTick;
                renderType = RenderType.breezeWind(ResourceLocation.withDefaultNamespace("textures/entity/breeze/breeze_wind.png"), this.xOffset(f) % 1.0F, 0.0F);
                poseStack.mulPose(Axis.YP.rotationDegrees(-(f * 22 - 45.0F)));

                getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, renderType, bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay, getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                poseStack.scale(1.3f, 1.3f, 1.3f);
                poseStack.mulPose(Axis.YP.rotationDegrees(f * 24 - 45.0F));
                getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, renderType, bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay, getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
            }
        }
    }
}