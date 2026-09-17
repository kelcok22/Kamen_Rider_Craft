package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.BattaCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.BattaCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BattaCanRenderer extends GeoEntityRenderer<BattaCanEntity> {
    public BattaCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BattaCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BattaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/batta_can.png");
    }
}