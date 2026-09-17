package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.TakaCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.TakaCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TakaCanRenderer extends GeoEntityRenderer<TakaCanEntity> {
    public TakaCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TakaCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TakaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taka_can.png");
    }
}