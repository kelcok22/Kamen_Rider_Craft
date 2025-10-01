package com.kelco.kamenridercraft.item.kabuto;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Objects;


public class ClockUpPadItem extends BaseItem {

	public ClockUpPadItem (Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		String[] ClockUpUsers = new String[] {"kabuto","thebee","drake","sasword","gatack","dark_kabuto","kickhopper","punchhopper","ketaros","hercus","caucasus","lady"};
		
		if (p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt && belt.isTransformed(p_41129_)){
			if (!Objects.equals(RiderDriverItem.get_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET), 1).getFormName(false), "_masked")){
                if (ArrayUtils.contains(ClockUpUsers, belt.Rider) && !p_41128_.isClientSide()) {
                	p_41129_.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 250, 20,true,false));
                	p_41129_.getCooldowns().addCooldown(this, 500);
					p_41129_.awardStat(Stats.ITEM_USED.get(this));
                }
			}
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}