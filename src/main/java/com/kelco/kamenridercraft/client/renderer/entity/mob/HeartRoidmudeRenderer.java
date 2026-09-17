package com.kelco.kamenridercraft.client.renderer.entity.mob;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.mob.HeartRoidmudeModel;
import com.kelco.kamenridercraft.entity.mobs.bosses.HeartRoidmudeEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class HeartRoidmudeRenderer extends HumanoidMobRenderer<HeartRoidmudeEntity, HeartRoidmudeModel<HeartRoidmudeEntity>> {
    public HeartRoidmudeRenderer(EntityRendererProvider.Context ctx) {
        this(ctx, ModelLayers.PLAYER);
    }

    public HeartRoidmudeRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
        super(ctx, new HeartRoidmudeModel<>(ctx.bakeLayer(HeartRoidmudeModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull HeartRoidmudeEntity heartRoidmudeEntity) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/heart_roidmude.png");
    }
}