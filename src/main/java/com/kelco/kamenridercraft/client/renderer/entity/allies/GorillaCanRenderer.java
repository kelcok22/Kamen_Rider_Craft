package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.GorillaCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.GorillaCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GorillaCanRenderer extends GeoEntityRenderer<GorillaCanEntity> {
    public GorillaCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GorillaCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull GorillaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/gorilla_can.png");
    }
}