package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class magnetCannonRenderLayerInfo extends RenderLayerInfo {

    public magnetCannonRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }
    public void ApplyMovement(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick) {
        GeoBone cannonRight = model.getBone("cannonRight").orElse(null);
        if (cannonRight != null) {
            cannonRight.setRotX((float) entity.getLookAngle().y);
        }
        GeoBone cannonLeft = model.getBone("cannonLeft").orElse(null);
        if (cannonLeft != null) {
            cannonLeft.setRotX((float) entity.getLookAngle().y);
        }
    }
}