package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.TorikeraCanModel;
import com.kelco.kamenridercraft.entities.allies.TorikeraCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TorikeraCanRenderer extends GeoEntityRenderer<TorikeraCanEntity> {




	public TorikeraCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TorikeraCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation( TorikeraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tricera_can.png");
    }
}