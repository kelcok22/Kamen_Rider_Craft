package com.kelco.kamenridercraft.block.entity;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static net.neoforged.neoforgespi.Environment.build;

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

    public static final Supplier<BlockEntityType<AstroswitchPanelBlockEntity>> ASTROSWITCH_PANEL =
            BLOCK_ENTITIES.register("astroswitch_panel", () ->
                    BlockEntityType.Builder.of(AstroswitchPanelBlockEntity::new,
                            Rider_Blocks.ASTROSWITCH_PANEL.get()).build(null));

    public static void register(IEventBus eventBus) { BLOCK_ENTITIES.register(eventBus);}
}
