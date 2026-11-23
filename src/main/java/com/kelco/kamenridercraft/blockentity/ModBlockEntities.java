package com.kelco.kamenridercraft.blockentity;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.RiderBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, KamenRiderCraftCore.MOD_ID);

    public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            RiderBlocks.HELHEIM_SIGN.get(), RiderBlocks.HELHEIM_WALL_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            RiderBlocks.HELHEIM_HANGING_SIGN.get(), RiderBlocks.HELHEIM_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<AmazonCellExtractorEntity>> AMAZON_CELL_EXTRACTOR_BE =
            BLOCK_ENTITIES.register("amazon_cell_extractor_be", () -> BlockEntityType.Builder.of(
                    AmazonCellExtractorEntity::new, RiderBlocks.AMAZON_CELL_EXTRACTOR.get()).build(null));

    public static final Supplier<BlockEntityType<GChipProgrammerEntity>> G_CHIP_PROGRAMMER_BE =
            BLOCK_ENTITIES.register("g_chip_programmer_be", () -> BlockEntityType.Builder.of(
                    GChipProgrammerEntity::new, RiderBlocks.G_SYSTEM_CHIP_PROGRAMMER.get()).build(null));

    public static final Supplier<BlockEntityType<IxaMachineBlockEntity>> IXA_MACHINE_BLOCK_BE =
            BLOCK_ENTITIES.register("ixa_machine_block_be", () -> BlockEntityType.Builder.of(
                    IxaMachineBlockEntity::new, RiderBlocks.IXA_MACHINE_BLOCK.get()).build(null));

    public static final Supplier<BlockEntityType<CellMedalProgrammerEntity>> CELL_MEDAL_PROGRAMMER_BE =
            BLOCK_ENTITIES.register("cell_medal_programmer_be", () -> BlockEntityType.Builder.of(
                    CellMedalProgrammerEntity::new, RiderBlocks.CELL_MEDAL_PROGRAMMER.get()).build(null));

    public static final Supplier<BlockEntityType<GameCreatorEntity>> GAME_CREATOR_BE =
            BLOCK_ENTITIES.register("game_creator_be", () -> BlockEntityType.Builder.of(
                    GameCreatorEntity::new, RiderBlocks.GAME_CREATOR.get()).build(null));

    public static final Supplier<BlockEntityType<AstroswitchProgrammerEntity>> ASTROSWITCH_PROGRAMMER_BE =
            BLOCK_ENTITIES.register("astroswitch_programmer_be", () -> BlockEntityType.Builder.of(
                    AstroswitchProgrammerEntity::new, RiderBlocks.ASTROSWITCH_PROGRAMMER.get()).build(null));

    public static final Supplier<BlockEntityType<PandoraPanelBlockEntity>> PANDORA_PANEL_BE =
            BLOCK_ENTITIES.register("pandora_panel_be", () -> BlockEntityType.Builder.of(
                    PandoraPanelBlockEntity::new, RiderBlocks.PANDORA_PANEL_BLOCK.get()).build(null));

    public static final Supplier<BlockEntityType<PlinthBlockEntity>> PLINTH_BE =
            BLOCK_ENTITIES.register("plinth_be", () -> BlockEntityType.Builder.of(
                    PlinthBlockEntity::new, RiderBlocks.PLINTH.get()).build(null));

    public static final Supplier<BlockEntityType<GochizoJarBlockEntity>> GOCHIZO_JAR_BE =
            BLOCK_ENTITIES.register("gochizo_jar_be", () -> BlockEntityType.Builder.of(
                    GochizoJarBlockEntity::new, RiderBlocks.GOCHIZO_JAR.get()).build(null));

    public static final Supplier<BlockEntityType<AngelGochizoStandBlockEntity>> ANGEL_GOCHIZO_STAND_BE =
            BLOCK_ENTITIES.register("angel_gochizo_stand_be", () -> BlockEntityType.Builder.of(
                    AngelGochizoStandBlockEntity::new, RiderBlocks.ANGEL_GOCHIZO_STAND.get()).build(null));

    public static final Supplier<BlockEntityType<MindDoorBlockEntity>> MIND_DOOR_BE =
            BLOCK_ENTITIES.register("mind_door_be", () -> BlockEntityType.Builder.of(
                    MindDoorBlockEntity::new, RiderBlocks.MIND_DOOR.get()).build(null));

//    public static final Supplier<BlockEntityType<AstroswitchRackBlockEntity>> ASTROSWITCH_RACK_BE =
//            BLOCK_ENTITIES.register("astroswitch_rack_be", () -> BlockEntityType.Builder.of(
//                    AstroswitchRackBlockEntity::new, RiderBlocks.ASTROSWITCH_RACK.get()).build(null));


    public static void register(IEventBus eventBus) { BLOCK_ENTITIES.register(eventBus);}
}
