package com.kelco.kamenridercraft.block.custom;


import java.util.List;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
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

public class ChairBlock extends Block {

	public static VoxelShape SHAPE = Block.box(4, 0, 6, 12,16, 10);
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public ChairBlock(Properties prop,VoxelShape shape ) {
		super(prop);
	      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
			SHAPE =shape;
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if(!level.isClientSide()) {
			Entity entity = null;
			List<ChairEntity> entities = level.getEntities(MobsCore.CHAIR_ENTITY.get(), new AABB(pos), chair -> true);
			if(entities.isEmpty()) {
				entity = MobsCore.CHAIR_ENTITY.get().spawn(((ServerLevel) level), pos, MobSpawnType.TRIGGERED);
			} else {
				entity = entities.get(0);
			}

			player.startRiding(entity);
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}



	 public void fallOn(Level p_152169_, BlockState p_152170_, BlockPos p_152171_, Entity p_152172_, float p_152173_) {
	      super.fallOn(p_152169_, p_152170_, p_152171_, p_152172_, p_152173_ * 0.5F);
	   }

	   public void updateEntityAfterFallOn(BlockGetter p_49483_, Entity p_49484_) {
	      if (p_49484_.isSuppressingBounce()) {
	         super.updateEntityAfterFallOn(p_49483_, p_49484_);
	      } else {
	         this.bounceUp(p_49484_);
	      }

	   }

	   private void bounceUp(Entity p_49457_) {
	      Vec3 vec3 = p_49457_.getDeltaMovement();
	      if (vec3.y < 0.0D) {
	         double d0 = p_49457_ instanceof LivingEntity ? 1.0D : 0.8D;
	         p_49457_.setDeltaMovement(vec3.x, -vec3.y * (double)0.66F * d0, vec3.z);
	      }

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
		    public RenderShape getRenderShape(BlockState pState) {
		        return RenderShape.MODEL;
		    }

		   public static boolean isShapeFullBlock(VoxelShape p_49917_) {
			      return false;
			   }

	
	public ChairBlock AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}