package com.kelco.kamenridercraft.item.client;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.RenderUtil;

public class RiderArmorRenderer extends GeoArmorRenderer<RiderArmorItem> {

    public RiderArmorRenderer(EquipmentSlot equipmentSlot) {

        super(new RiderArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this){
            @Nullable
            protected RenderType getRenderType(RiderArmorItem animatable, @Nullable MultiBufferSource bufferSource) {
                if (this.getRenderer() instanceof RiderArmorRenderer renderer2) {
                   LivingEntity RIDER = renderer2.GetEntity();
                    if (RIDER!=null&&RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                        return belt.getGlowForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET), equipmentSlot,RIDER)? AutoGlowingTexture.getRenderType(getTextureResource(animatable)): null;
                        }}
                return null;
            }});


            if (equipmentSlot == EquipmentSlot.HEAD||equipmentSlot == EquipmentSlot.FEET) {
                    addRenderLayer(new RiderRenderLayer<>(this));
        }
    }

    public GeoArmorRenderer<RiderArmorItem> addRenderLayer(GeoRenderLayer<RiderArmorItem> renderLayer) {
        this.renderLayers.addLayer(renderLayer);

        return this;
    }

    public LivingEntity GetEntity(){
        if (getCurrentEntity() instanceof LivingEntity entity) return entity;
        else return null;
    }

    /*
    @Override
	public GeoBone getRightBootBone(GeoModel<RiderArmorItem> model) {
		return model.getBone("armorBody").orElse(super.getRightBootBone(model));
	}
    // We don't use the boot bones, so we better let other mods know
	@Override
	public GeoBone getLeftBootBone(GeoModel<RiderArmorItem> model) {
		return model.getBone("armorBody").orElse(super.getLeftBootBone(model));
	}
    */
    @Override
    public RenderType getRenderType(RiderArmorItem animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

@Override
    protected void applyBaseTransformations(HumanoidModel<?> baseModel) {
        super.applyBaseTransformations(baseModel);
    if (this.body != null) {
        ModelPart bodyPart = baseModel.body;

        RenderUtil.matchModelPartRot(bodyPart, this.body);
        this.body.updatePosition(bodyPart.x, -bodyPart.y, bodyPart.z);
    }
    }

    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        setAllVisible(false);
        if (GetEntity()!=null){
        if (!GetEntity().hasEffect(MobEffects.INVISIBILITY) || !GetEntity().isInvisible()) {
            if (currentSlot == EquipmentSlot.FEET) {
                setBoneVisible(this.body, true);
                setBoneVisible(this.leftArm, true);
            } else if (GetEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem BELT && BELT.isTransformed(GetEntity())) {
                setBoneVisible(this.head, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET),currentSlot,"head"));
                setBoneVisible(this.body, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET),currentSlot,"body"));
                setBoneVisible(this.rightArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET),currentSlot,"rightArm"));
                setBoneVisible(this.leftArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET),currentSlot,"leftArm"));
                setBoneVisible(this.rightLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET),currentSlot,"rightLeg"));
                setBoneVisible(this.leftLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET),currentSlot,"leftLeg"));
            }
        }
        }
    }

}