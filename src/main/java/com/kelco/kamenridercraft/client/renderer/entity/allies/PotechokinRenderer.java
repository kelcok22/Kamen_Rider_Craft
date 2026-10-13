package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.BurgermealModel;
import com.kelco.kamenridercraft.client.model.entity.allies.PotechokinModel;
import com.kelco.kamenridercraft.entity.mobs.allies.BurgermealEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.PotechokinEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PotechokinRenderer extends GeoEntityRenderer<PotechokinEntity> {
    public PotechokinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PotechokinModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PotechokinEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/potechokin.png");
    }
}