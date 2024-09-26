package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BasicMobModel;
import com.kelco.kamenridercraft.entities.FootSoldierModel;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;


public class BasicEntityRenderer  extends  HumanoidMobRenderer<BaseHenchmenEntity, BasicMobModel<BaseHenchmenEntity>>  {


	public BasicEntityRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	
	public BasicEntityRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new BasicMobModel<>(ctx.bakeLayer(ModelLayer)),1,1,1,1);
		this.addLayer(new HumanoidArmorLayer<>(this, new FootSoldierModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new FootSoldierModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

	}

	@Override
	public ResourceLocation getTextureLocation(BaseHenchmenEntity p_114482_) {
		
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/"+p_114482_.NAME+".png");
	}
}