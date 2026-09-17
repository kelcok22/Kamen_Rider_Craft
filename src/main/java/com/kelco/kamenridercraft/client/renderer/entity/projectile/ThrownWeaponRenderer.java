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


public class ThrownWeaponRenderer<T extends Entity & ItemSupplier> extends EntityRenderer<T> {
    private static final float MIN_CAMERA_DISTANCE_SQUARED = 12.25F;
    private final ItemRenderer itemRenderer;
    private final float scale;
    private final boolean fullBright;

    public ThrownWeaponRenderer(EntityRendererProvider.Context context, float scale, boolean fullBright) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
        this.scale = scale;
        this.fullBright = fullBright;
    }

    public ThrownWeaponRenderer(EntityRendererProvider.Context context) {
        this(context, 1.0F, false);
    }

    protected int getBlockLightLevel(@NotNull T thrownWeapon, @NotNull BlockPos blockPos) {
        return this.fullBright ? 15 : super.getBlockLightLevel(thrownWeapon, blockPos);
    }

    public void render(T thrownWeapon, float entityYaw, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {
        if (thrownWeapon.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(thrownWeapon) < 12.25D)) {
            poseStack.pushPose();
            poseStack.scale(this.scale, this.scale, this.scale);
            poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            poseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));
            poseStack.mulPose(Axis.ZP.rotationDegrees(thrownWeapon.tickCount * 4));
            itemRenderer.renderStatic(thrownWeapon.getItem(), ItemDisplayContext.FIXED, packedLight, OverlayTexture.NO_OVERLAY,
                    poseStack, bufferSource, thrownWeapon.level(), thrownWeapon.getId());
            poseStack.popPose();
            super.render(thrownWeapon, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        }
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull Entity thrownWeapon) {
        return ResourceLocation.withDefaultNamespace("textures/atlas/blocks.png");
    }
}