package com.kelco.kamenridercraft.item.reiwa.geats;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


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

		String[] ClockUpUsers = GeatsRiderItems.BaseDesireDriverUsers;


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