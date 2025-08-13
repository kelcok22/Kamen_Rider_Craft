package com.kelco.kamenridercraft.block.entity.renderer;

import com.kelco.kamenridercraft.block.entity.PlinthBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class AstroswitchRackBlockEntityRenderer implements BlockEntityRenderer<PlinthBlockEntity> {
    public AstroswitchRackBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(PlinthBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = pBlockEntity.inventory.getStackInSlot(0);

        pPoseStack.pushPose();
        float X =0;
        float Z  =0;
        if (pBlockEntity.getRenderingRotation(pBlockEntity)==0) Z =133;
        if (pBlockEntity.getRenderingRotation(pBlockEntity)==90) Z =133;
        if (pBlockEntity.getRenderingRotation(pBlockEntity)==180) Z =133;
        if (pBlockEntity.getRenderingRotation(pBlockEntity)==270) Z =133;

        pPoseStack.translate(0.5f, 0.6f, 0.5f);
        pPoseStack.scale(0.8f, 0.8f, 0.8f);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.getRenderingRotation(pBlockEntity)));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Z));
        pPoseStack.mulPose(Axis.XP.rotationDegrees(X));

        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(),
                pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
