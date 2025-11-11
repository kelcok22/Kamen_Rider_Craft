package com.kelco.kamenridercraft.client.renderer;

import com.google.common.collect.Maps;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BasicMobModel;
import com.kelco.kamenridercraft.entities.footSoldiers.MalgamEntity;
import com.kelco.kamenridercraft.entities.variants.MalgamVariant;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;


public class MalgamRenderer extends  HumanoidMobRenderer<MalgamEntity, BasicMobModel<MalgamEntity>>  {
	private static final Map<MalgamVariant, ResourceLocation> LOCATION_BY_VARIANT =
			Util.make(Maps.newEnumMap(MalgamVariant.class), map -> {
				map.put(MalgamVariant.MANTIS,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/malgam_mantis.png"));
				map.put(MalgamVariant.SKATEBOARD,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/malgam_skateboard.png"));
				map.put(MalgamVariant.POISONOUS_MUSHROOM,
						ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/malgam_poisonous_mushroom.png"));
			});


	public MalgamRenderer(EntityRendererProvider.Context ctx) {
		this(ctx, ModelLayers.PLAYER);
	}

	public MalgamRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
		super(ctx, new BasicMobModel<>(ctx.bakeLayer(ModelLayer)),1,1,1,1);
		this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

	}
		@Override
	public ResourceLocation getTextureLocation(MalgamEntity entity) {
		return LOCATION_BY_VARIANT.get(entity.getVariant());
	}
}