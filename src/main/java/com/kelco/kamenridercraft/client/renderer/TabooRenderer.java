package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.TabooModel;
import com.kelco.kamenridercraft.entities.bosses.TabooDopantEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TabooRenderer extends GeoEntityRenderer<TabooDopantEntity> {




	public TabooRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TabooModel());
    }

    @Override
    public ResourceLocation getTextureLocation(TabooDopantEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taboo_dopant.png");
    }
}