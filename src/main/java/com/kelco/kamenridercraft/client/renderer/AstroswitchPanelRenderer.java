package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.block.entity.AstroswitchPanelBlockEntity;
import com.kelco.kamenridercraft.entities.ChairEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class AstroswitchPanelRenderer implements BlockEntityRenderer<AstroswitchPanelBlockEntity> {
    public AstroswitchPanelRenderer(EntityRendererProvider.Context context) {
        super();
    }


    public ResourceLocation getTextureLocation(AstroswitchPanelBlockEntity AstroswitchPanelBlockEntity) {
        return null;
    }


    public boolean shouldRender(AstroswitchPanelBlockEntity chestEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public void render(AstroswitchPanelBlockEntity astroswitchPanelBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {

    }
}