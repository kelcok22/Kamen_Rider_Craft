package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.GorillaCanModel;
import com.kelco.kamenridercraft.client.models.ToraCanModel;
import com.kelco.kamenridercraft.entities.allies.GorillaCanEntity;
import com.kelco.kamenridercraft.entities.allies.ToraCanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GorillaCanRenderer extends GeoEntityRenderer<GorillaCanEntity> {




	public GorillaCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GorillaCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GorillaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/gorilla_can.png");
    }

    @Override
    public void render(GorillaCanEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}