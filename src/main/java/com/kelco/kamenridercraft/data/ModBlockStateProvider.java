package com.kelco.kamenridercraft.data;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.RiderBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KamenRiderCraftCore.MOD_ID, exFileHelper);
    }

    public static List<Block> SIMPLE_BLOCK= new ArrayList<>();


    @Override
    protected void registerStatesAndModels() {


        for (Block block : SIMPLE_BLOCK) {
            simpleBlock(block);
            blockItem(block);

        }




        simpleBlock(RiderBlocks.KURUMA_BRICK.get());
        simpleBlock(RiderBlocks.YELLOW_WALLPLATE.get());
        simpleBlock(RiderBlocks.CYAN_WALLPLATE.get());
        simpleBlock(RiderBlocks.BLUE_WALLPLATE.get());
        simpleBlock(RiderBlocks.LIGHT_BLUE_WALLPLATE.get());
        simpleBlock(RiderBlocks.CHECKERED_TILE.get());
        simpleBlock(RiderBlocks.YELLOW_CHECKERED_TILE.get());
        simpleBlock(RiderBlocks.LIME_CHECKERED_TILE.get());
        simpleBlock(RiderBlocks.DORAN_SCALE.get());
        simpleBlock(RiderBlocks.CELL_ALLOY_BLOCK.get());
        simpleBlock(RiderBlocks.SHIFT_ALLOY_BLOCK.get());

        stairsBlock(RiderBlocks.HELHEIM_STAIRS.get(), blockTexture(RiderBlocks.HELHEIM_PLANKS.get()));
        stairsBlock(RiderBlocks.YELLOW_WALLPLATE_GRATE_STAIRS.get(), blockTexture(RiderBlocks.YELLOW_WALLPLATE.get()));
        stairsBlock(RiderBlocks.YELLOW_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.YELLOW_WALLPLATE.get()));
        stairsBlock(RiderBlocks.RED_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.RED_WALLPLATE.get()));
        stairsBlock(RiderBlocks.BLACK_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.BLACK_WALLPLATE.get()));
        stairsBlock(RiderBlocks.GREY_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.GREY_WALLPLATE.get()));
        stairsBlock(RiderBlocks.GREEN_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.GREEN_WALLPLATE.get()));
        stairsBlock(RiderBlocks.LIGHT_GREEN_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.LIGHT_GREEN_WALLPLATE.get()));
        stairsBlock(RiderBlocks.WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.WALLPLATE.get()));
        stairsBlock(RiderBlocks.WHITE_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.WHITE_WALLPLATE.get()));
        stairsBlock(RiderBlocks.CYAN_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.CYAN_WALLPLATE.get()));
        stairsBlock(RiderBlocks.BLUE_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.BLUE_WALLPLATE.get()));
        stairsBlock(RiderBlocks.LIGHT_BLUE_WALLPLATE_STAIRS.get(), blockTexture(RiderBlocks.LIGHT_BLUE_WALLPLATE.get()));

        slabBlock(RiderBlocks.HELHEIM_SLAB.get(), blockTexture(RiderBlocks.HELHEIM_PLANKS.get()), blockTexture(RiderBlocks.HELHEIM_PLANKS.get()));
        slabBlock(RiderBlocks.WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.WALLPLATE.get()), blockTexture(RiderBlocks.WALLPLATE.get()));
        slabBlock(RiderBlocks.RED_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.RED_WALLPLATE_SLAB.get()), blockTexture(RiderBlocks.RED_WALLPLATE.get()));
        slabBlock(RiderBlocks.YELLOW_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.YELLOW_WALLPLATE.get()), blockTexture(RiderBlocks.YELLOW_WALLPLATE.get()));
        slabBlock(RiderBlocks.GREEN_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.GREEN_WALLPLATE.get()), blockTexture(RiderBlocks.GREEN_WALLPLATE.get()));
        slabBlock(RiderBlocks.LIGHT_GREEN_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.LIGHT_GREEN_WALLPLATE.get()), blockTexture(RiderBlocks.LIGHT_GREEN_WALLPLATE.get()));
        slabBlock(RiderBlocks.GREY_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.GREY_WALLPLATE.get()), blockTexture(RiderBlocks.GREY_WALLPLATE.get()));
        slabBlock(RiderBlocks.WHITE_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.WHITE_WALLPLATE.get()), blockTexture(RiderBlocks.WHITE_WALLPLATE.get()));
        slabBlock(RiderBlocks.BLACK_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.BLACK_WALLPLATE.get()), blockTexture(RiderBlocks.BLACK_WALLPLATE.get()));
        slabBlock(RiderBlocks.CYAN_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.CYAN_WALLPLATE.get()), blockTexture(RiderBlocks.CYAN_WALLPLATE.get()));
        slabBlock(RiderBlocks.BLUE_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.BLUE_WALLPLATE.get()), blockTexture(RiderBlocks.BLUE_WALLPLATE.get()));
        slabBlock(RiderBlocks.LIGHT_BLUE_WALLPLATE_SLAB.get(), blockTexture(RiderBlocks.LIGHT_BLUE_WALLPLATE.get()), blockTexture(RiderBlocks.LIGHT_BLUE_WALLPLATE.get()));

        buttonBlock(RiderBlocks.HELHEIM_BUTTON.get(), blockTexture(RiderBlocks.HELHEIM_PLANKS.get()));
        pressurePlateBlock(RiderBlocks.HELHEIM_PRESSURE_PLATE.get(), blockTexture(RiderBlocks.HELHEIM_PLANKS.get()));

        fenceBlock(RiderBlocks.HELHEIM_FENCE.get(), blockTexture(RiderBlocks.HELHEIM_PLANKS.get()));
        fenceGateBlock(RiderBlocks.HELHEIM_FENCE_GATE.get(), blockTexture(RiderBlocks.HELHEIM_PLANKS.get()));
        fenceBlock(RiderBlocks.WHITE_FENCE.get(), blockTexture(RiderBlocks.PLANKS_WHITE.get()));

        doorBlockWithRenderType(RiderBlocks.HELHEIM_DOOR.get(),modLoc("block/helheim_door_bottom"),modLoc("block/helheim_door_top"), "cutout");
        trapdoorBlockWithRenderType(RiderBlocks.HELHEIM_TRAPDOOR.get(),modLoc("block/helheim_trapdoor"),true,"cutout");
        doorBlockWithRenderType(RiderBlocks.WONDERWOOD_DOOR.get(),modLoc("block/wonderwood_door_bottom"),modLoc("block/wonderwood_door_top"), "cutout");

        signBlock(((StandingSignBlock) RiderBlocks.HELHEIM_SIGN.get()), ((WallSignBlock) RiderBlocks.HELHEIM_WALL_SIGN.get()),
                blockTexture(RiderBlocks.HELHEIM_PLANKS.get()));

        hangingSignBlock(((CeilingHangingSignBlock) RiderBlocks.HELHEIM_HANGING_SIGN.get()), ((WallHangingSignBlock) RiderBlocks.HELHEIM_WALL_HANGING_SIGN.get()),
                blockTexture(RiderBlocks.HELHEIM_PLANKS.get()));

        wallBlock(RiderBlocks.YELLOW_WALLPLATE_WALL.get(), blockTexture(RiderBlocks.YELLOW_WALLPLATE.get()));
        wallBlock(RiderBlocks.WHITE_WALLPLATE_WALL.get(), blockTexture(RiderBlocks.WHITE_WALLPLATE.get()));
        wallBlock(RiderBlocks.CYAN_WALLPLATE_WALL.get(), blockTexture(RiderBlocks.CYAN_WALLPLATE.get()));
        wallBlock(RiderBlocks.BLUE_WALLPLATE_WALL.get(), blockTexture(RiderBlocks.BLUE_WALLPLATE.get()));
        wallBlock(RiderBlocks.LIGHT_BLUE_WALLPLATE_WALL.get(), blockTexture(RiderBlocks.LIGHT_BLUE_WALLPLATE.get()));


        blockItem(RiderBlocks.KURUMA_BRICK);
        blockItem(RiderBlocks.CORNERSTORE_SIGN);
        blockItem(RiderBlocks.YELLOW_WALLPLATE);
        blockItem(RiderBlocks.CHECKERED_TILE);
        blockItem(RiderBlocks.YELLOW_CHECKERED_TILE);
        blockItem(RiderBlocks.LIME_CHECKERED_TILE);
        blockItem(RiderBlocks.VERTICAL_PANEL);
        blockItem(RiderBlocks.CAFE_COUNTER);
        blockItem(RiderBlocks.GRANUTE_GLASS);
        blockItem(RiderBlocks.DORAN_SCALE);
        blockItem(RiderBlocks.RED_GEM_BLOCK);
        blockItem(RiderBlocks.BLUE_GEM_BLOCK);
        blockItem(RiderBlocks.YELLOW_GEM_BLOCK);
        blockItem(RiderBlocks.BLACK_GEM_BLOCK);
        blockItem(RiderBlocks.GREEN_GEM_BLOCK);
        blockItem(RiderBlocks.PURPLE_GEM_BLOCK);
        blockItem(RiderBlocks.CYAN_GEM_BLOCK);
        blockItem(RiderBlocks.ORANGE_GEM_BLOCK);
        blockItem(RiderBlocks.HIDEN_METAL_BLOCK);
        blockItem(RiderBlocks.CELL_ALLOY_BLOCK);
        blockItem(RiderBlocks.SHIFT_ALLOY_BLOCK);
        blockItem(RiderBlocks.ANOTHER_DENLINER_SIDE_WITH_LINE);

        blockItem(RiderBlocks.HELHEIM_PRESSURE_PLATE);
        blockItem(RiderBlocks.HELHEIM_STAIRS);
        blockItem(RiderBlocks.YELLOW_WALLPLATE_GRATE_STAIRS);

        blockItem(RiderBlocks.YELLOW_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.YELLOW_WALLPLATE_SLAB);
        blockItem(RiderBlocks.RED_WALLPLATE);
        blockItem(RiderBlocks.RED_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.RED_WALLPLATE_SLAB);
        blockItem(RiderBlocks.BLACK_WALLPLATE);
        blockItem(RiderBlocks.BLACK_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.BLACK_WALLPLATE_SLAB);
        blockItem(RiderBlocks.GREY_WALLPLATE);
        blockItem(RiderBlocks.GREY_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.GREY_WALLPLATE_SLAB);
        blockItem(RiderBlocks.GREEN_WALLPLATE);
        blockItem(RiderBlocks.GREEN_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.GREEN_WALLPLATE_SLAB);
        blockItem(RiderBlocks.LIGHT_GREEN_WALLPLATE);
        blockItem(RiderBlocks.LIGHT_GREEN_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.LIGHT_GREEN_WALLPLATE_SLAB);
        blockItem(RiderBlocks.LIGHT_GREEN_WALLPLATE_GRATE_SLAB);
        blockItem(RiderBlocks.WALLPLATE_STAIRS);
        blockItem(RiderBlocks.WALLPLATE_SLAB);
        blockItem(RiderBlocks.WHITE_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.WHITE_WALLPLATE_SLAB);
        blockItem(RiderBlocks.CYAN_WALLPLATE);
        blockItem(RiderBlocks.CYAN_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.CYAN_WALLPLATE_SLAB);
        blockItem(RiderBlocks.BLUE_WALLPLATE);
        blockItem(RiderBlocks.BLUE_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.BLUE_WALLPLATE_SLAB);
        blockItem(RiderBlocks.LIGHT_BLUE_WALLPLATE);
        blockItem(RiderBlocks.LIGHT_BLUE_WALLPLATE_STAIRS);
        blockItem(RiderBlocks.LIGHT_BLUE_WALLPLATE_SLAB);

        blockItem(RiderBlocks.HELHEIM_FENCE_GATE);
        blockItem(RiderBlocks.HELHEIM_SLAB);
        blockItem(RiderBlocks.HELHEIM_TRAPDOOR, "_bottom");
        blockItem(RiderBlocks.PAVEMENT);
        blockItem(RiderBlocks.PAVEMENT_ROADLINE);

        doorBlockWithRenderType(RiderBlocks.RABBIT_HUTCH_DOOR.get(),modLoc("block/rabbit_hutch_door_bottom"),modLoc("block/rabbit_hutch_door_top"), "cutout");
        doorBlockWithRenderType(RiderBlocks.GLASS_DOOR.get(),modLoc("block/glass_door_bottom"),modLoc("block/glass_door_top"), "cutout");
        doorBlockWithRenderType(RiderBlocks.JAIL_DOOR.get(),modLoc("block/jail_door_bottom"),modLoc("block/jail_door_top"), "cutout");
        doorBlockWithRenderType(RiderBlocks.GOLD_DOOR.get(),modLoc("block/gold_door_bottom"),modLoc("block/gold_door_top"), "cutout");

    }


    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(Block block) {
        ResourceLocation BLOCK = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block));
        simpleBlockItem(block, new ModelFile.UncheckedModelFile("kamenridercraft:block/"+BLOCK.getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("kamenridercraft:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("kamenridercraft:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
