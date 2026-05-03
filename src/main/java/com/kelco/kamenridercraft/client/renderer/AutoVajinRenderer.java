package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.AutoVajinModel;
import com.kelco.kamenridercraft.entity.mobs.allies.AutoVajinRoboEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AutoVajinRenderer extends GeoEntityRenderer<AutoVajinRoboEntity> {


	public AutoVajinRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AutoVajinModel());
	}

	@Override
	public ResourceLocation getTextureLocation(AutoVajinRoboEntity animatable) {
		return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/auto_vajin.png");
	}
}