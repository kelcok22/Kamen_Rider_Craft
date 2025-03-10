package com.kelco.kamenridercraft.item.client;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.Fourze.FourzeDriverItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

import java.util.List;

public class RiderArmorRenderer extends GeoArmorRenderer<RiderArmorItem> {

    private static LivingEntity RIDER;

    public RiderArmorRenderer(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

        super(new RiderArmorModel(livingEntity, equipmentSlot));

        if (livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
            if (belt.getGlowForSlot(livingEntity.getItemBySlot(EquipmentSlot.FEET), equipmentSlot,livingEntity))addRenderLayer(new AutoGlowingGeoLayer<>(this));


            if (belt.Unlimited_Textures!=0&equipmentSlot==EquipmentSlot.HEAD){
                for (int n = 0; n < belt.Unlimited_Textures; n++) {
                    {
                        addRenderLayer(new RiderRenderLayer<>(this, ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,"textures/armor/"+
                                belt.getUnlimitedTextures(livingEntity.getItemBySlot(EquipmentSlot.FEET), equipmentSlot, RIDER, belt.Rider, n + 1)+".png")));
                    }
                }
            }

        }
        RIDER =  livingEntity;
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

    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        setAllVisible(false);

        if (!RIDER.hasEffect(MobEffects.INVISIBILITY) || !RIDER.isInvisible()) {
            if (currentSlot == EquipmentSlot.FEET) {
                setBoneVisible(this.body, true);
            } else if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem BELT && BELT.isTransformed(RIDER)) {
                setBoneVisible(this.head, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"head"));
                setBoneVisible(this.body, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"body"));
                setBoneVisible(this.rightArm, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"rightArm"));
                setBoneVisible(this.leftArm, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"leftArm"));
                setBoneVisible(this.rightLeg, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"rightLeg"));
                setBoneVisible(this.leftLeg, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"leftLeg"));
            }
        }
    }

}