package com.kelco.kamenridercraft.block.machineBlocks;


import com.kelco.kamenridercraft.item.Build_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;


public class FullbottleSolidifier extends MachineBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public FullbottleSolidifier(Properties properties) {
        super(properties);
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
     }

     public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
     }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {
           if (player.getItemInHand(hand).getItem() == Build_Rider_Items.FULL_BOTTLE.get()){
                process(player, level, pos, hand, Build_Rider_Items.SCLASH_JELLY.get());
                return ItemInteractionResult.SUCCESS;
            }
           else  if (player.getItemInHand(hand).getItem() == Build_Rider_Items.ROBOT_FULL_BOTTLE.get()){
                process(player, level, pos, hand, Build_Rider_Items.ROBOT_SCLASH_JELLY.get());
                return ItemInteractionResult.SUCCESS;
            }
			else if (player.getItemInHand(hand).getItem() == Build_Rider_Items.DRAGON_FULL_BOTTLE.get()){
                process(player, level, pos, hand, Build_Rider_Items.DRAGON_SCLASH_JELLY.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == Build_Rider_Items.LOST_BAT_FULL_BOTTLE.get()){
                process(player, level, pos, hand, Build_Rider_Items.CROCODILE_CRACK_FULL_BOTTLE.get());
                return ItemInteractionResult.SUCCESS;
            }



        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }



	public FullbottleSolidifier AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}