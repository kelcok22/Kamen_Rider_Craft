package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.LibraModel;
import com.kelco.kamenridercraft.entities.summons.LibraEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LibraRenderer extends GeoEntityRenderer<LibraEntity> {




	public LibraRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LibraModel());
    }

    @Override
    public ResourceLocation getTextureLocation(LibraEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/libra.png");
    }
}