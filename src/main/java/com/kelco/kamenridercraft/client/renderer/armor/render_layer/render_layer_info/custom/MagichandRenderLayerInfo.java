package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class MagichandRenderLayerInfo extends RenderLayerInfo {
    public MagichandRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        model.getBone("bone").ifPresent(bone -> bone.setRotX(1 -
                ((entity.swingTime != 0) ? entity.swingTime + partialTick : entity.swingTime)));
        model.getBone("bone2").ifPresent(bone2 -> bone2.setRotX(-2 -
                ((entity.swingTime != 0) ? entity.swingTime + partialTick : entity.swingTime)));
        model.getBone("bone3").ifPresent(bone3 -> bone3.setRotX(-1 -
                ((entity.swingTime != 0) ? entity.swingTime + partialTick : entity.swingTime)));
        model.getBone("bone4").ifPresent(bone4 -> bone4.setRotY(entity.tickCount + partialTick));
    }
}