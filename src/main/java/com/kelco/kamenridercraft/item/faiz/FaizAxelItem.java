package com.kelco.kamenridercraft.item.faiz;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Faiz_Rider_Items;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class FaizAxelItem extends BaseItem {

	public FaizAxelItem(Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

		ItemStack itemstack = player.getItemInHand(usedHand);

		if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt && belt.isTransformed(player)){
            if(player.getItemBySlot(EquipmentSlot.FEET).getItem() == Faiz_Rider_Items.DELTA_DRIVER.get()){
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 5,true,false));
				if (!player.isCreative()) {
					player.getCooldowns().addCooldown(this, 1600);
				}
				player.awardStat(Stats.ITEM_USED.get(this));
			}
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}