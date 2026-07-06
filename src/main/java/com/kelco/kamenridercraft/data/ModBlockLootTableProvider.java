package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.RiderBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //dropSelf(RiderBlocks.HELHEIM_BUTTON.get());
        //add(RiderBlocks.HELHEIM_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.HELHEIM_SLAB.get()));
        //add(RiderBlocks.WALLPLATE_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.WALLPLATE_SLAB.get()));
        //add(RiderBlocks.WHITE_WALLPLATE_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.WHITE_WALLPLATE_SLAB.get()));
        //add(RiderBlocks.RED_WALLPLATE_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.RED_WALLPLATE_SLAB.get()));
        //add(RiderBlocks.GREY_WALLPLATE_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.GREY_WALLPLATE_SLAB.get()));
        //add(RiderBlocks.GREEN_WALLPLATE_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.GREEN_WALLPLATE_SLAB.get()));
        //add(RiderBlocks.LIGHT_GREEN_WALLPLATE_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.LIGHT_GREEN_WALLPLATE_SLAB.get()));
        //add(RiderBlocks.BLACK_WALLPLATE_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.BLACK_WALLPLATE_SLAB.get()));
        //add(RiderBlocks.LIGHT_GREEN_WALLPLATE_GRATE_SLAB.get(),
        //        block -> createSlabItemTable(RiderBlocks.LIGHT_GREEN_WALLPLATE_GRATE_SLAB.get()));

        //dropSelf(RiderBlocks.CANDY_SHOP.get());
        //dropSelf(RiderBlocks.HELHEIM_STAIRS.get());
        //dropSelf(RiderBlocks.HELHEIM_PRESSURE_PLATE.get());
        //dropSelf(RiderBlocks.WHITE_FENCE.get());
        //dropSelf(RiderBlocks.HELHEIM_FENCE_GATE.get());
        //dropSelf(RiderBlocks.HELHEIM_TRAPDOOR.get());
        //dropSelf(RiderBlocks.CORNERSTORE_SIGN.get());

        //dropSelf(RiderBlocks.YELLOW_WALLPLATE.get());
        //dropSelf(RiderBlocks.GREY_WALLPLATE.get());
        //dropSelf(RiderBlocks.BLACK_WALLPLATE.get());
        //dropSelf(RiderBlocks.GREEN_WALLPLATE.get());
        //dropSelf(RiderBlocks.LIGHT_GREEN_WALLPLATE.get());
        //dropSelf(RiderBlocks.RED_WALLPLATE.get());
        //dropSelf(RiderBlocks.YELLOW_WALLPLATE_STAIRS.get());
        //dropSelf(RiderBlocks.GREY_WALLPLATE_STAIRS.get());
        //dropSelf(RiderBlocks.BLACK_WALLPLATE_STAIRS.get());
        //dropSelf(RiderBlocks.GREEN_WALLPLATE_STAIRS.get());
        //dropSelf(RiderBlocks.LIGHT_GREEN_WALLPLATE_STAIRS.get());
        //dropSelf(RiderBlocks.RED_WALLPLATE_STAIRS.get());
        //dropSelf(RiderBlocks.WALLPLATE_STAIRS.get());

        //dropSelf(RiderBlocks.CHECKERED_TILE.get());
        //dropSelf(RiderBlocks.YELLOW_CHECKERED_TILE.get());
        //dropSelf(RiderBlocks.LIME_CHECKERED_TILE.get());
        //dropSelf(RiderBlocks.VERTICAL_PANEL.get());
        //dropSelf(RiderBlocks.PLINTH.get());
        //dropSelf(RiderBlocks.PAVEMENT_ROADLINE.get());
        dropSelf(RiderBlocks.CAFE_COUNTER.get());
        dropSelf(RiderBlocks.ANOTHER_DENLINER_WINDOW.get());
        dropSelf(RiderBlocks.ANOTHER_DENLINER_SIDE_WITH_LINE.get());

        //add(RiderBlocks.HELHEIM_DOOR.get(),
        //        block -> createDoorTable(RiderBlocks.HELHEIM_DOOR.get()));
        //dropSelf(RiderBlocks.ICHIGO_CHAIR.get());
        //dropSelf(RiderBlocks.HELHEIM_SAPLING.get());
        //add(RiderBlocks.RABBIT_HUTCH_DOOR.get(),
        //        block -> createDoorTable(RiderBlocks.RABBIT_HUTCH_DOOR.get()));
        //add(RiderBlocks.GLASS_DOOR.get(),
        //        block -> createDoorTable(RiderBlocks.GLASS_DOOR.get()));
        //add(RiderBlocks.WONDERWOOD_DOOR.get(),
        //        block -> createDoorTable(RiderBlocks.WONDERWOOD_DOOR.get()));
        //add(RiderBlocks.JAIL_DOOR.get(),
        //        block -> createDoorTable(RiderBlocks.JAIL_DOOR.get()));

       // add(RiderBlocks.HELHEIM_SIGN.get(),
       //         block -> createSingleItemTable(Modded_item_core.HELHEIM_SIGN_ITEM.get()));
        //add(RiderBlocks.HELHEIM_WALL_SIGN.get(),
        //        block -> createSingleItemTable(Modded_item_core.HELHEIM_SIGN_ITEM.get()));
       // add(RiderBlocks.HELHEIM_HANGING_SIGN.get(),
       //         block -> createSingleItemTable(Modded_item_core.HELHEIM_HANGING_SIGN_ITEM.get()));
       // add(RiderBlocks.HELHEIM_WALL_HANGING_SIGN.get(),
       //         block -> createSingleItemTable(Modded_item_core.HELHEIM_HANGING_SIGN_ITEM.get()));
        add(RiderBlocks.YELLOW_WALLPLATE_WALL.get(),
                block -> createSingleItemTable(RiderBlocks.YELLOW_WALLPLATE_WALL.get()));
        add(RiderBlocks.RED_GEM_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.RED_GEM_BLOCK.get()));
        add(RiderBlocks.YELLOW_GEM_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.YELLOW_GEM_BLOCK.get()));
        add(RiderBlocks.BLUE_GEM_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.BLUE_GEM_BLOCK.get()));
        add(RiderBlocks.GREEN_GEM_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.GREEN_GEM_BLOCK.get()));
        add(RiderBlocks.ORANGE_GEM_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.ORANGE_GEM_BLOCK.get()));
        add(RiderBlocks.PURPLE_GEM_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.PURPLE_GEM_BLOCK.get()));
        add(RiderBlocks.CYAN_GEM_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.CYAN_GEM_BLOCK.get()));
        add(RiderBlocks.BLACK_GEM_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.BLACK_GEM_BLOCK.get()));
        add(RiderBlocks.HIDEN_METAL_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.HIDEN_METAL_BLOCK.get()));
        add(RiderBlocks.CELL_ALLOY_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.CELL_ALLOY_BLOCK.get()));
        add(RiderBlocks.SHIFT_ALLOY_BLOCK.get(),
                block -> createSingleItemTable(RiderBlocks.SHIFT_ALLOY_BLOCK.get()));
    }

    @Override
    public @NotNull Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key -> key.getNamespace().equals(KamenRiderCraftCore.MOD_ID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}

