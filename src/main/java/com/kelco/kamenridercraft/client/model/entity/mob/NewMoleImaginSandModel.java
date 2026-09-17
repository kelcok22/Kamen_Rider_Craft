package com.kelco.kamenridercraft.client.model.entity.mob;


import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class NewMoleImaginSandModel<T extends Mob> extends HumanoidModel<T> {
    public NewMoleImaginSandModel(ModelPart modelPart) {
        super(modelPart);
    }

    public void prepareMobModel(T imagin, float limbSwing, float limbSwingAmount, float partialTick) {
        rightArmPose = ArmPose.EMPTY;
        leftArmPose = ArmPose.EMPTY;
        ItemStack itemstack = imagin.getItemInHand(InteractionHand.MAIN_HAND);
        if (itemstack.getItem() instanceof BowItem && imagin.isAggressive() && imagin.isUsingItem()) {
            if (imagin.getMainArm() == HumanoidArm.RIGHT) {
                rightArmPose = ArmPose.BOW_AND_ARROW;
            } else {
                leftArmPose = ArmPose.BOW_AND_ARROW;
            }
        }

        super.prepareMobModel(imagin, limbSwing, limbSwingAmount, partialTick);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean flag = entity.getFallFlyingTicks() > 4;
        head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        if (flag) {
            head.xRot = (-(float) Math.PI / 4F);
        } else {
            head.xRot = headPitch * ((float) Math.PI / 180F);
        }

        body.yRot = 0.0F;
        rightArm.z = 0.0F;
        rightArm.x = -5.0F;
        leftArm.z = 0.0F;
        leftArm.x = 5.0F;
        if (riding) {
            head.y = 2.0F;
            body.y = 2.0F;
            rightArm.y = 4.0F;
            leftArm.y = 4.0F;
            leftLeg.y = -18.0F;
            rightLeg.y = -18.0F;
        } else {
            head.y = 12.0F;
            body.y = 12.0F;
            rightArm.y = 14.0F;
            leftArm.y = 14.0F;
            leftLeg.y = -8.0F;
            rightLeg.y = -8.0F;
        }
        float f = 1.0F;
        if (flag) {
            f = (float) entity.getDeltaMovement().lengthSqr();
            f /= 0.2F;
            f *= f * f;
        }

        if (f < 1.0F) {
            f = 1.0F;
        }

        rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        rightArm.yRot = 0.0F;
        leftArm.yRot = 0.0F;
        rightArm.zRot = 0.0F;
        leftArm.zRot = 0.0F;
        rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
        rightLeg.yRot = 0.005F;
        leftLeg.yRot = -0.005F;
        rightLeg.zRot = 0.005F;
        leftLeg.zRot = -0.005F;

        setupAttackAnimation(entity, ageInTicks);
        AnimationUtils.bobModelPart(rightArm, ageInTicks, 1.0F);
        AnimationUtils.bobModelPart(leftArm, ageInTicks, -1.0F);

        hat.copyFrom(head);
    }

    protected void setupAttackAnimation(T imagin, float ageInTicks) {
        if (attackTime > 0.0F) {
            AnimationUtils.swingWeaponDown(rightArm, leftArm, imagin, attackTime, ageInTicks);
        } else {
            super.setupAttackAnimation(imagin, ageInTicks);
        }
    }

    private void holdWeaponHigh(T imagin) {
        if (imagin.isLeftHanded()) {
            leftArm.xRot = leftArm.xRot - 1F;
        } else {
            rightArm.xRot = rightArm.xRot - 1F;
        }
    }

    public void translateToHand(HumanoidArm side, PoseStack poseStack) {
        ModelPart modelpart = getArm(side);
        modelpart.translateAndRotate(poseStack);
    }
}