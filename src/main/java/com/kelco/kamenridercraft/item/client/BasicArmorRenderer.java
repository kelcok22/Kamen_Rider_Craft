package com.kelco.kamenridercraft.item.client;

import com.kelco.kamenridercraft.item.BaseItems.BasicArmorItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.util.RenderUtil;

public class BasicArmorRenderer extends GeoArmorRenderer<BasicArmorItem> {
    private static LivingEntity RIDER;

    public BasicArmorRenderer(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

        super(new BasicArmorModel(livingEntity, equipmentSlot));

        if (livingEntity.getItemBySlot(equipmentSlot).getItem() instanceof BasicArmorItem belt) {
            if (belt.Glow)addRenderLayer(new AutoGlowingGeoLayer<>(this));
        }
        RIDER =  livingEntity;
    }

    @Override
    public RenderType getRenderType(BasicArmorItem animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
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
                setBoneVisible(this.head, true);
    }
}