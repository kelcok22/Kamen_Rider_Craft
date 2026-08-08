package com.kelco.kamenridercraft.client.renderer.layers;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.models.RiderArmorLayerModel;
import com.kelco.kamenridercraft.client.renderer.RiderArmorRenderer;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.resource.GeoGlowingTextureMeta;

import java.util.List;


public class RiderRenderLayer<T extends RiderArmorItem> extends GeoRenderLayer<T> {

    public RiderRenderLayer(GeoRenderer<T> renderer) {
        super(renderer);
    }

    public static void matchModelPartRot(GeoBone from, GeoBone to) {
        to.updateRotation(from.getRotX(), from.getRotY(), from.getRotZ());
    }



    protected void applyBaseTransformations(BakedGeoModel bakedModel,BakedGeoModel newModel) {
        String[] boneNames = new String[] {"armorHead","armorBody","armorRightArm","armorLeftArm","armorRightLeg","armorLeftLeg"};
        for (int n = 0; n < boneNames.length; n++) {
            GeoBone bakedHead = bakedModel.getBone(boneNames[n]).orElse(null);
            GeoBone head = newModel.getBone(boneNames[n]).orElse(null);
            if (head != null & bakedHead != null) {
                matchModelPartRot(bakedHead, head);
                head.updatePosition(bakedHead.getPosX(), bakedHead.getPosY(), bakedHead.getPosZ());
            }
        }
    }
    protected void applyCustomAnimations(BakedGeoModel bakedModel, LivingEntity entity,float PartialTick) {
        GeoBone wizard_circle5 = bakedModel.getBone("wizard_circle5").orElse(null);
        double GetTransforming = entity.getAttribute(Attributes.IS_TRANSFORMING).getBaseValue();

        float Transforming = (float) Mth.lerp(1, GetTransforming, (GetTransforming - 1) - PartialTick);
        if (wizard_circle5 != null) {
            if (RiderDriverItem.isTransforming(entity)) {
                wizard_circle5.setScaleX(1.1f);
                wizard_circle5.setScaleY(1.1f);
                wizard_circle5.setScaleZ(1.1f);
                wizard_circle5.setPosX(2.5f);
                wizard_circle5.setPosZ(30 - Transforming);
                wizard_circle5.setHidden(false);
            } else {
                wizard_circle5.setHidden(true);
                wizard_circle5.setPosZ(0);
            }
        }
    }

    protected ResourceLocation getTextureResource(int n, LivingEntity entity, RiderDriverItem belt, EquipmentSlot slot) {
        if (slot == EquipmentSlot.FEET)
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/belts/" + belt.getUnlimitedBeltModels(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.riderName, n + 1)[0] + ".png");
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + belt.getUnlimitedModels(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.riderName, n + 1)[0] + ".png");
    }

    protected ResourceLocation getGlowTextureResource(int n, LivingEntity entity, RiderDriverItem belt, EquipmentSlot slot) {
        if (slot == EquipmentSlot.FEET)
            return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/belts/" + belt.getUnlimitedBeltModels(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.riderName, n + 1)[0] + "_glowmask.png");
        return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/" + belt.getUnlimitedModels(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.riderName, n + 1)[0] + "_glowmask.png");
    }

    protected String getModelResource(int n, LivingEntity entity, RiderDriverItem belt, EquipmentSlot slot) {
        if (slot == EquipmentSlot.FEET)
            return belt.getUnlimitedBeltModels(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.riderName, n + 1)[1];
        return belt.getUnlimitedModels(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.riderName, n + 1)[1];
    }

    public GeoModel<T> getGeoModel(String name) {
        return new RiderArmorLayerModel(){
            @Override
            public ResourceLocation getModelResource( RiderArmorItem animatable) {
                return ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "geo/armor/"+name+".geo.json");
            }
        };
    }

    public BakedGeoModel getBakedModel(T animatable,GeoModel<T> model) {
        return getGeoModel().getBakedModel(model.getModelResource(animatable, getRenderer()));
    }

    @Nullable
    protected RenderType getRenderType(ResourceLocation text) {
        if (text.getPath().equals((ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/belts/blank.png")).getPath()))return null;
        if (text.getPath().equals((ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png")).getPath()))return null;
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
                if (belt.unlimitedTextures != 0 & renderer2.getCurrentSlot() == EquipmentSlot.HEAD) {
                    for (int n = 0; n < belt.unlimitedTextures; n++) {
                        ResourceLocation text = getTextureResource(n,RIDER,belt,EquipmentSlot.HEAD);
                        ResourceLocation glowText = getGlowTextureResource(n,RIDER,belt,EquipmentSlot.HEAD);
                        renderType = getRenderType(text);
                        String model = getModelResource(n,RIDER,belt, EquipmentSlot.HEAD);
                        BakedGeoModel bakedGeoModel = model!= null ? getBakedModel(animatable,getGeoModel(model)):bakedModel;
                        if(model!= null)applyBaseTransformations(bakedModel,bakedGeoModel);
                        if(model!= null)applyCustomAnimations(bakedGeoModel,RIDER,partialTick);
                        if (renderType != null) {
                            getRenderer().reRender(bakedGeoModel, poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }
                        /**if (!glowText.getPath().isEmpty()){
                            renderType=  RenderType.breezeEyes(glowText);
                            getRenderer().reRender(bakedGeoModel, poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }**/
                    }
                }
                if (belt.unlimitedBeltTextures != 0 & renderer2.getCurrentSlot() == EquipmentSlot.FEET) {
                    for (int n = 0; n < belt.unlimitedBeltTextures; n++) {
                        ResourceLocation text = getTextureResource(n,RIDER,belt,EquipmentSlot.FEET);
                        renderType = getRenderType(text);
                        String model = getModelResource(n,RIDER,belt, EquipmentSlot.FEET);
                        BakedGeoModel bakedGeoModel = model!= null ? getBakedModel(animatable, getGeoModel(model)):bakedModel;
                        if(model!= null)applyBaseTransformations(bakedModel,bakedGeoModel);
                        if (renderType != null) {
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


