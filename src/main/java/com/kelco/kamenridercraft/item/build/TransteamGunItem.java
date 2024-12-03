package com.kelco.kamenridercraft.item.build;
import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Build_Rider_Items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class TransteamGunItem extends BaseBlasterItem {
	
	public TransteamGunItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}

	public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        super.releaseUsing(stack, level, entityLiving, timeLeft);
		if (entityLiving instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
			if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() == Build_Rider_Items.LOST_BAT_FULL_BOTTLE.get())
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(Build_Rider_Items.TRANSTEAM_GUN_NIGHT_ROGUE.get(), 1));
			else if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() == Build_Rider_Items.LOST_COBRA_FULL_BOTTLE.get())
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(Build_Rider_Items.TRANSTEAM_GUN_BLOOD_STALK.get(), 1));
		}
	}
}