package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class CoreRenderLayerInfo extends RenderLayerInfo {

    private final String Text;

    public CoreRenderLayerInfo(String text) {
        super(RenderType.breezeEyes(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/transforming/core_henshin.png")), "transforming/core_henshin");
        Text=text;
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.2F;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        double tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() - partialTick;

        GeoBone storm = model.getBone("storm").orElse(null);
        GeoBone legsSpin = model.getBone("ooo_legs_spin").orElse(null);

        if (storm != null) {
            storm.setRotY((entity.tickCount + partialTick) / 2.5f);
            storm.setHidden(false);
            storm.setScaleX((float) ((30 - tick) / 20));
            storm.setScaleY((float) ((30 - tick) / 20));
            storm.setScaleZ((float) ((30 - tick) / 20));
        }
            if (legsSpin != null) {
                legsSpin.setRotY(-(entity.tickCount + partialTick) / 3f);
                legsSpin.setHidden(false);
            }

    }

    public RenderType getRenderType(float partialTick, LivingEntity livingEntity) {
        float f = (float) livingEntity.tickCount + partialTick;
        return RenderType.breezeWind(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/transforming/"+Text+".png"), 0, 0.0F);
    }

    public float getScaleX() {
        return 1f;
    }

    public float getScaleY() {
        return 1f;
    }

    public float getScaleZ() {
        return 1f;
    }

    public float getX() {
        return 0f;
    }

    public float getY() {
        return 0.15f;
    }

    public float getZ() {
        return 0f;
    }


}