package com.kelco.kamenridercraft.effects;

import com.kelco.kamenridercraft.effects.effect_core.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.heisei_phase_2.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.reiwa.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.reiwa.Zero_One_Rider_Items;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.Random;


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
            int num1 = player.getInventory().countItem(Ex_Aid_Rider_Items.WONDERSWAN.get());

                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == Zero_One_Rider_Items.ZAIA_THOUSANDRIVER.get()) {
                    if (player.getInventory().countItem(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get()) > 0) {
                        if ( player.getInventory().getItem(40).getItem()== Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get()){
                            player.getInventory().removeItem(40, 1);
                        }else {
                            player.getInventory().removeItem(new ItemStack(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get()));
                            player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Zero_One_Rider_Items.HUMAGEAR_PROGRISEKEY.get())), 1);
                        }
                        player.removeEffect(EffectCore.BUGSTER);
                        player.drop(new ItemStack(Zero_One_Rider_Items.PRESIDENT_DAN_KUROTO_PROGRISEKEY.get()), false);
                    }
                }



            BaseHenchmenEntity boss = MobsCore.BUGSTERVIRUS.get().create(pLivingEntity.level());
            if (pLivingEntity.hasEffect(EffectCore.HAZARD_LEVEL)) {
                boss = MobsCore.NEBULA_BUGSTERVIRUS.get().create(pLivingEntity.level());
            }
            Random rand = new Random();
            if ((pAmplifier < 50 ? rand.nextInt(500 - (pAmplifier * 10)) : 0) == 0) {
                if (boss != null&num1==0) {
                    boss.moveTo(pLivingEntity.getX() + (rand.nextInt(8) - 4), pLivingEntity.getY(), pLivingEntity.getZ() + (rand.nextInt(8) - 4), 0.0f, 0.0F);
                    pLivingEntity.level().addFreshEntity(boss);
                }
            }
        }
		return true;
	}

}