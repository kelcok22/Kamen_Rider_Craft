package com.kelco.kamenridercraft.client.renderer;

import com.google.common.collect.Maps;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.ElementaryInvesModel;
import com.kelco.kamenridercraft.entities.variants.InvesVariant;

import com.kelco.kamenridercraft.entities.footSoldiers.ElementaryInvesRedEntity;
import net.minecraft.Util;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;


public class ElementaryInvesRenderer  extends  HumanoidMobRenderer<ElementaryInvesRedEntity, ElementaryInvesModel<ElementaryInvesRedEntity>>  {
	private static final Map<InvesVariant, ResourceLocation> LOCATION_BY_VARIANT =
			Util.make(Maps.newEnumMap(InvesVariant.class), map -> {
				map.put(InvesVariant.RED,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/elementary_inves_red.png"));
				map.put(InvesVariant.BLUE,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/elementary_inves_blue.png"));
				map.put(InvesVariant.GREEN,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/elementary_inves_green.png"));
			});

	public ElementaryInvesRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}



	public ElementaryInvesRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new ElementaryInvesModel<>(ctx.bakeLayer(ElementaryInvesModel.LAYER_LOCATION)), 0.25f);

	}

	@Override
	public ResourceLocation getTextureLocation(ElementaryInvesRedEntity entity) {
		return LOCATION_BY_VARIANT.get(entity.getVariant());
	}
}