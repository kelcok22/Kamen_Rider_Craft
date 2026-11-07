package com.kelco.kamenridercraft.mixin.client.renderer;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.extra_riders.GRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.KivaRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.RyukiRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.zigythebird.playeranim.accessors.IAnimatedPlayer;
import com.zigythebird.playeranim.animation.PlayerAnimManager;
import com.zigythebird.playeranimcore.bones.PlayerAnimBone;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.player.AbstractClientPlayer;
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
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ItemInHandLayer.class)
public class ItemInHandLayerMixin {
    ItemStack tango = new ItemStack(Items.APPLE);
    @Unique
    private final PlayerAnimBone palRightItem = new PlayerAnimBone("right_item");
    @Unique
    private final PlayerAnimBone palLeftItem = new PlayerAnimBone("left_item");

    @Inject(method = "renderArmWithItem", at = @At("HEAD"), cancellable = true)
    public void renderArmWithItemMixin(LivingEntity livingEntity, ItemStack itemStack, ItemDisplayContext displayContext,
                                       HumanoidArm arm, PoseStack poseStack, MultiBufferSource buffer, int packedLight, CallbackInfo ci) {
        if (livingEntity instanceof Player && livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem riderDriverItem
                && riderDriverItem.isTransformed(livingEntity)) {
            if (livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 0) {
                ci.cancel();
            }
        }
    }

    public void renderArmWithItemModification(LivingEntity livingEntity, ItemStack itemStack, ItemDisplayContext displayContext,
                                              HumanoidArm arm, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (livingEntity instanceof Player && livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem riderDriverItem
                && riderDriverItem.isTransformed(livingEntity)) {
            if (livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() != 0) {
                boolean replaceRender = false;
                boolean palOverride = false;

                if (riderDriverItem.riderName.equals("ooo") || riderDriverItem.riderName.equals("goda")
                        || riderDriverItem.riderName.equals("oooooo") || riderDriverItem.riderName.equals("shocker_ooo")
                        || riderDriverItem.riderName.equals("ooo_ancient")) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(OOORiderItems.O_SCANNER.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                } else if (riderDriverItem.riderName.equals("poseidon")) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(OOORiderItems.DEEPEST_HARPOON.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("ryuki") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.RYUKI_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("knight") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.KNIGHT_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("scissors") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.SCISSORS_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("zolda") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ZOLDA_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("raia") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.RAIA_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("ouja") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.OUJA_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("odin") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ODIN_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("imperer") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.IMPERER_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("tiger") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.TIGER_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("gai") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.GAI_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("verde") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.VERDE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("femme") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.FEMME_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("fatale") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.FATALE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("ryuga") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.RYUGA_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("abyss") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ABYSS_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("blade_mirror") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.RIGHT) {
                        tango = new ItemStack(RyukiRiderItems.BLADE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("alternative") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ALTERNATIVE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("alternative_zero") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(RyukiRiderItems.ALTERNATIVE_DECK.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                } else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("kamen_rider_g") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(GRiderItems.GORO_WINE_BOTTLE.get());
                    } else {
                        tango = new ItemStack(Items.AIR);
                    }
                    replaceRender = true;
                    palOverride = true;
                }else if (RiderDriverItem.isTransformingFromBlank(livingEntity.getItemBySlot(EquipmentSlot.FEET),livingEntity)&&riderDriverItem.riderName.equals("kiva") && livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() > 5) {
                    if (arm == HumanoidArm.LEFT) {
                        tango = new ItemStack(Items.AIR);
                    } else {
                        tango = new ItemStack(KivaRiderItems.KIVAT_THE_BAT_3RD.get());
                    }
                    replaceRender = true;
                    palOverride = true;
                }

                if (replaceRender) {
                    var renderer = ((ItemInHandLayer) (Object) this);
                    poseStack.pushPose();
                    ((ArmedModel) renderer.getParentModel()).translateToHand(arm, poseStack);
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
                    poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
                    boolean flag = arm == HumanoidArm.LEFT;
                    poseStack.translate((float) (flag ? -1 : 1) / 16.0F, 0.125F, -0.625F);
                    if (palOverride && livingEntity instanceof AbstractClientPlayer player && ((IAnimatedPlayer) player).playerAnimLib$getAnimProcessor() != null
                            && ((IAnimatedPlayer) player).playerAnimLib$getAnimManager().isActive()) {
                        //code copy from PAL mixin

                        PlayerAnimManager anim = ((IAnimatedPlayer) player).playerAnimLib$getAnimManager();

                        if (anim == null) return;
                        PlayerAnimBone bone;

                        if (arm == HumanoidArm.LEFT) bone = palLeftItem;
                        else bone = palRightItem;

                        bone.setToInitialPose();
                        anim.get3DTransform(bone);

                        poseStack.translate(bone.getPosX() / 16, -bone.getPosY() / 16, bone.getPosZ() / 16);
                        if (anim == null) return;

                        if (arm == HumanoidArm.LEFT) bone = palLeftItem;
                        else bone = palRightItem;

                        if (bone.getRotY() != 0)
                            poseStack.mulPose(Axis.ZP.rotation(-bone.getRotY()));

                        if (bone.getRotZ() != 0)
                            poseStack.mulPose(Axis.YP.rotation(-bone.getRotZ()));

                        if (bone.getRotX() != 0)
                            poseStack.mulPose(Axis.XP.rotation(-bone.getRotX()));

                        poseStack.scale(bone.getScaleX(), bone.getScaleY(), bone.getScaleZ());
                    }
                    renderer.itemInHandRenderer.renderItem(livingEntity, tango, displayContext, flag, poseStack, buffer, packedLight);
                    poseStack.popPose();
                }
            }
        }
    }

    @Inject(method = "render", at = @At("TAIL"))
    public void renderMixin(PoseStack poseStack, MultiBufferSource buffer, int packedLight, LivingEntity livingEntity, float limbSwing,
                            float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (livingEntity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() != 0) {
            renderArmWithItemModification(livingEntity, new ItemStack(Items.AIR), ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
                    HumanoidArm.LEFT, poseStack, buffer, packedLight);
            renderArmWithItemModification(livingEntity, new ItemStack(Items.AIR), ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
                    HumanoidArm.RIGHT, poseStack, buffer, packedLight);
        }
    }
}