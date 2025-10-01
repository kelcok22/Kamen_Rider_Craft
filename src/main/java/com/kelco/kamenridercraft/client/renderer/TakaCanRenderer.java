package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.TakaCanModel;
import com.kelco.kamenridercraft.entities.allies.TakaCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TakaCanRenderer extends GeoEntityRenderer<TakaCanEntity> {




	public TakaCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TakaCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(TakaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taka_can.png");
    }
}