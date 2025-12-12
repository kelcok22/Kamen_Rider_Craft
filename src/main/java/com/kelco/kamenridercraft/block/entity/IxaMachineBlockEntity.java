package com.kelco.kamenridercraft.block.entity;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.machineBlocks.MachineBlockTags;
import com.kelco.kamenridercraft.item.Kiva_Rider_Items;
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
import net.minecraft.core.registries.Registries;
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
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class IxaMachineBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(11) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public static void clientTick(Level level, BlockPos pos, BlockState state, IxaMachineBlockEntity be) {
        if (!level.isClientSide) {
        }
    }

    private static final int INPUT_SLOT = 0;
    private static final int MODIFIER_SLOT = 1;
    private static final int OUTPUT_SLOT_1 = 2;
    private static final int OUTPUT_SLOT_2 = 3;
    private static final int OUTPUT_SLOT_3 = 4;
    private static final int OUTPUT_SLOT_4 = 5;
    private static final int OUTPUT_SLOT_5 = 6;
    private static final int OUTPUT_SLOT_6 = 7;
    private static final int OUTPUT_SLOT_7 = 8;
    private static final int OUTPUT_SLOT_8 = 9;
    private static final int OUTPUT_SLOT_9 = 10; //Output

    private ItemStack lockedOutput = ItemStack.EMPTY;
    private String lastInputSignature = "";

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;
    private int outputSlot = 2;

    protected NonNullList<ItemStack> items = NonNullList.withSize(11, ItemStack.EMPTY);
    private int rawIndex = -1;


    public IxaMachineBlockEntity(BlockPos pos, BlockState blockState) {
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
        return new IxaMachineBlockGuiMenu(i, inventory, this, this.data);
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

    public void tick(Level level, BlockPos pos, BlockState state) {

        Optional<RecipeHolder<IxaMachineRecipe>> recipeOpt = getCurrentRecipe();
        if (recipeOpt.isEmpty()) {
            resetProgress();
            this.lockedOutput = ItemStack.EMPTY;
            this.lastInputSignature = "";
            return;
        }

        String currentSignature = signatureOf(
                itemHandler.getStackInSlot(INPUT_SLOT),
                itemHandler.getStackInSlot(MODIFIER_SLOT)
        );

        if (progress == 0) {
            if (lockedOutput.isEmpty() || !currentSignature.equals(lastInputSignature)) {
                lockedOutput = determineOutputForCurrentInputs().copy();
                lastInputSignature = currentSignature;
            }
        }

        ItemStack prospectiveOutput = lockedOutput.isEmpty() ? determineOutputForCurrentInputs() : lockedOutput;
        boolean canOutputNow = !prospectiveOutput.isEmpty()
                && canInsertItemIntoOutput(prospectiveOutput)
                && canInsertAmountIntoOutput(prospectiveOutput);

        if (!prospectiveOutput.isEmpty() && canOutputNow) {

            increaseCraftingProgress();
            setChanged(level, pos, state);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
                this.lockedOutput = ItemStack.EMPTY;
                this.lastInputSignature = "";
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        Optional<RecipeHolder<IxaMachineRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) return;

        ItemStack output = lockedOutput.isEmpty() ? recipe.get().value().output().copy() : lockedOutput.copy();
        if (output.isEmpty()) return;

        if (!canInsertItemIntoOutput(output) || !canInsertAmountIntoOutput(output)) {
            return;
        }

        int[] slots = {OUTPUT_SLOT_1, OUTPUT_SLOT_2, OUTPUT_SLOT_3, OUTPUT_SLOT_4, OUTPUT_SLOT_5, OUTPUT_SLOT_6, OUTPUT_SLOT_7, OUTPUT_SLOT_8, OUTPUT_SLOT_9};

        for (
                int slot : slots) {
            ItemStack current = itemHandler.getStackInSlot(slot);

            if (current.isEmpty()) {
                itemHandler.setStackInSlot(slot, output.copy());
                itemHandler.extractItem(INPUT_SLOT, 1, false);
                itemHandler.extractItem(MODIFIER_SLOT, 1, false);
                return;
            }

            if (current.getItem() == output.getItem()
                    && current.getCount() + output.getCount() <= current.getMaxStackSize()) {
                itemHandler.setStackInSlot(slot, new ItemStack(current.getItem(), current.getCount() + output.getCount()));
                itemHandler.extractItem(INPUT_SLOT, 1, false);
                itemHandler.extractItem(MODIFIER_SLOT, 1, false);
                return;
            }
        }
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

    private boolean isOutputSlotsEmptyorReceivable() {
        return itemHandler.getStackInSlot(OUTPUT_SLOT_1).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_2).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_3).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_4).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_5).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_6).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_7).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_8).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_9).isEmpty() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT_1).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_1).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_2).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_2).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_3).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_3).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_4).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_4).getMaxStackSize() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT_5).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_5).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_6).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_6).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_7).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_7).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_8).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_8).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_9).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_9).getMaxStackSize();
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<IxaMachineRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack output = lockedOutput.isEmpty() ? recipe.get().value().output() : lockedOutput;
        return !output.isEmpty() && canInsertAmountIntoOutput(output) && canInsertItemIntoOutput(output);
    }

