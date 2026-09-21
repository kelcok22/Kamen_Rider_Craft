package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;

import java.util.Objects;


public class gyroRenderLayerInfo extends RenderLayerInfo {
    private final String texture;

    public gyroRenderLayerInfo(String texture, String model) {
        super(texture, model);
        this.texture = texture;
    }

    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick) {
        GeoBone blade = model.getBone("blade").orElse(null);
        if (blade != null) {
            if(Objects.requireNonNull(entity.getAttribute(Attributes.WINGS_OUT)).getValue()!=0)blade.setRotY(entity.tickCount+partialTick);
            else blade.setRotY(0);
        }
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.02F;
    }
}