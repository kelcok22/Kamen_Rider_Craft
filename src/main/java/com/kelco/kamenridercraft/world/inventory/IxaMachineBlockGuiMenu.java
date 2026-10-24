package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.block.RiderBlocks;
import com.kelco.kamenridercraft.blockentity.IxaMachineBlockEntity;
import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.recipe.IxaMachineRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Optional;

public class IxaMachineBlockGuiMenu extends AbstractContainerMenu {
    private final IxaMachineBlockEntity bEntity;
    private final Level level;
    private final ContainerData data;

    public IxaMachineBlockGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory,
                playerInventory.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(2));
    }

    public IxaMachineBlockGuiMenu(int containerId, Inventory playerInventory, BlockEntity blockEntity, ContainerData data) {
        super(ModMenus.IXA_MACHINE_BLOCK_GUI.get(), containerId);
        checkContainerDataCount(data, 2);
        this.bEntity = (IxaMachineBlockEntity) blockEntity;
        this.level = playerInventory.player.level();
        this.data = data;

        addDataSlots(data);

        this.addSlot(new Slot((Container) blockEntity, 0, 36, 25));
        this.addSlot(new Slot((Container) blockEntity, 1, 36, 50));

        int slotIndex = 2;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.addSlot(new Slot((Container) blockEntity, slotIndex, 95 + (col * 18), 17 + (row * 18)){
                    public boolean mayPlace(ItemStack stack) {
                        return false;
                    }
                });
                slotIndex++;
            }
        }

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = slots.get(index);
        if (!sourceSlot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyStack = sourceStack.copy();

        if (index < 11) {
            if (!this.moveItemStackTo(sourceStack, 14, 47, true)) {
                return ItemStack.EMPTY;
            }
        } else {
            if (!this.moveItemStackTo(sourceStack, 0, 1, false)) {
                return ItemStack.EMPTY;
            }
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.setByPlayer(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        if (sourceStack.getCount() == copyStack.getCount()) {
            return ItemStack.EMPTY;
        }

        sourceSlot.onTake(player, sourceStack);
        return copyStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, bEntity.getBlockPos()), player, RiderBlocks.IXA_MACHINE_BLOCK.get());
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int arrowPixelSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}