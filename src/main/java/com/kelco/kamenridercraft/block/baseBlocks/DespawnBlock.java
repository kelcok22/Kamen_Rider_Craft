package com.kelco.kamenridercraft.block.baseBlocks;

import java.util.OptionalInt;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
public class DespawnBlock extends BaseBlock {

	public static final int DECAY_DISTANCE = 7;
	public static final IntegerProperty DISTANCE = BlockStateProperties.DISTANCE;
	public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;

	public DespawnBlock(Properties prop) {
		super(prop);
		this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)));


	}

	public boolean isRandomlyTicking(BlockState p_54449_) {
		return p_54449_.getValue(DISTANCE) == 7 && !p_54449_.getValue(PERSISTENT);
	}

	public void randomTick(BlockState p_221379_, ServerLevel p_221380_, BlockPos p_221381_, RandomSource p_221382_) {
		if (this.decaying(p_221379_)) {
			//dropResources(p_221379_, p_221380_, p_221381_);
			p_221380_.removeBlock(p_221381_, false);
		}

	}

	protected boolean decaying(BlockState p_221386_) {
		return !p_221386_.getValue(PERSISTENT) && p_221386_.getValue(DISTANCE) == 7;
	}

	public void tick(BlockState p_221369_, ServerLevel p_221370_, BlockPos p_221371_, RandomSource p_221372_) {
		p_221370_.setBlock(p_221371_, updateDistance(p_221369_, p_221370_, p_221371_), 3);
	}

	public int getLightBlock(BlockState p_54460_, BlockGetter p_54461_, BlockPos p_54462_) {
		return 1;
	}
	private static BlockState updateDistance(BlockState p_54436_, LevelAccessor p_54437_, BlockPos p_54438_) {
		int i = 7;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for(Direction direction : Direction.values()) {
			blockpos$mutableblockpos.setWithOffset(p_54438_, direction);
			i = Math.min(i, getDistanceAt(p_54437_.getBlockState(blockpos$mutableblockpos)) + 1);
			if (i == 1) {
				break;
			}
		}

		return p_54436_.setValue(DISTANCE, Integer.valueOf(i));
	}

	private static int getDistanceAt(BlockState p_54464_) {
		return getOptionalDistanceAt(p_54464_).orElse(7);
	}

	public static OptionalInt getOptionalDistanceAt(BlockState p_277868_) {
		return p_277868_.hasProperty(DISTANCE) ? OptionalInt.of(p_277868_.getValue(DISTANCE)) : OptionalInt.empty();
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54447_) {
		p_54447_.add(DISTANCE, PERSISTENT);
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_54424_) {
		BlockState blockstate = this.defaultBlockState().setValue(PERSISTENT, Boolean.valueOf(true));
		return updateDistance(blockstate, p_54424_.getLevel(), p_54424_.getClickedPos());
	}
}