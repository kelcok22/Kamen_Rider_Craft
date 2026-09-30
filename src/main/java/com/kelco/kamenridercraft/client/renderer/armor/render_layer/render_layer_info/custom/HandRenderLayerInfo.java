package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class HandRenderLayerInfo extends RenderLayerInfo {
    public HandRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        GeoBone bone = model.getBone("arm").orElse(null);
        if (bone != null) {
            float swing_time = entity.swingTime;
            if (swing_time != 0 & swing_time != 5) {
                swing_time = (swing_time + partialTick) - 2;
            } else if (swing_time != 0) {
                swing_time = Mth.lerp(partialTick, 3, 0);
            }
            bone.setRotX(-swing_time / 3);
            bone.setRotY(swing_time / 5);
/**
            GeoBone hand = model.getBone("hand").orElse(null);
            if (hand != null) {
                ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
                ItemStack stack2 = new ItemStack(GavvRiderItems.POPPINGUMMY_GOCHIZO.get());
                poseStack.pushPose();
                itemRenderer.getModel(stack2,entity.level(),entity,1);
                poseStack.translate(-hand.getLocalPosition().x,-hand.getLocalPosition().y, -hand.getLocalPosition().z);
                poseStack.scale(0.25f, 0.25f, 0.25f);

                itemRenderer.renderStatic(stack2, ItemDisplayContext.HEAD, packedLight, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, entity.level(), 1);

                poseStack.popPose();

            }
 **/
        }
    }
}