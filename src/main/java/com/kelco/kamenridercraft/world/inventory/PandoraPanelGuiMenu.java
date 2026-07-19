package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.base_items.component.BasicContainer;
import com.kelco.kamenridercraft.item.base_items.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.build.PandoraPanelItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

public class PandoraPanelGuiMenu extends AbstractContainerMenu {
    private final Container container;
    private BlockPos blockPos;

    public PandoraPanelGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId, inventory, new ItemStack(BuildRiderItems.PANDORA_PANEL_TOUTO.get()));
    }

    public PandoraPanelGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf, ItemStack itemStack, BlockPos blockPos) {
        this(containerId, inventory, itemStack);
        this.blockPos = blockPos;
    }

    public PandoraPanelGuiMenu(int containerId, Inventory inventory, ItemStack itemStack) {
        super(ModMenus.PANDORA_PANEL_GUI.get(), containerId);
        this.container = new BasicContainer(itemStack, 10);
        container.startOpen(inventory.player);

        this.addSlot(new SlotByTag(container, 0, 33, 21, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 1, 56, 21, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 2, 80, 21, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 3, 103, 21, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 4, 126, 21, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 5, 33, 44, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 6, 56, 44, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 7, 80, 44, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 8, 103, 44, "gear/fullbottles"));
        this.addSlot(new SlotByTag(container, 9, 126, 44, "gear/fullbottles"));

        for (int i1 = 0; i1 < 3; ++i1) {
            for (int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18) {
                    @Override
                    public boolean mayPickup(@NotNull Player player) {
                        return !(this.getItem().getItem() instanceof PandoraPanelItem);
                    }
                });
            }
        }

        for (int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(inventory, j1, 8 + j1 * 18, 142) {
                @Override
                public boolean mayPickup(@NotNull Player player) {
                    return !(this.getItem().getItem() instanceof PandoraPanelItem);
                }
            });
        }
    }


    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.container.stillValid(player);
    }


    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemStackTwo = slot.getItem();
            itemStack = itemStackTwo.copy();
            if (index < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemStackTwo, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStackTwo, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemStackTwo.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
                if (blockPos != null) {
                    BlockEntity blockentity = player.level().getBlockEntity(blockPos);
                    assert blockentity != null;
                    blockentity.setChanged();
                }
            }
        }
        return itemStack;
    }


    @Override
    public void removed(@NotNull Player player) {
        if (blockPos != null) {
            BlockEntity blockentity = player.level().getBlockEntity(blockPos);
            assert blockentity != null;
            blockentity.setChanged();
        }
        super.removed(player);
        this.container.stopOpen(player);
    }
}