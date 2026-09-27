package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class handRenderLayerInfo extends RenderLayerInfo {

    public handRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource bufferSource) {

        GeoBone bone = model.getBone("arm").orElse(null);
        if (bone != null) {

            /**
            GeoBone hand = model.getBone("hand").orElse(null);
            if (hand != null) {
                ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
                ItemStack stack2 = new ItemStack(Items.IRON_AXE);
                poseStack.pushPose();
                poseStack.translate(hand.getLocalPosition().x,hand.getLocalPosition().y,hand.getLocalPosition().z);
                poseStack.scale(0.8f, 0.8f, 0.8f);
                poseStack.mulPose(Axis.YP.rotationDegrees(hand.getRotY()));
                poseStack.mulPose(Axis.ZP.rotationDegrees(hand.getRotZ()));
                poseStack.mulPose(Axis.XP.rotationDegrees(hand.getRotX()));

                itemRenderer.renderStatic(stack2, ItemDisplayContext.FIXED, packedLight, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, entity.level(), 1);
                poseStack.popPose();

            }
            **/
                float swing_time = entity.swingTime;
                System.err.println(swing_time);
                if (swing_time != 0 & swing_time != 5) {
                    swing_time = (swing_time + partialTick) - 2;
                } else if (swing_time != 0) {
                    double GetROld = bone.getRotX();
                    swing_time = (float) Mth.lerp(partialTick, 3, 0);
                }
                bone.setRotX(-swing_time / 3);
                bone.setRotY(swing_time / 5);
            }
        }
}