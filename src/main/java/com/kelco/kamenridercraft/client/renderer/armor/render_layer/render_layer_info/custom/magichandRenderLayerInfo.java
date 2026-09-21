package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import java.util.Objects;


public class magichandRenderLayerInfo extends RenderLayerInfo {
    public magichandRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick) {
        GeoBone bone = model.getBone("bone").orElse(null);
         float swing_time = entity.swingTime;
         if (swing_time!=0) {
             swing_time = entity.swingTime + partialTick;
         }
        System.err.println(entity.swingTime);
        if (bone != null) {
            bone.setRotX(1-swing_time);
        }
        GeoBone bone2 = model.getBone("bone2").orElse(null);
        if (bone2 != null) {
            bone2.setRotX(-2-swing_time);
        }
        GeoBone bone3 = model.getBone("bone3").orElse(null);
        if (bone3 != null) {
            bone3.setRotX(-1-swing_time);
        }
        GeoBone bone4 = model.getBone("bone4").orElse(null);
        if (bone4 != null) {
            bone4.setRotY(entity.tickCount+partialTick);
        }
    }
}