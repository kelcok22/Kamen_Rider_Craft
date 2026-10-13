package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.NuggegyroikaModel;
import com.kelco.kamenridercraft.client.model.entity.allies.SoftonyaModel;
import com.kelco.kamenridercraft.entity.mobs.allies.NuggegyroikaEntity;
import com.kelco.kamenridercraft.entity.mobs.allies.SoftonyaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class NuggegyroikaRenderer extends GeoEntityRenderer<NuggegyroikaEntity> {
    public NuggegyroikaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NuggegyroikaModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull NuggegyroikaEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/nuggegyroika.png");
    }
}