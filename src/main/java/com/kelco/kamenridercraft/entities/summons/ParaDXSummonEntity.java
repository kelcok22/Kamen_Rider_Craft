package com.kelco.kamenridercraft.entities.summons;

import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.BugsterVirusEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.RideplayerEntity;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
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
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ParaDXSummonEntity extends BaseSummonEntity {

	public ParaDXSummonEntity(EntityType<? extends ParaDXSummonEntity> type, Level level) {
		super(type, level);
		NAME="paradx_summon";
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ex_Aid_Rider_Items.EX_AIDHELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ex_Aid_Rider_Items.EX_AIDCHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ex_Aid_Rider_Items.EX_AIDLEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ex_Aid_Rider_Items.GAMER_DRIVER_EX_AID.get()));
		RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_L.get(), 1);
		RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Modded_item_core.BLANK_FORM.get(), 2);
		this.addRequiredForm((RiderFormChangeItem)Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_L.get(), 1);
		this.addRequiredForm((RiderFormChangeItem)Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_R.get(), 1);
		this.addRequiredForm((RiderFormChangeItem)Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_2_GASHAT.get(), 1);
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Creeper.class, 24.0F, 1.5D, 1.5D));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
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
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, BugsterVirusEntity.class, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, RideplayerEntity.class, false));
      	this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, true));

	}

	public void aiStep() {
		super.aiStep();

		if (!this.level().isClientSide()) {
			if (this.getOwner() instanceof Player owner && owner.getItemBySlot(EquipmentSlot.FEET).getItem()==Ex_Aid_Rider_Items.GAMER_DRIVER_EX_AID.get()) {			
				if (RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1)==Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_2_GASHAT.get()) {
					if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1)!=Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_2_GASHAT.get()) {
						this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ex_Aid_Rider_Items.GAMER_DRIVER_PARA_DX.get()));
						RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ex_Aid_Rider_Items.KNOCK_OUT_FIGHTER_2_GASHAT.get(), 1);
						this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
					}
				} else if(RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1)==Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_L.get()) {
					if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1)!=Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_R.get()) {
						this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ex_Aid_Rider_Items.GAMER_DRIVER_EX_AID.get()));
						RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_R.get(), 1);
						this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ex_Aid_Rider_Items.GASHACON_KEY_SLASHER.get()));
					}
				} else if(RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1)==Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_R.get()) {
					if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1)!=Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_L.get()) {
						this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Ex_Aid_Rider_Items.GAMER_DRIVER_EX_AID.get()));
						RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Ex_Aid_Rider_Items.MIGHTY_BROTHERS_XX_GASHAT_L.get(), 1);
						this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Ex_Aid_Rider_Items.GASHACON_KEY_SLASHER.get()));
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

	public boolean wantsToAttack(LivingEntity p_30389_, LivingEntity p_30390_) {
		if (!(p_30389_ instanceof Creeper)&&!(p_30389_ instanceof Ghast)) {
        	if (p_30389_ instanceof BaseAllyEntity) {
        	    BaseAllyEntity illusion = (BaseAllyEntity)p_30389_;
        	    return !illusion.isTame() || illusion.getOwner() != p_30390_;
			} else if (p_30389_ instanceof BaseSummonEntity) {
				BaseSummonEntity illusion = (BaseSummonEntity)p_30389_;
				return !illusion.isTame() || illusion.getOwner() != p_30390_;
			} else if (p_30389_ instanceof Player player2 && p_30390_ instanceof Player player1 && !player1.canHarmPlayer(player2)) {
				return false;
			} else if (p_30389_ instanceof AbstractHorse horse && horse.isTamed()) {
				return false;
			} else {
				return !(p_30389_ instanceof TamableAnimal) || !((TamableAnimal)p_30389_).isTame();
			}
		} else {
			return false;
		}
	}
}