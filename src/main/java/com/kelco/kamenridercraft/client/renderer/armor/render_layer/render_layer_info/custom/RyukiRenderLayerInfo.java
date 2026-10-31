package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.mojang.math.Transformation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.util.TransformationHelper;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.util.Color;

import java.util.Optional;


public class RyukiRenderLayerInfo extends RenderLayerInfo {
    private final String Text;
    private final String Model;
    private final int NUM;

    public RyukiRenderLayerInfo(String texture, String model,int num) {
        super(texture, model);
        Text=texture;
        Model=model;
        NUM=num;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        GeoBone bone= model.getBone("body").orElse(null);
        if (bone!=null){
            if (NUM==1){
                bone.setPosX((float) (entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()-partialTick)*2);
                bone.setPosZ(0);
            }
            else if (NUM==2){
                bone.setPosX((float) (-entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()-partialTick)*2);
                bone.setPosZ(0);
            }
            else {
                bone.setPosZ((float) (-entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()-partialTick)*2);
                bone.setPosX(0);
            }
            bone.setScaleZ(0.1f);
            bone.setRotY(entity.tickCount+partialTick);
        }

    }
    public RenderType getRenderType(float partialTick, LivingEntity livingEntity) {
        float f = (float) livingEntity.tickCount + partialTick;
        return RenderType.eyes(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/"+Text+".png"));
    }

    public String getModel(float partialTick, LivingEntity RIDER) {
        return Model;
    }

}