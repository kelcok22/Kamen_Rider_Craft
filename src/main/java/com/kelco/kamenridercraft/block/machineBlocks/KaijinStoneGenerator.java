package com.kelco.kamenridercraft.block.machineBlocks;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Reboot_Rider_Items;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;


public class KaijinStoneGenerator extends MachineBlock {
	
	  public static List<Item> KING_STONE= new ArrayList<Item>();
		 
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public KaijinStoneGenerator(Properties properties) {
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

     private Item getvialDrop(int num) {
 		Random generator = new Random();
 			int rand = generator.nextInt(KING_STONE.size());
 			return KING_STONE.get(rand);
 		}

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {
            if (player.getItemInHand(hand).getItem() == Reboot_Rider_Items.CREATION_KING_EXTRACT_VIAL.get()) {
                process(player, level, pos, hand,  getvialDrop(0));
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    
    public void process(Player player, Level world, BlockPos pos, InteractionHand hand, Item... items) {
        // world.playSound((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_NOTE_BELL, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
        for(Item item : items) player.drop(new ItemStack(item), true);
    	player.drop(new ItemStack (Reboot_Rider_Items.EMPTY_VIAL.get()), true);
    	player.getItemInHand(hand).shrink(1);}


	public KaijinStoneGenerator AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}