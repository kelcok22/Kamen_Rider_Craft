package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.base_items.component.BasicContainer;
import com.kelco.kamenridercraft.item.base_items.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.reiwa.SaberRiderItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class HissatsuHolderGuiMenu extends AbstractContainerMenu {
    private final Container container;

    public HissatsuHolderGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId, inventory, new ItemStack(SaberRiderItems.SEIKEN_SWORDRIVER_DRIVER_SABER.get()));
    }

    public HissatsuHolderGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf, ItemStack itemStack) {
        this(containerId, inventory, itemStack);
    }

    public HissatsuHolderGuiMenu(int containerId, Inventory inventory, ItemStack itemstack) {
        super(ModMenus.HISSATSU_HOLDER_GUI.get(), containerId);
        this.container = new BasicContainer(itemstack, 4);
        container.startOpen(inventory.player);

        this.addSlot(new Slot(container, 3, 116, 44) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/by_series/saber")));
            }
        });
        this.addSlot(new SlotByTag(container, 0, 44, 26, "gear/wonder_ride_books"));
        this.addSlot(new SlotByTag(container, 1, 44, 44, "gear/wonder_ride_books"));
        this.addSlot(new SlotByTag(container, 2, 116, 26, "gear/wonder_ride_books"));

        for (int i1 = 0; i1 < 3; ++i1) {
            for (int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));
            }
        }

        for (int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(inventory, j1, 8 + j1 * 18, 142));
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