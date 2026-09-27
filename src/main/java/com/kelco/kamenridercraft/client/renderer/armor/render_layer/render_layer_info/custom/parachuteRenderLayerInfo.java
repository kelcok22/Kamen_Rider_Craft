package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import java.util.Objects;


public class parachuteRenderLayerInfo extends RenderLayerInfo {

    public parachuteRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }
    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        GeoBone parachute = model.getBone("parachute").orElse(null);
        if (parachute != null) {
            parachute.setHidden(!(entity.fallDistance>0));
        }
    }
}