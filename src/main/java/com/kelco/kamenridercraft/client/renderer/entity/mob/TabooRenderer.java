package com.kelco.kamenridercraft.client.renderer.entity.mob;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.mob.TabooModel;
import com.kelco.kamenridercraft.entity.mobs.bosses.TabooDopantEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TabooRenderer extends GeoEntityRenderer<TabooDopantEntity> {
    public TabooRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TabooModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TabooDopantEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/taboo_dopant.png");
    }
}