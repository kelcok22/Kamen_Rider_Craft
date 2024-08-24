package com.kelco.kamenridercraft.client.models;



import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.AnimationUtils;
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

public class BasicMobModel<T extends Mob> extends PlayerModel<T> {
	
	  private final PartPose bodyDefault = this.body.storePose();
	   private final PartPose headDefault = this.head.storePose();
	   private final PartPose leftArmDefault = this.leftArm.storePose();
	   private final PartPose rightArmDefault = this.rightArm.storePose();

   public BasicMobModel(ModelPart p_171090_) {
	   super(p_171090_, false);
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
   
   public void setupAnim(T p_103366_, float p_103367_, float p_103368_, float p_103369_, float p_103370_, float p_103371_) {
		  this.body.loadPose(this.bodyDefault);
	      this.head.loadPose(this.headDefault);
		  this.leftArm.loadPose(this.leftArmDefault);
		  this.rightArm.loadPose(this.rightArmDefault);
	      super.setupAnim(p_103366_, p_103367_, p_103368_, p_103369_, p_103370_, p_103371_);
	    
	          if (p_103366_.isAggressive() && p_103366_.getMainHandItem().getItem() instanceof TieredItem) {
	            this.holdWeaponHigh(p_103366_);
	         }

		  if (p_103366_ instanceof TamableAnimal sittingMob && sittingMob.isInSittingPose()) {
		  	this.rightArm.xRot += (-(float)Math.PI / 5F);
		  	this.leftArm.xRot += (-(float)Math.PI / 5F);
		  	this.rightLeg.xRot = -1.4137167F;
		  	this.rightLeg.yRot = ((float)Math.PI / 10F);
		  	this.rightLeg.zRot = 0.07853982F;
		  	this.leftLeg.xRot = -1.4137167F;
		  	this.leftLeg.yRot = (-(float)Math.PI / 10F);
		  	this.leftLeg.zRot = -0.07853982F;
			this.head.y -= -10.0F;
			for( ModelPart part : this.bodyParts() ){ 
				part.y -= -10.0F;
			}
		  }

	      this.leftPants.copyFrom(this.leftLeg);
	      this.rightPants.copyFrom(this.rightLeg);
	      this.leftSleeve.copyFrom(this.leftArm);
	      this.rightSleeve.copyFrom(this.rightArm);
	      this.jacket.copyFrom(this.body);
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
	         this.leftArm.xRot = -1F;
	      } else {
	         this.rightArm.xRot = -1F;
	      }

	   }

   public void translateToHand(HumanoidArm p_103778_, PoseStack p_103779_) {
      float f = p_103778_ == HumanoidArm.RIGHT ? 1.0F : -1.0F;
      ModelPart modelpart = this.getArm(p_103778_);
      modelpart.x += f;
      modelpart.translateAndRotate(p_103779_);
      modelpart.x -= f;
   }
      
}