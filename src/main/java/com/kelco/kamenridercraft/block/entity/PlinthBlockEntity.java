package com.kelco.kamenridercraft.block.entity;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.block.custom.PlinthBlock;
import com.kelco.kamenridercraft.block.storageBlock.PandoraPanelBlock;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByTag;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.ClientboundPacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class PlinthBlockEntity extends BlockEntity {
    public final ItemStackHandler inventory = new ItemStackHandler(1){
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(),3);
            }
        }
    };


    private float rotation;

    public float getRenderingRotation(PlinthBlockEntity pBlockEntity) {
        rotation += 0f;
        if (pBlockEntity.level.getBlockState(pBlockEntity.getBlockPos()).getBlock()== Rider_Blocks.PLINTH.get()){
            BlockState state = pBlockEntity.level.getBlockState(pBlockEntity.getBlockPos());

            switch ((Direction)state.getValue(PlinthBlock.FACING)) {
                case NORTH:
                    return 0;
                case EAST:
                    return 90;
                case SOUTH:
                    return 180;
                case WEST:
                default:
                    return 270;
            }
        }


        rotation += 0.5f;
        return rotation;
    }

    public PlinthBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.PLINTH_BE.get(), pos, blockState);
    }
    public void clearContents() {
        inventory.setStackInSlot(0, ItemStack.EMPTY);
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++) {
            inv.setItem(i, inventory.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }
}
