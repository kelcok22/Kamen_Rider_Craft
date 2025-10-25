package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.DoggaModel;
import com.kelco.kamenridercraft.entities.allies.DoggaEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;


public class DoggaRenderer extends  HumanoidMobRenderer<DoggaEntity, DoggaModel<DoggaEntity>>  {

    public DoggaRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	public DoggaRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new DoggaModel<>(ctx.bakeLayer(DoggaModel.LAYER_LOCATION)), 0.25f);
	}

	@Override
	public ResourceLocation getTextureLocation(DoggaEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/dogga.png");
	}
}