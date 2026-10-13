package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.HoruwankovModel;
import com.kelco.kamenridercraft.client.model.entity.allies.SoftonyaModel;
import com.kelco.kamenridercraft.entity.mobs.allies.HoruwankovEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.SoftonyaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SoftonyaRenderer extends GeoEntityRenderer<SoftonyaEntity> {
    public SoftonyaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SoftonyaModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SoftonyaEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/softonya.png");
    }
}