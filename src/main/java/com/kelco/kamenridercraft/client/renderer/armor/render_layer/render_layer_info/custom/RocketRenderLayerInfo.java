package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class RocketRenderLayerInfo extends ModuleRenderLayerInfo{
    public RocketRenderLayerInfo(String texture, String model) {
        super(texture, model,0xff87816,1);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        GeoBone bone = model.getBone("bone").orElse(null);
    }
}