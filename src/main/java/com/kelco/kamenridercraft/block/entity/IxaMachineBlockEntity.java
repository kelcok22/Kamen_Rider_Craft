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
import java.util.Random;

public class IxaMachineBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(11) {
        @Override
        protected void onContentsChanged(int slot) {
            if (!level.isClientSide()) {
                setChanged();
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public static void clientTick(Level level, BlockPos pos, BlockState state, IxaMachineBlockEntity be) {
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
    private String lastItem = "";

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    protected NonNullList<ItemStack> items = NonNullList.withSize(11, ItemStack.EMPTY);


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
        if (itemHandler.getStackInSlot(INPUT_SLOT).isEmpty() || !itemHandler.getStackInSlot(INPUT_SLOT).toString().equals(this.lastItem)) {
            this.progress = 0;
            this.lastItem = itemHandler.getStackInSlot(INPUT_SLOT).toString();
        }
        if (this.progress >= 72) {
            this.progress = 0;
            this.maxProgress = 72;
            this.craftItem();
            setChanged(level, pos, state);
        } else if (this.hasRecipe() && this.isOutputSlotsEmptyorReceivable()) {
            this.progress++;
            this.lastItem = itemHandler.getStackInSlot(INPUT_SLOT).toString();
            setChanged(level, pos, state);
        } else {
            this.progress = 0;
        }
    }

    private void craftItem() {
        ItemStack material = itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack modifier = itemHandler.getStackInSlot(MODIFIER_SLOT);
        ItemStack output = new ItemStack(Kiva_Rider_Items.FAKE_FUESTLE.get(), 1);
        int[] slots = {OUTPUT_SLOT_1, OUTPUT_SLOT_2, OUTPUT_SLOT_3, OUTPUT_SLOT_4, OUTPUT_SLOT_5, OUTPUT_SLOT_6, OUTPUT_SLOT_7, OUTPUT_SLOT_8, OUTPUT_SLOT_9};

        if (material.getItem() == Kiva_Rider_Items.FAKE_FUESTLE.get()) {
            output = switch (modifier.getItem().toString()) {
                case "kamenridercraft:doggafuestle" -> new ItemStack(Kiva_Rider_Items.FAKE_DOGGA_FUESTLE.get(), 1);
                case "kamenridercraft:basshaafuestle" -> new ItemStack(Kiva_Rider_Items.FAKE_BASSHAA_FUESTLE.get(), 1);
                case "kamenridercraft:garulufuestle" -> new ItemStack(Kiva_Rider_Items.FAKE_GARULU_FUESTLE.get(), 1);
                default -> switch (new Random().nextInt(3)) {
                    case 0 -> new ItemStack(Kiva_Rider_Items.KNUCKLE_FUESTLE.get(), 1);
                    case 1 -> new ItemStack(Kiva_Rider_Items.CALIBUR_FUESTLE.get(), 1);
                    case 2 -> new ItemStack(Kiva_Rider_Items.RISER_FUESTLE.get(), 1);
                    default -> output;
                };
            };
        }

        for (int slot : slots) {
            ItemStack current = itemHandler.getStackInSlot(slot);

            if (current.isEmpty()) {
                itemHandler.setStackInSlot(slot, output);
                itemHandler.extractItem(INPUT_SLOT, 1, false);
                itemHandler.extractItem(MODIFIER_SLOT, 1, false);
                return;
            }

            if (current.getItem() == output.getItem() && current.getCount() + output.getCount() <= current.getMaxStackSize()) {
                itemHandler.setStackInSlot(slot, new ItemStack(current.getItem(), current.getCount() + output.getCount()));
                itemHandler.extractItem(INPUT_SLOT, 1, false);
                itemHandler.extractItem(MODIFIER_SLOT, 1, false);
                return;
            }
        }
    }

    private boolean isOutputSlotsEmptyorReceivable() {
        return itemHandler.getStackInSlot(OUTPUT_SLOT_1).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_2).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_3).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_4).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_5).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_6).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_7).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_8).isEmpty() || itemHandler.getStackInSlot(OUTPUT_SLOT_9).isEmpty() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT_1).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_1).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_2).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_2).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_3).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_3).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_4).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_4).getMaxStackSize() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT_5).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_5).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_6).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_6).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_7).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_7).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_8).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_8).getMaxStackSize() || itemHandler.getStackInSlot(OUTPUT_SLOT_9).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT_9).getMaxStackSize();
    }

    private boolean hasRecipe() {
        ItemStack material = itemHandler.getStackInSlot(INPUT_SLOT);
        ItemStack modifier = itemHandler.getStackInSlot(MODIFIER_SLOT);
        if (material.getItem() == Kiva_Rider_Items.FUESTLE.get() && modifier.isEmpty()) {
            return true;
        }
        if (material.getItem() == Kiva_Rider_Items.FAKE_FUESTLE.get()) {
            if (modifier.isEmpty() || modifier.getItem() == Kiva_Rider_Items.GARULU_FUESTLE.get() || modifier.getItem() == Kiva_Rider_Items.BASSHAA_FUESTLE.get() || modifier.getItem() == Kiva_Rider_Items.DOGGA_FUESTLE.get()) {
                return true;
            }
            ;
        }
        return false;
    }

    private Optional<RecipeHolder<IxaMachineRecipe>> getCurrentRecipe() {
        assert this.level != null;
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.IXA_MACHINE_BLOCK_TYPE.get(), new IxaMachineRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT), itemHandler.getStackInSlot(MODIFIER_SLOT)), level);
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
