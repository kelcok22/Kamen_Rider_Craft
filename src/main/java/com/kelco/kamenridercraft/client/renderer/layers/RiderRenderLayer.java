package com.kelco.kamenridercraft.client.renderer.layers;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.renderer.RiderArmorRenderer;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;


public class RiderRenderLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {

    public RiderRenderLayer(GeoRenderer<T> renderer) {
        super(renderer);
    }

    protected ResourceLocation getTextureResource(T animatable, int n, LivingEntity entity, RiderDriverItem belt, EquipmentSlot slot) {
        if (slot == EquipmentSlot.FEET)
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/belts/" + belt.getUnlimitedBeltTextures(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.riderName, n + 1) + ".png");
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + belt.getUnlimitedTextures(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.riderName, n + 1) + ".png");
    }

    @Nullable
    protected RenderType getRenderType(T animatable, int run, LivingEntity entity, RiderDriverItem belt, EquipmentSlot slot) {
        if (getTextureResource(animatable, run, entity, belt, slot).getPath().equals((ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/belts/blank.png")).getPath()))return null;
        if (getTextureResource(animatable, run, entity, belt, slot).getPath().equals((ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png")).getPath()))return null;
        return RenderType.entityTranslucent(getTextureResource(animatable, run, entity, belt, slot));
    }

    /**
     * This is the method that is actually called by the render for your render layer to function
     * <p>
     * This is called <i>after</i> the animatable has been rendered, but before supplementary rendering like nametags
     */
    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        if (this.getRenderer() instanceof RiderArmorRenderer renderer2) {
            LivingEntity RIDER = renderer2.GetEntity();
            if (RIDER != null && RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                if (belt.unlimitedTextures != 0 & renderer2.getCurrentSlot() == EquipmentSlot.HEAD) {
                    for (int n = 0; n < belt.unlimitedTextures; n++) {
                        renderType = getRenderType(animatable, n, RIDER, belt, EquipmentSlot.HEAD);

                        if (renderType != null) {
                            getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }
                    }
                }
                if (belt.unlimitedBeltTextures != 0 & renderer2.getCurrentSlot() == EquipmentSlot.FEET) {
                    for (int n = 0; n < belt.unlimitedBeltTextures; n++) {
                        renderType = getRenderType(animatable, n, RIDER, belt, EquipmentSlot.FEET);

                        if (renderType != null) {
                            getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }
                    }
                }
            }
        }

    }
}


