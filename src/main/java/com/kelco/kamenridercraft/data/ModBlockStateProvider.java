package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            blockItem(SIMPLE_BLOCK.get(i));

        }




        simpleBlock(Rider_Blocks.KURUMA_BRICK.get());

        stairsBlock(Rider_Blocks.HELHEIM_STAIRS.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        slabBlock(Rider_Blocks.HELHEIM_SLAB.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        buttonBlock(Rider_Blocks.HELHEIM_BUTTON.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));
        pressurePlateBlock(Rider_Blocks.HELHEIM_PRESSURE_PLATE.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        fenceBlock(Rider_Blocks.HELHEIM_FENCE.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));
        fenceGateBlock(Rider_Blocks.HELHEIM_FENCE_GATE.get(), blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        doorBlockWithRenderType(Rider_Blocks.HELHEIM_DOOR.get(),modLoc("block/helheim_door_bottom"),modLoc("block/helheim_door_top"), "cutout");
        trapdoorBlockWithRenderType(Rider_Blocks.HELHEIM_TRAPDOOR.get(),modLoc("block/helheim_trapdoor"),true,"cutout");

        signBlock(((StandingSignBlock) Rider_Blocks.HELHEIM_SIGN.get()), ((WallSignBlock) Rider_Blocks.HELHEIM_WALL_SIGN.get()),
                blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));

        hangingSignBlock(((CeilingHangingSignBlock) Rider_Blocks.HELHEIM_HANGING_SIGN.get()), ((WallHangingSignBlock) Rider_Blocks.HELHEIM_WALL_HANGING_SIGN.get()),
                blockTexture(Rider_Blocks.HELHEIM_PLANKS.get()));


        blockItem(Rider_Blocks.KURUMA_BRICK);
        blockItem(Rider_Blocks.CORNERSTORE_SIGN);

        blockItem(Rider_Blocks.HELHEIM_PRESSURE_PLATE);
        blockItem(Rider_Blocks.HELHEIM_STAIRS);


        blockItem(Rider_Blocks.HELHEIM_FENCE_GATE);
        blockItem(Rider_Blocks.HELHEIM_SLAB);
        blockItem(Rider_Blocks.HELHEIM_TRAPDOOR, "_bottom");
        blockItem(Rider_Blocks.PAVEMENT);
     //   blockItem(Rider_Blocks.PAVEMENT_ROADLINE);

        doorBlockWithRenderType(Rider_Blocks.RABBIT_HUTCH_DOOR.get(),modLoc("block/rabbit_hutch_door_bottom"),modLoc("block/rabbit_hutch_door_top"), "cutout");
        doorBlockWithRenderType(Rider_Blocks.GLASS_DOOR.get(),modLoc("block/glass_door_bottom"),modLoc("block/glass_door_top"), "cutout");

    }


        private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(Block block) {
        ResourceLocation BLOCK = (ResourceLocation) Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block));
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("kamenridercraft:block/"+BLOCK.getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("kamenridercraft:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("kamenridercraft:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
