package com.kelco.kamenridercraft.entities.footSoldiers;

import javax.annotation.Nullable;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class KurokageTrooperEntity extends BaseHenchmenEntity {

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
			int bossChance = this.random.nextInt(40);
			switch (bossChance) {
				case 0:
					BaseHenchmenEntity boss = MobsCore.ZANGETSU_SHIN.get().create(this.level());
					if (boss != null) {
						boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Soda! Melon Energy Arms!").withStyle(ChatFormatting.GREEN));
						}
					}
					break;
				case 1:
					BaseHenchmenEntity boss2 = MobsCore.MARIKA.get().create(this.level());
					if (boss2 != null) {
						boss2.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss2);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Soda! Peach Energy Arms!").withStyle(ChatFormatting.LIGHT_PURPLE));
						}
					}
					break;
				case 2:
					BaseHenchmenEntity boss3 = MobsCore.DUKE.get().create(this.level());
					if (boss3 != null) {
						boss3.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss3);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Soda! Lemon Energy Arms!").withStyle(ChatFormatting.YELLOW));
						}
					}
					break;
				case 3:
					BaseHenchmenEntity boss4 = MobsCore.SIGURD.get().create(this.level());
					if (boss4 != null) {
						boss4.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
						this.level().addFreshEntity(boss4);
						if (this.getLastAttacker()instanceof Player playerIn) {
							playerIn.sendSystemMessage(Component.translatable("Soda! Cherry Energy Arms!").withStyle(ChatFormatting.RED));
						}
					}
					break;
				default:
			}
		}
		super.remove(p_149847_);
	}




	public static AttributeSupplier.Builder setAttributes() {

		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 35.0D)
				.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
				.add(Attributes.ARMOR, 3.0D)
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
	}
}