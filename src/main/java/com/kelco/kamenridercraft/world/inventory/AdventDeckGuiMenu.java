
package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.*;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;

public class AdventDeckGuiMenu extends AbstractContainerMenu {
	private static final int CONTAINER_SIZE = 10;
	private final Container container;

	public AdventDeckGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf) {
		this(containerId, playerInventory, new SimpleContainer(10));
	}

	public AdventDeckGuiMenu(int containerId, Inventory playerInventory, Container container) {
		super(ModMenus.ADVENT_DECK_GUI.get(), containerId);
		checkContainerSize(container, 10);
		this.container = container;
		container.startOpen(playerInventory.player);
		int i = 3;
		int j = 9;

		this.addSlot(new Slot(container,0,28,19));
		this.addSlot(new Slot(container,1,54,19));
		this.addSlot(new Slot(container,2,80,19));
		this.addSlot(new Slot(container,3,106,19));
		this.addSlot(new Slot(container,4,132,19));
		this.addSlot(new Slot(container,5,28,45));
		this.addSlot(new Slot(container,6,54,45));
		this.addSlot(new Slot(container,7,80,45));
		this.addSlot(new Slot(container,8,106,45));
		this.addSlot(new Slot(container,9,132,45));

		for(int i1 = 0; i1 < 3; ++i1) {
			for(int k1 = 0; k1 < 9; ++k1) {
				this.addSlot(new Slot(playerInventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));
			}
		}

		for(int j1 = 0; j1 < 9; ++j1) {
			this.addSlot(new Slot(playerInventory, j1, 8 + j1 * 18, 142));
		}
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	@Override
	public boolean stillValid(Player player) {
		return this.container.stillValid(player);
	}

	/**
	 * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player inventory and the other inventory(s).
	 */
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
