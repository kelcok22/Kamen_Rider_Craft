package com.kelco.kamenridercraft.block.custom;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.entity.IxaMachineBlockEntity;
import com.kelco.kamenridercraft.block.entity.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.List;

public class IxaMachineBlock extends BaseEntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public IxaMachineBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
    }

    public PushReaction getPistonPushReaction(BlockState p_53683_) {
        return PushReaction.PUSH_ONLY;
    }

    public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
        return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
    }

        @Override
        protected MapCodec<? extends BaseEntityBlock> codec () {
            return null;
        }

        @Nullable
        @Override
        public BlockEntity newBlockEntity (BlockPos blockPos, BlockState blockState){
            return new IxaMachineBlockEntity(blockPos, blockState);
        }

        @Override
        protected RenderShape getRenderShape (BlockState state){
            return RenderShape.MODEL;
        }

        @Override
        public void onRemove (BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState,boolean pIsMoving){
            if (pState.getBlock() != pNewState.getBlock()) {
                BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
                if (blockEntity instanceof IxaMachineBlockEntity ixaMachineBlockEntity) {
                    ixaMachineBlockEntity.drops();
                }
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }

        @Override
        protected ItemInteractionResult useItemOn (ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos,
                Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult){
            if (!pLevel.isClientSide()) {
                BlockEntity entity = pLevel.getBlockEntity(pPos);
                if (entity instanceof IxaMachineBlockEntity ixaMachineBlockEntity) {
                    pPlayer.openMenu(new SimpleMenuProvider(ixaMachineBlockEntity, Component.translatable("ixamachine.text")), pPos);
                } else {
                    throw new IllegalStateException("Our Container provider is missing!");
                }
            }

            return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
        }


    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (blockEntityType != ModBlockEntities.IXA_MACHINE_BLOCK_BE.get()) return null;

        if (level.isClientSide) {
            return (lvl, pos, st, be) -> {
                if (be instanceof IxaMachineBlockEntity extractor) {
                    IxaMachineBlockEntity.clientTick(lvl, pos, st, extractor);
                }
            };
        } else {
            return createTickerHelper(blockEntityType, ModBlockEntities.IXA_MACHINE_BLOCK_BE.get(),
                    (level1, blockPos, blockState, ixaMachineBlockEntity) -> ixaMachineBlockEntity.tick(level1, blockPos, blockState));
        }
    }

}
