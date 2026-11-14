package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class GaimArmsRenderLayerInfo extends RenderLayerInfo {
    public GaimArmsRenderLayerInfo() {
        super("ferbus", "ferbus");
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.2F;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        GeoBone bone = model.getBone("body").orElse(null);
        if (bone!= null) {
            double henshin_tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue()-partialTick;
            if (henshin_tick<10 ){henshin_tick=10;}
            bone.setPosY((float)(henshin_tick-10)*3);
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