package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.util.Color;


public class MagnetCannonRenderLayerInfo extends RenderLayerInfo {
    public MagnetCannonRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        model.getBone("cannonRight").ifPresent(cannonRight -> cannonRight.setRotX((float) entity.getLookAngle().y));
        model.getBone("cannonLeft").ifPresent(cannonLeft -> cannonLeft.setRotX((float) entity.getLookAngle().y));
    }
}