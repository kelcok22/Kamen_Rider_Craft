package com.kelco.kamenridercraft.client.models;



import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class NewMoleImaginSandModel<T extends Mob> extends HumanoidModel<T> {

   public NewMoleImaginSandModel(ModelPart p_171090_) {
	   super(p_171090_);
   }

   public void prepareMobModel(T p_103793_, float p_103794_, float p_103795_, float p_103796_) {
      this.rightArmPose = ArmPose.EMPTY;
      this.leftArmPose = ArmPose.EMPTY;
      ItemStack itemstack = p_103793_.getItemInHand(InteractionHand.MAIN_HAND);
      if (itemstack.getItem() instanceof BowItem && p_103793_.isAggressive() && p_103793_.isUsingItem()) {
         if (p_103793_.getMainArm() == HumanoidArm.RIGHT) {
            this.rightArmPose = ArmPose.BOW_AND_ARROW;
         } else {
            this.leftArmPose = ArmPose.BOW_AND_ARROW;
         }
      }

      super.prepareMobModel(p_103793_, p_103794_, p_103795_, p_103796_);
   }

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean flag = entity.getFallFlyingTicks() > 4;
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		if (flag) {
		   this.head.xRot = (-(float)Math.PI / 4F);
		} else {
		   this.head.xRot = headPitch * ((float)Math.PI / 180F);
		}
  
		this.body.yRot = 0.0F;
		this.rightArm.z = 0.0F;
		this.rightArm.x = -5.0F;
		this.leftArm.z = 0.0F;
		this.leftArm.x = 5.0F;
		if (this.riding) {
			this.head.y = 2.0F;
			this.body.y = 2.0F;
			this.rightArm.y = 4.0F;
			this.leftArm.y = 4.0F;
			this.leftLeg.y = -18.0F;
			this.rightLeg.y = -18.0F;
		} else {
			this.head.y = 12.0F;
			this.body.y = 12.0F;
			this.rightArm.y = 14.0F;
			this.leftArm.y = 14.0F;
			this.leftLeg.y = -8.0F;
			this.rightLeg.y = -8.0F;
		}
		float f = 1.0F;
		if (flag) {
		   f = (float)entity.getDeltaMovement().lengthSqr();
		   f /= 0.2F;
		   f *= f * f;
		}
  
		if (f < 1.0F) {
		   f = 1.0F;
		}

		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        this.rightArm.yRot = 0.0F;
        this.leftArm.yRot = 0.0F;
		this.rightArm.zRot = 0.0F;
		this.leftArm.zRot = 0.0F;
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
		this.rightLeg.yRot = 0.005F;
		this.leftLeg.yRot = -0.005F;
		this.rightLeg.zRot = 0.005F;
		this.leftLeg.zRot = -0.005F;

		this.setupAttackAnimation(entity, ageInTicks);
        AnimationUtils.bobModelPart(this.rightArm, ageInTicks, 1.0F);
        AnimationUtils.bobModelPart(this.leftArm, ageInTicks, -1.0F);

		this.hat.copyFrom(this.head);
	}

	   protected void setupAttackAnimation(T p_103363_, float p_103364_) {
	      if (this.attackTime > 0.0F) {
	         AnimationUtils.swingWeaponDown(this.rightArm, this.leftArm, p_103363_, this.attackTime, p_103364_);
	      } else {
	         super.setupAttackAnimation(p_103363_, p_103364_);
	      }
	   }

	   private void holdWeaponHigh(T p_103361_) {
	      if (p_103361_.isLeftHanded()) {
	         this.leftArm.xRot = leftArm.xRot-1F;
	      } else {
	         this.rightArm.xRot = rightArm.xRot-1F;
	      }
	   }

	public void translateToHand(HumanoidArm side, PoseStack poseStack) {
		ModelPart modelpart = this.getArm(side);
			modelpart.translateAndRotate(poseStack);
		}

      
}