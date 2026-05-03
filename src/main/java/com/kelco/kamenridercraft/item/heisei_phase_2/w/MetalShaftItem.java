package com.kelco.kamenridercraft.item.heisei_phase_2.w;


import com.kelco.kamenridercraft.item.base_items.BaseSwordItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.W_Rider_Items;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import java.util.List;

public class MetalShaftItem extends BaseSwordItem {

	public MetalShaftItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);

	}


	   public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		  	ItemStack belt = attacker.getItemBySlot(EquipmentSlot.FEET);
			if (belt.getItem() instanceof RiderDriverItem) {
				if (belt.getItem() == W_Rider_Items.WDRIVER.get()) {
					if (RiderDriverItem.get_Form_Item(belt, 1)==W_Rider_Items.HEAT_MEMORY.get()) {
						target.setSharedFlagOnFire(true);
						target.setRemainingFireTicks(200);
					} else if (RiderDriverItem.get_Form_Item(belt, 1)==W_Rider_Items.CYCLONE_MEMORY.get()) {
						target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 80, 0,true,false));
						}
				}
			}return true;
		   }
	
	public MetalShaftItem AddToList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

}