package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.TakaCanModel;
import com.kelco.kamenridercraft.client.models.TakoCanModel;
import com.kelco.kamenridercraft.entities.allies.TakaCanEntity;
import com.kelco.kamenridercraft.entities.allies.TakoCanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TakoCanRenderer extends GeoEntityRenderer<TakoCanEntity> {




	public TakoCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TakoCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(TakoCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tako_can.png");
    }

    @Override
    public void render(TakoCanEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}