//    public int getOutputSlot(ItemStack output) {
//        for (int slot = 2; slot < 11; slot++){
//            if (canInsertAmountIntoOutput(output.getCount(),slot) && canInsertItemIntoOutput(output,slot)) return slot;
//        }
//        return 2;
//    }

    private Optional<RecipeHolder<IxaMachineRecipe>> getCurrentRecipe() {
        assert this.level != null;
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.IXA_MACHINE_BLOCK_TYPE.get(), new IxaMachineRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT), itemHandler.getStackInSlot(MODIFIER_SLOT)), level);
    }


    private boolean canInsertAmountIntoOutput(ItemStack output) {
        int toInsert = output.getCount();
        int[] slots = {OUTPUT_SLOT_1, OUTPUT_SLOT_2, OUTPUT_SLOT_3, OUTPUT_SLOT_4, OUTPUT_SLOT_5, OUTPUT_SLOT_6, OUTPUT_SLOT_7, OUTPUT_SLOT_8, OUTPUT_SLOT_9};

        for (int slot : slots) {
            ItemStack stack = itemHandler.getStackInSlot(slot);

            if (stack.isEmpty()) {
                // Respect special cap for empty slots
                if (toInsert <= 8) {
                    return true;
                }
            } else if (stack.getItem() == output.getItem()) {
                int space = stack.getMaxStackSize() - stack.getCount();
                if (space >= toInsert) {
                    return true;
                }
            }
        }
        return false;
    }

    private ItemStack determineOutputForCurrentInputs() {
        Optional<RecipeHolder<IxaMachineRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) return ItemStack.EMPTY;

        ItemStack material = itemHandler.getStackInSlot(INPUT_SLOT);
        if (material.getItem() == Kiva_Rider_Items.FAKE_FUESTLE.get()) {
            ItemStack random = pickWeightedFromTag(recipe.get().value());
            int count = Math.max(1, recipe.get().value().output().getCount());
            if (!random.isEmpty()) {
                random.setCount(count);
            }
            return random;
        }

        return recipe.get().value().output().copy();
    }

    private ItemStack pickWeightedFromTag(IxaMachineRecipe recipe) {
        if (this.level == null) return ItemStack.EMPTY;

        var registry = this.level.registryAccess().registryOrThrow(Registries.ITEM);
        var tagged = registry.getTag(MachineBlockTags.Items.REPLICATOR_FROM_BLANK_FAKE);
        if (tagged.isEmpty()) return ItemStack.EMPTY;

        var holderSet = tagged.get();

        int totalWeight = 0;

        java.util.ArrayList<net.minecraft.world.item.Item> items = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> weights = new java.util.ArrayList<>();
        for (var holder : holderSet) {
            var item = holder.value();
            int w = Math.max(0, recipe.getWeightFor(item));
            if (w > 0) {
                items.add(item);
                weights.add(w);
                totalWeight += w;
            }
        }
        if (totalWeight <= 0) return ItemStack.EMPTY;

        int roll = this.level.random.nextInt(totalWeight);
        int acc = 0;
        for (int i = 0; i < items.size(); i++) {
            acc += weights.get(i);
            if (roll < acc) {
                return new ItemStack(items.get(i));
            }
        }
        return ItemStack.EMPTY;
    }

    private static String signatureOf(ItemStack test_tube, ItemStack material) {
        return stackSig(test_tube) + "#" + stackSig(material);
    }

    private static String stackSig(ItemStack s) {
        if (s.isEmpty()) return "empty";
        String id = s.getItem().builtInRegistryHolder().key().location().toString();
        return id + "x" + s.getCount();
    }

    private boolean canInsertItemIntoOutput(ItemStack output) {
        int[] slots = {OUTPUT_SLOT_1, OUTPUT_SLOT_2, OUTPUT_SLOT_3, OUTPUT_SLOT_4, OUTPUT_SLOT_5, OUTPUT_SLOT_6, OUTPUT_SLOT_7, OUTPUT_SLOT_8, OUTPUT_SLOT_9};

        for (int slot : slots) {
            ItemStack stack = itemHandler.getStackInSlot(slot);
            if (stack.isEmpty() || stack.getItem() == output.getItem()) {
                return true;
            }
        }
        return false;
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

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider lookupProvider) {
        super.onDataPacket(net, pkt, lookupProvider);
    }
}
