package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.LibraModel;
import com.kelco.kamenridercraft.entity.mobs.summons.LibraEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LibraRenderer extends GeoEntityRenderer<LibraEntity> {
    public LibraRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LibraModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LibraEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/libra.png");
    }
}