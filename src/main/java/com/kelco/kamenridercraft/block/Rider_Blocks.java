package com.kelco.kamenridercraft.block;


import java.util.function.Supplier;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.baseBlocks.*;
import com.kelco.kamenridercraft.block.custom.ChairBlock;
import com.kelco.kamenridercraft.block.machineBlocks.*;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Rider_Blocks {


	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(KamenRiderCraftCore.MOD_ID);
	
	public static final DeferredBlock<Block> ICHIGO_CHAIR = registerBlock("ichigo_chair",
			() -> new ChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).lightLevel((p_152632_) -> {
			      return 1;}).strength(2f).dynamicShape(),Block.box(2, 0, 1, 14,10, 15)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> SHOCKER_MONITOR = registerBlock("shocker_monitor",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> AMAZON_CELL_EXTRACTOR = registerBlock("amazon_cell_extractor",
			() -> new AmazonCellExtractor(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> AMAZON_CELL_MUTATOR = registerBlock("amazon_cell_mutator",
			() -> new AmazonCellMutator(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> KAIJIN_STONE_GENERATOR = registerBlock("kaijin_stone_generator",
			() -> new KaijinStoneGenerator(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>BLUE_ROSE = registerBlock("blue_rose",
			() -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 5, 
					BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).noOcclusion().noCollission()));

	public static final DeferredBlock<Block> POTTED_BLUE_ROSE = registerBlock("potted_blue_rose",
			() -> new FlowerPotBlock(Rider_Blocks.BLUE_ROSE.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

	public static final DeferredBlock<Block> KUUGA_ORE = registerBlock("stone_kuuga",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DEEPSLATE_KUUGA_ORE = registerBlock("deepslate_stone_kuuga",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> G_SYSTEM_CHIP_PROGRAMMER = registerBlock("g_chip_programer",
			() -> new GSystemChipProgrammer(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	/**
	public static final DeferredBlock<Block>  GLASS_RYUKI = registerBlock("glass_ryuki",
			() -> new GlassBaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6),DyeColor.RED).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>  DEEPSLATE_GLASS_RYUKI = registerBlock("deepslate_glass_ryuki",
			() -> new GlassBaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6),DyeColor.BLACK).AddToTabList(RiderTabs.RIDER_BLOCK));
**/
	public static final DeferredBlock<Block>  BLADE_ORE = registerBlock("stone_blade",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>  DEEPSLATE_BLADE_ORE = registerBlock("deepslate_stone_blade",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block>  HIBIKI_ORE = registerBlock("stone_hibiki",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));
		
	public static final DeferredBlock<Block>  DEEPSLATE_HIBIKI_ORE = registerBlock("deepslate_stone_hibiki",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));
		
	public static final DeferredBlock<Block>  KIVA_ORE = registerBlock("stone_kiva",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>  DEEPSLATE_KIVA_ORE = registerBlock("deepslate_stone_kiva",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));
/**
	public static final DeferredBlock<Block>  FANGIRE_GLASS = registerBlock("fangire_glass",
			() -> new GlassBaseBlockDropExperience(BlockBehaviour.Properties.copy(Blocks.GLASS), UniformInt.of(0,0),DyeColor.YELLOW).AddToTabList(RiderTabs.RIDER_BLOCK));
**/
	
	
	public static final DeferredBlock<Block>  PURE_GAIA_MEMORY_BLOCK = registerBlock("pure_gaia_memory_block",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	//.lightLevel((glow) -> { return 15; })
	
	public static final DeferredBlock<Block>  GAIA_MEMORY_ORE = registerBlock("gaiamemoryblock",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));

	//.lightLevel((glow) -> { return 15; })
	public static final DeferredBlock<Block> DEEPSLATE_GAIA_MEMORY_ORE = registerBlock("deepslate_gaiamemoryblock",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block>  GAIA_MEMORY_REFINER = registerBlock("gaia_memory_refiner",
			() -> new GaiaMemoryRefinerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> CELL_MEDAL_PROGRAMER = registerBlock("cell_medal_programer",
			() -> new CellMedalProgramer(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> MIGHTY_BLOCK = registerBlock("mighty_block",
			() -> new DespawnBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> BANG_BANG_DRUM = registerBlock("bang_bang_drum",
			() -> new DespawnBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> BAKUSOU_TROPHY = registerBlock("bakusou_trophy",
			() -> new DespawnBlockNotCube(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE).dynamicShape(),Block.box(4, 0, 6, 12,16, 10)).AddToTabList(RiderTabs.RIDER_BLOCK));
	

	public static final DeferredBlock<Block> GAME_CREATOR = registerBlock("gamecreator",
			() -> new GameCreator(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> GANBERIZING_MACHINE = registerBlock("ganbarizing_machine",
			() -> new GanbarizingMachine(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).lightLevel(null).dynamicShape().lightLevel((p_152632_) -> {
					      return 10;}),Block.box(1, 0, 1, 14,32, 14)).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> COUNTER_95DO = registerBlock("counter_95do",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> GINGA_METEOR = registerBlock("ginga_meteor",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> HIDEN_3D_PRINTER = registerBlock("hiden_3d_printer",
			() -> new ProgrisekeyPrinter(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> ZAIA_3D_PRINTER = registerBlock("zaia_3d_printer",
			() -> new ProgrisekeyPrinter(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> KAMEN_CAFE_COUNTER = registerBlock("kamen_cafe_counter",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	
	public static final DeferredBlock<Block> MONITOR = registerBlock("monitor",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	//.lightLevel((glow) -> { return 15; })

	public static final DeferredBlock<Block> OVERLORD_OOPART = registerBlock("overlord_oopart",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> OVERLORD_OOPART2 = registerBlock("overlord_oopart2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> PLANKS_BIG_OAK_GOLDEN_TRIM = registerBlock("planks_big_oak_golden_trim",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> PLANKS_BROWN = registerBlock("planks_brown",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> PLANKS_DARK_BLUE = registerBlock("planks_dark_blue",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> PLANKS_LIGHT_BLUE = registerBlock("planks_light_blue",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block>PLANKS_WHITE = registerBlock("planks_white",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> QUARTZ_BLOCK_GOLD_TRIM = registerBlock("quartz_block_gold_trim",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> SPRUCE_FLOORING = registerBlock("spruce_flooring",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> IMAGIN_SAND_BLOCK = registerBlock("imagin_sand_block",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)
					.strength(0.5f)).AddToTabList(RiderTabs.RIDER_BLOCK));
			// () -> new ColoredFallingBlock(new ColorRGBA(13224123),
			// BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)));


	public static final DeferredBlock<Block> DENLINER_INTERIOR = registerBlock("denliner_interior",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_INTERIOR_DARKER = registerBlock("denliner_interior_darker",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_INTERIOR_WITH_LINE = registerBlock("denliner_interior_with_line",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	/**
	public static final DeferredBlock<Block> DENLINER_INTERIOR_WINDOW = registerBlock("denliner_interior_windo",
			() -> new GlassBaseFacingBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
					.strength(2f),DyeColor.BLUE).AddToTabList(RiderTabs.RIDER_BLOCK));
**/

	public static final DeferredBlock<Block> DENLINER_SIDE_WITH_LINE = registerBlock("denliner_side_with_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_SIDE_WITH_START_LINE = registerBlock("denliner_side_with_start_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_SIDE_WITH_LINE_IKAZUCHI = registerBlock("denliner_side_with_line_ikazuchi",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_SIDE_WITH_LINE_REKKOU = registerBlock("denliner_side_with_line_rekkou",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_ROOF = registerBlock("denliner_roof",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
					
	public static final DeferredBlock<Block> DENLINER_LOGO_TOP = registerBlock("denliner_logo_top",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_LOGO_BOTTOM = registerBlock("denliner_logo_bottom",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_LOGO_SIDE = registerBlock("denliner_logo_side",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_LOGO_SIDER = registerBlock("denliner_logo_sider",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
				
	public static final DeferredBlock<Block> DENLINER_GLASS = registerBlock("denliner_glass",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_GLASS2 = registerBlock("denliner_glass2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_GLASS3 = registerBlock("denliner_glass3",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_GLASS_IKAZUCHI = registerBlock("denliner_glass_ikazuchi",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_GLASS_REKKOU = registerBlock("denliner_glass_rekkou",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> NEGA_DENLINER_GLASS = registerBlock("nega_denliner_glass",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
					
	public static final DeferredBlock<Block> DENLINER_GOLD = registerBlock("denliner_gold",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_MATEL = registerBlock("denliner_matel",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_MATEL_TOP = registerBlock("denliner_matel_top",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_MATEL_TOP2 = registerBlock("denliner_matel_top2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_MATEL_SIDE = registerBlock("denliner_matel_side",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
					
	public static final DeferredBlock<Block> DENLINER_MATEL_DARK = registerBlock("denliner_matel_dark",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DENLINER_MATEL_DARK_LINE = registerBlock("denliner_matel_dark_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
					
	public static final DeferredBlock<Block> NEW_DENLINER_INTERIOR = registerBlock("new_denliner_interior",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> NEW_DENLINER_SIDE_WITH_LINE = registerBlock("new_denliner_side_with_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> NEW_DENLINER_SIDE_WITH_START_LINE = registerBlock("new_denliner_side_with_start_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> NEW_DENLINER_LOGO_TOP = registerBlock("new_denliner_logo_top",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> NEW_DENLINER_LOGO_BOTTOM = registerBlock("new_denliner_logo_bottom",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> NEW_DENLINER_MATEL_TOP = registerBlock("new_denliner_matel_top",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> NEW_DENLINER_MATEL_TOP2 = registerBlock("new_denliner_matel_top2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> NEW_DENLINER_MATEL_SIDE = registerBlock("new_denliner_matel_side",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
					
	public static final DeferredBlock<Block> KING_LINER_RED = registerBlock("king_liner_red",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> KING_LINER_LOGO_TOP = registerBlock("king_liner_logo_top",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> KING_LINER_LOGO_BOTTOM = registerBlock("king_liner_logo_bottom",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> KING_LINER_LOGO_SIDE = registerBlock("king_liner_logo_side",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> KING_LINER_LOGO_SIDER = registerBlock("king_liner_logo_sider",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	/**
	public static final DeferredBlock<Block> KING_LINER_WINDOW = registerBlock("king_liner_windo",
			() -> new GlassBaseFacingBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
					.strength(2f),DyeColor.BLUE).AddToTabList(RiderTabs.RIDER_BLOCK));
		**/

	public static final DeferredBlock<Block> GAOH_LINER_GOLD = registerBlock("gaoh_liner_gold",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> GAOH_LINER_GREEN = registerBlock("gaoh_liner_green",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	/**
	public static final DeferredBlock<Block> GAOH_LINER_WINDOW = registerBlock("gaoh_liner_windo",
			() -> new GlassBaseFacingBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
					.strength(2f),DyeColor.LIME).AddToTabList(RiderTabs.RIDER_BLOCK));
	**/

	public static final DeferredBlock<Block> GAOHLINER_LOGO_TOP = registerBlock("gaohliner_logo_top",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> GAOHLINER_LOGO_BOTTOM = registerBlock("gaohliner_logo_bottom",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> GAOHLINER_LOGO_SIDE = registerBlock("gaohliner_logo_side",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> GAOHLINER_LOGO_SIDER = registerBlock("gaohliner_logo_sider",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
					
	public static final DeferredBlock<Block> ZERO_LINER_GREEN = registerBlock("zero_liner_green",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
					
	public static final DeferredBlock<Block> STONE_FLOORING = registerBlock("stone_flooring",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_BOOKSHELF = registerBlock("sword_of_logos_bookshelf",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_BRICK = registerBlock("sword_of_logos_brick",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));
	

	public static final DeferredBlock<Block> SWORD_OF_LOGOS_GOLD_TRIM = registerBlock("sword_of_logos_gold_trim",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_LOGO = registerBlock("sword_of_logos_logo",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	

	public static final DeferredBlock<Block> SWORD_OF_LOGOS_SWORD_BLADE = registerBlock("sword_of_logos_sword_blade",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> SWORD_OF_LOGOS_STAIRS = registerBlock("sword_of_logos_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> SWORD_OF_LOGOS_WOOD_STAIRS = registerBlock("sword_of_logos_wood_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_GOLD_STAIRS = registerBlock("sword_of_logos_gold_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_TABEL_STAIRS = registerBlock("sword_of_logos_tabel_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_TABEL_TOP = registerBlock("sword_of_logos_tabel_top",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_WOOD_TRIM = registerBlock("sword_of_logos_wood_trim",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));	
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_WOOD = registerBlock("sword_of_logos_wood",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_WOOD2 = registerBlock("sword_of_logos_wood2",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> TADDLE_BRICK = registerBlock("taddle_brick",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> TADDLE_WALL = registerBlock("taddle_wall",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> WALLPLATE = registerBlock("wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> WHITE_WALLPLATE = registerBlock("white_wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> WOODEN_PANEL = registerBlock("wooden_panel",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> WOODEN_PANEL2 = registerBlock("wooden_panel2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
/**
	public static final RegistryObject<Block> GAOH_BOSS_BLOCK = registerBlock("gaoh_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.GAOH
					,Component.translatable("Gaoh Form!").withStyle(ChatFormatting.GOLD)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final RegistryObject<Block> POSEIDON_BOSS_BLOCK = registerBlock("poseidon_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.POSEIDON
					,Component.translatable("Same! Kujira! Ookamiuo!").withStyle(ChatFormatting.AQUA)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final RegistryObject<Block> CORE_BOSS_BLOCK = registerBlock("core_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.CORE
					,Component.translatable("Henshin!").withStyle(ChatFormatting.RED)
					,1,Blocks.FIRE).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	
	public static final RegistryObject<Block> POWERED_UP_CORE_BOSS_BLOCK = registerBlock("powered_up_core_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.POWERED_UP_CORE
					,Component.translatable("Henshin!").withStyle(ChatFormatting.DARK_PURPLE)
					,1,Blocks.FIRE).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final RegistryObject<Block> ANCIENT_OOO_BOSS_BLOCK = registerBlock("ancient_ooo_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.ANCIENT_OOO
					,Component.translatable("Taka! Tora! Batta!").withStyle(ChatFormatting.GOLD)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final RegistryObject<Block> GODA_BOSS_BLOCK = registerBlock("goda_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.GODA
					,Component.translatable("Mukade! Hachi! Ari!").withStyle(ChatFormatting.DARK_PURPLE)).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final RegistryObject<Block> CRONUS_BOSS_BLOCK = registerBlock("cronus_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.CRONUS
					,Component.translatable("Buggle Up! Ten wo tsukame Rider! Kizame chronicle! Ima koso toki wa kiwamareri!").withStyle(ChatFormatting.GREEN)
					,1,MIGHTY_BLOCK.get(),BANG_BANG_DRUM.get(),BAKUSOU_TROPHY.get()).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final RegistryObject<Block> HOROBI_BOSS_BLOCK = registerBlock("horobi_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.HOROBI
					,Component.translatable("Forcerise! Sting Scorpion! Break down.").withStyle(ChatFormatting.DARK_PURPLE)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final RegistryObject<Block> IKAZUCHI_BOSS_BLOCK = registerBlock("ikazuchi_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.IKAZUCHI
					,Component.translatable("Forcerise! Break down.").withStyle(ChatFormatting.DARK_RED)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final RegistryObject<Block> ARK_ONE_BOSS_BLOCK = registerBlock("ark_one_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.ARK_ZERO
					,Component.translatable("Arkrise! All zero.").withStyle(ChatFormatting.DARK_RED)).AddToTabList(RiderTabs.RIDER_BLOCK));
**/

private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
	DeferredBlock<T> toReturn = BLOCKS.register(name, block);
	registerBlockItem(name, toReturn);
	return toReturn;
}

	private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
		Modded_item_core.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}