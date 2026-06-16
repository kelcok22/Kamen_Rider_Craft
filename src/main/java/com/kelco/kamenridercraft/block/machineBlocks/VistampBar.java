package com.kelco.kamenridercraft.block.machineBlocks;


import com.kelco.kamenridercraft.item.reiwa.ReviceRiderItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class VistampBar extends MachineBlock {
	
	  public static List<Item> PROTO_VISTAMP= new ArrayList<>();
    public static VoxelShape SHAPE = Block.box(1, 0, 1, 14,15, 14);

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public VistampBar(Properties properties) {
        super(properties);
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

    private Item getgashatDrop(Player player) {
 		Random generator = new Random();

        List<Item> PROTO_VISTAMP_PLUS = new ArrayList<>(PROTO_VISTAMP);

         if (player.getInventory().countItem(ReviceRiderItems.BARID_REX_VISTAMP.get())!=0){
             for (int i = 0; i < 20; i++) {
                 PROTO_VISTAMP_PLUS.add(ReviceRiderItems.VOLCANO_VISTAMP.get());
             }
         }
 			int rand = generator.nextInt(PROTO_VISTAMP_PLUS.size());
 			return PROTO_VISTAMP_PLUS.get(rand);

 	}

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {
            if (player.getItemInHand(hand).getItem() == ReviceRiderItems.PROTO_VISTAMP.get()){
                process(player, level, pos, hand, getgashatDrop( player));
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == ReviceRiderItems.PROTO_QUEEN_BEE_VISTAMP.get()) {
                process(player, level, pos, hand,  ReviceRiderItems.QUEEN_BEE_VISTAMP.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == ReviceRiderItems.PROTO_PLANARIAN_VISTAMP.get()) {
                process(player, level, pos, hand,  ReviceRiderItems.PLANARIAN_VISTAMP.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == ReviceRiderItems.PROTO_CHAMELEON_VISTAMP.get()) {
                process(player, level, pos, hand,  ReviceRiderItems.CHAMELEON_VISTAMP.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == ReviceRiderItems.DAIOUIKA_VISTAMP.get()) {
                process(player, level, pos, hand,  ReviceRiderItems.KRAKEN_VISTAMP.get());
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }



	public VistampBar AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}