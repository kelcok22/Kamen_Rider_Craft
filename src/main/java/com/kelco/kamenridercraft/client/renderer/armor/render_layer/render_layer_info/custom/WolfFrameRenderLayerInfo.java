package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;


public class WolfFrameRenderLayerInfo extends RenderLayerInfo {
    public WolfFrameRenderLayerInfo(String texture, String model) {
        super(texture, model);
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        model.getBone("muzzle").ifPresent(muzzle -> {
            muzzle.getChildBones().getFirst().setHidden(!isNighttime(entity));
            muzzle.getChildBones().getLast().setHidden(isNighttime(entity));
        });
    }

    private boolean isNighttime(LivingEntity entity){
        return entity.level().dayTime()%24000 > 13000 && entity.level().dayTime()%24000 < 23000;
    }
}