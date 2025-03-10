package com.kelco.kamenridercraft.entities.footSoldiers;

import java.util.Random;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.block.Rider_Blocks;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BugsterVirusEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;

	public BugsterVirusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="bugstervirus";

		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ex_Aid_Rider_Items.BUGSTER_TRIDENT.get()));
	}


	public void remove(Entity.RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
				int bossChoice = this.random.nextInt(2);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.GENM.get().create(this.level());
						if (boss != null) {
							for (int n = 0; n < 40; n++) {
								Random generator = new Random();

								 int posX = (this.blockPosition().getX()-10)+generator.nextInt(20);
								 int posY = this.blockPosition().getY()+generator.nextInt(6);
								 int posZ = (this.blockPosition().getZ()-10)+generator.nextInt(20);
								BlockPos pos1 = new BlockPos(posX,posY,posZ);
								if (this.level().isEmptyBlock(pos1))this.level().setBlockAndUpdate(pos1, Rider_Blocks.MIGHTY_BLOCK.get().defaultBlockState());
							}

							if (this.getLastAttacker()instanceof Player playerIn) {
								playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.genm"));
							}
						}
						break;
					case 1:
						boss = MobsCore.GRAPHITE_BUGSTER.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.graphite"));
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