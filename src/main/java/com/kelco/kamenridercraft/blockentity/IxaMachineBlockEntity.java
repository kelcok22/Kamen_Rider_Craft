package com.kelco.kamenridercraft.blockentity;

import com.kelco.kamenridercraft.item.heisei_phase_1.KivaRiderItems;
import com.kelco.kamenridercraft.recipe.IxaMachineRecipe;
import com.kelco.kamenridercraft.recipe.IxaMachineRecipeInput;
import com.kelco.kamenridercraft.recipe.ModRecipes;
import com.kelco.kamenridercraft.world.inventory.IxaMachineBlockGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeCraftingHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class IxaMachineBlockEntity extends BaseContainerBlockEntity implements MenuProvider, WorldlyContainer, RecipeCraftingHolder, StackedContentsCompatible {
    private static final int INPUT_SLOT = 0;
    private static final int OPTIONAL_INPUT_SLOT = 1;
    private static final int FIRST_OUTPUT_SLOT = 2;
    private static final int INVENTORY_SIZE = 11;
    private static final int MAX_PROGRESS = 72;

    private static final String PROGRESS_TAG = "Progress";

    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    protected NonNullList<ItemStack> items;


    private final ItemStackHandler inventory = new ItemStackHandler(INVENTORY_SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level == null || level.isClientSide()) {
                return;
            }
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    };

    private int progress = 0;

    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> MAX_PROGRESS;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            if (index == 0) {
                progress = value;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };

    public IxaMachineBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.IXA_MACHINE_BLOCK_BE.get(), pos, blockState);
        items = NonNullList.withSize(INVENTORY_SIZE + 1, ItemStack.EMPTY);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, IxaMachineBlockEntity forge) {
        if (!level.isClientSide()) {
            Optional<RecipeHolder<IxaMachineRecipe>> currentRecipe = forge.getCurrentRecipe(level);

            if (currentRecipe.isEmpty() || !forge.hasAnyOutputRoom()) {
                forge.resetProgress();
                return;
            }
            forge.progress++;
            setChanged(level, pos, state);
            level.sendBlockUpdated(pos, state, state, 3);

            if (forge.progress < MAX_PROGRESS) {
                return;
            }

            forge.replicateFuestle(currentRecipe.get().value());
            forge.progress = 0;
        }
    }

    private Optional<RecipeHolder<IxaMachineRecipe>> getCurrentRecipe(Level level) {
        IxaMachineRecipeInput recipeInput = new IxaMachineRecipeInput(
                items.get(INPUT_SLOT),
                items.get(OPTIONAL_INPUT_SLOT)
        );

        return level.getRecipeManager()
                .getRecipeFor(ModRecipes.IXA_MACHINE_BLOCK_TYPE.get(), recipeInput, level);
    }

    private void resetProgress() {
        if (progress == 0) {
            return;
        }
        progress = 0;
        setChanged();
    }

    private boolean hasAnyOutputRoom() {
        int filledSlots = 0;
        for (int i = 3; i <= 11; ++i) {
            if (items.get(i) != ItemStack.EMPTY) {
                ++filledSlots;
            }
        }

        if (filledSlots >= 9 && getCurrentRecipe(getLevel()).get().value().outputs().size() > 1) {
            return false;
        }

        for (int slot = FIRST_OUTPUT_SLOT; slot < items.size(); slot++) {
            ItemStack stack = items.get(slot);

            if (stack.isEmpty()) {
                return true;
            }
            if (stack.getCount() < stack.getMaxStackSize()) {
                return true;
            }
        }

        return false;
    }

    private boolean canOutputFit(ItemStack output) {
        if (output.isEmpty()) {
            return false;
        }

        for (int slot = FIRST_OUTPUT_SLOT; slot < items.size(); slot++) {
            ItemStack slotStack = items.get(slot);

            if (slotStack.isEmpty()) {
                return true;
            }
            if (!ItemStack.isSameItemSameComponents(slotStack, output)) {
                continue;
            }

            int combinedCount = slotStack.getCount() + output.getCount();
            if (combinedCount <= slotStack.getMaxStackSize()) {
                return true;
            }
        }

        return false;
    }

    private void replicateFuestle(IxaMachineRecipe recipe) {
        ItemStack chosenOutput = selectRandomOutput(recipe.outputs());

        if (chosenOutput.isEmpty()) {
            return;
        }
        if (!canOutputFit(chosenOutput)) {
            return;
        }

        items.get(INPUT_SLOT).shrink(1);
        consumeOptionalInput(recipe);
        insertOutput(chosenOutput);
    }

    private void consumeOptionalInput(IxaMachineRecipe recipe) {
        if (recipe.optionalInput().isEmpty()) {
            return;
        }

        ItemStack modifierStack = items.get(OPTIONAL_INPUT_SLOT);

        // This acts as a reusable modifier.
        if (modifierStack.is(KivaRiderItems.KIVA_LOGO.get())) {
            return;
        }

        if (modifierStack.getItem().hasCraftingRemainingItem()) {
            ItemStack remainder = new ItemStack(modifierStack.getItem().getCraftingRemainingItem());
            items.set(OPTIONAL_INPUT_SLOT, remainder);
            return;
        }

        modifierStack.shrink(1);
    }

    private void insertOutput(ItemStack output) {
        for (int slot = FIRST_OUTPUT_SLOT; slot < items.size(); slot++) {
            if (items.get(slot) == ItemStack.EMPTY) {
                items.set(slot, output);
                return;
            } else if (items.get(slot).getItem() == output.getItem() && output.isStackable() && items.get(slot).isStackable() &&
                    items.get(slot).getCount() + output.getCount() <= output.getMaxStackSize()) {
                items.get(slot).setCount(items.get(slot).getCount() + output.getCount());
                return;
            }
        }
    }

    private ItemStack selectRandomOutput(List<IxaMachineRecipe.WeightedOutput> pool) {
        if (pool.isEmpty() || level == null) {
            return ItemStack.EMPTY;
        }

        int totalWeight = 0;
        for (IxaMachineRecipe.WeightedOutput output : pool) {
            if (output.weight() > 0) {
                totalWeight += output.weight();
            }
        }

        if (totalWeight <= 0) {
            return ItemStack.EMPTY;
        }

        int roll = level.random.nextInt(totalWeight);

        for (IxaMachineRecipe.WeightedOutput output : pool) {
            if (output.weight() <= 0) {
                continue;
            }

            roll -= output.weight();
            if (roll < 0) {
                return output.stack().copy();
            }
        }

        return ItemStack.EMPTY;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt(PROGRESS_TAG, progress);
        ContainerHelper.saveAllItems(tag, items, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, items, registries);
        progress = tag.getInt(PROGRESS_TAG);
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.kamenridercraft.ixa_machine_block");
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.kamenridercraft.ixa_machine_block");
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player player) {
        return new IxaMachineBlockGuiMenu(id, playerInventory, this, data);
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
        return new IxaMachineBlockGuiMenu(id, inventory, this, data);
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = super.getUpdateTag(registries);
        saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public int getContainerSize() {
        return items.size();
    }

    @Override
    public int @NotNull [] getSlotsForFace(@NotNull Direction direction) {
        if (direction == Direction.UP) {
            return SLOTS_FOR_UP;
        } else if (direction == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return SLOTS_FOR_SIDES;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, @NotNull ItemStack itemStack, @Nullable Direction direction) {
        return canPlaceItem(i, itemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int i, @NotNull ItemStack itemStack, @NotNull Direction direction) {
        if (direction == Direction.DOWN && i >= 2 && i <= INVENTORY_SIZE) {
            return canTakeItem(this, i, itemStack);
        }
        return false;
    }

    @Override
    public void setRecipeUsed(@Nullable RecipeHolder<?> recipeHolder) {

    }

    @Override
    public @Nullable RecipeHolder<?> getRecipeUsed() {
        return null;
    }

    @Override
    public void fillStackedContents(StackedContents stackedContents) {
        for (ItemStack itemstack : items) {
            stackedContents.accountStack(itemstack);
        }
    }
}
