package com.kelco.kamenridercraft.client.model.entity.mob;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import org.jetbrains.annotations.NotNull;

public class BasicMobModel<T extends Mob> extends PlayerModel<T> {
    private final PartPose bodyDefault = body.storePose();
    private final PartPose headDefault = head.storePose();
    private final PartPose leftArmDefault = leftArm.storePose();
    private final PartPose rightArmDefault = rightArm.storePose();

    public BasicMobModel(ModelPart modelPart) {
        super(modelPart, false);
    }

    public void prepareMobModel(T mob, float limbSwing, float limbSwingAmount, float partialTick) {
        rightArmPose = ArmPose.EMPTY;
        leftArmPose = ArmPose.EMPTY;
        ItemStack itemstack = mob.getItemInHand(InteractionHand.MAIN_HAND);
        if (itemstack.getItem() instanceof BowItem && mob.isUsingItem()) {
            if (mob.getMainArm() == HumanoidArm.RIGHT) {
                rightArmPose = ArmPose.BOW_AND_ARROW;
            } else {
                leftArmPose = ArmPose.BOW_AND_ARROW;
            }
        }

        super.prepareMobModel(mob, limbSwing, limbSwingAmount, partialTick);
    }

    public void setupAnim(@NotNull T mob, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        body.loadPose(bodyDefault);
        head.loadPose(headDefault);
        leftArm.loadPose(leftArmDefault);
        rightArm.loadPose(rightArmDefault);
        super.setupAnim(mob, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        if (mob.isAggressive() && mob.getMainHandItem().getItem() instanceof TieredItem) {
            holdWeaponHigh(mob);
        }

        if (mob.isPassenger()) {
            head.y -= -10.0F;
            for (ModelPart part : bodyParts()) part.y -= -10.0F;
        } else if (mob instanceof TamableAnimal sittingMob && sittingMob.isInSittingPose()) {
            rightArm.xRot += (-(float) Math.PI / 5F);
            leftArm.xRot += (-(float) Math.PI / 5F);
            rightLeg.xRot = -1.4137167F;
            rightLeg.yRot = ((float) Math.PI / 10F);
            rightLeg.zRot = 0.07853982F;
            leftLeg.xRot = -1.4137167F;
            leftLeg.yRot = (-(float) Math.PI / 10F);
            leftLeg.zRot = -0.07853982F;
            head.y -= -10.0F;
            for (ModelPart part : bodyParts()) part.y -= -10.0F;
        }

        leftPants.copyFrom(leftLeg);
        rightPants.copyFrom(rightLeg);
        leftSleeve.copyFrom(leftArm);
        rightSleeve.copyFrom(rightArm);
        jacket.copyFrom(body);
        hat.copyFrom(head);
    }

    private void holdWeaponHigh(T mob) {
        if (mob.isLeftHanded()) {
            leftArm.xRot = leftArm.xRot - 1F;
        } else {
            rightArm.xRot = rightArm.xRot - 1F;
        }
    }

    public void translateToHand(@NotNull HumanoidArm side, @NotNull PoseStack poseStack) {
        ModelPart modelpart = getArm(side);
        modelpart.translateAndRotate(poseStack);
    }
}