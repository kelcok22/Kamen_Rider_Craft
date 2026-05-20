package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.client.models.NeoBikeModel;
import com.kelco.kamenridercraft.entity.vehicles.NeoBaseBikeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class NeoBikeRenderer<T extends NeoBaseBikeEntity> extends GeoEntityRenderer<T> {
	public NeoBikeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NeoBikeModel<>());
        this.scaleWidth = 1.1f;
        this.scaleHeight = 1.1f;
    }

    @Override
    public void render(T entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(-entity.getViewYRot(0)));
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }
}