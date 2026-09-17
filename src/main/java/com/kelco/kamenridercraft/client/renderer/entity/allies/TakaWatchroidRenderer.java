package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.TakaWatchroidModel;
import com.kelco.kamenridercraft.entity.mobs.allies.TakaWatchroidEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TakaWatchroidRenderer extends GeoEntityRenderer<TakaWatchroidEntity> {
    public TakaWatchroidRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TakaWatchroidModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TakaWatchroidEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taka_watchroid.png");
    }
}