
package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.BaseItems.component.BasicContainer;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ChemyRiserGuiMenu extends AbstractContainerMenu {
	private static final int CONTAINER_SIZE = 2;
	private final Container container;

	public ChemyRiserGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf) {
		this(containerId, playerInventory,new ItemStack(Gotchard_Rider_Items.CHEMY_RISER.get()));
	}

	public ChemyRiserGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf, ItemStack itemstack) {

		this(containerId, playerInventory,itemstack);
	}

	public ChemyRiserGuiMenu(int containerId, Inventory playerInventory, ItemStack itemstack) {
		super(ModMenus.CHEMY_RISER_GUI.get(), containerId);
		this.container = new BasicContainer(itemstack,2);
		container.startOpen(playerInventory.player);

		int i = 3;
		int j = 9;

		this.addSlot(new Slot(container,0,116,35) {
			@Override
			public boolean mayPlace(ItemStack stack) {
				return (stack.getItem()==Gotchard_Rider_Items.BLANK_RIDE_CHEMY_CARD.get());
			}
		});
		this.addSlot(new SlotByTag(container,1,44,35,"gear/alchemist_ring"));

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
