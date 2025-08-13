package com.kelco.kamenridercraft.block.entity;

import com.kelco.kamenridercraft.block.storageBlock.AstroswitchRackBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.state.BlockState;

public class AstroswitchRackBlockEntity extends ChestBlockEntity {
    private static final int EVENT_SET_OPEN_COUNT = 1;
    private NonNullList<ItemStack> items;
    private final ContainerOpenersCounter openersCounter;
    private final ChestLidController chestLidController;

    protected AstroswitchRackBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);


        this.items = NonNullList.withSize(20, ItemStack.EMPTY);
        this.openersCounter = new ContainerOpenersCounter() {

            @Override
            protected void onOpen(Level level, BlockPos blockPos, BlockState blockState) {

            }

            @Override
            protected void onClose(Level level, BlockPos blockPos, BlockState blockState) {

            }

            @Override
            protected void openerCountChanged(Level level, BlockPos blockPos, BlockState blockState, int i, int i1) {

            }

            protected boolean isOwnContainer(Player p_155355_) {
                if (!(p_155355_.containerMenu instanceof ChestMenu)) {
                    return false;
                } else {
                    Container container = ((ChestMenu)p_155355_.containerMenu).getContainer();
                    return container == AstroswitchRackBlockEntity.this || container instanceof CompoundContainer && ((CompoundContainer)container).contains(AstroswitchRackBlockEntity.this);
                }
            }
        };
        this.chestLidController = new ChestLidController();
    }


//    public AstroswitchRackBlockEntity(BlockPos pos, BlockState blockState) {
//        this(ModBlockEntities.ASTROSWITCH_RACK_BE.get(), pos, blockState);
//    }

    @Override
    public int getContainerSize() {
        return 20;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return ChestMenu.threeRows(id, player, this);
    }

    @Override
    public void setBlockState(BlockState p_155251_) {
        BlockState oldState = this.getBlockState();
        super.setBlockState(p_155251_);
        if (oldState.getValue(AstroswitchRackBlock.FACING) != p_155251_.getValue(AstroswitchRackBlock.FACING) || oldState.getValue(AstroswitchRackBlock.TYPE) != p_155251_.getValue(AstroswitchRackBlock.TYPE)) {
            this.invalidateCapabilities();
        }

    }
}
