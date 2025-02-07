package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.entities.MobsCore;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;

public class SeitoGuardianEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;

	public SeitoGuardianEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="seito_guardian";

	}


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
				int bossChoice = this.random.nextInt(2);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.BUILD.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.build"));
						}
						break;
					case 1:
						boss = MobsCore.SMASH.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
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
				.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, 3.0D)
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
	}
}