package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class MeteorBallLayerInfo extends RenderLayerInfo {
    public MeteorBallLayerInfo() {
        super(RenderType.breezeEyes(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/meteor_ball.png")), "meteor_ball");
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.2F;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        GeoBone storm = model.getBone("spin").orElse(null);
        if (storm != null) {
                storm.setRotZ((entity.tickCount + partialTick)/2.5f);
            storm.setRotY((entity.tickCount + partialTick)/2.5f);
            storm.setRotZ((entity.tickCount + partialTick)/2.5f);
        }
    }

    public RenderType getRenderType(float partialTick, LivingEntity livingEntity) {
        float f = (float) livingEntity.tickCount + partialTick;
        return RenderType.energySwirl(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/meteor_ball.png"), f, 0.0F);
    }

    public float getScaleX() {
        return 2f;
    }

    public float getScaleY() {return 2f;}

    public float getScaleZ() {
        return 2f;
    }

    public float getX() {
        return 0f;
    }

    public float getY() {
        return -0.6f;
    }

    public float getZ() {
        return 0f;
    }


}