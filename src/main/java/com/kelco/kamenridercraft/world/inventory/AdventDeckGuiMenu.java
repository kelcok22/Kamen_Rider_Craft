
package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.BaseItems.comonent.BasicContainer;
import com.kelco.kamenridercraft.item.BaseItems.comonent.slot.SlotByItem;
import com.kelco.kamenridercraft.item.BaseItems.comonent.slot.SlotByTag;
import com.kelco.kamenridercraft.item.Ryuki_Rider_Items;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.*;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;

public class AdventDeckGuiMenu extends AbstractContainerMenu {
	private static final int CONTAINER_SIZE = 10;
	private final Container container;

	public AdventDeckGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf) {
		this(containerId, playerInventory,new ItemStack(Ryuki_Rider_Items.BLANK_DECK.get()));
	}

	public AdventDeckGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf, ItemStack itemstack) {

		this(containerId, playerInventory,itemstack);
	}

	public AdventDeckGuiMenu(int containerId, Inventory playerInventory,ItemStack itemstack) {
		super(ModMenus.ADVENT_DECK_GUI.get(), containerId);
		this.container = new BasicContainer(itemstack,10);
		container.startOpen(playerInventory.player);

		int i = 3;
		int j = 9;

		this.addSlot(new SlotByTag(container,0,33,21,"gear/advent_cards"));
		this.addSlot(new SlotByTag(container,1,56,21,"gear/advent_cards"));
		this.addSlot(new SlotByTag(container,2,80,21,"gear/advent_cards"));
		this.addSlot(new SlotByTag(container,3,103,21,"gear/advent_cards"));
		this.addSlot(new SlotByTag(container,4,126,21,"gear/advent_cards"));
		this.addSlot(new SlotByTag(container,5,33,44,"gear/advent_cards"));
		this.addSlot(new SlotByTag(container,6,56,44,"gear/advent_cards"));
		this.addSlot(new SlotByTag(container,7,80,44,"gear/advent_cards"));
		this.addSlot(new SlotByTag(container,8,103,44,"gear/advent_cards"));
		this.addSlot(new SlotByItem(container,9,126,44, Items.APPLE));

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
