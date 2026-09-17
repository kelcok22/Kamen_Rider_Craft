package com.kelco.kamenridercraft.client.renderer.armor;

import com.kelco.kamenridercraft.client.model.armor.BasicArmorModel;
import com.kelco.kamenridercraft.item.base_items.BasicArmorItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.util.RenderUtil;

import static software.bernie.geckolib.cache.texture.GeoAbstractTexture.appendToPath;


public class BasicArmorRenderer extends GeoArmorRenderer<BasicArmorItem> {
    public BasicArmorRenderer(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {
        super(new BasicArmorModel());
        if (livingEntity.getItemBySlot(equipmentSlot).getItem() instanceof BasicArmorItem belt) {
            if (belt.glowing) addRenderLayer(new AutoGlowingGeoLayer<>(this) {
                protected @NotNull RenderType getRenderType(BasicArmorItem animatable, @Nullable MultiBufferSource bufferSource) {
                    ResourceLocation path = appendToPath(getTextureLocation(animatable), "_glowmask");
                    return RenderType.breezeEyes(path);
                }
            });
        }
    }

    @Override
    public RenderType getRenderType(BasicArmorItem animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
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
        setBoneVisible(head, true);
    }
}