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


public class GlowHenshinRenderLayerInfo extends RenderLayerInfo {
    private final String Text;
    private final String Model;

    public GlowHenshinRenderLayerInfo(String texture, String model, int num) {
        super(texture, model);
        Text=texture;
        Model=model;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
        for (GeoBone head : model.topLevelBones()) {
            if (head != null) {
                float scale = (float) (1.1-(entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getBaseValue()-partialTick)/25);
                head.setScaleX(scale );
                head.setScaleY(scale );
                head.setScaleZ(scale );
            }
        }

    }
    public RenderType getRenderType(float partialTick, LivingEntity livingEntity) {
        return RenderType.energySwirl(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/"+Text+".png"),0,0);
    }

    public String getModel(float partialTick, LivingEntity RIDER) {
        return Model;
    }

}