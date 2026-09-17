package com.kelco.kamenridercraft.client.renderer.entity.allies;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.mob.ApolloModel;
import com.kelco.kamenridercraft.entity.mobs.summons.ApolloEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ApolloRenderer extends GeoEntityRenderer<ApolloEntity> {
    public ApolloRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ApolloModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ApolloEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/apollo.png");
    }
}