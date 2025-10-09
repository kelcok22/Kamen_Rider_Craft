package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class HokutoGuardianEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;

	public HokutoGuardianEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="hokuto_guardian";

	}


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
            double num = 100.0;
            if (this.getLastAttacker()instanceof Player playerIn){
                if(playerIn.hasEffect(Effect_core.HAZARD_LEVEL)){
                    num=100-((playerIn.getEffect(Effect_core.HAZARD_LEVEL).getAmplifier()+1)*10);
                }
            }
            if (this.random.nextDouble() * num  <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
				int bossChoice = this.random.nextInt(2);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.GREASE.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.grease"));
						}
						break;
					case 1:
						boss = MobsCore.SMASH.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.smash"));
						}
						break;
					default:
				}
				if (boss != null) {
					boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
					this.level().addFreshEntity(boss);
				}
			}
		}
		super.remove(p_149847_);
	}

	public static AttributeSupplier.Builder setAttributes() {

		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 35.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.23F)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, 3.0D)
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
	}
}