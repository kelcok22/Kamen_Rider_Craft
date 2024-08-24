package com.kelco.kamenridercraft.item.ooo;


import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class CellMedalItem extends BaseItem {


	public CellMedalItem (Properties properties)
	{
		super(properties);
	}




	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int num, boolean flag) {
		if (entity instanceof Player playerIn) {
					int num1 = playerIn.getInventory().countItem(OOO_Rider_Items.CELL_MEDAL.get());
					int num2 = (num1/64)-1;
					if (num1>63) playerIn.addEffect(new MobEffectInstance(Effect_core.GREEED,300,num2));
			}
		}


	}