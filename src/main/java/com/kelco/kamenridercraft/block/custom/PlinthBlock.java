package com.kelco.kamenridercraft.block.custom;


import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.block.entity.PlinthBlockEntity;
import com.kelco.kamenridercraft.entities.ChairEntity;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.item.BaseItems.component.slot.SlotByTag;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class PlinthBlock extends BaseEntityBlock {

	public static VoxelShape SHAPE = Block.box(2, 0, 4, 12,2, 8);
	public static final MapCodec<PlinthBlock> CODEC = simpleCodec(PlinthBlock::new);
	public static DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	protected static final float AABB_OFFSET = 3.0F;
	protected static final VoxelShape EAST_AABB;
	protected static final VoxelShape WEST_AABB;
	protected static final VoxelShape SOUTH_AABB;
	protected static final VoxelShape NORTH_AABB;

	public static final TagKey<Item> SWORDS = TagKey.create(
			Registries.ITEM,
			ResourceLocation.fromNamespaceAndPath("c", "tools/melee_weapons"));

	public PlinthBlock(Properties properties) {
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
		EAST_AABB = Block.box(4.0, 0.0, 3.0, 11.0, 2.0, 14.0);
		WEST_AABB = Block.box(5.0, 0.0, 2.0, 12.0, 2.0, 13.0);
		SOUTH_AABB = Block.box(2.0, 0.0, 4.0, 13.0, 2.0, 11.0);
		NORTH_AABB = Block.box(3.0, 0.0, 5.0, 14.0, 2.0, 12.0);
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	public static boolean isShapeFullBlock(VoxelShape p_49917_) {
		return false;
	}


	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new PlinthBlockEntity(blockPos, blockState);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		if(state.getBlock() != newState.getBlock()) {
			if(level.getBlockEntity(pos) instanceof PlinthBlockEntity plinthBlockEntity) {
				plinthBlockEntity.drops();
				level.updateNeighbourForOutputSignal(pos,this);
			}
		}
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if(level.getBlockEntity(pos) instanceof PlinthBlockEntity plinthBlockEntity) {
			if(plinthBlockEntity.inventory.getStackInSlot(0).isEmpty() && stack.getItem() instanceof TieredItem||
					plinthBlockEntity.inventory.getStackInSlot(0).isEmpty() && stack.getItem() instanceof BaseBlasterItem){
				plinthBlockEntity.inventory.insertItem(0, stack.copy(), false);
				stack.shrink(1);
				level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
			} else if (stack.isEmpty()) {
				ItemStack stackOnPlinth = plinthBlockEntity.inventory.extractItem(0,1, false);
				player.setItemInHand(InteractionHand.MAIN_HAND, stackOnPlinth);
				plinthBlockEntity.clearContents();
				level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
			}
		}
		return ItemInteractionResult.SUCCESS;
	}



}