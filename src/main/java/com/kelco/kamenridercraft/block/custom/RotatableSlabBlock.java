package com.kelco.kamenridercraft.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class RotatableSlabBlock extends Block {

	public static VoxelShape SHAPE = Block.box(0, 0, 0, 16,8, 16);
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public RotatableSlabBlock(Properties prop ) {
		super(prop);
	      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));

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
	 	
		   @Override
		    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		        return SHAPE;
		    }


	
	public RotatableSlabBlock AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}