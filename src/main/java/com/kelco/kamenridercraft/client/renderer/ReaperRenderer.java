package com.kelco.kamenridercraft.client.renderer;

import com.google.common.collect.Maps;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BasicMobModel;
import com.kelco.kamenridercraft.entities.footSoldiers.ReaperlegionEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.RoidmudeEntity;
import com.kelco.kamenridercraft.entities.variants.ReaperVariant;
import com.kelco.kamenridercraft.entities.variants.RoidmudeVariant;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;


public class ReaperRenderer extends  HumanoidMobRenderer<ReaperlegionEntity, BasicMobModel<ReaperlegionEntity>>  {
	private static final Map<ReaperVariant, ResourceLocation> LOCATION_BY_VARIANT =
			Util.make(Maps.newEnumMap(ReaperVariant.class), map -> {
				map.put(ReaperVariant.COBRA,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/cobra_roidmude_reaper_legion.png"));
				map.put(ReaperVariant.BAT,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/bat_roidmude_reaper_legion.png"));
				map.put(ReaperVariant.SPIDER,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/spider_roidmude_reaper_legion.png"));
			});


	public ReaperRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	public ReaperRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new BasicMobModel<>(ctx.bakeLayer(ModelLayer)),1,1,1,1);
		this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

	}
		@Override
	public ResourceLocation getTextureLocation(ReaperlegionEntity entity) {
		return LOCATION_BY_VARIANT.get(entity.getVariant());
	}
}