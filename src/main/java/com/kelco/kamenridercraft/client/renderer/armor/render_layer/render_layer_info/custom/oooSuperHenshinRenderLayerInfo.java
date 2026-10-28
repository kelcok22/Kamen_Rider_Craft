package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class oooSuperHenshinRenderLayerInfo extends RenderLayerInfo {
    public oooSuperHenshinRenderLayerInfo(String core) {
        super(core, "transforming/ooo_henshin_super",core);
    }


    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {

        double tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue();

        GeoBone headSpin = model.getBone("ooo_head_spin").orElse(null);
        GeoBone torsoSpin = model.getBone("ooo_torso_spin").orElse(null);
        GeoBone legsSpin = model.getBone("ooo_legs_spin").orElse(null);
        GeoBone logo = model.getBone("logo").orElse(null);
        if (tick >7) {
            if (headSpin != null) {
                headSpin.setRotX(-(entity.tickCount + partialTick) / 2.5f);
                headSpin.setHidden(false);
            }
            if (torsoSpin != null) {
                torsoSpin.setRotY((entity.tickCount + partialTick) / 2.5f);
                torsoSpin.setHidden(false);
            }
            if (legsSpin != null) {
                legsSpin.setRotY(-(entity.tickCount + partialTick) / 2.5f);
                legsSpin.setHidden(false);
            }
            if (logo != null) {
                logo.setHidden(true);
                logo.setPosZ(0);
            }
        }else {
            if (headSpin != null) {
                headSpin.setHidden(true);
            }
            if (torsoSpin != null) {
                torsoSpin.setHidden(true);
            }
            if (legsSpin != null) {
                legsSpin.setHidden(true);
            }
            if (logo != null) {
                logo.setHidden(false);
                logo.setPosZ((float) (20-tick+partialTick));
            }

        }

    }

    public float getScaleX() {
        return 1f;
    }

    public float getScaleY() {return 1f;}

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