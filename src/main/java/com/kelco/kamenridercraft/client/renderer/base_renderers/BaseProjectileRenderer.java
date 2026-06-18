package com.kelco.kamenridercraft.client.renderer.base_renderers;

import com.kelco.kamenridercraft.client.models.base_models.BaseProjectileModel;
import com.kelco.kamenridercraft.entity.base_entities.BaseProjectileEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class BaseProjectileRenderer extends GeoEntityRenderer<BaseProjectileEntity> {

    public BaseProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BaseProjectileModel());
    }

    public void render(BaseProjectileEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(-entity.getXRot()));

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    public RenderType getRenderType(BaseProjectileRenderer animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucentEmissive(texture, true);
    }
}