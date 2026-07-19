package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.base_items.component.BasicContainer;
import com.kelco.kamenridercraft.item.base_items.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.ooo.OMedalHolderItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class OMedalHolderGuiMenu extends AbstractContainerMenu {
    private final Container container;

    public OMedalHolderGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId, inventory, new ItemStack(OOORiderItems.O_MEDAL_HOLDER.get()));
    }

    public OMedalHolderGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf, ItemStack itemStack) {
        this(containerId, inventory, itemStack);
    }

    public OMedalHolderGuiMenu(int containerId, Inventory inventory, ItemStack itemStack) {
        super(ModMenus.O_MEDAL_HOLDER_GUI.get(), containerId);
        this.container = new BasicContainer(itemStack, 24);
        container.startOpen(inventory.player);

        this.addSlot(new SlotByTag(container, 0, 30, 17, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 1, 48, 17, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 2, 66, 17, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 3, 30, 35, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 4, 48, 35, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 5, 66, 35, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 6, 30, 53, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 7, 48, 53, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 8, 66, 53, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 9, 30, 71, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 10, 48, 71, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 11, 66, 71, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 12, 94, 17, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 13, 112, 17, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 14, 130, 17, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 15, 94, 35, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 16, 112, 35, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 17, 130, 35, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 18, 94, 53, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 19, 112, 53, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 20, 130, 53, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 21, 94, 71, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 22, 112, 71, "gear/core_medals"));
        this.addSlot(new SlotByTag(container, 23, 130, 71, "gear/core_medals"));

        for (int i1 = 0; i1 < 3; ++i1) {
            for (int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 102 + i1 * 18) {
                    @Override
                    public boolean mayPickup(@NotNull Player player) {
                        return !(this.getItem().getItem() instanceof OMedalHolderItem);
                    }
                });
            }
        }

        for (int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(inventory, j1, 8 + j1 * 18, 160) {
                @Override
                public boolean mayPickup(@NotNull Player player) {
                    return !(this.getItem().getItem() instanceof OMedalHolderItem);
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
            }
        }
        return itemStack;
    }


    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }
}