package com.kelco.kamenridercraft.block.custom;


import com.kelco.kamenridercraft.blockentity.MindDoorBlockEntity;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.HashSet;

public class MindDoorBlock extends BaseEntityBlock {
    public static final MapCodec<MindDoorBlock> CODEC = simpleCodec(MindDoorBlock::new);
    public static VoxelShape SHAPE = Block.box(0, 0, 0, 16, 32, 2);

    public static DirectionProperty FACING;
    protected static final VoxelShape EAST_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;

    public MindDoorBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player rider, BlockHitResult hitResult) {
        ResourceKey<Level> dreamDimension = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:dream"));

        if (rider instanceof ServerPlayer serverPlayer && level.dimension() == dreamDimension) {
            if (!serverPlayer.isCreative()) {
                rider.addEffect(new MobEffectInstance(EffectCore.INSOMNIA, 1200, 0, false, true));
            }
            DimensionTransition respawn = serverPlayer.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);
            double X = respawn.pos().x();
            double Y = respawn.pos().y();
            double Z = respawn.pos().z();
            rider.teleportTo(rider.getServer().overworld(), X, Y, Z, new HashSet<>(), 0, 0);
            while (!rider.getServer().overworld().noCollision(rider) || rider.getServer().overworld().containsAnyLiquid(rider.getBoundingBox())) {
                rider.teleportRelative(0.0, 5.0, 0.0);
            }
            rider.randomTeleport(X, Y, Z, false);
        }
        return super.useWithoutItem(state, level, pos, rider, hitResult);
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case WEST -> WEST_AABB;
            default -> EAST_AABB;
        };
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
    }

    public PushReaction getPistonPushReaction(BlockState p_53683_) {
        return PushReaction.DESTROY;
    }

    public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
        return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        EAST_AABB = Block.box(0, 0, 0, 16, 32, 16);
        WEST_AABB = Block.box(0, 0, 0, 16, 32, 16);
        SOUTH_AABB = Block.box(0, 0, 0, 16, 32, 16);
        NORTH_AABB = Block.box(0, 0, 0, 16, 32, 16);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static boolean isShapeFullBlock(VoxelShape p_49917_) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MindDoorBlockEntity(blockPos, blockState);
    }
}