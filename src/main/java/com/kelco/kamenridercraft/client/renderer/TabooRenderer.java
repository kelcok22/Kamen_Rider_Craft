package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BattaCanModel;
import com.kelco.kamenridercraft.client.models.TabooModel;
import com.kelco.kamenridercraft.entities.allies.BattaCanEntity;
import com.kelco.kamenridercraft.entities.bosses.TabooDopantEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TabooRenderer extends GeoEntityRenderer<TabooDopantEntity> {




	public TabooRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TabooModel());
    }

    @Override
    public ResourceLocation getTextureLocation(TabooDopantEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taboo_dopant.png");
    }

    @Override
    public void render(TabooDopantEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}