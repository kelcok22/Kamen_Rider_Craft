package com.kelco.kamenridercraft.entities.footSoldiers;


import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import java.time.LocalDate;

import net.minecraft.world.level.Level;

public class ChapEntity extends BaseHenchmenEntity {
	
    public ChapEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="chaps";
    }

	public void remove(RemovalReason reason) {
		if (reason == RemovalReason.KILLED) {
			if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
				BaseHenchmenEntity boss = MobsCore.SHADOWMOON.get().create(this.level());
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);

                    if (this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
                        LocalDate localdate = LocalDate.now();
                        if (localdate.getMonthValue() == 4 && localdate.getDayOfMonth() == 1) playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.shadow_moon.a1"));
                        else playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.shadow_moon"));
                    }
				}
			}
		}
		super.remove(reason);
	}



	public static AttributeSupplier.Builder setAttributes() {

		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 35.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.23F)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, 3.0D)
				.add(Attributes.MAX_HEALTH, 30.0D);
	}
}