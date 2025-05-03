
package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.BaseItems.component.SingleItemContainer;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class NeoDiendriverGuiMenu extends AbstractContainerMenu {
	private final Container container;

	public NeoDiendriverGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf) {
		this(containerId, playerInventory,new ItemStack(Decade_Rider_Items.NEO_DIENDRIVER.get()));
	}

	public NeoDiendriverGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf, ItemStack itemstack) {

		this(containerId, playerInventory,itemstack);
	}

	public NeoDiendriverGuiMenu(int containerId, Inventory playerInventory, ItemStack itemstack) {
		super(ModMenus.NEO_DIENDRIVER_GUI.get(), containerId);
		this.container = new SingleItemContainer(itemstack,3);
		container.startOpen(playerInventory.player);

		int i = 3;
		int j = 9;

		this.addSlot(new SlotByTag(container,0,78,18,"gear/rider_cards/neo_diendriver"));
		this.addSlot(new SlotByTag(container,1,78,36,"gear/rider_cards/neo_diendriver"));
		this.addSlot(new SlotByTag(container,2,78,54,"gear/rider_cards/neo_diendriver"));

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
