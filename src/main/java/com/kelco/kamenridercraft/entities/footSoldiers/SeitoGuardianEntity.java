package com.kelco.kamenridercraft.entities.footSoldiers;

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

	public SeitoGuardianEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="seito_guardian";

	}


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			int bossChance = this.random.nextInt(20);
			switch (bossChance) {
				case 0:
					BaseHenchmenEntity boss = MobsCore.BUILD.get().create(this.level());
					if (boss != null) {
						boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss);

						for (int n = 0; n < 40; n++)
						{

							Random generator = new Random();

							 int posX = (this.blockPosition().getX()-10)+generator.nextInt(20);
							 int posY = this.blockPosition().getY()+generator.nextInt(6);
							 int posZ = (this.blockPosition().getZ()-10)+generator.nextInt(20);
							BlockPos pos1 = new BlockPos(posX,posY,posZ);
							if (this.level().isEmptyBlock(pos1))this.level().setBlockAndUpdate(pos1, Rider_Blocks.MIGHTY_BLOCK.get().defaultBlockState());
						
						}

						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Rabbit, Tank, Best Match!").withStyle(ChatFormatting.DARK_RED));
						}
					}
					break;
		/*		case 1:
					BaseHenchmenEntity boss2 = MobsCore.SMASH.get().create(this.level());
					if (boss2 != null) {
						boss2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss2);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("<Sento>It's a Smash, a transformed human!").withStyle(ChatFormatting.BLUE));
						}
					}
					break; */
				default:
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