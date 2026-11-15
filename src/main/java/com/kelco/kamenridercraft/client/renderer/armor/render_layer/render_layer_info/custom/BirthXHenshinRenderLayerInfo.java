package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class BirthXHenshinRenderLayerInfo extends RenderLayerInfo {
    public BirthXHenshinRenderLayerInfo(String core) {
        super(core, "transforming/birth_x_henshin",core);
    }


    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {

        double tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue();

        GeoBone logo = model.getBone("core3").orElse(null);
        if (logo != null) {
            if (tick <11)logo.setRotX((float) (11-tick + partialTick));
            else logo.setRotX(0);
            if (tick <15) logo.setPosZ((float) (20-tick+partialTick));
           else logo.setPosZ(0);
        }

        GeoBone logo2 = model.getBone("core2").orElse(null);
        if (logo2 != null) {
            if (tick <9)logo2.setRotX((float) (9-tick + partialTick));
            else logo2.setRotX(0);
            if (tick <15) logo2.setPosZ((float) (20-tick+partialTick));
            else logo2.setPosZ(0);
        }

        GeoBone logo3 = model.getBone("core").orElse(null);
        if (logo3 != null) {
            if (tick <7)logo3.setRotX((float) (7-tick + partialTick));
            else logo3.setRotX(0);
            if (tick <15) logo3.setPosZ((float) (20-tick+partialTick));
            else logo3.setPosZ(0);
        }


    }

    public float getScaleX() {
        return 1f;
    }

    public float getScaleY() {return 1f;}

    public float getScaleZ() {
        return 1f;
    }

    public float getX() {
        return 0f;
    }

    public float getY() {
        return 0.5f;
    }

    public float getZ() {
        return 0f;
    }


}