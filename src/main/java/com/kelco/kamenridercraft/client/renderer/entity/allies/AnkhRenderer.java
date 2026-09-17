package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.AnkhModel;
import com.kelco.kamenridercraft.entity.mobs.allies.AnkhEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AnkhRenderer extends GeoEntityRenderer<AnkhEntity> {
    public AnkhRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AnkhModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AnkhEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/ankh.png");
    }
}