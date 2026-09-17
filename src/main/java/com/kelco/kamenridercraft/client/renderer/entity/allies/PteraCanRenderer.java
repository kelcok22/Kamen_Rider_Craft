package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.PteraCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.PteraCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PteraCanRenderer extends GeoEntityRenderer<PteraCanEntity> {
    public PteraCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PteraCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PteraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/ptera_can.png");
    }
}