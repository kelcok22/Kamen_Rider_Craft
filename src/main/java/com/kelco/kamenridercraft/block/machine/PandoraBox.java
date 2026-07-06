package com.kelco.kamenridercraft.block.machine;


import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
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


public class PandoraBox extends MachineBlock {

    public static List<Item> PANDORA_BOTTLE= new ArrayList<>();
    public static List<Item> PANDORA_PANEL_R= new ArrayList<>();
    public static List<Item> PANDORA_PANEL_G= new ArrayList<>();
    public static List<Item> PANDORA_PANEL_B= new ArrayList<>();
    public static List<Item> PANDORA_PANEL_W= new ArrayList<>();
    public static List<Item> PANDORA_PANEL_BL= new ArrayList<>();

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public PandoraBox(Properties properties) {
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
            if (player.getItemInHand(hand).getItem() == BuildRiderItems.FULL_BOTTLE.get()){
                process(player, level, pos, hand, BuildRiderItems.PANDORA_BOTTLE.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == BuildRiderItems.HAZARD_TRIGGER.get()){
                process(player, level, pos, hand, BuildRiderItems.LAST_PANDORA_PANEL_WHITE.get());
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public PandoraBox AddToTabList(List<Block> TabList) {
        TabList.add(this);
        return this;
    }

}