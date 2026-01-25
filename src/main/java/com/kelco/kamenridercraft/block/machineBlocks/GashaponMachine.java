package com.kelco.kamenridercraft.block.machineBlocks;


import com.kelco.kamenridercraft.item.Miscellaneous_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GashaponMachine extends MachineBlock {

	  public static List<Item> CAPSEM= new ArrayList<>();
    public static VoxelShape SHAPE = Block.box(1, 0, 1, 15,16, 15);

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public GashaponMachine(Properties properties) {
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


    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {
            LocalDate localdate = LocalDate.now();
            int day = localdate.getDayOfMonth();
          if (player.getItemInHand(hand).getItem() == Items.EMERALD){
              if (localdate.getMonthValue() == 10 && day >= 24) {
                  process(player, level, pos, hand, Miscellaneous_Rider_Items.HALLOWEEN_GASHAPON_CAPSULE.asItem());
              }else if (localdate.getMonthValue() == 2 && day >= 13&& day <= 18) {
                  process(player, level, pos, hand, Miscellaneous_Rider_Items.VALENTINE_GASHAPON_CAPSULE.asItem());
              }else {
                  process(player, level, pos, hand, Miscellaneous_Rider_Items.GASHAPON_CAPSULE.asItem());
              }
              return ItemInteractionResult.SUCCESS;
          }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }


	public GashaponMachine AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}