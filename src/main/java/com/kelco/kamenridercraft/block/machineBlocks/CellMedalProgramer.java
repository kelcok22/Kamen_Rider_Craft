package com.kelco.kamenridercraft.block.machineBlocks;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;


public class CellMedalProgramer extends MachineBlock {
	
    public static List<Item> CELL_MEDAL= new ArrayList<>();
    public static List<Item> SEISHIROGIN= new ArrayList<>();
		 
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public CellMedalProgramer(Properties properties) {
        super(properties);
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
     }

     public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
     }

    private Item getCellMedalDrop() {
 		Random generator = new Random();
 			int rand = generator.nextInt(CELL_MEDAL.size());
 			return CELL_MEDAL.get(rand);
 		}

     private Item getSeishiroginDrop() {
         Random generator = new Random();
             int rand = generator.nextInt(SEISHIROGIN.size());
             return SEISHIROGIN.get(rand);
         }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {
            if (player.getItemInHand(hand).getItem() == OOO_Rider_Items.CELL_MEDAL.get()) {
                process(player, level, pos, hand, getCellMedalDrop());
                return ItemInteractionResult.SUCCESS;
            } else if (player.getItemInHand(hand).getItem() == Items.PACKED_ICE) {
                process(player, level, pos, hand, getSeishiroginDrop());
                return ItemInteractionResult.SUCCESS;
            }

        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }



	public CellMedalProgramer AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}