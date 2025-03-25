
package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.BaseItems.component.BasicContainer;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Fourze_Rider_Items;
import com.kelco.kamenridercraft.item.decade.RideBookerItem;
import com.kelco.kamenridercraft.item.ex_aid.RiderGashatCaseItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class RiderGashatCaseGuiMenu extends AbstractContainerMenu {
	private static final int CONTAINER_SIZE = 11;
	private final Container container;

	public RiderGashatCaseGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf) {
		this(containerId, playerInventory,new ItemStack(Ex_Aid_Rider_Items.RIDER_GASHAT_CASE.get()));
	}

	public RiderGashatCaseGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf registryFriendlyByteBuf, ItemStack itemstack) {

		this(containerId, playerInventory,itemstack);
	}

	public RiderGashatCaseGuiMenu(int containerId, Inventory playerInventory, ItemStack itemstack) {
		super(ModMenus.RIDER_GASHAT_CASE_GUI.get(), containerId);
		this.container = new BasicContainer(itemstack,11);
		container.startOpen(playerInventory.player);

		int i = 3;
		int j = 9;

		this.addSlot(new SlotByTag(container,0,36,26,"gear/gashats"));
		this.addSlot(new SlotByTag(container,1,54,26,"gear/gashats"));
		this.addSlot(new SlotByTag(container,2,72,26,"gear/gashats"));
		this.addSlot(new SlotByTag(container,3,90,26,"gear/gashats"));
		this.addSlot(new SlotByTag(container,4,108,26,"gear/gashats"));
		this.addSlot(new SlotByTag(container,5,126,26,"gear/gashats"));
		this.addSlot(new SlotByTag(container,6,45,44,"gear/gashats"));
		this.addSlot(new SlotByTag(container,7,63,44,"gear/gashats"));
		this.addSlot(new SlotByTag(container,8,81,44,"gear/gashats"));
		this.addSlot(new SlotByTag(container,9,99,44,"gear/gashats"));
		this.addSlot(new SlotByTag(container,10,117,44,"gear/gashats"));

		for(int i1 = 0; i1 < 3; ++i1) {
			for(int k1 = 0; k1 < 9; ++k1) {
				this.addSlot(new Slot(playerInventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18){
					@Override
					public boolean mayPickup(Player player) {
						if (this.getItem().getItem() instanceof RiderGashatCaseItem)return false;
						else return true;
					}
				});
			}
		}

		for(int j1 = 0; j1 < 9; ++j1) {
			this.addSlot(new Slot(playerInventory, j1, 8 + j1 * 18, 142){
				@Override
				public boolean mayPickup(Player player) {
					if (this.getItem().getItem() instanceof RiderGashatCaseItem)return false;
					else return true;
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
