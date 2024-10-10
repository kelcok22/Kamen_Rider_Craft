package com.kelco.kamenridercraft.block.machineBlocks;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Reboot_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
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


public class GameCreator extends MachineBlock {
	
	  public static List<Item> BLANK_GASHAT= new ArrayList<Item>();
	  public static List<Item> BLANK_DOUBLE_GASHAT= new ArrayList<Item>();
	  public static List<Item> BLANK_MAXIMUM_GASHAT= new ArrayList<Item>();
	  public static List<Item> BLANK_HYPER_GASHAT= new ArrayList<Item>();
		 
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public GameCreator(Properties properties) {
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

     private Item getgashatDrop(int num, Player player) {
 		Random generator = new Random();

		 List<Item> BLANK_GASHAT_PLUS= new ArrayList<Item>();
		 BLANK_GASHAT_PLUS.clear();
		 BLANK_GASHAT_PLUS.addAll (BLANK_GASHAT);

		 if (player.getInventory().countItem(Zero_One_Rider_Items.PRESIDENT_DAN_KUROTO_PROGRISEKEY.get())!=0){
			 for (int i = 0; i < 2; i++) {
				 BLANK_GASHAT_PLUS.add(Ex_Aid_Rider_Items.PROTO_MIGHTY_ACTION_X_GASHAT_ORIGIN_REMAKE.get());
				 BLANK_GASHAT_PLUS.add(Ex_Aid_Rider_Items.TOKI_MEKTI_BRIDAL_GASHAT.get());
			 }
			 	 }

 		if (num==1){
 			int rand = generator.nextInt(BLANK_GASHAT_PLUS.size());
 			return BLANK_GASHAT_PLUS.get(rand);
 		} else if (num==2){
 			int rand = generator.nextInt(BLANK_DOUBLE_GASHAT.size());
 			return BLANK_DOUBLE_GASHAT.get(rand);
 		} else if (num==3){
 			int rand = generator.nextInt(BLANK_HYPER_GASHAT.size());
 			return BLANK_HYPER_GASHAT.get(rand);
 		}  else{
 			int rand = generator.nextInt(BLANK_MAXIMUM_GASHAT.size());
 			return BLANK_MAXIMUM_GASHAT.get(rand);
 		}
 	}


	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

		if (!level.isClientSide()) {
            if (player.getItemInHand(hand).getItem() == Ex_Aid_Rider_Items.UNFINISHED_MAXIMUM_MIGHTY_X_GASHAT.get()) {
				process(player, level, pos, hand, getgashatDrop(0, player));
				return ItemInteractionResult.SUCCESS;
			}
			else if (player.getItemInHand(hand).getItem() == Ex_Aid_Rider_Items.BLANK_GASHAT.get()) {
				process(player, level, pos, hand, getgashatDrop(1, player));
				return ItemInteractionResult.SUCCESS;
			}
			else if (player.getItemInHand(hand).getItem() == Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_UNFINISHED_GASHAT.get()){
				process(player, level, pos, hand, getgashatDrop(2, player));
				return ItemInteractionResult.SUCCESS;
			}
			else if (player.getItemInHand(hand).getItem() == Ex_Aid_Rider_Items.UNFINISHED_HYPER_MUTEKI_GASHAT.get()){
				process(player, level, pos, hand, getgashatDrop(3, player));
				return ItemInteractionResult.SUCCESS;
			}
			else if (player.getItemInHand(hand).getItem() == Zero_One_Rider_Items.PRESIDENT_DAN_KUROTO_PROGRISEKEY.get()) {
				process(player, level, pos, hand, Ex_Aid_Rider_Items.GENM_MUSOU_GASHAT.get());
				return ItemInteractionResult.SUCCESS;
			}

        }
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }



	public GameCreator AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}