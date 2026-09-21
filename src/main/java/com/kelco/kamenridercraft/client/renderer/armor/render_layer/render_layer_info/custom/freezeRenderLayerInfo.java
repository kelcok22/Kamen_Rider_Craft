package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import java.util.Objects;


public class freezeRenderLayerInfo extends RenderLayerInfo {

    public freezeRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }
    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick) {
        GeoBone door = model.getBone("door").orElse(null);
        if (door != null) {
            if(Objects.requireNonNull(entity.getAttribute(Attributes.WINGS_OUT)).getValue()!=0) door.setRotY(-2);
            else door.setRotY(0);
        }
    }
}