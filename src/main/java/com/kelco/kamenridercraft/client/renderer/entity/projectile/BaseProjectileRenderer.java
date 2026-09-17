package com.kelco.kamenridercraft.client.renderer.entity.projectile;

import com.kelco.kamenridercraft.client.model.base_model.BaseProjectileModel;
import com.kelco.kamenridercraft.entity.base_entities.BaseProjectileEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class BaseProjectileRenderer extends GeoEntityRenderer<BaseProjectileEntity> {
    public BaseProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BaseProjectileModel());
    }

    public void render(BaseProjectileEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(-entity.getXRot()));

        if (entity.getModel().equals("card")) {
            poseStack.scale(0.6F, 0.6F, 0.6F);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    @Override
    public @Nullable RenderType getRenderType(BaseProjectileEntity animatable, ResourceLocation texture,
                                              @Nullable MultiBufferSource bufferSource, float partialTick) {
        if (animatable.isGlowing()) {
            return RenderType.breezeEyes(texture);
        }
        return RenderType.entityTranslucent(texture);
    }
}