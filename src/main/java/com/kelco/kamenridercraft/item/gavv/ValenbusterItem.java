package com.kelco.kamenridercraft.item.gavv;

import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ValenbusterItem extends BaseBlasterItem {

	public ValenbusterItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}

	public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
		super.releaseUsing(stack, level, entityLiving, timeLeft);
		if (entityLiving instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY
		 && player.getItemBySlot(EquipmentSlot.HEAD).getItem() == Gavv_Rider_Items.GAVV_HELMET.get()
		 &&player.getItemBySlot(EquipmentSlot.CHEST).getItem() == Gavv_Rider_Items.GAVV_CHESTPLATE.get()
		&&player.getItemBySlot(EquipmentSlot.LEGS).getItem() == Gavv_Rider_Items.GAVV_LEGGINGS.get()) {
				player.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gavv_Rider_Items.VALENBUCKLE.get(), 1));
		}
	}
}