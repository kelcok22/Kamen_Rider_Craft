package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.DenkiunagiCanModel;
import com.kelco.kamenridercraft.entities.allies.DenkiunagiCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DenkiunagiCanRenderer extends GeoEntityRenderer<DenkiunagiCanEntity> {




	public DenkiunagiCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DenkiunagiCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(DenkiunagiCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/unagi_can.png");
    }
}