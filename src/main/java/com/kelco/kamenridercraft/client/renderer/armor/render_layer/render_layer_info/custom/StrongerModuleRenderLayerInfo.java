package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.util.Color;


public class StrongerModuleRenderLayerInfo extends ModuleRenderLayerInfo {
    public StrongerModuleRenderLayerInfo(String texture, String model, String glowmask) {
        super(texture, model, glowmask, Color.RED.getColor(),1);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        GeoBone blade = model.getBone("bone").orElse(null);
        float swing_time = entity.swingTime;
        if (blade != null) {
            blade.setRotX((entity.tickCount + partialTick)/2);
        }
    }
}