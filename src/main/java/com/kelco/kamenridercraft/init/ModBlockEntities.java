package com.kelco.kamenridercraft.init;

import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.block.entity.AstroswitchPanelBlockEntity;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, KamenRiderCraftCore.MOD_ID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ASTROSWITCH_PANEL = register("astroswitch_panel", Rider_Blocks.ASTROSWITCH_PANEL, AstroswitchPanelBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ASTROSWITCH_PANEL.get(), (blockEntity, side) -> ((AstroswitchPanelBlockEntity) blockEntity).getItemHandler());
	}
}
