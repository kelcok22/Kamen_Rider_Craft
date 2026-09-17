package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.DenkiunagiCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.DenkiunagiCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DenkiunagiCanRenderer extends GeoEntityRenderer<DenkiunagiCanEntity> {
    public DenkiunagiCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DenkiunagiCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DenkiunagiCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/unagi_can.png");
    }
}