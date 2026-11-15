package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.base_items.component.SingleItemContainer;
import com.kelco.kamenridercraft.item.base_items.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class LegendRideMagnumGuiMenu extends AbstractContainerMenu {
    private final Container container;

    public LegendRideMagnumGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId, inventory, new ItemStack(GotchardRiderItems.LEGEND_RIDE_MAGNUM.get()));
    }

    public LegendRideMagnumGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf, ItemStack itemStack) {
        this(containerId, inventory, itemStack);
    }

    public LegendRideMagnumGuiMenu(int containerId, Inventory inventory, ItemStack itemStack) {
        super(ModMenus.LEGEND_RIDE_MAGNUM_GUI.get(), containerId);
        container = new SingleItemContainer(itemStack, 4);
        container.startOpen(inventory.player);

        addSlot(new SlotByTag(container, 0, 78, 16, "gear/ride_chemy_cards/legend_ride_magnum"));
        addSlot(new SlotByTag(container, 1, 78, 34, "gear/ride_chemy_cards/legend_ride_magnum"));
        addSlot(new SlotByTag(container, 2, 60, 34, "gear/ride_chemy_cards/legend_ride_magnum"));
        addSlot(new SlotByTag(container, 3, 78, 52, "gear/ride_chemy_cards/legend_ride_magnum"));

        for (int i1 = 0; i1 < 3; ++i1) {
            for (int k1 = 0; k1 < 9; ++k1) {
                addSlot(new Slot(inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));
            }
        }

        for (int j1 = 0; j1 < 9; ++j1) {
            addSlot(new Slot(inventory, j1, 8 + j1 * 18, 142));
        }
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return container.stillValid(player);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemStackTwo = slot.getItem();
            itemStack = itemStackTwo.copy();
            if (index < container.getContainerSize()) {
                if (!moveItemStackTo(itemStackTwo, container.getContainerSize(), slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(itemStackTwo, 0, container.getContainerSize(), false)) {
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
        container.stopOpen(player);
    }
}