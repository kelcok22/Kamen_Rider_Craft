package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.HoruwankovModel;
import com.kelco.kamenridercraft.client.model.entity.allies.HulashakeModel;
import com.kelco.kamenridercraft.entity.mobs.allies.HoruwankovEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.HulashakeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HoruwankovRenderer extends GeoEntityRenderer<HoruwankovEntity> {
    public HoruwankovRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HoruwankovModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull HoruwankovEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/horuwankov.png");
    }
}