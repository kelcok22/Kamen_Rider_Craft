package com.kelco.kamenridercraft.block.machineBlocks;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;

import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;


public class VistampBar extends MachineBlock {
	
	  public static List<Item> PROTO_VISTAMP= new ArrayList<Item>();
		 
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public VistampBar(Properties properties) {
        super(properties);
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

     private Item getVistampDrop(int num) {
 		Random generator = new Random();
 		//if (num==0){
 			int rand = generator.nextInt(PROTO_VISTAMP.size());
 			return PROTO_VISTAMP.get(rand);
 		//}
 	}

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {
            if (player.getItemInHand(hand).getItem() == Revice_Rider_Items.PROTO_VISTAMP.get()){
                process(player, level, pos, hand, getVistampDrop(0));
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