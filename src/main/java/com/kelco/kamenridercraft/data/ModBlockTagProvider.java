package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.RiderBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, KamenRiderCraftCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        /*
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(RiderBlocks.HELHEIM_DOOR.get())
                .add(RiderBlocks.HELHEIM_SLAB.get())
                .add(RiderBlocks.HELHEIM_STAIRS.get())
                .add(RiderBlocks.HELHEIM_BUTTON.get())
                .add(RiderBlocks.HELHEIM_PLANKS.get())
                .add(RiderBlocks.HELHEIM_FENCE_GATE.get())
                .add(RiderBlocks.HELHEIM_PRESSURE_PLATE.get())
                .add(RiderBlocks.HELHEIM_FENCE.get())
                .add(RiderBlocks.HELHEIM_WOOD.get())
                .add(RiderBlocks.STRIPPED_HELHEIM_WOOD.get())
                .add(RiderBlocks.STRIPPED_HELHEIM_LOG.get())
                .add(RiderBlocks.HELHEIM_LOG.get())
                .add(RiderBlocks.HELHEIM_TRAPDOOR.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(RiderBlocks.GHOST_LINER_WHEEL.get());
                .add(RiderBlocks.RABBIT_HUTCH_DOOR.get())
*/


        tag(BlockTags.FENCES).add(RiderBlocks.HELHEIM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(RiderBlocks.HELHEIM_FENCE_GATE.get());

        tag(BlockTags.WALLS).add(RiderBlocks.YELLOW_WALLPLATE_WALL.get());
        tag(BlockTags.WALLS).add(RiderBlocks.CYAN_WALLPLATE_WALL.get());
        tag(BlockTags.WALLS).add(RiderBlocks.BLUE_WALLPLATE_WALL.get());
        tag(BlockTags.WALLS).add(RiderBlocks.LIGHT_BLUE_WALLPLATE_WALL.get());
        tag(BlockTags.WALLS).add(RiderBlocks.WHITE_WALLPLATE_WALL.get());

    }
}