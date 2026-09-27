package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.item.heisei_phase_1.AgitoRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.FaizRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.faiz.FaizAxelItem;
import com.kelco.kamenridercraft.item.reiwa.GavvRiderItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class handRenderLayerInfo extends RenderLayerInfo {

    public handRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {

        GeoBone bone = model.getBone("arm").orElse(null);
        if (bone != null) {
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