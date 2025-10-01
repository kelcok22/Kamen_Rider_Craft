package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.ToraCanModel;
import com.kelco.kamenridercraft.entities.allies.ToraCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ToraCanRenderer extends GeoEntityRenderer<ToraCanEntity> {




	public ToraCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ToraCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ToraCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tora_can.png");
    }
}