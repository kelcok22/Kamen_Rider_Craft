package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.item.Modded_item_core;
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
        add(Rider_Blocks.WALLPLATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.WALLPLATE_SLAB.get()));
        add(Rider_Blocks.WHITE_WALLPLATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.WHITE_WALLPLATE_SLAB.get()));
        add(Rider_Blocks.RED_WALLPLATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.RED_WALLPLATE_SLAB.get()));
        add(Rider_Blocks.GREY_WALLPLATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.GREY_WALLPLATE_SLAB.get()));
        add(Rider_Blocks.GREEN_WALLPLATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.GREEN_WALLPLATE_SLAB.get()));
        add(Rider_Blocks.LIGHT_GREEN_WALLPLATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.LIGHT_GREEN_WALLPLATE_SLAB.get()));
        add(Rider_Blocks.BLACK_WALLPLATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.BLACK_WALLPLATE_SLAB.get()));
        add(Rider_Blocks.YELLOW_WALLPLATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.YELLOW_WALLPLATE_SLAB.get()));
        add(Rider_Blocks.LIGHT_GREEN_WALLPLATE_GRATE_SLAB.get(),
                block -> createSlabItemTable(Rider_Blocks.LIGHT_GREEN_WALLPLATE_GRATE_SLAB.get()));

        dropSelf(Rider_Blocks.HELHEIM_STAIRS.get());
        dropSelf(Rider_Blocks.HELHEIM_PRESSURE_PLATE.get());
        dropSelf(Rider_Blocks.HELHEIM_FENCE.get());
        dropSelf(Rider_Blocks.HELHEIM_FENCE_GATE.get());
        dropSelf(Rider_Blocks.HELHEIM_TRAPDOOR.get());
        dropSelf(Rider_Blocks.CORNERSTORE_SIGN.get());
        dropSelf(Rider_Blocks.YELLOW_WALLPLATE.get());
        dropSelf(Rider_Blocks.GREY_WALLPLATE.get());
        dropSelf(Rider_Blocks.BLACK_WALLPLATE.get());
        dropSelf(Rider_Blocks.GREEN_WALLPLATE.get());
        dropSelf(Rider_Blocks.LIGHT_GREEN_WALLPLATE.get());
        dropSelf(Rider_Blocks.RED_WALLPLATE.get());
        dropSelf(Rider_Blocks.YELLOW_WALLPLATE_STAIRS.get());
        dropSelf(Rider_Blocks.GREY_WALLPLATE_STAIRS.get());
        dropSelf(Rider_Blocks.BLACK_WALLPLATE_STAIRS.get());
        dropSelf(Rider_Blocks.GREEN_WALLPLATE_STAIRS.get());
        dropSelf(Rider_Blocks.LIGHT_GREEN_WALLPLATE_STAIRS.get());
        dropSelf(Rider_Blocks.RED_WALLPLATE_STAIRS.get());
        dropSelf(Rider_Blocks.WALLPLATE_STAIRS.get());
        dropSelf(Rider_Blocks.CHECKERED_TILE.get());
        dropSelf(Rider_Blocks.VERTICAL_PANEL.get());
        add(Rider_Blocks.HELHEIM_DOOR.get(),
                block -> createDoorTable(Rider_Blocks.HELHEIM_DOOR.get()));
        dropSelf(Rider_Blocks.ICHIGO_CHAIR.get());
        dropSelf(Rider_Blocks.HELHEIM_SAPLING.get());
        add(Rider_Blocks.RABBIT_HUTCH_DOOR.get(),
                block -> createDoorTable(Rider_Blocks.RABBIT_HUTCH_DOOR.get()));
        add(Rider_Blocks.GLASS_DOOR.get(),
                block -> createDoorTable(Rider_Blocks.GLASS_DOOR.get()));

        add(Rider_Blocks.HELHEIM_SIGN.get(),
                block -> createSingleItemTable(Modded_item_core.HELHEIM_SIGN_ITEM.get()));
        add(Rider_Blocks.HELHEIM_WALL_SIGN.get(),
                block -> createSingleItemTable(Modded_item_core.HELHEIM_SIGN_ITEM.get()));
        add(Rider_Blocks.HELHEIM_HANGING_SIGN.get(),
                block -> createSingleItemTable(Modded_item_core.HELHEIM_HANGING_SIGN_ITEM.get()));
        add(Rider_Blocks.HELHEIM_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(Modded_item_core.HELHEIM_HANGING_SIGN_ITEM.get()));
        add(Rider_Blocks.YELLOW_WALLPLATE_WALL.get(),
                block -> createSingleItemTable(Rider_Blocks.YELLOW_WALLPLATE_WALL.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Rider_Blocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
