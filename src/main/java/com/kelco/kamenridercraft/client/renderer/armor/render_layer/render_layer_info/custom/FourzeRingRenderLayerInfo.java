package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class FourzeRingRenderLayerInfo extends RenderLayerInfo {
    public FourzeRingRenderLayerInfo() {
        super("fourze_ring", "transforming/fourze_ring","fourze_ring_glowmask");
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.2F;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        GeoBone storm = model.getBone("spin").orElse(null);
        GeoBone henshin_ring = model.getBone("henshin_ring").orElse(null);
        if (storm != null) {
            double henshin_tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue()-partialTick;
            if (henshin_tick<10 ){henshin_tick=10;}
            storm.setRotY((entity.tickCount + partialTick)/2.5f);
            henshin_ring.setPosY((float)-henshin_tick+25);
        }
    }


    public float getScaleX() {
        return 1.5f;
    }

    public float getScaleY() {return 1.5f;}

    public float getScaleZ() {
        return 1.5f;
    }

    public float getX() {
        return 0f;
    }

    public float getY() {
        return -0.25f;
    }

    public float getZ() {
        return 0f;
    }


}