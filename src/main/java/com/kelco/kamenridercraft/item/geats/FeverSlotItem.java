package com.kelco.kamenridercraft.item.geats;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class FeverSlotItem extends BaseItem {

	public String RIDER;
    public static List<Item> FEVER_SLOT= new ArrayList<>();
    
    
	public FeverSlotItem (Properties properties)
	{
		super(properties);
	}

	
    private RiderFormChangeItem RandomForm() {
 		Random generator = new Random();
 			int rand = generator.nextInt(FEVER_SLOT.size());
 			return (RiderFormChangeItem) FEVER_SLOT.get(rand);
 		
 	}
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {

		ItemStack itemstack = player.getItemInHand(hand);

		String[] ClockUpUsers = Geats_Rider_Items.BaseDesireDriverUsers;


		if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof  DesireDriverItem){
            for (String clockUpUser : ClockUpUsers) {
                if (Objects.equals(clockUpUser, ((RiderDriverItem) player.getItemBySlot(EquipmentSlot.FEET).getItem()).Rider)) {
                    if (!world.isClientSide()) {
                        RandomForm().use(world, player, hand);
                        player.getCooldowns().addCooldown(this, 50);
                    }
                }
            }
		}

		return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
	}
}