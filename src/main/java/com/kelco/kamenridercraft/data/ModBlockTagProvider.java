package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
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
        /**
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(Rider_Blocks.HELHEIM_DOOR.get())
                .add(Rider_Blocks.HELHEIM_SLAB.get())
                .add(Rider_Blocks.HELHEIM_STAIRS.get())
                .add(Rider_Blocks.HELHEIM_BUTTON.get())
                .add(Rider_Blocks.HELHEIM_PLANKS.get())
                .add(Rider_Blocks.HELHEIM_FENCE_GATE.get())
                .add(Rider_Blocks.HELHEIM_PRESSURE_PLATE.get())
                .add(Rider_Blocks.HELHEIM_FENCE.get())
                .add(Rider_Blocks.HELHEIM_WOOD.get())
                .add(Rider_Blocks.STRIPPED_HELHEIM_WOOD.get())
                .add(Rider_Blocks.STRIPPED_HELHEIM_LOG.get())
                .add(Rider_Blocks.HELHEIM_LOG.get())
                .add(Rider_Blocks.HELHEIM_TRAPDOOR.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Rider_Blocks.GHOST_LINER_WHEEL.get());
                .add(Rider_Blocks.RABBIT_HUTCH_DOOR.get())
**/


        tag(BlockTags.FENCES).add(Rider_Blocks.HELHEIM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(Rider_Blocks.HELHEIM_FENCE_GATE.get());

    }
}