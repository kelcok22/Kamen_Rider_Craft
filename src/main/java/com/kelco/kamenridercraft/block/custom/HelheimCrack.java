package com.kelco.kamenridercraft.block.custom;


import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.block.baseBlocks.BaseBlock;
import com.kelco.kamenridercraft.effect.Effect_core;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.HashSet;
import java.util.List;


public class HelheimCrack extends BaseBlock {



    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


	  public static VoxelShape SHAPE = Block.box(0, 0, 0, 16,32, 16);

	public HelheimCrack(Properties properties, VoxelShape shape ) {
		
		super(properties);
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


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
     }

     public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
     }

     public PushReaction getPistonPushReaction(BlockState p_53683_) {
        return PushReaction.DESTROY;
     }




	public static void teleportToDimension(ServerLevel otherDim, LivingEntity entity, BlockPos pos) {

		if (otherDim.getBlockState(pos)!= Rider_Blocks.HELHEIM_CRACK.get().defaultBlockState()){
			otherDim.setBlockAndUpdate(pos,Rider_Blocks.HELHEIM_CRACK.get().defaultBlockState());
		}

		entity.teleportTo(otherDim, entity.getX(), Mth.clamp(entity.getY(), (double)otherDim.getMinBuildHeight(), (double)(otherDim.getMinBuildHeight() + ((ServerLevel)otherDim).getLogicalHeight() - 1)), entity.getZ(), new HashSet<>(), 0, 0);
		while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) entity.teleportRelative(0.0, 2.0, 0.0);

		entity.addEffect(new MobEffectInstance(Effect_core.PORTAL_COOLDOWN, 200, 0, true, true));
		entity.randomTeleport(entity.getX(), entity.getY(), entity.getZ(), false);
	}

	@Override
	protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
		if (entity.canUsePortal(false) && entity instanceof Player player && !player.hasEffect(Effect_core.PORTAL_COOLDOWN)){
			ResourceKey<Level> HELHEIM = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:helheim"));
			MinecraftServer Server = player.getServer();

			if (!level.isClientSide()) {
				List<TamableAnimal> nearbyAllies = level.getEntitiesOfClass(TamableAnimal.class, entity.getBoundingBox().inflate(30), entity2 ->
						(entity2.getOwner() == player && !entity2.isOrderedToSit()));
				if (level.dimension() == HELHEIM) {
					for (LivingEntity ally : nearbyAllies) teleportToDimension(Server.overworld(), ally,pos);
					teleportToDimension(Server.overworld(), player,pos);
				} else {
					for (LivingEntity ally : nearbyAllies) teleportToDimension(Server.getLevel(HELHEIM), ally,pos);
					teleportToDimension(Server.getLevel(HELHEIM), player,pos);
				}
			}
		}
	}



	public HelheimCrack AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}