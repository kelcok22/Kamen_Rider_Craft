package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.AnkhModel;
import com.kelco.kamenridercraft.entities.allies.AnkhEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AnkhRenderer extends GeoEntityRenderer<AnkhEntity> {
	
	


	public AnkhRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnkhModel());
    }

    @Override
    public ResourceLocation getTextureLocation(AnkhEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/ankh.png");
    }
}