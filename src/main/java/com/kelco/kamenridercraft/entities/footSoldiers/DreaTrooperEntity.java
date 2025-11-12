package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Gotchard_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.level.ModGameRules;
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

public class DreaTrooperEntity extends BaseHenchmenEntity {

	private BaseHenchmenEntity boss;

	public DreaTrooperEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="dreatrooper";
	    this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gotchard_Rider_Items.GOTCHARD_HELMET.get()));
	    this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gotchard_Rider_Items.GOTCHARD_CHESTPLATE.get()));
	    this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gotchard_Rider_Items.GOTCHARD_LEGGINGS.get()));
	    this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gotchard_Rider_Items.DREADRIVER_TROOPER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gotchard_Rider_Items.TROOP_AUTHIFY.get()));
    }

    public void remove(RemovalReason p_149847_) {

		if ( this.isDeadOrDying()) {
			if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
				int bossChoice = this.random.nextInt(1);
				switch (bossChoice) {
					case 0:
						boss = MobsCore.DREATROOPER_COMMANDER.get().create(this.level());
						if (boss != null && this.getLastAttacker()instanceof Player playerIn && this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUCEMENTS)) {
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
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
	}

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_);

        if (p_34297_.getRandom().nextInt(2) == 1) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gotchard_Rider_Items.TROOP_GOLDENT.get()));
        }
        return p_34300_;
    }
}