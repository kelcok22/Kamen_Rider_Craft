package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BasicMobModel;
import com.kelco.kamenridercraft.client.models.ElementaryInvesModel;
import com.kelco.kamenridercraft.entities.FootSoldierModel;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;

import com.kelco.kamenridercraft.entities.footSoldiers.ElementaryInvesRedEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;


public class ElementaryInvesRenderer  extends  HumanoidMobRenderer<ElementaryInvesRedEntity, ElementaryInvesModel<ElementaryInvesRedEntity>>  {


	public ElementaryInvesRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}



	public ElementaryInvesRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new ElementaryInvesModel<>(ctx.bakeLayer(ModelLayer)),1,1,1,1);
		this.addLayer(new HumanoidArmorLayer<>(this, new ElementaryInvesModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new ElementaryInvesModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

	}

	@Override
	public ResourceLocation getTextureLocation(ElementaryInvesRedEntity p_114482_) {

		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/"+p_114482_.NAME+".png");
	}
}