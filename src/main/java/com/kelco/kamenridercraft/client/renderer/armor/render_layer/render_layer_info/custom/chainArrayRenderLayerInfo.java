package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class chainArrayRenderLayerInfo extends RenderLayerInfo {

    public chainArrayRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }
    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource bufferSource) {
        GeoBone bone = model.getBone("bone").orElse(null);
        if (bone != null) {
        float swing_time = entity.swingTime;
            System.err.println(swing_time);
        if (swing_time!=0&swing_time!=5) {
            swing_time = (swing_time+partialTick)-2;
        }else if (swing_time!=0) {
                double GetROld = bone.getRotX();
                swing_time = (float) Mth.lerp(partialTick, 3, 0);
            }
            bone.setRotX(swing_time / 3);
            bone.setRotY(swing_time / 5);
        }
    }
}