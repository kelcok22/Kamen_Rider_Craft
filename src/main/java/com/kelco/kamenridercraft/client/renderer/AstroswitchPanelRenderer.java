package com.kelco.kamenridercraft.client.renderer;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.entity.AstroswitchPanelBlockEntity;
import com.kelco.kamenridercraft.block.storageBlock.AstroswitchPanelBlock;
import com.kelco.kamenridercraft.entities.ChairEntity;
import com.kelco.kamenridercraft.entities.bikes.baseBikeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;

import java.util.Calendar;

public class AstroswitchPanelRenderer<T extends BlockEntity > implements BlockEntityRenderer<T> {
    private static final String BACK1 = "back1";
    private static final String FRONT = "front";
    private static final String BACK2 = "back2";
    private static final String BACK3 = "back3";
    private static final String BACK4 = "back4";
    private final ModelPart front;
    private final ModelPart back1;
    private final ModelPart back2;
    private final ModelPart back3;
    private final ModelPart back4;
    private final ModelPart doubleLeftFront;
    private final ModelPart doubleLeftBack1;
    private final ModelPart doubleLeftBack2;
    private final ModelPart doubleLeftBack3;
    private final ModelPart doubleLeftBack4;
    private final ModelPart doubleRightFront;
    private final ModelPart doubleRightBack1;
    private final ModelPart doubleRightBack2;
    private final ModelPart doubleRightBack3;
    private final ModelPart doubleRightBack4;

    public AstroswitchPanelRenderer(BlockEntityRendererProvider.Context context) {

        ModelPart modelpart = context.bakeLayer(ModelLayers.CHEST)
                implement
        ModelPart modelpart1 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT);
        this.
        ModelPart modelpart2 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT);
        this.doubleRightFront = modelpart2.getChild("front");
        this.doubleRightBack1 = modelpart2.getChild("back1");
        this.doubleRightBack2 = modelpart2.getChild("back2");
        this.doubleRightBack3 = modelpart2.getChild("back3");
        this.doubleRightBack4 = modelpart2.getChild("back4");
    }


    public static LayerDefinition createDoubleBodyRightLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(1.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        partdefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(15.0F, -2.0F, 14.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createDoubleBodyLeftLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        partdefinition.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, 14.0F, 1.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 9.0F, 1.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level = blockEntity.getLevel();
        boolean flag = level != null;
        BlockState blockstate = flag ? blockEntity.getBlockState() : (BlockState) Blocks.CHEST.defaultBlockState().setValue(AstroswitchPanelBlock.FACING, Direction.SOUTH);
        ChestType chesttype = blockstate.hasProperty(AstroswitchPanelBlock.TYPE) ? (ChestType)blockstate.getValue(AstroswitchPanelBlock.TYPE) : ChestType.SINGLE;
        Block var12 = blockstate.getBlock();
        if (var12 instanceof AbstractChestBlock<?> abstractchestblock) {
            boolean flag1 = chesttype != ChestType.SINGLE;
            poseStack.pushPose();
            float f = ((Direction)blockstate.getValue(ChestBlock.FACING)).toYRot();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            poseStack.mulPose(Axis.YP.rotationDegrees(-f));
            poseStack.translate(-0.5F, -0.5F, -0.5F);
            DoubleBlockCombiner.NeighborCombineResult neighborcombineresult;
            if (flag) {
                neighborcombineresult = abstractchestblock.combine(blockstate, level, blockEntity.getBlockPos(), true);
            } else {
                neighborcombineresult = DoubleBlockCombiner.Combiner::acceptNone;
            }

            poseStack.popPose();
        }

    }


    @Override
    public void render(AstroswitchPanelBlockEntity astroswitchPanelBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {

    }
}