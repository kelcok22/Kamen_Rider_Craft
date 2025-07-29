package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.KujakuCanModel;
import com.kelco.kamenridercraft.client.models.TorikeraCanModel;
import com.kelco.kamenridercraft.entities.allies.KujakuCanEntity;
import com.kelco.kamenridercraft.entities.allies.TakaCanEntity;
import com.kelco.kamenridercraft.entities.allies.TorikeraCanEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KujakuCanRenderer extends GeoEntityRenderer<KujakuCanEntity> {


	public KujakuCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KujakuCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(KujakuCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/kujaku_can.png");
    }

    @Override
    public void render(KujakuCanEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}