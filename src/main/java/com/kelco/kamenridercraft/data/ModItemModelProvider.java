package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KamenRiderCraftCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        buttonItem(Rider_Blocks.HELHEIM_BUTTON, Rider_Blocks.HELHEIM_PLANKS);
        fenceItem(Rider_Blocks.HELHEIM_FENCE, Rider_Blocks.HELHEIM_PLANKS);

        basicItem(Rider_Blocks.HELHEIM_DOOR.asItem());
        basicItem(Rider_Blocks.RABBIT_HUTCH_DOOR.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}

