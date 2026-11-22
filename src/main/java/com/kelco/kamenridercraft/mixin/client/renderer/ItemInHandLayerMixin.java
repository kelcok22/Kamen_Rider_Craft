package com.kelco.kamenridercraft.mixin.client.renderer;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.extra_riders.GRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.KivaRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.RyukiRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.gaim.SengokuDriverItem;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ItemInHandLayer.class, priority = 899)
public class ItemInHandLayerMixin {
    ItemStack tango = new ItemStack(Items.APPLE);

    public ItemStack getItem(HumanoidArm arm, LivingEntity livingEntity) {
        if (livingEntity instanceof Player && livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem riderDriverItem
                && riderDriverItem.isTransformed(livingEntity)) {
            if (livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() != 0) {
                if (riderDriverItem.riderName.equals("ooo") || riderDriverItem.riderName.equals("goda")
                        || riderDriverItem.riderName.equals("oooooo") || riderDriverItem.riderName.equals("shocker_ooo")
                        || riderDriverItem.riderName.equals("ooo_ancient")) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(OOORiderItems.O_SCANNER.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (riderDriverItem.riderName.equals("poseidon")) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(OOORiderItems.DEEPEST_HARPOON.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (riderDriverItem instanceof SengokuDriverItem && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 30) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(SengokuDriverItem.getFormItem(livingEntity.getItemBySlot(EquipmentSlot.FEET),1));
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("ryuki") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.RYUKI_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("knight") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.KNIGHT_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("scissors") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.SCISSORS_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("zolda") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ZOLDA_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("raia") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.RAIA_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("ouja") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.OUJA_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("odin") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ODIN_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("imperer") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.IMPERER_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("tiger") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.TIGER_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("gai") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.GAI_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("verde") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.VERDE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("femme") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.FEMME_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("fatale") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.FATALE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("ryuga") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.RYUGA_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("abyss") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ABYSS_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("blade_mirror") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(RyukiRiderItems.BLADE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("alternative") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ALTERNATIVE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("alternative_zero") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ALTERNATIVE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("kamen_rider_g") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 46) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(GRiderItems.GORO_WINE_BOTTLE.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity) && riderDriverItem.riderName.equals("kiva") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(Items.AIR);
                    } else {
                        tango = new ItemStack(KivaRiderItems.KIVAT_THE_BAT_3RD.get());
                    }
                }
                else {
                    tango = new ItemStack(Items.AIR);
                }
            }
        }
        return tango;
    }

    @Shadow
    protected void renderArmWithItem(LivingEntity livingEntity, ItemStack itemStack, ItemDisplayContext displayContext, HumanoidArm arm, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

    }

    @Inject(method = "render", at = @At("INVOKE"), cancellable = true)
    public void renderMixin(PoseStack poseStack, MultiBufferSource buffer, int packedLight, LivingEntity livingEntity, float limbSwing,
                            float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (livingEntity instanceof Player && livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem riderDriverItem
                && riderDriverItem.isTransformed(livingEntity)) {
            if (livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() != 0) {
                poseStack.pushPose();
                renderArmWithItem(livingEntity, getItem(HumanoidArm.LEFT, livingEntity), ItemDisplayContext.THIRD_PERSON_LEFT_HAND, HumanoidArm.LEFT, poseStack, buffer, packedLight);
                renderArmWithItem(livingEntity, getItem(HumanoidArm.RIGHT, livingEntity), ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, HumanoidArm.RIGHT, poseStack, buffer, packedLight);
                poseStack.popPose();
                ci.cancel();
            }
        }
    }
}