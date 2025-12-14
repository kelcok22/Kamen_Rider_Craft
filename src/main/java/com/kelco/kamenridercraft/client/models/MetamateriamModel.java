package com.kelco.kamenridercraft.client.models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.summons.TechnolomProjectionEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class MetamateriamModel<T extends TechnolomProjectionEntity> extends PlayerModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "technolom_projection"), "main");

	public MetamateriamModel(ModelPart root) {
        super(root, false);
	}

	public void prepareMobModel(T p_103793_, float p_103794_, float p_103795_, float p_103796_) {
		this.rightArmPose = ArmPose.EMPTY;
		this.leftArmPose = ArmPose.EMPTY;
		ItemStack itemstack = p_103793_.getItemInHand(InteractionHand.MAIN_HAND);
		if (itemstack.getItem() instanceof BowItem && p_103793_.isUsingItem()) {
			if (p_103793_.getMainArm() == HumanoidArm.RIGHT) {
				this.rightArmPose = ArmPose.BOW_AND_ARROW;
			} else {
				this.leftArmPose = ArmPose.BOW_AND_ARROW;
			}
		}

		super.prepareMobModel(p_103793_, p_103794_, p_103795_, p_103796_);
	}

	public void translateToHand(HumanoidArm side, PoseStack poseStack) {
		ModelPart modelpart = this.getArm(side);
		modelpart.translateAndRotate(poseStack);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		partdefinition.addOrReplaceChild("ear", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -1.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
		partdefinition.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 16.0F, 1.0F, new CubeDeformation(0.0F), 1.0F, 0.5F), PartPose.offset(0.0F, 0.0F, 0.0F));


		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,new CubeDeformation(0.0F).extend(0.25F)), PartPose.offset(5.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,new CubeDeformation(0.0F).extend(0.25F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("left_pants", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F).extend(0.25F)), PartPose.offset(1.9F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_pants", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F).extend(0.25F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F).extend(0.25F)), PartPose.ZERO);

		addHead(meshdefinition);
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static void addHead(MeshDefinition mesh) {
		PartDefinition partdefinition = mesh.getRoot();

		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition1.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition horns = partdefinition1.addOrReplaceChild("horns", CubeListBuilder.create().texOffs(25, 5).addBox(-1.0F, -5.0F, -4.9F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(25, 5).addBox(2.0F, -7.0F, -4.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(25, 5).addBox(1.0F, -6.0F, -4.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(25, 5).addBox(-3.0F, -7.0F, -4.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(25, 5).addBox(-2.0F, -6.0F, -4.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		horns.addOrReplaceChild("horns_r1", CubeListBuilder.create().texOffs(25, 2).addBox(0.0F, -3.4F, 2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(25, 2).addBox(5.0F, -3.4F, 2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(25, 2).addBox(0.0F, -5.4F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 2).addBox(5.0F, -5.4F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, -6.0F, -0.3927F, 0.0F, 0.0F));

	}
}