package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;
import com.kelco.kamenridercraft.item.Geats_Rider_Items;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class EndRiderEntity extends BaseHenchmenEntity {

	private BaseHenchmenEntity boss;

	public EndRiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
	    this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Geats_Rider_Items.GEATS_HELMET.get()));
	    this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Geats_Rider_Items.GEATS_CHESTPLATE.get()));
	    this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Geats_Rider_Items.GEATS_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Geats_Rider_Items.DESIRE_DRIVER_THE_END_RIDER.get()));
    }


	public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= ServerConfig.bossSpawnRate) {
				int bossChoice = this.random.nextInt(3);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.PREMIUM_BEROBA.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.premium_beroba"));
						}
						break;
					case 1:
						boss = MobsCore.PREMIUM_KEKERA.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("henshin.kamenridercraft.premium_kekera"));
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
   
   @Nullable
   public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
      p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);
	  
	  switch (p_34297_.getRandom().nextInt(16)) {
		case 0:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.MAGNUM_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.MAGNUM_SHOOTER_40X.get()));
			break;
		case 1:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.BOOST_RAISE_BUCKLE.get(), 2);
			break;
		case 2:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.ZOMBIE_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.ZOMBIE_BREAKER.get()));
			break;
		case 3:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.NINJA_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.NINJA_DUELER_TWIN_BLADE_MODE.get()));
			this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Geats_Rider_Items.NINJA_DUELER_TWIN_BLADE_MODE2.get()));
			break;
		case 4:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.MONSTER_RAISE_BUCKLE.get(), 2);
			break;
		case 5:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.BEAT_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.BEAT_AXE.get()));
			break;
		case 6:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.ARROW_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.RAISE_ARROW.get()));
			break;
		case 7:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.WATER_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.RAISE_WATER.get()));
			break;
		case 8:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.HAMMER_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.RAISE_HAMMER.get()));
			break;
		case 9:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.SHIELD_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.RAISE_SHIELD.get()));
			break;
		case 10:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.CHAIN_ARRAY_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.RAISE_CHAIN_ARRAY.get()));
			break;
		case 11:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.CLAW_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.RAISE_CLAW.get()));
			break;
		case 12:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.DRILL_RAISE_BUCKLE.get(), 2);
			break;
		case 13:
			RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Geats_Rider_Items.PROPELLER_RAISE_BUCKLE.get(), 2);
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Geats_Rider_Items.RAISE_PROPELLER.get()));
			break;
	  }
      return p_34300_;
   }

}