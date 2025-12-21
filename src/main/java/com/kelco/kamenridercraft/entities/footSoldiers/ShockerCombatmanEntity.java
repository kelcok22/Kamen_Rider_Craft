package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.item.Ghost_Rider_Items;
import com.kelco.kamenridercraft.item.Miscellaneous_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;

import com.kelco.kamenridercraft.entities.MobsCore;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.time.LocalDate;

public class ShockerCombatmanEntity extends BaseHenchmenEntity {


	public ShockerCombatmanEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
        LocalDate localdate = LocalDate.now();
        int day = localdate.getDayOfMonth();
        if (localdate.getMonthValue() == 12 && day >= 22 && day <= 28 ) NAME="shocker_combatman_christmas";
        else NAME="shocker_combatman";

	}

	public void remove(RemovalReason reason) {
		if (reason == RemovalReason.KILLED) {
            LocalDate localdate = LocalDate.now();
            int day = localdate.getDayOfMonth();
            if (localdate.getMonthValue() == 12 && day >= 22 && day <= 28   && this.lastHurtByPlayer!=null){
                ItemEntity key = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(Miscellaneous_Rider_Items.GIFT.get(), 1), 0, 0, 0);
                key.setPickUpDelay(0);
                level().addFreshEntity(key);
            }


            if (this.getLastAttacker()instanceof Player playerIn){}
                if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
				BaseHenchmenEntity boss = MobsCore.SHOCKER_RIDER.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);

                    if (this.getLastAttacker()instanceof Player playerIn){
                      if ( this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.shocker_rider"));
				}
                }
			}
		}
		super.remove(reason);
	}
}