package com.kelco.kamenridercraft.item.heisei_phase_2.ooo;

import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.summons.RiderSummonEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOO_Rider_Items;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;


public class ShowaMedalItem extends BaseItem {

    private RiderDriverItem summonBelt;
    private Item summonWeapon;

	public ShowaMedalItem (Properties properties, RiderDriverItem belt, @Nullable Item weapon)
	{
		super(properties);
        summonBelt = belt;
        summonWeapon = weapon;
    }

	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
		
		if (!p_41128_.isClientSide() && p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt
        && belt.isTransformed(p_41129_) && p_41129_.getItemBySlot(EquipmentSlot.FEET).getItem() == OOO_Rider_Items.OOODRIVER.get()
        && p_41129_.getInventory().countItem(OOO_Rider_Items.O_SCANNER.get()) != 0) {
            RiderSummonEntity summon = MobsCore.RIDER_SUMMON.get().create(p_41128_);
            if (summon != null) {
                summon.moveTo(p_41129_.getX(), p_41129_.getY()+1, p_41129_.getZ(), p_41129_.getYRot(), p_41129_.getXRot());
                summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(summonBelt.HEAD));
                summon.setItemSlot(EquipmentSlot.CHEST, new ItemStack(summonBelt.TORSO));
                summon.setItemSlot(EquipmentSlot.LEGS, new ItemStack(summonBelt.LEGS));
                summon.setItemSlot(EquipmentSlot.FEET, new ItemStack(summonBelt));
                if (summonWeapon != null) summon.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(summonWeapon, 1));

                p_41128_.addFreshEntity(summon);
                summon.bindToPlayer(p_41129_);
                if (!p_41129_.isCreative()) {
					itemstack.shrink(1);
                    p_41129_.getCooldowns().addCooldown(this, 500);
                }
                p_41129_.awardStat(Stats.ITEM_USED.get(this));
            }
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}