package com.kelco.kamenridercraft.item.BaseItems;

import com.kelco.kamenridercraft.entities.projectile.ShurikenProjectileEntity;
import com.kelco.kamenridercraft.entities.projectile.WeaponProjectileEntity;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class BaseThrowableItem extends SwordItem {

	private Item RepairItem = Modded_item_core.RIDER_CIRCUIT.get();
	private Item Changer = null;
	private boolean Shuriken = false;

	public BaseThrowableItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));

	}

	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
		pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
				SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

		if (!pLevel.isClientSide) {
			if (Changer != null && pPlayer.getItemBySlot(EquipmentSlot.FEET)==ItemStack.EMPTY) {
				pPlayer.setItemSlot(EquipmentSlot.FEET, new ItemStack(Changer));
				if (pPlayer.getItemBySlot(EquipmentSlot.OFFHAND).getItem() instanceof RiderFormChangeItem formItem) formItem.use(pLevel, pPlayer, InteractionHand.OFF_HAND);
			}
			else if (Shuriken)
			{
				ShurikenProjectileEntity shuriken = new ShurikenProjectileEntity(pLevel, pPlayer);
				shuriken.setItem(itemstack);
				shuriken.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
				pLevel.addFreshEntity(shuriken);
			}
			else
			{
				WeaponProjectileEntity weapon = new WeaponProjectileEntity(pLevel, pPlayer);
				weapon.setItem(itemstack);
				weapon.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
				pLevel.addFreshEntity(weapon);
			}
		}

		pPlayer.awardStat(Stats.ITEM_USED.get(this));
		if (!pPlayer.getAbilities().instabuild) {
			itemstack.shrink(1);
		}

		return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
	}

	public BaseThrowableItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseThrowableItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public BaseThrowableItem IsShuriken() {
		Shuriken=true;
		return this;
	}

	public BaseThrowableItem isChanger(Item item) {
		Changer=item;
		return this;
	}
}
