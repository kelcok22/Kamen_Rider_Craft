package com.kelco.kamenridercraft.entities.footSoldiers;

import net.minecraft.network.chat.Component;

import com.kelco.kamenridercraft.entities.MobsCore;

import net.minecraft.ChatFormatting;
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
			if (this.random.nextInt(10) == 1) {
				BaseHenchmenEntity boss = MobsCore.SHOCKER_RIDER.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);

					if (this.getLastAttacker()instanceof Player playerIn) playerIn.sendSystemMessage(Component.translatable("<Shocker Rider> Henshin!").withStyle(ChatFormatting.YELLOW));
				}
			}
		}
		super.remove(reason);
	}
}