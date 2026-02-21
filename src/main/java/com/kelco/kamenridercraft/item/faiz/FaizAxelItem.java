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

	public void startCooldown(Player player) {
		if (!player.isCreative()) player.getCooldowns().addCooldown(this, 1600);
		player.awardStat(Stats.ITEM_USED.get(this));
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack itemstack = player.getItemInHand(usedHand);

		if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == Faiz_Rider_Items.FAIZ_DRIVER.get()) {
				Faiz_Rider_Items.FAIZ_AXEL_FORM.asItem().use(level,player,usedHand);
				startCooldown(player);
			} else if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == Faiz_Rider_Items.FAIZ_DRIVER_NEXT.get()) {
				Faiz_Rider_Items.NEXT_FAIZ_AXEL_MISSION_MEMORY.asItem().use(level,player,usedHand);
				startCooldown(player);
			} else if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == Faiz_Rider_Items.NEXT_KAIXA_DRIVER.get()) {
				Faiz_Rider_Items.NEXT_KAIXA_AXEL_MISSION_MEMORY.asItem().use(level,player,usedHand);
				startCooldown(player);
			} else if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == Faiz_Rider_Items.DELTA_DRIVER.get() && belt.isTransformed(player)){
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 5,true,false));
				startCooldown(player);
			}
		}
		
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}