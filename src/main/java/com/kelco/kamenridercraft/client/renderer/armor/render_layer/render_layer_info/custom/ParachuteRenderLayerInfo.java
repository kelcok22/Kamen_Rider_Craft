package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;


public class ParachuteRenderLayerInfo extends RenderLayerInfo {
    public ParachuteRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        model.getBone("parachute").ifPresent(parachute -> parachute.setHidden(showParachute(entity)));
    }

    private boolean showParachute(LivingEntity entity){
        if (entity.isInWater())return true;
        return !(entity.fallDistance > 0);
    }
}