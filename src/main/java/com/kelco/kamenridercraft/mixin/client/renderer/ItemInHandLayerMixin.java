package com.kelco.kamenridercraft.mixin.client.renderer;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ItemInHandLayer.class)
public class ItemInHandLayerMixin {
    @Inject(method = "renderArmWithItem", at = @At("HEAD"), cancellable = true)
    public void renderArmWithItemMixin(LivingEntity livingEntity, ItemStack itemStack, ItemDisplayContext displayContext, HumanoidArm arm, PoseStack poseStack, MultiBufferSource buffer, int packedLight, CallbackInfo ci) {
        if (livingEntity instanceof Player && livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem riderDriverItem && riderDriverItem.isTransformed(livingEntity)) {
            if (livingEntity.getAttribute(Attributes.IS_TRANSFORMING).getValue() > 0) {
                boolean replaceRender = false;
                ItemStack tango = new ItemStack(Items.APPLE);
                if (riderDriverItem.riderName.equals("ooo")) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(OOORiderItems.O_SCANNER.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                }
                if (replaceRender) {
                    var renderer = ((ItemInHandLayer) (Object) this);
                    poseStack.pushPose();
                    ((ArmedModel) renderer.getParentModel()).translateToHand(arm, poseStack);
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
                    poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
                    boolean flag = arm == HumanoidArm.LEFT;
                    poseStack.translate((float) (flag ? -1 : 1) / 16.0F, 0.125F, -0.625F);
                    renderer.itemInHandRenderer.renderItem(livingEntity, tango, displayContext, flag, poseStack, buffer, packedLight);
                    poseStack.popPose();
                    ci.cancel();
                }
            }

        }
    }
}