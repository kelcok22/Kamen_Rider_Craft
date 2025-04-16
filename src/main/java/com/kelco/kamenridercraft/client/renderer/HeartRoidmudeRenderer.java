package com.kelco.kamenridercraft.client.renderer;

import com.google.common.collect.Maps;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.BasicMobModel;
import com.kelco.kamenridercraft.client.models.ElementaryInvesModel;
import com.kelco.kamenridercraft.client.models.HeartRoidmudeModel;
import com.kelco.kamenridercraft.entities.FootSoldierModel;
import com.kelco.kamenridercraft.entities.bosses.HeartRoidmudeEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.ElementaryInvesRedEntity;
import com.kelco.kamenridercraft.entities.variants.InvesVariant;
import net.minecraft.Util;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;


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