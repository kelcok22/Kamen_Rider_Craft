package com.kelco.kamenridercraft.blockentity;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.heisei_phase_1.KivaRiderItems;
import com.kelco.kamenridercraft.recipe.IxaMachineRecipe;
import com.kelco.kamenridercraft.recipe.IxaMachineRecipeInput;
import com.kelco.kamenridercraft.recipe.ModRecipes;
import com.kelco.kamenridercraft.world.inventory.IxaMachineBlockGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
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

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class IxaMachineBlockEntity extends BlockEntity implements MenuProvider {

    private static final int INPUT_SLOT = 0;
    private static final int OPTIONAL_INPUT_SLOT = 1;
    private static final int FIRST_OUTPUT_SLOT = 2;
    private static final int INVENTORY_SIZE = 11;
    private static final int MAX_PROGRESS = 72;

    private static final String DATA_TAG = "kamenridercraft_data";
    private static final String INVENTORY_TAG = "Inventory";
    private static final String PROGRESS_TAG = "Progress";

    private final ItemStackHandler inventory = new ItemStackHandler(INVENTORY_SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();

            if(level == null || level.isClientSide) return;
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    };

    private int progress = 0;

    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch(index) {
                case 0 -> progress;
                case 1 -> MAX_PROGRESS;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            if(index == 0) progress = value;
        }

        @Override
        public int getCount() {
            return 2;
        }
    };

    public IxaMachineBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.IXA_MACHINE_BLOCK_BE.get(), pos, blockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, IxaMachineBlockEntity forge) {
        if(level.isClientSide()) return;

        Optional<RecipeHolder<IxaMachineRecipe>> currentRecipe = forge.getCurrentRecipe(level);

        if(currentRecipe.isEmpty()) {
            forge.resetProgress();
            return;
        }

        if(!forge.hasAnyOutputRoom()) {
            forge.resetProgress();
            return;
        }

        forge.progress++;
        setChanged(level, pos, state);
        level.sendBlockUpdated(pos, state, state, 3);

        if(forge.progress < MAX_PROGRESS) return;

        forge.replicateFuestle(currentRecipe.get().value());
        forge.progress = 0;
    }

    private Optional<RecipeHolder<IxaMachineRecipe>> getCurrentRecipe(Level level) {
        IxaMachineRecipeInput recipeInput = new IxaMachineRecipeInput(
                this.inventory.getStackInSlot(INPUT_SLOT),
                this.inventory.getStackInSlot(OPTIONAL_INPUT_SLOT)
        );

        return level.getRecipeManager()
                .getRecipeFor(ModRecipes.IXA_MACHINE_BLOCK_TYPE.get(), recipeInput, level);
    }

    private void resetProgress() {
        if(this.progress == 0) return;
        this.progress = 0;
        setChanged();
    }

    private boolean hasAnyOutputRoom() {
        for(int slot = FIRST_OUTPUT_SLOT; slot < this.inventory.getSlots(); slot++) {
            ItemStack stack = this.inventory.getStackInSlot(slot);

            if(stack.isEmpty()) return true;
            if(stack.getCount() < stack.getMaxStackSize()) return true;
        }

        return false;
    }

    private boolean canOutputFit(ItemStack output) {
        if(output.isEmpty()) return false;

        for(int slot = FIRST_OUTPUT_SLOT; slot < this.inventory.getSlots(); slot++) {
            ItemStack slotStack = this.inventory.getStackInSlot(slot);

            if(slotStack.isEmpty()) return true;
            if(!ItemStack.isSameItemSameComponents(slotStack, output)) continue;

            int combinedCount = slotStack.getCount() + output.getCount();
            if(combinedCount <= slotStack.getMaxStackSize()) return true;
        }

        return false;
    }

    private void replicateFuestle(IxaMachineRecipe recipe) {
        ItemStack chosenOutput = selectRandomOutput(recipe.outputs());

        if(chosenOutput.isEmpty()) return;
        if(!canOutputFit(chosenOutput)) return;

        this.inventory.getStackInSlot(INPUT_SLOT).shrink(1);
        consumeOptionalInput(recipe);
        insertOutput(chosenOutput);
    }

    private void consumeOptionalInput(IxaMachineRecipe recipe) {
        if(recipe.optionalInput().isEmpty()) return;

        ItemStack modifierStack = this.inventory.getStackInSlot(OPTIONAL_INPUT_SLOT);

        // This acts as a reusable modifier.
        if(modifierStack.is(KivaRiderItems.KIVA_LOGO.get())) return;

        if(modifierStack.getItem().hasCraftingRemainingItem()) {
            ItemStack remainder = new ItemStack(modifierStack.getItem().getCraftingRemainingItem());
            this.inventory.setStackInSlot(OPTIONAL_INPUT_SLOT, remainder);
            return;
        }

        modifierStack.shrink(1);
    }

    private void insertOutput(ItemStack output) {
        ItemStack remainder = output.copy();

        for(int slot = FIRST_OUTPUT_SLOT; slot < this.inventory.getSlots(); slot++) {
            remainder = this.inventory.insertItem(slot, remainder, false);
            if(remainder.isEmpty()) return;
        }
    }

    private ItemStack selectRandomOutput(List<IxaMachineRecipe.WeightedOutput> pool) {
        if(pool.isEmpty() || this.level == null) return ItemStack.EMPTY;

        int totalWeight = 0;
        for(IxaMachineRecipe.WeightedOutput output : pool) {
            if(output.weight() > 0) totalWeight += output.weight();
        }

        if(totalWeight <= 0) return ItemStack.EMPTY;

        int roll = this.level.random.nextInt(totalWeight);

        for(IxaMachineRecipe.WeightedOutput output : pool) {
            if(output.weight() <= 0) continue;

            roll -= output.weight();
            if(roll < 0) return output.stack().copy();
        }

        return ItemStack.EMPTY;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);

        CompoundTag modData = new CompoundTag();
        modData.put(INVENTORY_TAG, this.inventory.serializeNBT(registries));
        modData.putInt(PROGRESS_TAG, this.progress);

        tag.put(DATA_TAG, modData);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        if(!tag.contains(DATA_TAG)) return;

        CompoundTag modData = tag.getCompound(DATA_TAG);

        if(modData.contains(INVENTORY_TAG)) {
            this.inventory.deserializeNBT(registries, modData.getCompound(INVENTORY_TAG));
        }

        this.progress = modData.getInt(PROGRESS_TAG);
    }

    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.kamenridercraft.ixa_machine_block");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
        return new IxaMachineBlockGuiMenu(id, playerInventory, this, this.data);
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
}
