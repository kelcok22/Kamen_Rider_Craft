package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.DenkiunagiCanModel;
import com.kelco.kamenridercraft.client.models.ToraCanModel;
import com.kelco.kamenridercraft.entities.allies.DenkiunagiCanEntity;
import com.kelco.kamenridercraft.entities.allies.ToraCanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DenkiunagiCanRenderer extends GeoEntityRenderer<DenkiunagiCanEntity> {




	public DenkiunagiCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DenkiunagiCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DenkiunagiCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/unagi_can.png");
    }

    @Override
    public void render(DenkiunagiCanEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}