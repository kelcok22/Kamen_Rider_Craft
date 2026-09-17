package com.kelco.kamenridercraft.client.renderer.entity;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.mob.BasicMobModel;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public class SummonedEntityRenderer extends HumanoidMobRenderer<BaseSummonEntity, BasicMobModel<BaseSummonEntity>> {
    public SummonedEntityRenderer(EntityRendererProvider.Context ctx) {
        this(ctx, ModelLayers.PLAYER);
    }

    public SummonedEntityRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
        super(ctx, new BasicMobModel<>(ctx.bakeLayer(ModelLayer)), 1, 1, 1, 1);
        this.addLayer(new HumanoidArmorLayer<>(this,
                new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));
    }

    @Override
    protected float getShadowRadius(@NotNull BaseSummonEntity baseSummonEntity) {
        return this.shadowRadius / 2;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(BaseSummonEntity baseSummonEntity) {
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/" + baseSummonEntity.NAME + ".png");
    }
}