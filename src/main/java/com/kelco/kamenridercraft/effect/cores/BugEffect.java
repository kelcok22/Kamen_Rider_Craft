package com.kelco.kamenridercraft.effect.cores;

import java.util.Random;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


public class BugEffect extends MobEffect {


	public BugEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		return true;
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {



			if (pLivingEntity instanceof Player player) {
				if (player.getItemBySlot(EquipmentSlot.FEET).getItem()==Zero_One_Rider_Items.ZAIA_THOUSANDRIVER.get()) {
					if (player.getInventory().countItem(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get()) > 0) {
						player.getInventory().removeItem(new ItemStack(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get()));
						player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get())), 1);
						player.removeEffect(Effect_core.BUGSTER);
						player.drop(new ItemStack(Zero_One_Rider_Items.PRESIDENT_DAN_KUROTO_PROGRISEKEY.get()), false);
					}
				}
			}


		BaseHenchmenEntity boss  =   MobsCore.BUGSTERVIRUS.get().create(pLivingEntity.level());
			if (pLivingEntity.hasEffect(Effect_core.HAZARD_LEVEL)){
				boss = MobsCore.NEBULA_BUGSTERVIRUS.get().create(pLivingEntity.level());
			}
		Random rand = new Random();
		switch  (pAmplifier<50? rand.nextInt(500-(pAmplifier*10)):0)
		{
		case 0:
			if (boss != null) {
				boss.moveTo(pLivingEntity.getX()+(rand.nextInt(8)-4), pLivingEntity.getY(), pLivingEntity.getZ()+(rand.nextInt(8)-4),0.0f, 0.0F);
				pLivingEntity.level().addFreshEntity(boss);
				break;
			}
		}
		return true;
	}

}