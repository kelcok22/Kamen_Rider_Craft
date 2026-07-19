
package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.base_items.component.BasicContainer;
import com.kelco.kamenridercraft.item.base_items.component.slot.SlotByTag;
import com.kelco.kamenridercraft.item.heisei_phase_2.Fourze.AstroswitchCaseItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.FourzeRiderItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AstroswitchCaseGuiMenu extends AbstractContainerMenu {
	private final Container container;

	public AstroswitchCaseGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
		this(containerId, inventory,new ItemStack(FourzeRiderItems.ASTROSWITCH_CASE.get()));
	}

	public AstroswitchCaseGuiMenu(int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf, ItemStack itemStack) {
		this(containerId, inventory,itemStack);
	}

	public AstroswitchCaseGuiMenu(int containerId, Inventory inventory, ItemStack itemStack) {
		super(ModMenus.ASTROSWITCH_CASE_GUI.get(), containerId);
		this.container = new BasicContainer(itemStack,18);
		container.startOpen(inventory.player);

		this.addSlot(new SlotByTag(container,0,36,26,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,1,54,26,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,2,72,26,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,3,90,26,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,4,108,26,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,5,126,26,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,6,45,44,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,7,63,44,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,8,99,44,"gear/astroswitches"));
		this.addSlot(new SlotByTag(container,9,117,44,"gear/astroswitches"));

		for(int i1 = 0; i1 < 3; ++i1) {
			for(int k1 = 0; k1 < 9; ++k1) {
				this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 84 + i1 * 18){
					@Override
					public boolean mayPickup(@NotNull Player player) {
                        return !(this.getItem().getItem() instanceof AstroswitchCaseItem);
					}
				});
			}
		}

		for(int j1 = 0; j1 < 9; ++j1) {
			this.addSlot(new Slot(inventory, j1, 8 + j1 * 18, 142){
				@Override
				public boolean mayPickup(@NotNull Player player) {
                    return !(this.getItem().getItem() instanceof AstroswitchCaseItem);
				}
			});
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