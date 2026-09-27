package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class scissorsRenderLayerInfo extends RenderLayerInfo {

    public scissorsRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }
    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        GeoBone blade = model.getBone("blade").orElse(null);
        float swing_time = entity.swingTime;
        if (swing_time!=0) {
            swing_time = entity.swingTime + partialTick;
        }
        if (blade != null) {
            blade.setRotX((float) (1-(swing_time/5))/2);
        }
    }
}