//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.kelco.kamenridercraft.client.models;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeartRoidmudeModel<T extends Mob> extends PlayerModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "heart_roidmude"), "main");


	public HeartRoidmudeModel(ModelPart p_170810_) {
		super(p_170810_,false);


	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		partdefinition.addOrReplaceChild("ear", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -1.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
		partdefinition.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 16.0F, 1.0F, new CubeDeformation(0.0F), 1.0F, 0.5F), PartPose.offset(0.0F, 0.0F, 0.0F));
		float f = 0.25F;


		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));
			partdefinition.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,new CubeDeformation(0.0F).extend(0.5F)), PartPose.offset(5.0F, 2.0F, 0.0F));
			partdefinition.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,new CubeDeformation(0.0F).extend(0.5F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		partdefinition.addOrReplaceChild("left_pants", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F).extend(0.5F)), PartPose.offset(1.9F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_pants", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F).extend(0.5F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F).extend(0.5F)), PartPose.ZERO);

		addHead(meshdefinition);
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public static void addHead(MeshDefinition mesh) {
		PartDefinition partdefinition = mesh.getRoot();

		PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdefinitionbig = partdefinition1.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition partdefinition2 = partdefinition1.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(68, 0).mirror().addBox(-7.0F, -7.0F, -2.0F, 4, 4, 7, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));

		PartDefinition partdefinition3 = partdefinition1.addOrReplaceChild("head3", CubeListBuilder.create().texOffs( 83, 0).addBox(-9.0F, -8.0F, -2.0F, 2, 2, 4, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition4 = partdefinition1.addOrReplaceChild("head4", CubeListBuilder.create().texOffs( 83, 0).mirror().addBox(7.0F, -8.0F, -2.0F, 2, 2, 4, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition5 = partdefinition1.addOrReplaceChild("head5", CubeListBuilder.create().texOffs(95, 0).mirror().addBox(7.0F, -10.0F, -6.0F, 2, 2, 4, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition6 = partdefinition1.addOrReplaceChild("head6", CubeListBuilder.create().texOffs(97, 2).mirror().addBox( 7.0F, -11.0F, -6.0F, 2, 1, 2, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition7 = partdefinition1.addOrReplaceChild("head7", CubeListBuilder.create().texOffs(95, 0).addBox(-9.0F, -10.0F, -6.0F, 2, 2, 4, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition8 = partdefinition1.addOrReplaceChild("head8", CubeListBuilder.create().texOffs(97, 2).addBox(-9.0F, -11.0F, -6.0F, 2, 1, 2, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition9 = partdefinition1.addOrReplaceChild("head9", CubeListBuilder.create().texOffs(98, 3).mirror().addBox(7.0F, -8.0F, -3.0F, 2, 1, 1, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition10 = partdefinition1.addOrReplaceChild("head10", CubeListBuilder.create().texOffs(98, 3).addBox(-9.0F, -8.0F, -3.0F, 2, 1, 1, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition11 = partdefinition1.addOrReplaceChild("head11", CubeListBuilder.create().texOffs(108, 0).addBox(7.0F, -6.0F, -1.0F, 1, 2, 5, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition12 = partdefinition1.addOrReplaceChild("head12", CubeListBuilder.create().texOffs(108, 0).mirror().addBox(-8.0F, -6.0F, -1.0F, 1, 2, 5, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));
		PartDefinition partdefinition13 = partdefinition1.addOrReplaceChild("head13", CubeListBuilder.create().texOffs(68, 0).addBox(3.0F, -7.0F, -2.0F, 4, 4, 7, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0F, 0.0F, 0.0F));

	}





}
