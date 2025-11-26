package com.kelco.kamenridercraft.block.entity;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
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
                            Rider_Blocks.HELHEIM_SIGN.get(), Rider_Blocks.HELHEIM_WALL_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            Rider_Blocks.HELHEIM_HANGING_SIGN.get(), Rider_Blocks.HELHEIM_WALL_HANGING_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<IxaMachineBlockEntity>> IXA_MACHINE_BLOCK_BE =
            BLOCK_ENTITIES.register("ixa_machine_block_be", () -> BlockEntityType.Builder.of(
                    IxaMachineBlockEntity::new, Rider_Blocks.IXA_MACHINE_BLOCK.get()).build(null));

    public static final Supplier<BlockEntityType<PandoraPanelBlockEntity>> PANDORA_PANEL_BE =
            BLOCK_ENTITIES.register("pandora_panel_be", () -> BlockEntityType.Builder.of(
                    PandoraPanelBlockEntity::new, Rider_Blocks.PANDORA_PANEL_BLOCK.get()).build(null));

    public static final Supplier<BlockEntityType<PlinthBlockEntity>> PLINTH_BE =
            BLOCK_ENTITIES.register("plinth_be", () -> BlockEntityType.Builder.of(
                    PlinthBlockEntity::new, Rider_Blocks.PLINTH.get()).build(null));

//    public static final Supplier<BlockEntityType<AstroswitchRackBlockEntity>> ASTROSWITCH_RACK_BE =
//            BLOCK_ENTITIES.register("astroswitch_rack_be", () -> BlockEntityType.Builder.of(
//                    AstroswitchRackBlockEntity::new, Rider_Blocks.ASTROSWITCH_RACK.get()).build(null));


    public static void register(IEventBus eventBus) { BLOCK_ENTITIES.register(eventBus);}
}
