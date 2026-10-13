package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.BattaCanModel;
import com.kelco.kamenridercraft.client.model.entity.allies.BurgermealModel;
import com.kelco.kamenridercraft.entity.mobs.allies.BattaCanEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.BurgermealEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BurgermealRenderer extends GeoEntityRenderer<BurgermealEntity> {
    public BurgermealRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BurgermealModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BurgermealEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/burgermeal.png");
    }
}