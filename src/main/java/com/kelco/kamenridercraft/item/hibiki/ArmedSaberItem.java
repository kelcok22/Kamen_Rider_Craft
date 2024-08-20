package com.kelco.kamenridercraft.item.hibiki;


import com.kelco.kamenridercraft.item.BaseItems.BaseSwordItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Hibiki_Rider_Items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
public class ArmedSaberItem extends BaseSwordItem {
	
	public ArmedSaberItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ItemStack BELT = p_41129_.getItemBySlot(EquipmentSlot.FEET);

		if (BELT.getItem() instanceof RiderDriverItem belt) {
			
			if (belt== Hibiki_Rider_Items.HIBIKIDRIVER.get())
			{
				if (this==Hibiki_Rider_Items.ARMED_SABER.get()) ((RiderFormChangeItem)Hibiki_Rider_Items.HENSHIN_ONSA_ARMED.get()).use(p_41128_, p_41129_, p_41130_);
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}