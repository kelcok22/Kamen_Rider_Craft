package com.kelco.kamenridercraft.client.renderer.entity.projectile;

import com.kelco.kamenridercraft.client.model.entity.mob.RouzeCardModel;
import com.kelco.kamenridercraft.entity.projectiles.RouzeCardEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RouzeCardRenderer extends GeoEntityRenderer<RouzeCardEntity> {
    public RouzeCardRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RouzeCardModel());
    }

    public void render(RouzeCardEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(-entity.getXRot()));
        poseStack.scale(0.4F, 0.4F, 0.4F);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    @Override
    public @Nullable RenderType getRenderType(RouzeCardEntity animatable, ResourceLocation texture,
                                              @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}