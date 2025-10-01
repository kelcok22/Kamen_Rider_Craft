package com.kelco.kamenridercraft.block.storageBlock;


import com.kelco.kamenridercraft.block.entity.PandoraPanelBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

public class PandoraPanelBlock extends BaseEntityBlock {

	public static final MapCodec<PandoraPanelBlock> CODEC = simpleCodec(PandoraPanelBlock::new);
	public static final DirectionProperty FACING;
	protected static final float AABB_OFFSET = 3.0F;
	protected static final VoxelShape EAST_AABB;
	protected static final VoxelShape WEST_AABB;
	protected static final VoxelShape SOUTH_AABB;
	protected static final VoxelShape NORTH_AABB;

	public MapCodec<PandoraPanelBlock> codec() {
		return CODEC;
	}


	public PandoraPanelBlock(Properties prop) {
		super(prop);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case WEST -> WEST_AABB;
            default -> EAST_AABB;
        };
	}

	private boolean canAttachTo(BlockGetter blockReader, BlockPos pos, Direction direction) {
		BlockState blockstate = blockReader.getBlockState(pos);
		return blockstate.isFaceSturdy(blockReader, pos, direction);
	}

	protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		return this.canAttachTo(level, pos.relative(direction.getOpposite()), direction);
	}

	protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		if (facing.getOpposite() == state.getValue(FACING) && !state.canSurvive(level, currentPos)) {
			return Blocks.AIR.defaultBlockState();
		} else {
			return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
		}
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState blockstate1;
		if (!context.replacingClickedOnBlock()) {
			blockstate1 = context.getLevel().getBlockState(context.getClickedPos().relative(context.getClickedFace().getOpposite()));
			if (blockstate1.is(this) && blockstate1.getValue(FACING) == context.getClickedFace()) {
				return null;
			}
		}

		blockstate1 = this.defaultBlockState();
		LevelReader levelreader = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
		Direction[] var6 = context.getNearestLookingDirections();
		int var7 = var6.length;

        for (Direction direction : var6) {
            if (direction.getAxis().isHorizontal()) {
                blockstate1 = blockstate1.setValue(FACING, direction.getOpposite());
                if (blockstate1.canSurvive(levelreader, blockpos)) {
                    return blockstate1;
                }
            }
        }

		return null;
	}

	protected BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	protected BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	static {
		FACING = HorizontalDirectionalBlock.FACING;
		EAST_AABB = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
		WEST_AABB = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
		SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
		NORTH_AABB = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
	}

	public PandoraPanelBlock AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

	@Override
	protected RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new PandoraPanelBlockEntity(blockPos, blockState);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		if(state.getBlock() != newState.getBlock()) {
			if(level.getBlockEntity(pos) instanceof PandoraPanelBlockEntity pedestalBlockEntity) {
				pedestalBlockEntity.drops();
				level.updateNeighbourForOutputSignal(pos, this);
			}
		}
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

/**
	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
											  Player player, InteractionHand hand, BlockHitResult hitResult) {
		if(level.getBlockEntity(pos) instanceof PandoraPanelBlockEntity PanelBlockEntity) {

				if(!PanelBlockEntity.inventory.getStackInSlot(0).isEmpty()) {
					if (PanelBlockEntity.inventory.getStackInSlot(0).getItem() instanceof PandoraPanelItem) {
						ItemStack itemstack =PanelBlockEntity.inventory.getStackInSlot(0);

						if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
							serverPlayer.openMenu(new MenuProvider() {
								@Override
								public Component getDisplayName() {
                                    return Component.translatable("container.kamenridercraft.pandora_panel");
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
									packetBuffer.writeBlockPos(player.blockPosition());
									packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
									return new PandoraPanelGuiMenu(id, inventory, packetBuffer,itemstack);
								}
							}, buf -> {
								buf.writeBlockPos(pos);
								buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							});
					}
					}
			}
		}

		return ItemInteractionResult.SUCCESS;
	}
	**/
}