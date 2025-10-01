package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.PteraCanModel;
import com.kelco.kamenridercraft.entities.allies.PteraCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PteraCanRenderer extends GeoEntityRenderer<PteraCanEntity> {


	public PteraCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PteraCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(PteraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/ptera_can.png");
    }
}