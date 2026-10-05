package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.util.Color;


public class ScissorsRenderLayerInfo extends RenderLayerInfo {
    public ScissorsRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        GeoBone blade = model.getBone("blade").orElse(null);
        float swing_time = entity.swingTime;
        if (swing_time != 0) {
            swing_time = entity.swingTime + partialTick;
        }
        if (blade != null) {
            blade.setRotX((1 - (swing_time / 5)) / 2);
        }
    }
    public RenderType getRenderType(float partialTick, LivingEntity RIDER) {
        if (RiderDriverItem.isTransforming(RIDER))return RenderType.debugLineStrip(20);
        else return super.getRenderType(partialTick,RIDER);
    }

    public int getColor(float partialTick, LivingEntity RIDER) {
        if (RiderDriverItem.isTransforming(RIDER))return Color.YELLOW.getColor();
        else return Color.WHITE.getColor();
    }
}