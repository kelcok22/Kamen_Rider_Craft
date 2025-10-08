package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.TakaWatchroidModel;
import com.kelco.kamenridercraft.entities.allies.TakaWatchroidEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TakaWatchroidRenderer extends GeoEntityRenderer<TakaWatchroidEntity> {




	public TakaWatchroidRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TakaWatchroidModel());
    }

    @Override
    public ResourceLocation getTextureLocation(TakaWatchroidEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taka_watchroid.png");
    }
}