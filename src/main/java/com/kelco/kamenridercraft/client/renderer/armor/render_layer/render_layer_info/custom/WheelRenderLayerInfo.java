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
import software.bernie.geckolib.util.Color;


public class WheelRenderLayerInfo extends ModuleRenderLayerInfo {

    public WheelRenderLayerInfo(String texture, String model) {
        super(texture, model, Color.CYAN.getColor(),3);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        GeoBone wheels = model.getBone("wheels").orElse(null);
        if (wheels!= null) {
            double GetWheelOld = entity.getAttribute(KRCAttributes.WHEEL_ROT_OLD).getBaseValue();
            double GetWheel = entity.getAttribute(KRCAttributes.WHEEL_ROT).getBaseValue();
            float wheel = (float) Mth.lerp(partialTick, GetWheelOld, GetWheel);
          wheels.setRotX(wheel);
        }
    }
}