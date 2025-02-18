
package com.kelco.kamenridercraft.world.inventory;

import com.kelco.kamenridercraft.init.ModMenus;
import com.kelco.kamenridercraft.item.Fourze_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AstroswitchPanelDoubleGuiMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;


	public AstroswitchPanelDoubleGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ModMenus.ASTROSWITCH_PANEL_DOUBLE_GUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(40);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				IItemHandler cap = itemstack.getCapability(Capabilities.ItemHandler.ITEM);
				if (cap != null) {
					this.internal = cap;
					this.bound = true;
				}
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null) {
					IItemHandler cap = boundEntity.getCapability(Capabilities.ItemHandler.ENTITY);
					if (cap != null) {
						this.internal = cap;
						this.bound = true;
					}
				}
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity instanceof BaseContainerBlockEntity baseContainerBlockEntity) {
					this.internal = new InvWrapper(baseContainerBlockEntity);
					this.bound = true;
				}
			}
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 14, 22) {
			private final int slot = 0;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.ROCKET_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 37, 22) {
			private final int slot = 1;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.LAUNCHER_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 59, 22) {
			private final int slot = 2;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.DRILL_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 82, 22) {
			private final int slot = 3;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.RADAR_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 104, 22) {
			private final int slot = 4;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.MAGIC_HAND_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 127, 22) {
			private final int slot = 5;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.CAMERA_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 149, 22) {
			private final int slot = 6;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.PARACHUTE_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 172, 22) {
			private final int slot = 7;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.CHAINSAW_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 194, 22) {
			private final int slot = 8;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.HOPPING_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 217, 22) {
			private final int slot = 9;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.ELEK_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 14, 44) {
			private final int slot = 10;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.SCISSORS_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 37, 44) {
			private final int slot = 11;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.BEAT_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 59, 44) {
			private final int slot = 12;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.CHAIN_ARRAY_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 82, 44) {
			private final int slot = 13;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.SMOKE_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 104, 44) {
			private final int slot = 14;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.SPIKE_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 127, 44) {
			private final int slot = 15;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.WINCH_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 149, 44) {
			private final int slot = 16;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.FLASH_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 172, 44) {
			private final int slot = 17;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.SHIELD_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 194, 44) {
			private final int slot = 18;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.GATLING_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 217, 44) {
			private final int slot = 19;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.FIRE_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 14, 67) {
			private final int slot = 20;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.STEALTH_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 37, 67) {
			private final int slot = 21;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.HAMMER_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 59, 67) {
			private final int slot = 22;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.WATER_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 82, 67) {
			private final int slot = 23;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.MEDICAL_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 104, 67) {
			private final int slot = 24;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.PEN_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 127, 67) {
			private final int slot = 25;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.WHEEL_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 149, 67) {
			private final int slot = 26;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.SCREW_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 172, 67) {
			private final int slot = 27;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.HAND_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 194, 67) {
			private final int slot = 28;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.SCHOOP_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 217, 67) {
			private final int slot = 29;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.MAGNET_ASTROSWITCH_N.get() == stack.getItem();
			}
		}));
		this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 14, 89) {
			private final int slot = 30;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.MAGNET_ASTROSWITCH_S.get() == stack.getItem();
			}
		}));
		this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 37, 89) {
			private final int slot = 31;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.FREEZE_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 59, 89) {
			private final int slot = 32;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.CLAW_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 82, 89) {
			private final int slot = 33;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.BOARD_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 104, 89) {
			private final int slot = 34;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.GIANTFOOT_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 127, 89) {
			private final int slot = 35;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.AERO_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 149, 89) {
			private final int slot = 36;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.GYRO_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 172, 89) {
			private final int slot = 37;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.NET_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 194, 89) {
			private final int slot = 38;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.STAMPER_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 217, 89) {
			private final int slot = 39;
			private int x = AstroswitchPanelDoubleGuiMenu.this.x;
			private int y = AstroswitchPanelDoubleGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack stack) {
				return Fourze_Rider_Items.COSMIC_ASTROSWITCH.get() == stack.getItem();
			}
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 37 + 8 + sj * 18, 45 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 37 + 8 + si * 18, 45 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 40) {
				if (!this.moveItemStackTo(itemstack1, 40, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 40, false)) {
				if (index < 40 + 27) {
					if (!this.moveItemStackTo(itemstack1, 40 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 40, 40 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.getCount() == 0)
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack p_38904_, int p_38905_, int p_38906_, boolean p_38907_) {
		boolean flag = false;
		int i = p_38905_;
		if (p_38907_) {
			i = p_38906_ - 1;
		}
		if (p_38904_.isStackable()) {
			while (!p_38904_.isEmpty() && (p_38907_ ? i >= p_38905_ : i < p_38906_)) {
				Slot slot = this.slots.get(i);
				ItemStack itemstack = slot.getItem();
				if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameComponents(p_38904_, itemstack)) {
					int j = itemstack.getCount() + p_38904_.getCount();
					int k = slot.getMaxStackSize(itemstack);
					if (j <= k) {
						p_38904_.setCount(0);
						itemstack.setCount(j);
						slot.set(itemstack);
						flag = true;
					} else if (itemstack.getCount() < k) {
						p_38904_.shrink(k - itemstack.getCount());
						itemstack.setCount(k);
						slot.set(itemstack);
						flag = true;
					}
				}
				if (p_38907_) {
					i--;
				} else {
					i++;
				}
			}
		}
		if (!p_38904_.isEmpty()) {
			if (p_38907_) {
				i = p_38906_ - 1;
			} else {
				i = p_38905_;
			}
			while (p_38907_ ? i >= p_38905_ : i < p_38906_) {
				Slot slot1 = this.slots.get(i);
				ItemStack itemstack1 = slot1.getItem();
				if (itemstack1.isEmpty() && slot1.mayPlace(p_38904_)) {
					int l = slot1.getMaxStackSize(p_38904_);
					slot1.setByPlayer(p_38904_.split(Math.min(p_38904_.getCount(), l)));
					slot1.setChanged();
					flag = true;
					break;
				}
				if (p_38907_) {
					i--;
				} else {
					i++;
				}
			}
		}
		return flag;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					if (j == 0)
						continue;
					if (j == 1)
						continue;
					if (j == 2)
						continue;
					if (j == 3)
						continue;
					if (j == 4)
						continue;
					if (j == 5)
						continue;
					if (j == 6)
						continue;
					if (j == 7)
						continue;
					if (j == 8)
						continue;
					if (j == 9)
						continue;
					if (j == 10)
						continue;
					if (j == 11)
						continue;
					if (j == 12)
						continue;
					if (j == 13)
						continue;
					if (j == 14)
						continue;
					if (j == 15)
						continue;
					if (j == 16)
						continue;
					if (j == 17)
						continue;
					if (j == 18)
						continue;
					if (j == 19)
						continue;
					if (j == 20)
						continue;
					if (j == 21)
						continue;
					if (j == 22)
						continue;
					if (j == 23)
						continue;
					if (j == 24)
						continue;
					if (j == 25)
						continue;
					if (j == 26)
						continue;
					if (j == 27)
						continue;
					if (j == 28)
						continue;
					if (j == 29)
						continue;
					if (j == 30)
						continue;
					if (j == 31)
						continue;
					if (j == 32)
						continue;
					if (j == 33)
						continue;
					if (j == 34)
						continue;
					if (j == 35)
						continue;
					if (j == 36)
						continue;
					if (j == 37)
						continue;
					if (j == 38)
						continue;
					if (j == 39)
						continue;
					playerIn.drop(internal.getStackInSlot(j), false);
					if (internal instanceof IItemHandlerModifiable ihm)
						ihm.setStackInSlot(j, ItemStack.EMPTY);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					if (i == 0)
						continue;
					if (i == 1)
						continue;
					if (i == 2)
						continue;
					if (i == 3)
						continue;
					if (i == 4)
						continue;
					if (i == 5)
						continue;
					if (i == 6)
						continue;
					if (i == 7)
						continue;
					if (i == 8)
						continue;
					if (i == 9)
						continue;
					if (i == 10)
						continue;
					if (i == 11)
						continue;
					if (i == 12)
						continue;
					if (i == 13)
						continue;
					if (i == 14)
						continue;
					if (i == 15)
						continue;
					if (i == 16)
						continue;
					if (i == 17)
						continue;
					if (i == 18)
						continue;
					if (i == 19)
						continue;
					if (i == 20)
						continue;
					if (i == 21)
						continue;
					if (i == 22)
						continue;
					if (i == 23)
						continue;
					if (i == 24)
						continue;
					if (i == 25)
						continue;
					if (i == 26)
						continue;
					if (i == 27)
						continue;
					if (i == 28)
						continue;
					if (i == 29)
						continue;
					if (i == 30)
						continue;
					if (i == 31)
						continue;
					if (i == 32)
						continue;
					if (i == 33)
						continue;
					if (i == 34)
						continue;
					if (i == 35)
						continue;
					if (i == 36)
						continue;
					if (i == 37)
						continue;
					if (i == 38)
						continue;
					if (i == 39)
						continue;
					playerIn.getInventory().placeItemBackInInventory(internal.getStackInSlot(i));
					if (internal instanceof IItemHandlerModifiable ihm)
						ihm.setStackInSlot(i, ItemStack.EMPTY);
				}
			}
		}
	}

	public Map<Integer, Slot> get() {
		return customSlots;
	}
}
