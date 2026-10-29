package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class LevelOneRingRenderLayerInfo extends RenderLayerInfo {
    public LevelOneRingRenderLayerInfo(String core) {
        super(core, "transforming/lv1_ring",core);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {

        double tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue();

        GeoBone storm = model.getBone("spin").orElse(null);
        GeoBone reverse = model.getBone("reverse").orElse(null);
        GeoBone reverse2 = model.getBone("reverse2").orElse(null);
        GeoBone reverse3 = model.getBone("reverse3").orElse(null);
        GeoBone reverse4 = model.getBone("reverse4").orElse(null);
        GeoBone reverse5 = model.getBone("reverse5").orElse(null);
        GeoBone reverse6 = model.getBone("reverse6").orElse(null);
        if (tick >0) {
            if (storm != null) {
                storm.setRotY((entity.tickCount + partialTick) / 5f);
                storm.setHidden(false);
            }
            if (reverse != null) {
                reverse.setRotY(-((entity.tickCount + partialTick) / 5f));
                reverse.setHidden(false);
            }
            if (reverse2 != null) {
                reverse2.setRotY(-((entity.tickCount + partialTick) / 5f));
                reverse2.setHidden(false);
            }
            if (reverse3 != null) {
                reverse3.setRotY(-((entity.tickCount + partialTick) / 5f));
                reverse3.setHidden(false);
            }
            if (reverse4 != null) {
                reverse4.setRotY(-((entity.tickCount + partialTick) / 5f));
                reverse4.setHidden(false);
            }
            if (reverse5 != null) {
                reverse5.setRotY(-((entity.tickCount + partialTick) / 5f));
                reverse5.setHidden(false);
            }
            if (reverse6 != null) {
                reverse6.setRotY(-((entity.tickCount + partialTick) / 5f));
                reverse6.setHidden(false);
            }
        }
    }


    public float getScaleX() {
        return 1.5f;
    }

    public float getScaleY() {return 1.5f;}

    public float getScaleZ() {
        return 1.5f;
    }

    public float getX() {
        return 0f;
    }

    public float getY() {
        return -0.25f;
    }

    public float getZ() {
        return 0f;
    }


}