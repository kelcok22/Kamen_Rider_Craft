package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.HeartRoidmudeModel;
import com.kelco.kamenridercraft.entities.bosses.HeartRoidmudeEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;


public class HeartRoidmudeRenderer extends  HumanoidMobRenderer<HeartRoidmudeEntity, HeartRoidmudeModel<HeartRoidmudeEntity>>  {

	public HeartRoidmudeRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	@Override
	public ResourceLocation getTextureLocation(HeartRoidmudeEntity heartRoidmudeEntity) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/heart_roidmude.png");
	}

	public HeartRoidmudeRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new HeartRoidmudeModel<>(ctx.bakeLayer(HeartRoidmudeModel.LAYER_LOCATION)), 0.25f);
	}


}