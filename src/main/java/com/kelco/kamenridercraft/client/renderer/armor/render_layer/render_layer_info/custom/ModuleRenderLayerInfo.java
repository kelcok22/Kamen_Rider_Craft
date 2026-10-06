package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.util.Color;


public class ModuleRenderLayerInfo extends RenderLayerInfo {
    private final int Slot;
    private final int LineColor;

    public ModuleRenderLayerInfo(String texture, String model,int lineColor, int slot) {
        super(texture, model);
        Slot=slot;
        LineColor=lineColor;
    }

    public ModuleRenderLayerInfo(String texture, String model,String glow,int lineColor, int slot) {
        super(texture, model,glow);
        Slot=slot;
        LineColor=lineColor;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick, MultiBufferSource pBufferSource, PoseStack poseStack, int packedLight) {
    }

    public RenderType getRenderType(float partialTick, LivingEntity RIDER) {
        if (RiderDriverItem.isTransformingFromBlank(RIDER.getItemBySlot(EquipmentSlot.FEET),RIDER)||RiderDriverItem.isTransforming(RIDER)&&RiderDriverItem.wasSlotChanged(RIDER.getItemBySlot(EquipmentSlot.FEET),Slot))return RenderType.debugLineStrip(20);
        else return super.getRenderType(partialTick,RIDER);
    }

    public int getColor(float partialTick, LivingEntity RIDER) {
        if (RiderDriverItem.isTransformingFromBlank(RIDER.getItemBySlot(EquipmentSlot.FEET),RIDER)||RiderDriverItem.isTransforming(RIDER)&&RiderDriverItem.wasSlotChanged(RIDER.getItemBySlot(EquipmentSlot.FEET),Slot))return LineColor;
        else return Color.WHITE.getColor();
    }
}