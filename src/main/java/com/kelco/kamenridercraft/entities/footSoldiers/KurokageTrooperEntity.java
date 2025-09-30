package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;

import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class KurokageTrooperEntity extends BaseHenchmenEntity {
	
	private BaseHenchmenEntity boss;

	public KurokageTrooperEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="kurokage_trooper";
	    this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gaim_Rider_Items.GAIM_HELMET.get()));
	    this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gaim_Rider_Items.GAIM_CHESTPLATE.get()));
	    this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gaim_Rider_Items.GAIM_LEGGINGS.get()));
	    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gaim_Rider_Items.SENGOKU_DRIVER_KUROKAGE_TOOPERS.get()));
	    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gaim_Rider_Items.KAGEMATSU.get()));
    }


    public void remove(Entity.RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
				int bossChoice = this.random.nextInt(4);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.ZANGETSU_SHIN.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.zangetsu_shin"));
						}
						break;
					case 1:
						boss = MobsCore.MARIKA.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.marika"));
						}
						break;
					case 2:
						boss = MobsCore.DUKE.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.duke"));
						}
						break;
					case 3:
						boss = MobsCore.SIGURD.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.sigurd"));
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
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
				.add(Attributes.ARMOR, 3.0D)
				.add(Attributes.MAX_HEALTH, 20.0D)
				.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
	}
}