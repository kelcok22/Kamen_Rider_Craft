package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class GingaEntity extends BaseHenchmenEntity {

	private final ServerBossEvent bossEvent = new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.GOLD), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS);

	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(GingaEntity.class, EntityDataSerializers.BYTE);


    public GingaEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="ginga";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zi_O_Rider_Items.ZI_O_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zi_O_Rider_Items.ZI_O_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zi_O_Rider_Items.ZI_O_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zi_O_Rider_Items.GINGADRIVER.get()));
		this.setPersistenceRequired();

    }


	protected void customServerAiStep() {
		super.customServerAiStep();

			if (!this.level().isDay()) {
				this.bossEvent.setColor(BossEvent.BossBarColor.PURPLE);
				this.addEffect(new MobEffectInstance(Effect_core.GRAVITY, 70, 3, true, true));
				this.addEffect(new MobEffectInstance(Effect_core.ANTIPOISON, 70, 3, true, true));
				this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 70, 100, true, true));
				this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 100, true, true));
				this.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 70, 100, true, true));
				this.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 70, 100, true, true));

				}else {

				this.bossEvent.setColor(BossEvent.BossBarColor.GREEN);
			}

		this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public boolean canAttack(LivingEntity target) {
		return target.level().isDay() && super.canAttack(target);
	}

	public void readAdditionalSaveData(CompoundTag p_31474_) {
		super.readAdditionalSaveData(p_31474_);
		if (this.hasCustomName()) {
			this.bossEvent.setName(this.getDisplayName());
		}
	}

	public void setCustomName(@Nullable Component p_31476_) {
		super.setCustomName(p_31476_);
		this.bossEvent.setName(this.getDisplayName());
	}

	public void startSeenByPlayer(ServerPlayer p_31483_) {
		super.startSeenByPlayer(p_31483_);
		this.bossEvent.addPlayer(p_31483_);
	}

	public void stopSeenByPlayer(ServerPlayer p_31488_) {
		super.stopSeenByPlayer(p_31488_);
		this.bossEvent.removePlayer(p_31488_);
	}



	protected void addBehaviourGoals() {

		this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.0F));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
	}



	public static AttributeSupplier.Builder setAttributes() {

		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 135.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.3F)
				.add(Attributes.ATTACK_DAMAGE, 10.0D)
				.add(Attributes.ARMOR, 0.0D)
				.add(Attributes.MAX_HEALTH, 100.0D);

	}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_FLAGS_ID, (byte)0);
	}

	void setCharged(boolean p_32241_) {
		byte b0 = this.entityData.get(DATA_FLAGS_ID);
		if (p_32241_) {
			b0 = (byte)(b0 | 1);
		} else {
			b0 = (byte)(b0 & -2);
		}

		this.entityData.set(DATA_FLAGS_ID, b0);
	}
}
