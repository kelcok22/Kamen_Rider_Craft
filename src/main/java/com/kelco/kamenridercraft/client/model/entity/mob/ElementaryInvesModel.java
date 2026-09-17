package com.kelco.kamenridercraft.client.model.entity.mob;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class ElementaryInvesModel<T extends Mob> extends BasicMobModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "elementary_inves_red"), "main");

    public ElementaryInvesModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partDefinitionOne = meshdefinition.getRoot();
        PartDefinition partDefinitionTwo = partDefinitionOne.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16)
                .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.ZERO);

        PartDefinition bodyThree = partDefinitionTwo.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(56, 0).mirror()
                .addBox(-9.0F, -5.0F, -2.0F, 18.0F, 9.0F, 8.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3718F, 0.0F, 0.0F));
        PartDefinition bodyTwo = partDefinitionTwo.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(56, 17).mirror()
                .addBox(-5.0F, 0.0F, 3.0F, 10.0F, 11.0F, 3.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2603F, 0.0F, 0.0F));

        partDefinitionOne.addOrReplaceChild("ear", CubeListBuilder.create().texOffs(24, 0)
                .addBox(-3.0F, -6.0F, -1.0F, 6.0F, 6.0F, 1.0F,
                        new CubeDeformation(0.0F)), PartPose.ZERO);
        partDefinitionOne.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-5.0F, 0.0F, -1.0F, 10.0F, 16.0F, 1.0F,
                        new CubeDeformation(0.0F), 1.0F, 0.5F), PartPose.offset(0.0F, 0.0F, 0.0F));

        partDefinitionOne.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16)
                .addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
        partDefinitionOne.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48)
                .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));
        partDefinitionOne.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48)
                .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F).extend(0.25F)), PartPose.offset(5.0F, 2.0F, 0.0F));
        partDefinitionOne.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32)
                .addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F).extend(0.25F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

        partDefinitionOne.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 48)
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
        partDefinitionOne.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror()
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

        partDefinitionOne.addOrReplaceChild("left_pants", CubeListBuilder.create().texOffs(0, 48)
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F).extend(0.25F)), PartPose.offset(1.9F, 12.0F, 0.0F));
        partDefinitionOne.addOrReplaceChild("right_pants", CubeListBuilder.create().texOffs(0, 32)
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F).extend(0.25F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
        partDefinitionOne.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(16, 32)
                .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F,
                        new CubeDeformation(0.0F).extend(0.25F)), PartPose.ZERO);

        addHead(meshdefinition);
        partDefinitionOne.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public static void addHead(MeshDefinition mesh) {
        PartDefinition partDefinitionOne = mesh.getRoot();
        PartDefinition partDefinitionTwo = partDefinitionOne.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 0).mirror().
                        addBox(-4.0F, -6.0F, -6.0F, 8.0F, 8.0F, 8.0F,
                                new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
    }
}