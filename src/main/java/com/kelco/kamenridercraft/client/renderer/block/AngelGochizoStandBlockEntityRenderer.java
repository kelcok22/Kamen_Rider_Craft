package com.kelco.kamenridercraft.client.renderer.block;

import com.kelco.kamenridercraft.blockentity.AngelGochizoStandBlockEntity;
import com.kelco.kamenridercraft.blockentity.GochizoJarBlockEntity;
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
import org.jetbrains.annotations.NotNull;

public class AngelGochizoStandBlockEntityRenderer implements BlockEntityRenderer<AngelGochizoStandBlockEntity> {
    public AngelGochizoStandBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(AngelGochizoStandBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       @NotNull MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = pBlockEntity.inventory.getStackInSlot(0);
        pPoseStack.pushPose();

        float X = switch ((int) pBlockEntity.getRenderingRotation(pBlockEntity)) {
            case 0, 180 -> 0.3f;
            default -> 2;
        };
        float Y = switch ((int) pBlockEntity.getRenderingRotation(pBlockEntity)) {
            case  90, 270 -> 0.3f;
            default -> 2;
        };
        pPoseStack.translate(0.5f, 0.4f, 0.5f);
        pPoseStack.scale(X, 0.3f, Y);

        pPoseStack.mulPose(Axis.YP.rotationDegrees(pBlockEntity.getRenderingRotation(pBlockEntity)));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(0));
        pPoseStack.mulPose(Axis.XP.rotationDegrees(0));

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
