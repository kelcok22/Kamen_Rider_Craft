package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.ToraCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.ToraCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ToraCanRenderer extends GeoEntityRenderer<ToraCanEntity> {
    public ToraCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ToraCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ToraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tora_can.png");
    }
}