package com.kelco.kamenridercraft.block.custom;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.entity.IxaMachineBlockEntity;
import com.kelco.kamenridercraft.block.entity.ModBlockEntities;
import com.kelco.kamenridercraft.block.machineBlocks.GaiaMemoryRefinerBlock;
import com.kelco.kamenridercraft.world.inventory.NeoDiendriverGuiMenu;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.List;

public class IxaMachineBlock extends BaseEntityBlock {

    public IxaMachineBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new IxaMachineBlockEntity(blockPos, blockState);
    }

    @Override
    protected RenderShape getRenderShape (BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof IxaMachineBlockEntity ixaMachineBlockEntity) {
                ixaMachineBlockEntity.drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos,
                                              Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof IxaMachineBlockEntity ixaMachineBlockEntity) {
                ((ServerPlayer) pPlayer).openMenu(new SimpleMenuProvider(ixaMachineBlockEntity, Component.translatable(KamenRiderCraftCore.MOD_ID + ":ixamachine")), pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
    }


//    @Nullable
//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
//        if(level.isClientSide()) {
//            return null;
//        }
//
//        return createTickerHelper(blockEntityType, ModBlockEntities.IXA_MACHINE_BLOCK_BE.get(),
//                (level1, blockPos, blockState, blockEntity) -> blockEntity.tick(level1, blockPos, blockState));
//    }

    public IxaMachineBlock AddToTabList(List<Block> TabList) {
        TabList.add(this);
        return this;
    }

}
