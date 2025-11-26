package com.kelco.kamenridercraft.block.entity;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.recipe.IxaMachineRecipe;
import com.kelco.kamenridercraft.recipe.IxaMachineRecipeInput;
import com.kelco.kamenridercraft.recipe.ModRecipes;
import com.kelco.kamenridercraft.world.inventory.IxaMachineBlockGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class IxaMachineBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(11) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int MODIFIER_SLOT = 1;
    private static final int[] OUTPUT_SLOT = new int[]{3,4,5,6,7,8,9,10}; //Output

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    protected NonNullList<ItemStack> items = NonNullList.withSize(11, ItemStack.EMPTY);
    private int rawIndex = -1;

    public IxaMachineBlockEntity( BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.IXA_MACHINE_BLOCK_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> IxaMachineBlockEntity.this.progress;
                    case 1 -> IxaMachineBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0:
                        IxaMachineBlockEntity.this.progress = value;
                    case 1:
                        IxaMachineBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(KamenRiderCraftCore.MOD_ID + ":ixa_machine_entity");
    }

    @Override
    @Nullable
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new IxaMachineBlockGuiMenu(i,inventory, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("machine_block.progress", progress);
        pTag.putInt("machine_block.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("machine_block.progress");
        maxProgress = pTag.getInt("machine_block.max_progress");
    }

  /**  public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    } **/

    private void craftItem() {
        Optional<RecipeHolder<IxaMachineRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        itemHandler.extractItem(INPUT_SLOT, 1, false);
        itemHandler.extractItem(MODIFIER_SLOT, 1, false);
    //    itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
    //            itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 72;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }


  /**  private boolean hasRecipe() {
        Optional<RecipeHolder<IxaMachineRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack output = recipe.get().value().output();
      return canInsertAmountIntoOutput(output.getCount()) && canInsertItemIntoOutput(output);
    }
   **/
    private Optional<RecipeHolder<IxaMachineRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.IXA_MACHINE_BLOCK_TYPE.get(), new IxaMachineRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT), itemHandler.getStackInSlot(MODIFIER_SLOT)), level);
    }

    private void canInsertItemIntoOutput(ItemStack output) {
        for (int slot = 2; slot < 10; slot++) {
            ItemStack itemStack = items.get(slot);
            if (itemStack.isEmpty()) {
                items.set(slot, output);
                return;
            }
        }
    }
/**
    private void canInsertAmountIntoOutput(int count) {
        for (int slot = 2; slot < 10; slot++)
            ItemStack output = getCurrentRecipe(output)
            ItemStack itemStack = items.get(slot)
        int currentCount = itemHandler.getStackInSlot(OUTPUT_SLOT).getCount();
        if (currentCount > 0) {
            for (int slot = 2; slot < 10; slot++) {
                ItemStack itemStack = items.get(slot);
                if (itemStack.isStackable(output) && itemStack.getCount() + output.getCount() < 64) {
                    itemStack.setCount(itemStack.getCount() + output.getCount());
                    return;
                }
            }
        }
    }


    public void setItem(int slot, @NotNull ItemStack stack) {
        items.set(slot, stack);
        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
        setChanged();
    }
**/
    public boolean canPlaceItem(int slot, @NotNull ItemStack stack) {
        return slot < OUTPUT_SLOT[0];
    }


    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
