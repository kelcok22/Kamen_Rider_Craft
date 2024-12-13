package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(Rider_Blocks.HELHEIM_BUTTON.get());
        add(Rider_Blocks.HELHEIM_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.HELHEIM_SLAB.get()));
        dropSelf(Rider_Blocks.HELHEIM_STAIRS.get());
        dropSelf(Rider_Blocks.HELHEIM_PRESSURE_PLATE.get());
        dropSelf(Rider_Blocks.HELHEIM_FENCE.get());
        dropSelf(Rider_Blocks.HELHEIM_FENCE_GATE.get());
        dropSelf(Rider_Blocks.HELHEIM_TRAPDOOR.get());
        add(Rider_Blocks.HELHEIM_DOOR.get(),
                block -> createDoorTable(Rider_Blocks.HELHEIM_DOOR.get()));
        dropSelf(Rider_Blocks.ICHIGO_CHAIR.get());
        dropSelf(Rider_Blocks.HELHEIM_SAPLING.get());
        add(Rider_Blocks.RABBIT_HUTCH_DOOR.get(),
                block -> createDoorTable(Rider_Blocks.RABBIT_HUTCH_DOOR.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Rider_Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
