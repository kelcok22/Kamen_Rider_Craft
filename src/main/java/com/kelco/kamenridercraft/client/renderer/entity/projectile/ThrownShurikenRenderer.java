package com.kelco.kamenridercraft.client.renderer.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemDisplayContext;
import org.jetbrains.annotations.NotNull;


public class ThrownShurikenRenderer<T extends Entity & ItemSupplier> extends EntityRenderer<T> {
    private static final float MIN_CAMERA_DISTANCE_SQUARED = 12.25F;
    private final ItemRenderer itemRenderer;
    private final float scale;
    private final boolean fullBright;
    private float rotation;

    public ThrownShurikenRenderer(EntityRendererProvider.Context context, float scale, boolean fullBright) {
        super(context);
        itemRenderer = context.getItemRenderer();
        this.scale = scale;
        this.fullBright = fullBright;
    }

    public ThrownShurikenRenderer(EntityRendererProvider.Context context) {
        this(context, 1.0F, false);
    }

    protected int getBlockLightLevel(T shuriken, BlockPos blockPos) {
        return fullBright ? 15 : super.getBlockLightLevel(shuriken, blockPos);
    }

    public void render(T shuriken, float entityYaw, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {
        if (shuriken.tickCount >= 2 || !(entityRenderDispatcher.camera.getEntity().distanceToSqr(shuriken) < 12.25D)) {
            rotation += 10.0f;
            if (rotation >= 360) {
                rotation = 0;
            }
            poseStack.pushPose();
            poseStack.scale(scale, scale, scale);
            poseStack.mulPose(entityRenderDispatcher.cameraOrientation());
            poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
            poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
            itemRenderer.renderStatic(shuriken.getItem(), ItemDisplayContext.FIXED, packedLight, OverlayTexture.NO_OVERLAY,
                    poseStack, bufferSource, shuriken.level(), shuriken.getId());
            poseStack.popPose();
            super.render(shuriken, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        }
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull Entity shuriken) {
        return ResourceLocation.withDefaultNamespace("textures/atlas/blocks.png");
    }
}