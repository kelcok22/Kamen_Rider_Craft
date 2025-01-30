package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KamenRiderCraftCore.MOD_ID, exFileHelper);
    }

    public static List<Block> SIMPLE_BLOCK= new ArrayList<Block>();


    @Override
    protected void registerStatesAndModels() {


        for (int i = 0; i < SIMPLE_BLOCK.size(); i++)
        {
            simpleBlock(SIMPLE_BLOCK.get(i));


        }

        //lockItem(Rider_Blocks.SWORD_OF_LOGOS_GOLD_BLOCK.get());


        simpleBlock(Rider_Blocks.KURUMA_BRICK.get());

        stairsBlock(Rider_Blocks.HELHEIM_STAIRS.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        slabBlock(Rider_Blocks.HELHEIM_SLAB.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        buttonBlock(Rider_Blocks.HELHEIM_BUTTON.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));
        pressurePlateBlock(Rider_Blocks.HELHEIM_PRESSURE_PLATE.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        fenceBlock(Rider_Blocks.HELHEIM_FENCE.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));
        fenceGateBlock(Rider_Blocks.HELHEIM_FENCE_GATE.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        doorBlockWithRenderType(Rider_Blocks.HELHEIM_DOOR.get(),modLoc("block/helheim_door_bottom"),modLoc("block/helheim_door_top"), "cutout");
        trapdoorBlockWithRenderType(Rider_Blocks.HELHEIM_TRAPDOOR.get(),modLoc("block/helheim_trapdoor"),true,"cutout");

        blockItem(Rider_Blocks.KURUMA_BRICK);

        blockItem(Rider_Blocks.HELHEIM_PRESSURE_PLATE);
        blockItem(Rider_Blocks.HELHEIM_STAIRS);


        blockItem(Rider_Blocks.HELHEIM_FENCE_GATE);
        blockItem(Rider_Blocks.HELHEIM_SLAB);
        blockItem(Rider_Blocks.HELHEIM_TRAPDOOR, "_bottom");
        blockItem(Rider_Blocks.PAVEMENT);
     //   blockItem(Rider_Blocks.PAVEMENT_ROADLINE);

        doorBlockWithRenderType(Rider_Blocks.RABBIT_HUTCH_DOOR.get(),modLoc("block/rabbit_hutch_door_bottom"),modLoc("block/rabbit_hutch_door_top"), "cutout");

    }

        private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("kamenridercraft:block/" + block.getName()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("kamenridercraft:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("kamenridercraft:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
