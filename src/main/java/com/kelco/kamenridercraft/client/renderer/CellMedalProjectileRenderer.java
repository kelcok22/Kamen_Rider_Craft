package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.client.models.CellMedalModel;
import com.kelco.kamenridercraft.entities.projectile.CellMedalProjectileEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CellMedalProjectileRenderer extends GeoEntityRenderer<CellMedalProjectileEntity> {

	public CellMedalProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CellMedalModel());
    }

    public void render(CellMedalProjectileEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(-entity.getXRot()));

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }
}