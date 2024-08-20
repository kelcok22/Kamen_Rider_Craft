package com.kelco.kamenridercraft.block.baseBlocks;



import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
public class BaseBlockNotCube extends BaseBlock {


	  public static VoxelShape SHAPE = Block.box(4, 0, 6, 12,16, 10);
	  
	public BaseBlockNotCube(Properties prop,VoxelShape shape ) {
		
		super(prop);
		SHAPE =shape;
	}
	
	   @Override
	    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
	        return SHAPE;
	    }

	    @Override
	    public RenderShape getRenderShape(BlockState pState) {
	        return RenderShape.MODEL;
	    }

	   public static boolean isShapeFullBlock(VoxelShape p_49917_) {
		      return false;
		   }

}