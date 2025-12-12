package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;

import com.kelco.kamenridercraft.entities.MobsCore;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ShockerCombatmanEntity extends BaseHenchmenEntity {


	public ShockerCombatmanEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="shocker_combatman";

	}

	public void remove(RemovalReason reason) {
		if (reason == RemovalReason.KILLED) {
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