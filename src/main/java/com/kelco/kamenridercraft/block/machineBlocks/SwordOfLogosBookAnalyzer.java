package com.kelco.kamenridercraft.block.machineBlocks;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
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
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;


public class SwordOfLogosBookAnalyzer extends MachineBlock {
	
	  public static List<Item> BLANK_BOOK= new ArrayList<Item>();
	  public static List<Item> WONDER_WORLD_BOOK= new ArrayList<Item>();
		 
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public SwordOfLogosBookAnalyzer(Properties properties) {
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

     private Item getBookDrop(int num) {
 		Random generator = new Random();
 		if (num==1){
 			int rand = generator.nextInt(BLANK_BOOK.size());
 			return BLANK_BOOK.get(rand);
        } else {
 			int rand = generator.nextInt(WONDER_WORLD_BOOK.size());
 			return WONDER_WORLD_BOOK.get(rand);
        }
 	}


    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {
            if (player.getItemInHand(hand).getItem() == Saber_Rider_Items.BLANK_WONDER_WORLD_STORY_WONDER_RIDE_BOOK.get()) {
                process(player, level, pos, hand, getBookDrop(0));
                return ItemInteractionResult.SUCCESS;
            }
            if (player.getItemInHand(hand).getItem() == Saber_Rider_Items.BLANK_WONDER_RIDE_BOOK.get()) {
                process(player, level, pos, hand, getBookDrop(1));
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }


	public SwordOfLogosBookAnalyzer AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}