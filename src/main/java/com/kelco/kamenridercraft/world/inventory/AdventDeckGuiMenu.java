
package com.kelco.kamenridercraft.world.inventory;

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

	public AdventDeckGuiMenu(int containerId, Inventory playerInventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
		this(containerId, playerInventory, new SimpleContainer(10));
	}

	public AdventDeckGuiMenu(int containerId, Inventory playerInventory, Container container) {
		super(MenuType.SHULKER_BOX, containerId);
		checkContainerSize(container, 10);
		this.container = container;
		container.startOpen(playerInventory.player);
		int i = 2;
		int j = 5;

		for (int k = 0; k < 2; k++) {
			for (int l = 0; l < 5; l++) {
				this.addSlot(new ShulkerBoxSlot(container, l + k * 9, 8 + l * 18, 18 + k * 18));
			}
		}

		for (int i1 = 0; i1 < 3; i1++) {
			for (int k1 = 0; k1 < 9; k1++) {
				this.addSlot(new Slot(playerInventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18));
			}
		}
		for (int j1 = 0; j1 < 9; j1++) {
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
