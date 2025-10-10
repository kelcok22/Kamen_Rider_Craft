package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.ApolloModel;
import com.kelco.kamenridercraft.entities.summons.ApolloEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ApolloRenderer extends GeoEntityRenderer<ApolloEntity> {




	public ApolloRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ApolloModel());
    }

    @Override
    public ResourceLocation getTextureLocation(ApolloEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entity/apollo.png");
    }
}