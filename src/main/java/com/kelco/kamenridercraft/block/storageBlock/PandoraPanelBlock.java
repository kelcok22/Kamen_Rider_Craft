package com.kelco.kamenridercraft.block.storageBlock;


import com.kelco.kamenridercraft.block.entity.PandoraPanelBlockEntity;
import com.kelco.kamenridercraft.item.build.PandoraPanelItem;
import com.kelco.kamenridercraft.world.inventory.PandoraPanelGuiMenu;
import com.mojang.serialization.MapCodec;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.phys.BlockHitResult;

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
		this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)));
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

	private boolean canAttachTo(BlockGetter blockReader, BlockPos pos, Direction direction) {
		BlockState blockstate = blockReader.getBlockState(pos);
		return blockstate.isFaceSturdy(blockReader, pos, direction);
	}

	protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		Direction direction = (Direction)state.getValue(FACING);
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

		for(int var8 = 0; var8 < var7; ++var8) {
			Direction direction = var6[var8];
			if (direction.getAxis().isHorizontal()) {
				blockstate1 = (BlockState)blockstate1.setValue(FACING, direction.getOpposite());
				if (blockstate1.canSurvive(levelreader, blockpos)) {
					return (BlockState)blockstate1;
				}
			}
		}

		return null;
	}

	protected BlockState rotate(BlockState state, Rotation rotation) {
		return (BlockState)state.setValue(FACING, rotation.rotate((Direction)state.getValue(FACING)));
	}

	protected BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{FACING});
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

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
											  Player player, InteractionHand hand, BlockHitResult hitResult) {
		if(level.getBlockEntity(pos) instanceof PandoraPanelBlockEntity PanelBlockEntity) {
			if(PanelBlockEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty()) {
				PanelBlockEntity.inventory.insertItem(0, stack.copy(), false);
				stack.shrink(1);
				level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
			} else if(stack.isEmpty()) {
				if(!PanelBlockEntity.inventory.getStackInSlot(0).isEmpty()) {
					if (PanelBlockEntity.inventory.getStackInSlot(0).getItem() instanceof PandoraPanelItem) {
						ItemStack itemstack =PanelBlockEntity.inventory.getStackInSlot(0);

						if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
							serverPlayer.openMenu(new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("Pandora Panel");
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
									packetBuffer.writeBlockPos(player.blockPosition());
									packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
									return new PandoraPanelGuiMenu(id, inventory, packetBuffer,itemstack);
								}
							}, buf -> {
								buf.writeBlockPos(player.blockPosition());
								buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
							});
					}
					}
				}
			}
		}

		return ItemInteractionResult.SUCCESS;
	}
}