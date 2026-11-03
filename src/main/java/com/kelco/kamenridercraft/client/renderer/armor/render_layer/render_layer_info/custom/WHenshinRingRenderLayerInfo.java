package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.util.Color;


public class WHenshinRingRenderLayerInfo extends RenderLayerInfo {

    private static int COL;
    private static int COL2;
    public WHenshinRingRenderLayerInfo(int col, int col2) {
        super(RenderType.breezeEyes(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/meteor_storm_test.png")), "transforming/w_henshin_ring");
        COL=col;
        COL2=col2;
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.2F;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {

        double tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue()-partialTick;
        GeoBone storm = model.getBone("storm").orElse(null);
        if (storm != null) {
            storm.setRotZ((entity.tickCount + partialTick) / 5f);
            storm.setPosZ((float) (-tick/10));
            storm.setScaleX((float) (tick/20));
            storm.setScaleY((float) (tick/20));
            storm.setScaleZ((float) (tick/20));
        }
    }

    public RenderType getRenderType(float partialTick, LivingEntity livingEntity) {
        float f = (float) livingEntity.tickCount + partialTick;
        return RenderType.energySwirl(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/transforming/w_henshin_ring.png"), 0, f / 10);
    }


    @Override
    public int getColor(float partialTick, LivingEntity RIDER) {
        if (((RIDER.tickCount/3) & 1) == 0){
            return COL2;
        }
        return COL;
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
        return -0.2f;
    }

    public float getZ() {
        return 0f;
    }
}