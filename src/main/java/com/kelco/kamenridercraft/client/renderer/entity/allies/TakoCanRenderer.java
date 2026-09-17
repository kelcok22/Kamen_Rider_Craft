package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.TakoCanModel;
import com.kelco.kamenridercraft.entity.mobs.allies.TakoCanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TakoCanRenderer extends GeoEntityRenderer<TakoCanEntity> {
    public TakoCanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TakoCanModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TakoCanEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/tako_can.png");
    }
}