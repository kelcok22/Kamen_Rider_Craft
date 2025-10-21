package com.kelco.kamenridercraft.client.renderer;

import com.google.common.collect.Maps;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BasicMobModel;
import com.kelco.kamenridercraft.entities.footSoldiers.MakamouNinjaGroupEntity;
import com.kelco.kamenridercraft.entities.variants.MakamouNinjaGroupVariant;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;


public class MakamouNinjaGroupRenderer extends  HumanoidMobRenderer<MakamouNinjaGroupEntity, BasicMobModel<MakamouNinjaGroupEntity>>  {
	private static final Map<MakamouNinjaGroupVariant, ResourceLocation> LOCATION_BY_VARIANT =
			Util.make(Maps.newEnumMap(MakamouNinjaGroupVariant.class), map -> {
				map.put(MakamouNinjaGroupVariant.BENIGITSUNE,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/benigitsune.png"));
				map.put(MakamouNinjaGroupVariant.BYAKKO,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/byakko.png"));
			});


	public MakamouNinjaGroupRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	public MakamouNinjaGroupRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new BasicMobModel<>(ctx.bakeLayer(ModelLayer)),1,1,1,1);
		this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

	}
		@Override
	public ResourceLocation getTextureLocation(MakamouNinjaGroupEntity entity) {
		return LOCATION_BY_VARIANT.get(entity.getVariant());
	}
}