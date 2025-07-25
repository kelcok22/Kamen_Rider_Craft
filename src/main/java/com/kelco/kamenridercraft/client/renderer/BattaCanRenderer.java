package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BattaCanModel;
import com.kelco.kamenridercraft.client.models.TakaCanModel;
import com.kelco.kamenridercraft.entities.allies.BattaCanEntity;
import com.kelco.kamenridercraft.entities.allies.TakaCanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BattaCanRenderer extends GeoEntityRenderer<BattaCanEntity> {




	public BattaCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BattaCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(BattaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/batta_can.png");
    }

    @Override
    public void render(BattaCanEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}