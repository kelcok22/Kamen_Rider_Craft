package com.kelco.kamenridercraft.block.machineBlocks;


import com.kelco.kamenridercraft.item.Reboot_Rider_Items;
import com.kelco.kamenridercraft.item.W_Rider_Items;
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
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PandoraBox extends MachineBlock {

    public static List<Item> PAANDORA_BOTTLE= new ArrayList<Item>();
    public static List<Item> PANDORA_PANEL_R= new ArrayList<Item>();
    public static List<Item> PANDORA_PANEL_G= new ArrayList<Item>();
    public static List<Item> PANDORA_PANEL_B= new ArrayList<Item>();
    public static List<Item> PANDORA_PANEL_W= new ArrayList<Item>();
    public static List<Item> PANDORA_PANEL_BL= new ArrayList<Item>();

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

    public PushReaction getPistonPushReaction(BlockState p_53683_) {
        return PushReaction.PUSH_ONLY;
    }



    public PandoraBox AddToTabList(List<Block> TabList) {
        TabList.add(this);
        return this;
    }

}