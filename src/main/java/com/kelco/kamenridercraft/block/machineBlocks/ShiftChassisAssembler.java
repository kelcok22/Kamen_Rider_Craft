package com.kelco.kamenridercraft.block.machineBlocks;


import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ShiftChassisAssembler extends MachineBlock {

	  public static List<Item> DRIVE_CAR= new ArrayList<>();
	  public static List<Item> NEXT_BIKE= new ArrayList<>();
	  public static List<Item> NEXT_CAR = new ArrayList<>();

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ShiftChassisAssembler(Properties properties) {
        super(properties);
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
     }

     public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
     }

    private Item getCarDrop(int num) {
 		Random generator = new Random();
 		if (num==1){
 			int rand = generator.nextInt(DRIVE_CAR.size());
 			return DRIVE_CAR.get(rand);
 		} else if (num==2){
 			int rand = generator.nextInt(NEXT_BIKE.size());
 			return NEXT_BIKE.get(rand);
 		} else {
 			int rand = generator.nextInt(NEXT_CAR.size());
 			return NEXT_CAR.get(rand);
 		}
 	}

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {

                if (player.getItemInHand(hand).getItem() == Drive_Rider_Items.DRIVE_SYSTEM_CAR.get()){
                    process(player, level, pos, hand, getCarDrop(1));
                    return ItemInteractionResult.SUCCESS;
                }
                if (player.getItemInHand(hand).getItem() == Drive_Rider_Items.NEXT_SYSTEM_BIKE.get()) {
                    process(player, level, pos, hand, getCarDrop(2));
                    return ItemInteractionResult.SUCCESS;
                }
			    else if (player.getItemInHand(hand).getItem() ==  Drive_Rider_Items.NEXT_SYSTEM_CAR.get()){
                    process(player, level, pos, hand, getCarDrop(0));
                    return ItemInteractionResult.SUCCESS;
                }

        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }



	public ShiftChassisAssembler AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}