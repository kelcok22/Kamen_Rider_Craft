package com.kelco.kamenridercraft.item.ichigo;

import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Ichigo_Rider_Items;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;


public class V3HopperItem extends BaseItem {

	public V3HopperItem(Properties properties)
	{
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
		
		if (!p_41128_.isClientSide() && p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem() == Ichigo_Rider_Items.DOUBLE_TYPHOON.get()
                && ((RiderDriverItem) p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem()).isTransformed(p_41129_)) {
            List<LivingEntity> nearbyAllies = p_41128_.getEntitiesOfClass(LivingEntity.class, p_41129_.getBoundingBox().inflate(15), entity ->
                    (entity instanceof Player && entity != p_41129_)
                            || (entity instanceof Mob mob));
            for (LivingEntity ally : nearbyAllies) {
                ally.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0,false,true));
            }
            p_41129_.getCooldowns().addCooldown(this, 400);
			p_41129_.awardStat(Stats.ITEM_USED.get(this));
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}