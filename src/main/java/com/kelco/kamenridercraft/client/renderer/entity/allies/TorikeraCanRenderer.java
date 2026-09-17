package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.TorikeraCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.TorikeraCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TorikeraCanRenderer extends GeoEntityRenderer<TorikeraCanEntity> {
    public TorikeraCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TorikeraCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TorikeraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tricera_can.png");
    }
}