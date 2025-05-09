package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.BaseItems.component.BasicContainer;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByItem;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.W_Rider_Items;
import com.kelco.kamenridercraft.item.ex_aid.RiderGashatCaseItem;
import com.kelco.kamenridercraft.item.w.T2MemoryCaseItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class T2MemoryCaseGuiMenu extends AbstractContainerMenu {
    private static final int CONTAINER_SIZE = 26;
    private final Container container;

    public T2MemoryCaseGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf) {
        this(containerId, playerInventory,new ItemStack(W_Rider_Items.T2_MEMORY_CASE.get()));
    }

    public T2MemoryCaseGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf, ItemStack itemstack) {

        this(containerId, playerInventory,itemstack);
    }

    public T2MemoryCaseGuiMenu(int containerId, Inventory playerInventory, ItemStack itemstack) {
        super(ModMenus.T2_MEMORY_CASE_GUI.get(), containerId);
        this.container = new BasicContainer(itemstack,26);
        container.startOpen(playerInventory.player);

        int i = 3;
        int j = 9;

        this.addSlot(new SlotByTag(container,0,8,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,1,26,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,2,44,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,3,62,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,4,80,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,5,98,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,6,116,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,7,134,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,8,152,26,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,9,8,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,10,26,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,11,44,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,12,62,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,13,80,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,14,98,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,15,116,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,16,134,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,17,152,44,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,18,17,62,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,19,35,62,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,20,53,62,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,21,71,62,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,22,89,62,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,23,107,62,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,24,125,62,"gear/gaia_memories/t2"));
        this.addSlot(new SlotByTag(container,25,143,62,"gear/gaia_memories/t2"));


        for(int i1 = 0; i1 < 3; ++i1) {
            for(int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(playerInventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 97 + i1 * 18){
                    @Override
                    public boolean mayPickup(Player player) {
                        if (this.getItem().getItem() instanceof T2MemoryCaseItem)return false;
                        else return true;
                    }
                });
            }
        }

        for(int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(playerInventory, j1, 8 + j1 * 18, 155){
                @Override
                public boolean mayPickup(Player player) {
                    if (this.getItem().getItem() instanceof T2MemoryCaseItem)return false;
                    else return true;
                }
            });
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }
}
