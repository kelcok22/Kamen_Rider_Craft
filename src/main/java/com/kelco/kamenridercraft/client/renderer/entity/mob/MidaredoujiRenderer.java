package com.kelco.kamenridercraft.client.renderer.entity.mob;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.allies.MidaredoujiModel;
import com.kelco.kamenridercraft.entity.mobs.bosses.MidaredoujiEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public class MidaredoujiRenderer extends HumanoidMobRenderer<MidaredoujiEntity, MidaredoujiModel<MidaredoujiEntity>> {
    public MidaredoujiRenderer(EntityRendererProvider.Context ctx) {
        this(ctx, ModelLayers.PLAYER);
    }

    public MidaredoujiRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
        super(ctx, new MidaredoujiModel<>(ctx.bakeLayer(MidaredoujiModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MidaredoujiEntity MidaredoujiEntity) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/midaredouji.png");
    }
}