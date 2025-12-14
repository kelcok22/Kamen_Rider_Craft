package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.MetamateriamModel;
import com.kelco.kamenridercraft.client.renderer.layers.MetamateriamEyesLayer;
import com.kelco.kamenridercraft.entities.summons.TechnolomProjectionEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;


public class MetamateriamRenderer extends  HumanoidMobRenderer<TechnolomProjectionEntity, MetamateriamModel<TechnolomProjectionEntity>>  {

	public MetamateriamRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
		this.addLayer(new MetamateriamEyesLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(TechnolomProjectionEntity technolomProjectionEntity) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/technolom_projection.png");
	}

	public MetamateriamRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new MetamateriamModel<>(ctx.bakeLayer(MetamateriamModel.LAYER_LOCATION)), 0.25f);
	}


}