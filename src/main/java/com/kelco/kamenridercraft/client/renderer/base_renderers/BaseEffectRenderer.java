package com.kelco.kamenridercraft.client.renderer.base_renderers;

import com.kelco.kamenridercraft.client.models.base_models.BaseEffectModel;
import com.kelco.kamenridercraft.entity.base_entities.BaseEffectEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class BaseEffectRenderer extends GeoEntityRenderer<BaseEffectEntity> {

    public BaseEffectRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BaseEffectModel());
    }

    public void render(BaseEffectEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(-entity.getXRot()));
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    @Override
    public RenderType getRenderType(BaseEffectEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        if (animatable.isGlowing()) {
            return RenderType.breezeEyes(texture);
        }
        return RenderType.entityTranslucent(texture);
    }
}