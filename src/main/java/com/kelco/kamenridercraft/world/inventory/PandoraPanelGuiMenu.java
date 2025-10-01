
package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.BaseItems.component.BasicContainer;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.build.PandoraPanelItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class PandoraPanelGuiMenu extends AbstractContainerMenu {
	private static final int CONTAINER_SIZE = 10;
	private final Container container;

	public PandoraPanelGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf) {
		this(containerId, playerInventory,new ItemStack(Build_Rider_Items.PANDORA_PANEL_TOUTO.get()));
	}

	public PandoraPanelGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf, ItemStack itemstack) {

		this(containerId, playerInventory,itemstack);
	}

	public PandoraPanelGuiMenu(int containerId, Inventory playerInventory, ItemStack itemstack) {
		super(ModMenus.PANDORA_PANEL_GUI.get(), containerId);
		this.container = new BasicContainer(itemstack,10);
		container.startOpen(playerInventory.player);

		int i = 3;
		int j = 9;

		this.addSlot(new SlotByTag(container,0,33,21,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,1,56,21,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,2,80,21,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,3,103,21,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,4,126,21,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,5,33,44,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,6,56,44,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,7,80,44,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,8,103,44,"gear/fullbottles"));
		this.addSlot(new SlotByTag(container,9,126,44,"gear/fullbottles"));

		for(int i1 = 0; i1 < 3; ++i1) {
			for(int k1 = 0; k1 < 9; ++k1) {
				this.addSlot(new Slot(playerInventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18){
					@Override
					public boolean mayPickup(Player player) {
                        return !(this.getItem().getItem() instanceof PandoraPanelItem);
					}
				});
			}
		}

		for(int j1 = 0; j1 < 9; ++j1) {
			this.addSlot(new Slot(playerInventory, j1, 8 + j1 * 18, 142){
				@Override
				public boolean mayPickup(Player player) {
                    return !(this.getItem().getItem() instanceof PandoraPanelItem);
				}
			});
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
