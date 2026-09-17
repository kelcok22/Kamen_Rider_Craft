package com.kelco.kamenridercraft.client.renderer.armor;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.client.model.armor.RiderArmorModel;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.RiderRenderLayer;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.WindRenderLayer;
import com.kelco.kamenridercraft.entity.vehicles.RidoronEntity;
import com.kelco.kamenridercraft.item.base_items.RiderArmorItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.RenderUtil;

import static com.kelco.kamenridercraft.client.ModRenderTypes.mutekiGlint;
import static software.bernie.geckolib.cache.texture.GeoAbstractTexture.appendToPath;


public class RiderArmorRenderer extends GeoArmorRenderer<RiderArmorItem> {
    public RiderArmorRenderer(EquipmentSlot equipmentSlot) {
        super(new RiderArmorModel<>());
        if (equipmentSlot != EquipmentSlot.FEET) {
            addRenderLayer(new AutoGlowingGeoLayer<>(this) {
                @Nullable
                protected RenderType getRenderType(RiderArmorItem animatable, @Nullable MultiBufferSource bufferSource) {
                    if (getRenderer() instanceof RiderArmorRenderer renderer2) {
                        LivingEntity RIDER = renderer2.GetEntity();
                        if (RIDER != null && RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                            if (renderer.getTextureLocation(animatable).getPath().equals((ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "textures/armor/blank.png")).getPath())) {
                                return null;
                            }
                            ResourceLocation path = appendToPath(model.getTextureResource(animatable, renderer2), "_glowmask");
                            return belt.getGlowForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET), renderer2.getCurrentSlot(), RIDER) ? RenderType.breezeEyes(path) : null;
                        }
                    }
                    return null;
                }
            });
        }

        if (equipmentSlot == EquipmentSlot.HEAD || equipmentSlot == EquipmentSlot.FEET) {
            addRenderLayer(new RiderRenderLayer<>(this));
        }

        addRenderLayer(new AutoGlowingGeoLayer<>(this) {
            @Nullable
            protected RenderType getRenderType(RiderArmorItem animatable, @Nullable MultiBufferSource bufferSource) {
                if (getCurrentEntity() instanceof LivingEntity rider && rider.invulnerableTime > 0 && rider.getAttribute(Attributes.MUTEKI).getValue() > 0) {
                    return mutekiGlint();
                }
                return null;
            }
        });

        if (equipmentSlot == EquipmentSlot.HEAD) {
            addRenderLayer(new WindRenderLayer<>(this));
        }

    }

    public GeoArmorRenderer<RiderArmorItem> addRenderLayer(GeoRenderLayer<RiderArmorItem> renderLayer) {
        renderLayers.addLayer(renderLayer);
        return this;
    }

    public LivingEntity GetEntity() {
        if (getCurrentEntity() instanceof LivingEntity entity) {
            return entity;
        } else {
            return null;
        }
    }

    @Override
    public RenderType getRenderType(RiderArmorItem animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    protected void applyBaseTransformations(HumanoidModel<?> baseModel) {
        super.applyBaseTransformations(baseModel);
        if (body != null) {
            ModelPart bodyPart = baseModel.body;
            RenderUtil.matchModelPartRot(bodyPart, body);
            body.updatePosition(bodyPart.x, -bodyPart.y, bodyPart.z);
        }
    }

    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        setAllVisible(false);
        if (GetEntity() != null) {
            if (!GetEntity().isInvisible() && !(GetEntity().getVehicle() != null && GetEntity().getVehicle() instanceof RidoronEntity) || GetEntity() instanceof ArmorStand) {
                if (currentSlot == EquipmentSlot.FEET) {
                    setAllVisible(true);
                } else if (GetEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem BELT) {
                    setBoneVisible(head, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "head"));
                    setBoneVisible(body, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "body"));
                    setBoneVisible(rightArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "rightArm"));
                    setBoneVisible(leftArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "leftArm"));
                    setBoneVisible(rightLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "rightLeg"));
                    setBoneVisible(leftLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "leftLeg"));
                }
            }
        }
    }
}