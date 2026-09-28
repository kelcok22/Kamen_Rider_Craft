package com.kelco.kamenridercraft.client.renderer.entity.projectile;

import com.kelco.kamenridercraft.client.model.entity.effect.SealingModel;
import com.kelco.kamenridercraft.entity.effect.SealingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class SealingRenderer extends GeoEntityRenderer<SealingEntity> {
    private static final float HALF_SQRT_3 = (float)(Math.sqrt((double)3.0F) / (double)2.0F);

    public SealingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SealingModel());
    }

    public void render(SealingEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(-entity.getXRot()));
        renderRays(poseStack, (((61 - entity.tickCount - partialTick)) / 100), bufferSource.getBuffer(RenderType.dragonRays()));

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    private static void renderRays(PoseStack poseStack, float dragonDeathCompletion, VertexConsumer buffer) {
        poseStack.pushPose();
        float f = Math.min(dragonDeathCompletion > 0.8F ? (dragonDeathCompletion - 0.8F) / 0.2F : 0.0F, 1.0F);
        int i = FastColor.ARGB32.colorFromFloat(1.0F - f, 1.0F, 1.0F, 1.0F);
        int green = FastColor.ARGB32.colorFromFloat(0.95F, 0.0F, 1.0F, 0.3F);

        RandomSource randomsource = RandomSource.create(432L);
        Vector3f vector3f = new Vector3f();
        Vector3f vector3f1 = new Vector3f();
        Vector3f vector3f2 = new Vector3f();
        Vector3f vector3f3 = new Vector3f();
        Quaternionf quaternionf = new Quaternionf();
        int k = Mth.floor((dragonDeathCompletion + dragonDeathCompletion * dragonDeathCompletion) / 2.0F * 60.0F);

        for(int l = 0; l < k; ++l) {
            quaternionf.rotationXYZ(randomsource.nextFloat() * ((float)Math.PI * 2F), randomsource.nextFloat() * ((float)Math.PI * 2F), randomsource.nextFloat() * ((float)Math.PI * 2F)).rotateXYZ(randomsource.nextFloat() * ((float)Math.PI * 2F), randomsource.nextFloat() * ((float)Math.PI * 2F), randomsource.nextFloat() * ((float)Math.PI * 2F) + dragonDeathCompletion * ((float)Math.PI / 2F));
            poseStack.mulPose(quaternionf);
            float f1 = randomsource.nextFloat() * 20.0F + 5.0F + f * 10.0F;
            float f2 = randomsource.nextFloat() * 2.0F + 1.0F + f * 2.0F;
            f1 = f1/10;
            f2 = f2/15;
            vector3f1.set(-HALF_SQRT_3 * f2, f1, -0.5F * f2);
            vector3f2.set(HALF_SQRT_3 * f2, f1, -0.5F * f2);
            vector3f3.set(0.0F, f1, f2);
            PoseStack.Pose posestack$pose = poseStack.last();
            buffer.addVertex(posestack$pose, vector3f).setColor(i);
            buffer.addVertex(posestack$pose, vector3f1).setColor(green);
            buffer.addVertex(posestack$pose, vector3f2).setColor(green);
            buffer.addVertex(posestack$pose, vector3f).setColor(i);
            buffer.addVertex(posestack$pose, vector3f2).setColor(green);
            buffer.addVertex(posestack$pose, vector3f3).setColor(green);
            buffer.addVertex(posestack$pose, vector3f).setColor(i);
            buffer.addVertex(posestack$pose, vector3f3).setColor(green);
            buffer.addVertex(posestack$pose, vector3f1).setColor(green);
        }

        poseStack.popPose();
    }

    @Override
    public @Nullable RenderType getRenderType(SealingEntity animatable, ResourceLocation texture,
                                              @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}