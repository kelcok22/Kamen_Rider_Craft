package com.kelco.kamenridercraft.client.renderer.layers;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.RiderArmorLayerModel;
import com.kelco.kamenridercraft.client.renderer.RiderArmorRenderer;
import com.kelco.kamenridercraft.client.renderer.layers.render_layer_util.RenderLayerInfo;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class RiderRenderLayer<T extends RiderArmorItem> extends GeoRenderLayer<T> {
    public RiderRenderLayer(GeoRenderer<T> renderer) {
        super(renderer);
    }

    public static void matchModelPartRot(GeoBone from, GeoBone to) {
        to.updateRotation(from.getRotX(), from.getRotY(), from.getRotZ());
    }


    protected void applyBaseTransformations(BakedGeoModel bakedModel, BakedGeoModel newModel) {
        String[] boneNames = new String[]{"armorHead", "armorBody", "armorRightArm", "armorLeftArm", "armorRightLeg", "armorLeftLeg"};
        for (String boneName : boneNames) {
            GeoBone bakedHead = bakedModel.getBone(boneName).orElse(null);
            GeoBone head = newModel.getBone(boneName).orElse(null);
            if (head != null & bakedHead != null) {
                matchModelPartRot(bakedHead, head);
                head.updatePosition(bakedHead.getPosX(), bakedHead.getPosY(), bakedHead.getPosZ());
            }
        }
    }

    protected void applyCustomAnimations(RenderLayerInfo renderLayerInfo, BakedGeoModel bakedModel, ItemStack stack, LivingEntity entity, float partialTick) {
        renderLayerInfo.ApplyMovement(bakedModel,stack,entity,partialTick);
    }


    public GeoModel<T> getGeoModel(String name, EquipmentSlot slot) {
        return new RiderArmorLayerModel() {
            @Override
            public ResourceLocation getModelResource(RiderArmorItem animatable) {
                if (slot == EquipmentSlot.FEET)
                    return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/belts/" + name + ".geo.json");
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/" + name + ".geo.json");
            }
        };
    }

    public BakedGeoModel getBakedModel(T animatable, GeoModel<T> model) {
        return getGeoModel().getBakedModel(model.getModelResource(animatable, getRenderer()));
    }

    @Nullable
    protected RenderType getRenderType(ResourceLocation text) {
        if (text.getPath().equals((ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/belts/blank.png")).getPath())||
                text.getPath().equals((ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png")).getPath())||
                text.getPath().equals((ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/tire/no_tire.png")).getPath()))
            return null;
        return RenderType.entityTranslucent(text);
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
                List<RenderLayerInfo> layerInfo = new ArrayList<>();
                belt.SetUnlimitedModels(layerInfo, RIDER.getItemBySlot(EquipmentSlot.FEET), RIDER, renderer2.getCurrentSlot());

                if (!layerInfo.isEmpty()) {
                    for (RenderLayerInfo renderLayerInfo : layerInfo) {

                        renderType = renderLayerInfo.getRenderType();
                        String model = renderLayerInfo.getModel();

                        BakedGeoModel bakedGeoModel = model != null ? getBakedModel(animatable, getGeoModel(model, renderer2.getCurrentSlot())) : bakedModel;
                        //poseStack.scale(renderLayerInfo.getScaleX(), renderLayerInfo.getScaleY(), renderLayerInfo.getScaleZ());
                        //poseStack.translate(renderLayerInfo.getX(), renderLayerInfo.getY(), renderLayerInfo.getZ());

                        if (model != null) applyBaseTransformations(bakedModel, bakedGeoModel);
                        if (model != null) applyCustomAnimations(renderLayerInfo,bakedGeoModel,RIDER.getItemBySlot(EquipmentSlot.FEET) ,RIDER, partialTick);
                        if (renderType != null) {
                            getRenderer().reRender(bakedGeoModel, poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }
                        if (renderLayerInfo.isGlowing()) {
                            renderType = RenderType.breezeEyes(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + renderLayerInfo.getGlowTexture() + ".png"));
                            getRenderer().reRender(bakedGeoModel, poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }
                    }
                }
            }
        }

    }
}