package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.NewMoleImaginSandModel;
import com.kelco.kamenridercraft.entities.footSoldiers.NewMoleImaginSandEntity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;


public class NewMoleImaginSandRenderer  extends  HumanoidMobRenderer<NewMoleImaginSandEntity, NewMoleImaginSandModel<NewMoleImaginSandEntity>>  {


	public NewMoleImaginSandRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	
	public NewMoleImaginSandRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new NewMoleImaginSandModel<>(ctx.bakeLayer(ModelLayer)),1,1,1,1);
		this.addLayer(new HumanoidArmorLayer<>(this, new NewMoleImaginSandModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new NewMoleImaginSandModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

	}


	@Override
	public ResourceLocation getTextureLocation(NewMoleImaginSandEntity p_114482_) {
		
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/"+p_114482_.NAME+".png");
	}
}