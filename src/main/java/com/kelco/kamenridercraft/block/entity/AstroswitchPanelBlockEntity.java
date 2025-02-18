package com.kelco.kamenridercraft.block.entity;

import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.function.Supplier;
import java.util.stream.IntStream;

import io.netty.buffer.Unpooled;

import com.kelco.kamenridercraft.world.inventory.AstroswitchPanelGuiMenu;

public class AstroswitchPanelBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(20, ItemStack.EMPTY);
	private final SidedInvWrapper handler = new SidedInvWrapper(this, null);

	public AstroswitchPanelBlockEntity(BlockPos position, BlockState state) {
		super(ModBlockEntities.ASTROSWITCH_PANEL.get(), position, state);
	}

	public static Supplier<BlockEntityType<? extends AstroswitchPanelBlockEntity>> get() {
        return null;
    }

	@Override
	public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.loadAdditional(compound, lookupProvider);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
	}

	@Override
	public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.saveAdditional(compound, lookupProvider);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);
		}
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
		return this.saveWithFullMetadata(lookupProvider);
	}



	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	public static void swapContents(AstroswitchPanelBlockEntity chest, AstroswitchPanelBlockEntity otherChest) {
		NonNullList<ItemStack> nonnulllist = chest.getItems();
		chest.setItems(otherChest.getItems());
		otherChest.setItems(nonnulllist);
	}

	@Override
	public Component getDefaultName() {
		return Component.literal("astroswitch_panel");
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new AstroswitchPanelGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}


	@Override
	public Component getDisplayName() {
		return Component.literal("Astroswitch Rack");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		if (index == 0)
			return false;
		if (index == 1)
			return false;
		if (index == 2)
			return false;
		if (index == 3)
			return false;
		if (index == 4)
			return false;
		if (index == 5)
			return false;
		if (index == 6)
			return false;
		if (index == 7)
			return false;
		if (index == 8)
			return false;
		if (index == 9)
			return false;
		if (index == 10)
			return false;
		if (index == 11)
			return false;
		if (index == 12)
			return false;
		if (index == 13)
			return false;
		if (index == 14)
			return false;
		if (index == 15)
			return false;
		if (index == 16)
			return false;
		if (index == 17)
			return false;
		if (index == 18)
			return false;
		if (index == 19)
			return false;
		if (index == 20)
			return false;
		if (index == 21)
			return false;
		if (index == 22)
			return false;
		if (index == 23)
			return false;
		if (index == 24)
			return false;
		if (index == 25)
			return false;
		if (index == 26)
			return false;
		if (index == 27)
			return false;
		if (index == 28)
			return false;
		if (index == 29)
			return false;
		if (index == 30)
			return false;
		if (index == 31)
			return false;
		if (index == 32)
			return false;
		if (index == 33)
			return false;
		if (index == 34)
			return false;
		if (index == 35)
			return false;
		if (index == 36)
			return false;
		if (index == 37)
			return false;
		if (index == 38)
			return false;
		if (index == 39)
			return false;
		return true;
	}

	public SidedInvWrapper getItemHandler() {
		return handler;
	}

	public void setBlockState(BlockState p_155251_) {
		BlockState oldState = this.getBlockState();
		super.setBlockState(p_155251_);
		if (oldState.getValue(ChestBlock.FACING) != p_155251_.getValue(ChestBlock.FACING) || oldState.getValue(ChestBlock.TYPE) != p_155251_.getValue(ChestBlock.TYPE)) {
			this.invalidateCapabilities();
		}
	}
}
