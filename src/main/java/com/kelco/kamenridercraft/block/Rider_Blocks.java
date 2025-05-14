package com.kelco.kamenridercraft.block;


import java.util.function.Supplier;

import com.kelco.kamenridercraft.KamenRiderCraftCore;

import com.kelco.kamenridercraft.block.baseBlocks.*;
import com.kelco.kamenridercraft.block.custom.*;
import com.kelco.kamenridercraft.block.machineBlocks.*;
/*import com.kelco.kamenridercraft.block.storageBlocks.AstroswitchPanelBlock;*/
import com.kelco.kamenridercraft.block.storageBlock.PandoraPanelBlock;
import com.kelco.kamenridercraft.data.ModWoodTypes;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import com.kelco.kamenridercraft.wordgen.tree.ModTreeGrowers;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Rider_Blocks {


	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(KamenRiderCraftCore.MOD_ID);
	
	public static final DeferredBlock<Block> ICHIGO_CHAIR = registerBlock("ichigo_chair",
			() -> new ChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).lightLevel((p_152632_) -> {
			      return 1;}).strength(2f).dynamicShape(),Block.box(2, 0, 1, 14,10, 15)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> RED_ICHIGO_CHAIR = registerBlock("red_ichigo_chair",
			() -> new ChairBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).lightLevel((p_152632_) -> {
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

	public static final DeferredBlock<LadderBlock> STEEL_LADDER = registerBlock("steel_ladder",
			() -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));


	public static final DeferredBlock<Block> KUUGA_ORE = registerBlock("stone_kuuga",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DEEPSLATE_KUUGA_ORE = registerBlock("deepslate_stone_kuuga",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> G_SYSTEM_CHIP_PROGRAMMER = registerBlock("g_chip_programer",
			() -> new GSystemChipProgrammer(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>  GLASS_RYUKI = registerBlock("glass_ryuki",
			() -> new GlassBaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6),DyeColor.RED).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>  DEEPSLATE_GLASS_RYUKI = registerBlock("deepslate_glass_ryuki",
			() -> new GlassBaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6),DyeColor.BLACK).AddToTabList(RiderTabs.RIDER_BLOCK));

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

	public static final DeferredBlock<Block>  FANGIRE_GLASS = registerBlock("fangire_glass",
			() -> new GlassBaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel((glow) -> { return 15; }), UniformInt.of(0,0),DyeColor.YELLOW).AddToTabList(RiderTabs.RIDER_BLOCK));

	
	public static final DeferredBlock<Block>  PURE_GAIA_MEMORY_BLOCK = registerBlock("pure_gaia_memory_block",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel((glow) -> { return 15; })
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	
	public static final DeferredBlock<Block>  GAIA_MEMORY_ORE = registerBlock("gaiamemoryblock",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> DEEPSLATE_GAIA_MEMORY_ORE = registerBlock("deepslate_gaiamemoryblock",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block>  WIZARD_GEM_ORE = registerBlock("wizardgemblock",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6))
					.AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DEEPSLATE_WIZARD_GEM_ORE= registerBlock("deepslate_wizardgemblock",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>  GHOST_ORE = registerBlock("ghost_eyecon_stone",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>  DEEPSLATE_GHOST_ORE = registerBlock("deepslate_ghost_eyecon_stone",
			() -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block>  GAIA_MEMORY_REFINER = registerBlock("gaia_memory_refiner",
			() -> new GaiaMemoryRefinerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> CELL_MEDAL_PROGRAMMER = registerBlock("cell_medal_programer",
			() -> new CellMedalProgramer(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> ASTROSWITCH_PROGRAMMER = registerBlock("astroswitch_programmer",
			() -> new AstroswitchProgrammer(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));



	public static final DeferredBlock<DoorBlock> RABBIT_HUTCH_DOOR = registerBlock("rabbit_hutch_door",
			() -> new DoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

	public static final DeferredBlock<Block> GINGA_METEOR = registerBlock("ginga_meteor",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> ARTIFICIAL_GRAVITY_BLOCK = registerBlock("artificial_gravity_block",
			() -> new ArtificialGravityBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> SHIFT_CHASSIS_ASSEMBLER = registerBlock("shift_chassis_assembler",
			() -> new ShiftChassisAssembler(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> MIGHTY_BLOCK = registerBlock("mighty_block",
			() -> new DespawnBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_DECOR));
	
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
					.strength(5.0F, 6.0F).sound(SoundType.METAL).dynamicShape().lightLevel((p_152632_) -> {
					      return 10;}),Block.box(1, 0, 1, 14,32, 14)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> PANDORA_BOX = registerBlock("pandora_box",
			() -> new PandoraBox(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> FULLBOTTLE_PURIFIER = registerBlock("fullbottle_purifier",
			() -> new FullbottlePurifier(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> FULLBOTTLE_SOLIDIFIER = registerBlock("fullbottle_solidifier",
			() -> new FullbottleSolidifier(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> COUNTER_95DO = registerBlock("counter_95do",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	

	public static final DeferredBlock<Block> HIDEN_3D_PRINTER = registerBlock("hiden_3d_printer",
			() -> new ProgrisekeyPrinter(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> ZAIA_3D_PRINTER = registerBlock("zaia_3d_printer",
			() -> new ProgrisekeyPrinter(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> SWORD_OF_LOGOS_BOOK_ANALYZER = registerBlock("sword_of_logos_book_analyzer",
			() -> new SwordOfLogosBookAnalyzer(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> VISTAMP_BAR = registerBlock("vistamp_bar",
			() -> new VistampBar(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> HEATPRESS_EXTRACTOR = registerBlock("heatpress_extractor",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> KURUMA_BRICK = registerBlock("kuruma_brick",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<LadderBlock> DRIVE_PIT_LADDER = registerBlock("drive_pit_ladder",
			() -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));

	public static final DeferredBlock<LadderBlock> DRIVE_PIT_LOGO = registerBlock("drive_pit_logo",
			() -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).lightLevel((p_152632_) -> {return 100;})));


	public static final DeferredBlock<Block> HELHEIM_LOG = registerBlock("helheim_log",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> HELHEIM_WOOD = registerBlock("helheim_wood",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> STRIPPED_HELHEIM_LOG = registerBlock("stripped_helheim_log",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> STRIPPED_HELHEIM_WOOD = registerBlock("stripped_helheim_wood",
			() -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> HELHEIM_PLANKS = registerBlock("helheim_planks",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> HELHEIM_STAIRS = registerBlock("helheim_stairs",
			() -> new StairBlock(Rider_Blocks.HELHEIM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(2f)));

	public static final DeferredBlock<SlabBlock> HELHEIM_SLAB = registerBlock("helheim_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));

	public static final DeferredBlock<PressurePlateBlock> HELHEIM_PRESSURE_PLATE = registerBlock("helheim_pressure_plate",
			() -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f)));

	public static final DeferredBlock<ButtonBlock> HELHEIM_BUTTON = registerBlock("helheim_button",
			() -> new ButtonBlock(BlockSetType.OAK,20, BlockBehaviour.Properties.of().strength(2f).noCollission()));

	public static final DeferredBlock<FenceBlock> HELHEIM_FENCE = registerBlock("helheim_fence",
			() -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));

	public static final DeferredBlock<FenceGateBlock> HELHEIM_FENCE_GATE = registerBlock("helheim_fence_gate",
			() -> new FenceGateBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2f)));

	public static final DeferredBlock<DoorBlock> HELHEIM_DOOR = registerBlock("helheim_door",
			() -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

	public static final DeferredBlock<TrapDoorBlock> HELHEIM_TRAPDOOR = registerBlock("helheim_trapdoor",
			() -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

	public static final DeferredBlock<Block> HELHEIM_SIGN = registerBlock("helheim_sign",
			() -> new ModStandingSignBlock(ModWoodTypes.HELHEIM,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
	public static final DeferredBlock<Block> HELHEIM_WALL_SIGN = registerBlock("helheim_wall_sign",
			() -> new ModWallSignBlock(ModWoodTypes.HELHEIM,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
	public static final DeferredBlock<Block> HELHEIM_HANGING_SIGN = registerBlock("helheim_hanging_sign",
			() -> new ModCeilingHangingSignBlock(ModWoodTypes.HELHEIM,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
	public static final DeferredBlock<Block> HELHEIM_WALL_HANGING_SIGN = registerBlock("helheim_wall_hanging_sign",
			() -> new ModWallHangingSignBlock(ModWoodTypes.HELHEIM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));


	public static final DeferredBlock<SaplingBlock> HELHEIM_SAPLING = registerBlock("helheim_sapling",
			() -> new SaplingBlock(ModTreeGrowers.HELHEIM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

	public static final DeferredBlock<Block> POTTED_HELHEIM_SAPLING = registerBlock("potted_helheim_sapling",
			() -> new FlowerPotBlock(Rider_Blocks.HELHEIM_SAPLING.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

	public static final DeferredBlock<LeavesBlock> HELHEIM_LEAVES = registerBlock("helheim_leaves",
			() -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
			@Override
				public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
				return true;
			}

			@Override
			public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
				return 60;
			}
			@Override
			public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
				return 30;
			}
			});


	public static final DeferredBlock<DoorBlock> WONDERWOOD_DOOR = registerBlock("wonderwood_door",
			() -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

	public static final DeferredBlock<FenceBlock> WHITE_FENCE = registerBlock("white_fence",
			() -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));

	public static final DeferredBlock<VineBlock> HELHEIM_VINE = registerBlock("helheim_vine",
			() -> new VineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.VINE)
					));

	public static final DeferredBlock<FlowerBlock>HELHEIM_PLANT = registerBlock("helheim_plant",
			() -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 5,
					BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).noOcclusion().noCollission()));

	public static final DeferredBlock<FlowerPotBlock> POTTED_HELHEIM_PLANT = registerBlock("potted_helheim_plant",
			() -> new FlowerPotBlock(Rider_Blocks.HELHEIM_PLANT.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

	public static final DeferredBlock<FlowerBlock>HELHEIM_PLANT_2 = registerBlock("helheim_plant_2",
			() -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 5,
					BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).noOcclusion().noCollission()));

	public static final DeferredBlock<FlowerPotBlock> POTTED_HELHEIM_PLANT_2 = registerBlock("potted_helheim_plant_2",
			() -> new FlowerPotBlock(Rider_Blocks.HELHEIM_PLANT_2.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

	public static final DeferredBlock<FlowerBlock>HELHEIM_PLANT_3 = registerBlock("helheim_plant_3",
			() -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 5,
					BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).noOcclusion().noCollission()));

	public static final DeferredBlock<FlowerPotBlock> POTTED_HELHEIM_PLANT_3 = registerBlock("potted_helheim_plant_3",
			() -> new FlowerPotBlock(Rider_Blocks.HELHEIM_PLANT_3.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

	public static final DeferredBlock<FlowerBlock>HELHEIM_PLANT_4 = registerBlock("helheim_plant_4",
			() -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 5,
					BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).noOcclusion().noCollission()));

	public static final DeferredBlock<FlowerPotBlock> POTTED_HELHEIM_PLANT_4 = registerBlock("potted_helheim_plant_4",
			() -> new FlowerPotBlock(Rider_Blocks.HELHEIM_PLANT_4.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

	public static final DeferredBlock<Block> HELHEIM_CRACK = registerBlock("helheim_crack",
			() -> new HelheimCrack(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).noCollission().noLootTable().lightLevel((p_152632_) -> {
				return 10;}).strength(2f).dynamicShape(),Block.box(2, 0, 1, 14,30, 15)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> PANDORA_FIRE = registerBlock("pandora_fire",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
					.strength(2.0F, 6.0F).sound(SoundType.AMETHYST).noCollission().noOcclusion()
					.noLootTable().lightLevel((p_152632_) -> {return 10;})));


	public static final DeferredBlock<Block> KAMEN_CAFE_COUNTER = registerBlock("kamen_cafe_counter",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	
	public static final DeferredBlock<Block> MONITOR = registerBlock("monitor",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_DECOR));
	//.lightLevel((glow) -> { return 15; })

	public static final DeferredBlock<Block> KUUGA_TOMB = registerBlock("kuuga_tomb",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> OVERLORD_OOPART = registerBlock("overlord_oopart",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> OVERLORD_OOPART2 = registerBlock("overlord_oopart2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> PLANKS_BIG_OAK_GOLDEN_TRIM = registerBlock("planks_big_oak_golden_trim",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> PLANKS_BROWN = registerBlock("planks_brown",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> PLANKS_DARK_BLUE = registerBlock("planks_dark_blue",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> PLANKS_LIGHT_BLUE = registerBlock("planks_light_blue",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block>PLANKS_WHITE = registerBlock("planks_white",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> QUARTZ_BLOCK_GOLD_TRIM = registerBlock("quartz_block_gold_trim",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SPRUCE_FLOORING = registerBlock("spruce_flooring",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> IMAGIN_SAND_BLOCK = registerBlock("imagin_sand_block",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)
					.strength(0.5f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> DENLINER_INTERIOR = registerBlock("denliner_interior",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_INTERIOR_DARKER = registerBlock("denliner_interior_darker",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_INTERIOR_WITH_LINE = registerBlock("denliner_interior_with_line",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> DENLINER_INTERIOR_WINDOW = registerBlock("denliner_interior_windo",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> DENLINER_SIDE_WITH_LINE = registerBlock("denliner_side_with_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_SIDE_WITH_START_LINE = registerBlock("denliner_side_with_start_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_SIDE_WITH_LINE_IKAZUCHI = registerBlock("denliner_side_with_line_ikazuchi",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_SIDE_WITH_LINE_REKKOU = registerBlock("denliner_side_with_line_rekkou",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_ROOF = registerBlock("denliner_roof",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
					
	public static final DeferredBlock<Block> DENLINER_LOGO_TOP = registerBlock("denliner_logo_top",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_LOGO_BOTTOM = registerBlock("denliner_logo_bottom",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_LOGO_SIDE = registerBlock("denliner_logo_side",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_LOGO_SIDER = registerBlock("denliner_logo_sider",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
				
	public static final DeferredBlock<Block> DENLINER_GLASS = registerBlock("denliner_glass",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_GLASS2 = registerBlock("denliner_glass2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_GLASS3 = registerBlock("denliner_glass3",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_GLASS_IKAZUCHI = registerBlock("denliner_glass_ikazuchi",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_GLASS_REKKOU = registerBlock("denliner_glass_rekkou",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> NEGA_DENLINER_GLASS = registerBlock("nega_denliner_glass",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
					
	public static final DeferredBlock<Block> DENLINER_GOLD = registerBlock("denliner_gold",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_MATEL = registerBlock("denliner_matel",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_MATEL_TOP = registerBlock("denliner_matel_top",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_MATEL_TOP2 = registerBlock("denliner_matel_top2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_MATEL_SIDE = registerBlock("denliner_matel_side",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
					
	public static final DeferredBlock<Block> DENLINER_MATEL_DARK = registerBlock("denliner_matel_dark",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> DENLINER_MATEL_DARK_LINE = registerBlock("denliner_matel_dark_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
					
	public static final DeferredBlock<Block> NEW_DENLINER_INTERIOR = registerBlock("new_denliner_interior",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> NEW_DENLINER_SIDE_WITH_LINE = registerBlock("new_denliner_side_with_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> NEW_DENLINER_SIDE_WITH_START_LINE = registerBlock("new_denliner_side_with_start_line",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> NEW_DENLINER_LOGO_TOP = registerBlock("new_denliner_logo_top",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> NEW_DENLINER_LOGO_BOTTOM = registerBlock("new_denliner_logo_bottom",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> NEW_DENLINER_MATEL_TOP = registerBlock("new_denliner_matel_top",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> NEW_DENLINER_MATEL_TOP2 = registerBlock("new_denliner_matel_top2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> NEW_DENLINER_MATEL_SIDE = registerBlock("new_denliner_matel_side",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
					
	public static final DeferredBlock<Block> KING_LINER_RED = registerBlock("king_liner_red",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> KING_LINER_LOGO_TOP = registerBlock("king_liner_logo_top",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> KING_LINER_LOGO_BOTTOM = registerBlock("king_liner_logo_bottom",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> KING_LINER_LOGO_SIDE = registerBlock("king_liner_logo_side",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> KING_LINER_LOGO_SIDER = registerBlock("king_liner_logo_sider",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> KING_LINER_WINDOW = registerBlock("king_liner_windo",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> GAOH_LINER_GOLD = registerBlock("gaoh_liner_gold",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> GAOH_LINER_GREEN = registerBlock("gaoh_liner_green",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> GAOH_LINER_WINDOW = registerBlock("gaoh_liner_windo",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> GAOHLINER_LOGO_TOP = registerBlock("gaohliner_logo_top",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> GAOHLINER_LOGO_BOTTOM = registerBlock("gaohliner_logo_bottom",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> GAOHLINER_LOGO_SIDE = registerBlock("gaohliner_logo_side",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> GAOHLINER_LOGO_SIDER = registerBlock("gaohliner_logo_sider",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
					
	public static final DeferredBlock<Block> ZERO_LINER_GREEN = registerBlock("zero_liner_green",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> RABBIT_HUTCH_LIGHT = registerBlock("rabbit_hutch_light",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> RABBIT_HUTCH_CYAN = registerBlock("rabbit_hutch_cyan",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> RABBIT_HUTCH_CYAN_LIGHT = registerBlock("rabbit_hutch_cyan_light",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> RABBIT_HUTCH_CYAN2 = registerBlock("rabbit_hutch_cyan2",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> RABBIT_HUTCH_COMPUTER_STAIRS = registerBlock("rabbit_hutch_computer_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<LadderBlock> RABBIT_HUTCH_LADDER = registerBlock("rabbit_hutch_ladder",
			() -> new LadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));


					
	public static final DeferredBlock<Block> STONE_FLOORING = registerBlock("stone_flooring",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_BOOKSHELF = registerBlock("sword_of_logos_bookshelf",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_BRICK = registerBlock("sword_of_logos_brick",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> SWORD_OF_LOGOS_GOLD_BLOCK = registerBlock("sword_of_logos_gold_block",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE))
					.is_basic_cube().AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> SWORD_OF_LOGOS_GOLD_TRIM = registerBlock("sword_of_logos_gold_trim",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_LOGO = registerBlock("sword_of_logos_logo",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_DECOR));
	

	public static final DeferredBlock<Block> SWORD_OF_LOGOS_SWORD_BLADE = registerBlock("sword_of_logos_sword_blade",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> SWORD_OF_LOGOS_STAIRS = registerBlock("sword_of_logos_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> SWORD_OF_LOGOS_WOOD_STAIRS = registerBlock("sword_of_logos_wood_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_GOLD_STAIRS = registerBlock("sword_of_logos_gold_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_TABEL_STAIRS = registerBlock("sword_of_logos_tabel_stairs",
			() -> new BaseStairsBlock(PLANKS_BROWN.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_TABEL_TOP = registerBlock("sword_of_logos_tabel_top",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).lightLevel((glow) -> { return 15; })
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_WOOD_TRIM = registerBlock("sword_of_logos_wood_trim",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_WOOD = registerBlock("sword_of_logos_wood",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> SWORD_OF_LOGOS_WOOD2 = registerBlock("sword_of_logos_wood2",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> SWORD_OF_LOGOS_ARCH = registerBlock("sword_of_logos_arch",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));


	public static final DeferredBlock<Block> TADDLE_BRICK = registerBlock("taddle_brick",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> TADDLE_WALL = registerBlock("taddle_wall",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
					.strength(2.0F, 6.0F).sound(SoundType.STONE)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> WALLPLATE = registerBlock("wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> WALLPLATE_STAIRS = registerBlock("wallplate_stairs",
			() -> new StairBlock(Rider_Blocks.WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> WALLPLATE_SLAB = registerBlock("wallplate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<Block> HAZARD_WALLPLATE = registerBlock("hazard_wallplate",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> GHOST_LINER_WHEEL = registerBlock("ghostliner_wheel",
			() -> new StairBlock(Rider_Blocks.WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<Block> BLACK_WALLPLATE = registerBlock("black_wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).is_basic_cube().AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> BLACK_WALLPLATE_STAIRS = registerBlock("black_wallplate_stairs",
			() -> new StairBlock(Rider_Blocks.BLACK_WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> BLACK_WALLPLATE_SLAB = registerBlock("black_wallplate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<Block> WHITE_WALLPLATE = registerBlock("white_wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> WHITE_WALLPLATE_STAIRS = registerBlock("white_wallplate_stairs",
			() -> new StairBlock(Rider_Blocks.WHITE_WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> WHITE_WALLPLATE_SLAB = registerBlock("white_wallplate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<Block> GREY_WALLPLATE = registerBlock("grey_wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).is_basic_cube().AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> GREY_WALLPLATE_STAIRS = registerBlock("grey_wallplate_stairs",
			() -> new StairBlock(Rider_Blocks.GREY_WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> GREY_WALLPLATE_SLAB = registerBlock("grey_wallplate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).strength(2f)));

	public static final DeferredBlock<Block> YELLOW_WALLPLATE = registerBlock("yellow_wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> YELLOW_WALLPLATE_STAIRS = registerBlock("yellow_wallplate_stairs",
			() -> new StairBlock(Rider_Blocks.YELLOW_WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> YELLOW_WALLPLATE_SLAB = registerBlock("yellow_wallplate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<WallBlock> YELLOW_WALLPLATE_WALL = registerBlock("yellow_wallplate_wall",
			() -> new WallBlock(BlockBehaviour.Properties.of().strength(2f)));

	public static final DeferredBlock<Block> RED_WALLPLATE = registerBlock("red_wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).is_basic_cube().AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> RED_WALLPLATE_STAIRS = registerBlock("red_wallplate_stairs",
			() -> new StairBlock(Rider_Blocks.RED_WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> RED_WALLPLATE_SLAB = registerBlock("red_wallplate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<Block> GREEN_WALLPLATE = registerBlock("green_wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).is_basic_cube().AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> GREEN_WALLPLATE_STAIRS = registerBlock("green_wallplate_stairs",
			() -> new StairBlock(Rider_Blocks.GREEN_WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> GREEN_WALLPLATE_SLAB = registerBlock("green_wallplate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<Block> LIGHT_GREEN_WALLPLATE = registerBlock("light_green_wallplate",
			() -> new BaseBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL)).is_basic_cube().AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<StairBlock> LIGHT_GREEN_WALLPLATE_STAIRS = registerBlock("light_green_wallplate_stairs",
			() -> new StairBlock(Rider_Blocks.LIGHT_GREEN_WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> LIGHT_GREEN_WALLPLATE_SLAB = registerBlock("light_green_wallplate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<Block> WALLPLATE_GRATE = registerBlock("wallplate_grate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<StairBlock> YELLOW_WALLPLATE_GRATE_STAIRS = registerBlock("yellow_wallplate_grate_stairs",
			() -> new StairBlock(Rider_Blocks.YELLOW_WALLPLATE.get().defaultBlockState(),
					BlockBehaviour.Properties.of().noOcclusion().strength(2f).requiresCorrectToolForDrops()));

	public static final DeferredBlock<SlabBlock> LIGHT_GREEN_WALLPLATE_GRATE_SLAB = registerBlock("light_green_wallplate_grate_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
					.strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion()
					.strength(2f)));

	public static final DeferredBlock<Block> WOODEN_PANEL = registerBlock("wooden_panel",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));
	
	public static final DeferredBlock<Block> WOODEN_PANEL2 = registerBlock("wooden_panel2",
			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<DoorBlock> GLASS_DOOR = registerBlock("glass_door",
			() -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

	public static final DeferredBlock<Block> CORNERSTORE_SIGN = registerBlock("cornerstore_sign",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLOWSTONE)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> VERTICAL_PANEL = registerBlock("vertical_panel",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> CHECKERED_TILE = registerBlock("checkered_tile",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_GLAZED_TERRACOTTA)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> YELLOW_CHECKERED_TILE = registerBlock("yellow_checkered_tile",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_GLAZED_TERRACOTTA)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

	public static final DeferredBlock<Block> LIME_CHECKERED_TILE = registerBlock("lime_checkered_tile",
			() -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_GLAZED_TERRACOTTA)
					.strength(2f)).AddToTabList(RiderTabs.RIDER_DECOR));

//	public static final DeferredBlock<Block> PAVEMENT_ROADLINE = registerBlock("pavement_roadline",
//			() -> new BaseFacingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB)
//					.strength(2f)));

	public static final DeferredBlock<Block> PAVEMENT = registerBlock("pavement",
			() -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB)
					.strength(2f)));
	

	public static final DeferredBlock<Block> GAOH_BOSS_BLOCK = registerBlock("gaoh_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.GAOH).addLine(Component.translatable("henshin.kamenridercraft.gaoh")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> POSEIDON_BOSS_BLOCK = registerBlock("poseidon_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.POSEIDON).addLine(Component.translatable("henshin.kamenridercraft.poseidon")).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> CORE_BOSS_BLOCK = registerBlock("core_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.CORE,Blocks.FIRE).addLine(Component.translatable("henshin.kamenridercraft.henshin").withStyle(ChatFormatting.RED)).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> POWERED_UP_CORE_BOSS_BLOCK = registerBlock("powered_up_core_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.POWERED_UP_CORE,Blocks.FIRE).addLine(Component.translatable("henshin.kamenridercraft.henshin").withStyle(ChatFormatting.DARK_PURPLE)).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> ANCIENT_OOO_BOSS_BLOCK = registerBlock("ancient_ooo_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.ANCIENT_OOO).addLine(Component.translatable("henshin.kamenridercraft.ancient_ooo")).AddToTabList(RiderTabs.RIDER_BLOCK));
	
	public static final DeferredBlock<Block> GODA_BOSS_BLOCK = registerBlock("goda_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.GODA).addLine(Component.translatable("henshin.kamenridercraft.goda")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> SUPER_GINGAOH_BOSS_BLOCK = registerBlock("super_gingaoh_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.SUPER_GINGAOH).addLine(Component.translatable("henshin.kamenridercraft.super_gingaoh")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> WISEMAN_BOSS_BLOCK = registerBlock("wiseman_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.WISEMAN).addLine(Component.translatable("henshin.kamenridercraft.wiseman")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> ROSYUO_BOSS_BLOCK = registerBlock("rosyuo_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.ROSYUO).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> REDYUE_BOSS_BLOCK = registerBlock("redyue_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.REDYUE).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DEMUSHU_BOSS_BLOCK = registerBlock("demushu_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.DEMUSHU).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> LORD_BARON_BOSS_BLOCK = registerBlock("lord_baron_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.LORD_BARON).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> GORD_DRIVE_BOSS_BLOCK = registerBlock("gord_drive_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.GORD_DRIVE).addLine(Component.translatable("henshin.kamenridercraft.gord_drive")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> CRONUS_BOSS_BLOCK = registerBlock("cronus_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.CRONUS,MIGHTY_BLOCK.get(),BANG_BANG_DRUM.get(),BAKUSOU_TROPHY.get()).addLine(Component.translatable("henshin.kamenridercraft.cronus")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> NIGHT_ROGUE_BOSS_BLOCK = registerBlock("night_rogue_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.NIGHT_ROGUE).addLine(Component.translatable("henshin.kamenridercraft.night_rogue")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> HOKUTO_TRIO_BOSS_BLOCK = registerBlock("hokuto_trio_boss_block",
			() -> new BossBlockHokutoTrio(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
			).addLine(Component.translatable("henshin.kamenridercraft.hokuto_trio")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> HELL_BROS_BOSS_BLOCK = registerBlock("hell_bros_boss_block",
			() -> new BossBlockHellBros(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)).addLine(Component.translatable("henshin.kamenridercraft.hell_bros")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> MAD_ROGUE_BOSS_BLOCK = registerBlock("mad_rogue_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.MAD_ROGUE).addLine(Component.translatable("henshin.kamenridercraft.mad_rogue")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> EVOL_BOSS_BLOCK = registerBlock("evol_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.EVOL).addLine(Component.translatable("henshin.kamenridercraft.evol")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> WOZ_BOSS_BLOCK = registerBlock("woz_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.WOZ).addLine(Component.translatable("henshin.kamenridercraft.woz")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> GINGA_BOSS_BLOCK = registerBlock("ginga_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.GINGA).addLine(Component.translatable("henshin.kamenridercraft.ginga")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> HOROBI_BOSS_BLOCK = registerBlock("horobi_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.HOROBI).addLine(Component.translatable("henshin.kamenridercraft.horobi")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> IKAZUCHI_BOSS_BLOCK = registerBlock("ikazuchi_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.IKAZUCHI).addLine(Component.translatable("henshin.kamenridercraft.ikazuchi")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> ARK_ONE_BOSS_BLOCK = registerBlock("ark_one_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.ARK_ZERO).addLine(Component.translatable("henshin.kamenridercraft.ark_zero")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<Block> SABELA_BOSS_BLOCK = registerBlock("sabela_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.SABELA).addLine(Component.translatable("henshin.kamenridercraft.sabela")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> DURENDAL_BOSS_BLOCK = registerBlock("durendal_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.DURENDAL).addLine(Component.translatable("henshin.kamenridercraft.durendal")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> SOLOMON_BOSS_BLOCK = registerBlock("solomon_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.SOLOMON).addLine(Component.translatable("henshin.kamenridercraft.solomon")).AddToTabList(RiderTabs.RIDER_BLOCK));

	public static final DeferredBlock<Block> STORIOUS_BOSS_BLOCK = registerBlock("storious_boss_block",
			() -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f)
					,MobsCore.STORIOUS_RIDER).addLine(Component.translatable("henshin.kamenridercraft.storious_rider")).AddToTabList(RiderTabs.RIDER_BLOCK));


	public static final DeferredBlock<PandoraPanelBlock> PANDORA_PANEL_BLOCK = registerBlock("pandora_panel_block",
			() -> new PandoraPanelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER)));



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