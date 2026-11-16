package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class GaimArmsRenderLayerInfo extends RenderLayerInfo {
    public GaimArmsRenderLayerInfo(String texture, String model) {
        super("transforming/"+texture, "transforming/"+model);
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.2F;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        GeoBone bone = model.getBone("body").orElse(null);
        double henshin_tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() - partialTick;
        GeoBone peel_1 = model.getBone("peel_1").orElse(null);
        GeoBone peel_1_upper = model.getBone("peel_1_upper").orElse(null);
        GeoBone peel_2 = model.getBone("peel_2").orElse(null);
        GeoBone peel_2_upper = model.getBone("peel_2_upper").orElse(null);
        GeoBone peel_3 = model.getBone("peel_3").orElse(null);
        GeoBone peel_3_upper = model.getBone("peel_3_upper").orElse(null);
        GeoBone peel_4 = model.getBone("peel_4").orElse(null);
        GeoBone peel_4_upper = model.getBone("peel_4_upper").orElse(null);

        if (peel_1 != null && henshin_tick < 8) {
            peel_1.setRotZ(Mth.clamp(peel_1.getRotZ() + 10f * Mth.DEG_TO_RAD, 0, 140 * Mth.DEG_TO_RAD));
            if (peel_1_upper != null && henshin_tick < 4) {
                peel_1_upper.setRotZ(Mth.clamp(peel_1_upper.getRotZ() - 20f * Mth.DEG_TO_RAD, -150 * Mth.DEG_TO_RAD, 0));
            }
        } else if (peel_1 != null && henshin_tick >= 8) {
            peel_1.setRotZ(0);
            if (peel_1_upper != null) {
                peel_1_upper.setRotZ(0);
            }
        }

        if (peel_2 != null && henshin_tick < 8) {
            peel_2.setRotZ(Mth.clamp(peel_2.getRotZ() - 10f * Mth.DEG_TO_RAD, -140 * Mth.DEG_TO_RAD, 0));
            if (peel_2_upper != null && henshin_tick < 4) {
                peel_2_upper.setRotZ(Mth.clamp(peel_2_upper.getRotZ() + 20f * Mth.DEG_TO_RAD, 0, 150 * Mth.DEG_TO_RAD));
            }
        } else if (peel_2 != null && henshin_tick >= 8) {
            peel_2.setRotZ(0);
            if (peel_2_upper != null) {
                peel_2_upper.setRotZ(0);
            }
        }

        if (peel_3 != null && henshin_tick < 8) {
            peel_3.setRotX(Mth.clamp(peel_3.getRotX() + 10f * Mth.DEG_TO_RAD, 0, 180 * Mth.DEG_TO_RAD));
            if (peel_3_upper != null && henshin_tick < 6) {
                peel_3_upper.setRotX(Mth.clamp(peel_3_upper.getRotX() - 40f * Mth.DEG_TO_RAD, -145 * Mth.DEG_TO_RAD, 0));
            }
        } else if (peel_3 != null && henshin_tick >= 8) {
            peel_3.setRotX(0);
            if (peel_3_upper != null) {
                peel_3_upper.setRotX(0);
            }
        }

        if (peel_4 != null && henshin_tick < 8) {
            peel_4.setRotX(Mth.clamp(peel_4.getRotX() - 10f * Mth.DEG_TO_RAD, -155 * Mth.DEG_TO_RAD, 0));
            if (peel_4_upper != null && henshin_tick < 6) {
                peel_4_upper.setRotX(Mth.clamp(peel_4_upper.getRotX() + 20f * Mth.DEG_TO_RAD, 0, 125 * Mth.DEG_TO_RAD));
            }
        } else if (peel_4 != null && henshin_tick >= 8) {
            peel_4.setRotX(0);
            if (peel_4_upper != null) {
                peel_4_upper.setRotX(0);
            }
        }

        if (bone != null) {
            if (henshin_tick < 10) {
                henshin_tick = 10;
            }
            bone.setPosY((float) (henshin_tick - 10) * 3);
        }
    }


    public float getScaleX() {
        return 1f;
    }

    public float getScaleY() {
        return 1f;
    }

    public float getScaleZ() {
        return 1f;
    }

    public float getX() {
        return 0f;
    }

    public float getY() {
        return 0f;
    }

    public float getZ() {
        return 0f;
    }


}