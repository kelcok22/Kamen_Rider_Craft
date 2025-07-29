package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.KujakuCanModel;
import com.kelco.kamenridercraft.client.models.PteraCanModel;
import com.kelco.kamenridercraft.entities.allies.KujakuCanEntity;
import com.kelco.kamenridercraft.entities.allies.PteraCanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PteraCanRenderer extends GeoEntityRenderer<PteraCanEntity> {


	public PteraCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PteraCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(PteraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/ptera_can.png");
    }

    @Override
    public void render(PteraCanEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}