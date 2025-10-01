package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.GorillaCanModel;
import com.kelco.kamenridercraft.entities.allies.GorillaCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GorillaCanRenderer extends GeoEntityRenderer<GorillaCanEntity> {




	public GorillaCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GorillaCanModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GorillaCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/gorilla_can.png");
    }
}