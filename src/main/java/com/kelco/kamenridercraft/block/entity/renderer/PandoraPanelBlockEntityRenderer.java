package com.kelco.kamenridercraft.block.entity.renderer;


import com.kelco.kamenridercraft.block.entity.PandoraPanelBlockEntity;
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

public class PandoraPanelBlockEntityRenderer implements BlockEntityRenderer<PandoraPanelBlockEntity> {
    public PandoraPanelBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(PandoraPanelBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = pBlockEntity.inventory.getStackInSlot(0);

        pPoseStack.pushPose();

        float X =0.5f;
        float Z  =0.5f;
        if (pBlockEntity.getRenderingRotation(pBlockEntity)==0) Z =0.95f;
        if (pBlockEntity.getRenderingRotation(pBlockEntity)==90) X =0.05f;
        if (pBlockEntity.getRenderingRotation(pBlockEntity)==180) Z =0.05f;
        if (pBlockEntity.getRenderingRotation(pBlockEntity)==270) X =0.95f;

        pPoseStack.translate(X, 0.5f, Z);
        pPoseStack.scale(1f, 1f, 1f);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.getRenderingRotation(pBlockEntity)));

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