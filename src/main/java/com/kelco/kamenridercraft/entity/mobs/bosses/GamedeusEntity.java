package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ExAidRiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import com.kelco.kamenridercraft.particle.ModParticles;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class GamedeusEntity extends BaseHenchmenEntity {

	private final ServerBossEvent bossEvent = new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS);
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(GamedeusEntity.class, EntityDataSerializers.BYTE);

	public GamedeusEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
		super(type, level);
		NAME="gamedeus";
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ExAidRiderItems.EX_AIDHELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ExAidRiderItems.EX_AIDCHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ExAidRiderItems.EX_AIDLEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET,new ItemStack(ExAidRiderItems.GASHACON_BUGVISOR_BUGSTER.get()));
		RiderDriverItem.setFormItem(getItemBySlot(EquipmentSlot.FEET), ExAidRiderItems.KAMEN_RIDER_CHRONICLE_GASHAT_BUGSTER_GEMEDEUS.get(), 1);
        RiderDriverItem.setUpdateForm(this.getItemBySlot(EquipmentSlot.FEET));
		this.setItemSlot(EquipmentSlot.MAINHAND,new ItemStack(ExAidRiderItems.DEUS_RUSHER.get()));
		this.setItemSlot(EquipmentSlot.OFFHAND,new ItemStack(ExAidRiderItems.DEUS_RAMPART.get()));
	}


	@Override
	public void actuallyHurt(DamageSource source, float amount) {
		super.actuallyHurt(source, amount);
		if (!this.level().isClientSide() && source.getEntity() instanceof Player player) {
			if ((this.getHealth() < 150) && player.getInventory().countItem(ExAidRiderItems.DOCTOR_MIGHTY_XX_GASHAT.get().asItem()) == 0) {
				if (getItemBySlot(EquipmentSlot.FEET).getItem() == ExAidRiderItems.GASHACON_BUGVISOR_BUGSTER.get()) {
					ItemStack belt = getItemBySlot(EquipmentSlot.FEET);

					if (RiderDriverItem.getFormItem(belt, 1) != ExAidRiderItems.KAMEN_RIDER_CHRONICLE_GASHAT_BUGSTER_MACHINA.get()) {
						RiderDriverItem.setFormItem(belt, ExAidRiderItems.KAMEN_RIDER_CHRONICLE_GASHAT_BUGSTER_MACHINA.get(), 1);
						this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ExAidRiderItems.DEUS_RUSHER_RED.get()));
						this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ExAidRiderItems.MACHINA_RAMPART.get()));
					}


				}
			}
			if (this.getHealth() < 250 && player.getInventory().countItem(ExAidRiderItems.DOCTOR_MIGHTY_XX_GASHAT.get().asItem()) != 0 && this.getHealth() > 151) {
				if (this.level().getGameRules().getBoolean(ModGameRules.RULE_BOSS_HENSHIN_ANNOUNCEMENTS))
					player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.gamedeus_doctor_mighty_xx"));
				this.setHealth(150);
				this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(7.0D);
				this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(150.0D);
				((ServerLevel) player.level()).sendParticles(ModParticles.CYAN_SPARK_PARTICLES.get(),
						player.getX(), player.getY() + 1,
						player.getZ(), 100, 0, 0, 0, 1);
			}
			super.tick();
		}
	}

	public void remove(RemovalReason p_149847_) {
		if (this.isDeadOrDying()) {
			if (!this.level().isClientSide()  && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET),1)== ExAidRiderItems.KAMEN_RIDER_CHRONICLE_GASHAT_BUGSTER_MACHINA.get()) {
				ItemEntity gashat = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(ExAidRiderItems.UNFINISHED_HYPER_MUTEKI_GASHAT.get(), 1), 0, 0, 0);
				gashat.setPickUpDelay(0);
				level().addFreshEntity(gashat);
			}
		}
		super.remove(p_149847_);
	}

	protected void customServerAiStep() {
		super.customServerAiStep();

		if(getItemBySlot(EquipmentSlot.FEET).getItem()== ExAidRiderItems.GASHACON_BUGVISOR_BUGSTER.get()){
			ItemStack belt = getItemBySlot(EquipmentSlot.FEET);
			if (RiderDriverItem.getFormItem(belt,1)== ExAidRiderItems.KAMEN_RIDER_CHRONICLE_GASHAT_BUGSTER_MACHINA.get()&this.bossEvent.getColor()!=BossEvent.BossBarColor.RED) {
				this.bossEvent.setColor(BossEvent.BossBarColor.RED);
				this.bossEvent.setName(Component.translatable("entity.kamenridercraft.gamedeus_machina").withStyle(ChatFormatting.GOLD));
            }
		}
		this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
	}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_FLAGS_ID, (byte)0);
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


	public static AttributeSupplier.Builder setAttributes() {

		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 135.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.3F)
				.add(Attributes.ATTACK_DAMAGE, 12.0D)
				.add(Attributes.ARMOR, 10.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 4.0D)
				.add(Attributes.ATTACK_KNOCKBACK, 2.0D)
				.add(Attributes.MAX_HEALTH, 300.0D);
	}
}