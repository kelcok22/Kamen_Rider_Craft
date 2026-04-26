package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.MidaredoujiModel;
import com.kelco.kamenridercraft.entities.bosses.MidaredoujiEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;


public class MidaredoujiRenderer extends  HumanoidMobRenderer<MidaredoujiEntity, MidaredoujiModel<MidaredoujiEntity>>  {

	public MidaredoujiRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	@Override
	public ResourceLocation getTextureLocation(MidaredoujiEntity MidaredoujiEntity) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/midaredouji.png");
	}

	public MidaredoujiRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new MidaredoujiModel<>(ctx.bakeLayer(MidaredoujiModel.LAYER_LOCATION)), 0.25f);
	}


}