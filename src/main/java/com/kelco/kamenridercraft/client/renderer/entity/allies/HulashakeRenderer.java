package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.HulashakeModel;
import com.kelco.kamenridercraft.client.model.entity.allies.PotechokinModel;
import com.kelco.kamenridercraft.entity.mobs.allies.HulashakeEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.PotechokinEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HulashakeRenderer extends GeoEntityRenderer<HulashakeEntity> {
    public HulashakeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HulashakeModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull HulashakeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/hulashake.png");
    }
}