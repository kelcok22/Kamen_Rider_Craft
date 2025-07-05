package com.kelco.kamenridercraft.block.custom;


import com.kelco.kamenridercraft.block.entity.PlinthBlockEntity;
import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class WhiteboardBlock extends BaseEntityBlock {

	public static VoxelShape SHAPE = Block.box(-16, 0, 7, 32,16, 9);
	public static final MapCodec<WhiteboardBlock> CODEC = simpleCodec(WhiteboardBlock::new);
	public static DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	protected static final float AABB_OFFSET = 3.0F;
	protected static final VoxelShape EAST_AABB;
	protected static final VoxelShape WEST_AABB;
	protected static final VoxelShape SOUTH_AABB;
	protected static final VoxelShape NORTH_AABB;


	public WhiteboardBlock(Properties properties) {
		super(properties);
	      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		switch ((Direction)state.getValue(FACING)) {
			case NORTH:
				return NORTH_AABB;
			case SOUTH:
				return SOUTH_AABB;
			case WEST:
				return WEST_AABB;
			case EAST:
			default:
				return EAST_AABB;
		}
	}


	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
		p_53681_.add(FACING);
	}

	public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
		return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
	}

	public PushReaction getPistonPushReaction(BlockState p_53683_) {
		return PushReaction.PUSH_ONLY;
	}

	public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
		return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
	}

	static {
		FACING = HorizontalDirectionalBlock.FACING;
		EAST_AABB = Block.box(7, 0.0, -16, 9, 16, 32);
		WEST_AABB = Block.box(7.0, 0.0, -16.0, 9.0, 16, 32);
		SOUTH_AABB = Block.box(-16.0, 0.0, 7.0, 32.0, 16.0, 9.0);
		NORTH_AABB = Block.box(-16.0, 0.0, 7.0, 32.0, 16.0, 9.0);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	public static boolean isShapeFullBlock(VoxelShape p_49917_) {
		return false;
	}


	@Override
	public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return null;
	}
}