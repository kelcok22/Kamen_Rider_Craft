package com.kelco.kamenridercraft.client.renderer.entity;

import com.kelco.kamenridercraft.entity.misc_entity.ChairEntity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public class ChairRenderer extends EntityRenderer<ChairEntity> {
    public ChairRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull ChairEntity chairEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(@NotNull ChairEntity chairEntity, @NotNull Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}