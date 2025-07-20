package com.kelco.kamenridercraft.client.renderer;

import com.google.common.collect.Maps;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BasicMobModel;
import com.kelco.kamenridercraft.entities.footSoldiers.AgentEntity;
import com.kelco.kamenridercraft.entities.variants.AgentVariant;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;


public class AgentRenderer extends  HumanoidMobRenderer<AgentEntity, BasicMobModel<AgentEntity>>  {
	private static final Map<AgentVariant, ResourceLocation> LOCATION_BY_VARIANT =
			Util.make(Maps.newEnumMap(AgentVariant.class), map -> {
				map.put(AgentVariant.WHITE_A,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/agent_white_a.png"));
				map.put(AgentVariant.WHITE_B,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/agent_white_b.png"));
				map.put(AgentVariant.BLUE_A,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/agent_blue_a.png"));
				map.put(AgentVariant.BLUE_B,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/agent_blue_b.png"));
				map.put(AgentVariant.ORANGE_A,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/agent_orange_a.png"));
				map.put(AgentVariant.ORANGE_B,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/agent_orange_b.png"));
				map.put(AgentVariant.PINK_A,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/agent_pink_a.png"));
				map.put(AgentVariant.PINK_B,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/agent_pink_b.png"));
			});


	public AgentRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	public AgentRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new BasicMobModel<>(ctx.bakeLayer(ModelLayer)),1,1,1,1);
		this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

	}
		@Override
	public ResourceLocation getTextureLocation(AgentEntity entity) {
		return LOCATION_BY_VARIANT.get(entity.getVariant());
	}
}