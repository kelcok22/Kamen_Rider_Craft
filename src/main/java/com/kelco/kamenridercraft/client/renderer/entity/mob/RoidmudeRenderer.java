package com.kelco.kamenridercraft.client.renderer.entity.mob;

import com.google.common.collect.Maps;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.entity.mob.BasicMobModel;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.RoidmudeEntity;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.variants.RoidmudeVariant;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public class RoidmudeRenderer extends HumanoidMobRenderer<RoidmudeEntity, BasicMobModel<RoidmudeEntity>> {
    private static final Map<RoidmudeVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RoidmudeVariant.class), map -> {
                map.put(RoidmudeVariant.COBRA,
                        ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/cobra_roidmude.png"));
                map.put(RoidmudeVariant.BAT,
                        ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/bat_roidmude.png"));
                map.put(RoidmudeVariant.SPIDER,
                        ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/entities/spider_roidmude.png"));
            });

    public RoidmudeRenderer(EntityRendererProvider.Context ctx) {
        this(ctx, ModelLayers.PLAYER);
    }

    public RoidmudeRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
        super(ctx, new BasicMobModel<>(ctx.bakeLayer(ModelLayer)), 1, 1, 1, 1);
        addLayer(new HumanoidArmorLayer<>(this,
                new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(RoidmudeEntity roidmudeEntity) {
        return LOCATION_BY_VARIANT.get(roidmudeEntity.getVariant());
    }
}