package com.kelco.kamenridercraft.entities.summons;

import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.BugsterVirusEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.RideplayerEntity;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.ex_aid.GamerDriverItem;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class DecadeArmorExAidEntity extends BaseSummonEntity {

	public DecadeArmorExAidEntity(EntityType<? extends DecadeArmorExAidEntity> type, Level level) {
		super(type, level);
		NAME="decade_armor_ex_aid";
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zi_O_Rider_Items.ZI_O_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zi_O_Rider_Items.ZI_O_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zi_O_Rider_Items.ZI_O_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.RIDE_HEISABER.get()));
		RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_R.get(), 1);
		this.addRequiredForm((RiderFormChangeItem)Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_L.get(), 1);
		this.addRequiredForm((RiderFormChangeItem)Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_R.get(), 1);
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Creeper.class, 24.0F, 1.5D, 1.5D));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 5.0F, 2.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, 5, false, false, (p_28879_) -> {
			if (isTame()) {
				return p_28879_ instanceof Enemy && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			}else return false;
		}));
      	this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, true));

	}

	public void aiStep() {
		super.aiStep();

		if (!this.level().isClientSide()) {
			if ( this.getOwner() instanceof Player owner && owner.getItemBySlot(EquipmentSlot.FEET).getItem()==Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get()) {			
				if (RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1)==Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_L.get()) {
					if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1)!=Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_R.get()) {
						RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_R.get(), 1);
						this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.RIDE_HEISABER.get()));
					}
				} else if(RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1)==Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_R.get()) {
					if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1)!=Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_L.get()) {
						RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_L.get(), 1);
						this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Zi_O_Rider_Items.ZIKAN_GIRADE.get()));
					}
				}
			}
		}
	}


	@Override
	public void setTame(boolean p_30443_, boolean p_30444_) {
		super.setTame(p_30443_, p_30444_);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
		this.setHealth(20.0F);
	}
}