package com.kelco.kamenridercraft.entities.summons;


import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import javax.annotation.Nullable;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;


public class BaseSummonEntity extends TamableAnimal implements NeutralMob, RangedAttackMob {
	private boolean swordgunMelee = false;
	private final RangedBowAttackGoal<BaseSummonEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
	private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2D, false) {
	   public void stop() {
		  super.stop();
		  BaseSummonEntity.this.stopBeingAngry();
		  BaseSummonEntity.this.startPersistentAngerTimer();
		  BaseSummonEntity.this.setAggressive(false);
	   }
 
	   public void start() {
		  super.start();
		  BaseSummonEntity.this.setAggressive(true);
	   }
	};
	private boolean swordgunMeleeOnly;

   private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(BaseSummonEntity.class, EntityDataSerializers.INT);
   private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
   private final NonNullList<ItemStack> REQUIRED_ARMOR = NonNullList.withSize(4, ItemStack.EMPTY);
   private ItemStack SUMMON_ITEM = ItemStack.EMPTY;

   @Nullable
   private UUID persistentAngerTarget;
	
	public String NAME = "rider_summon";

	public int Scale=1;

	public double BOW_DISTANCE = 40.0D;

	public BaseSummonEntity(EntityType<? extends BaseSummonEntity> entityType, Level level) {
		super(entityType, level);
		this.setDropChance(EquipmentSlot.HEAD, 0.0f);
		this.setDropChance(EquipmentSlot.CHEST, 0.0f);
		this.setDropChance(EquipmentSlot.LEGS, 0.0f);
		this.setDropChance(EquipmentSlot.FEET, 0.0f);
		this.setDropChance(EquipmentSlot.MAINHAND, 0.0f);
		this.setDropChance(EquipmentSlot.OFFHAND, 0.0f);
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_REMAINING_ANGER_TIME, 0);
	}

	

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
			if (isTame()) {
				return p_28879_ instanceof Enemy && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			}else return false;
		}));
		this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, true));

	}

	public void aiStep() {
		Level level = this.level();
		ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof BowItem));
		if (this.getTarget() != null && (itemstack.getItem() instanceof BowItem && itemstack.getItem() instanceof SwordItem
		|| itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/all_swordguns"))))) {
        	boolean swordgunMeleeCheck = (((this.getTarget() instanceof Player player && player.getAbilities().flying && player.distanceToSqr(this) < 10.0D)
        	|| (this.getTarget() instanceof FlyingMob fly && fly.distanceToSqr(this) < 20.0D)
        	|| this.getTarget().distanceToSqr(this) < BOW_DISTANCE));

        	if (swordgunMeleeOnly) this.setSwordgunMelee(true);
        	else if (swordgunMelee != swordgunMeleeCheck) this.setSwordgunMelee(swordgunMeleeCheck);
     	}
		
		if (!level.isClientSide) {
		   this.updatePersistentAnger((ServerLevel)this.level(), true);
			if ( this.getOwner() instanceof Player owner && this.isAlive()) {		
				if(!owner.isAlive()
				||owner.getItemBySlot(EquipmentSlot.HEAD).getItem()!=this.getRequiredArmor(EquipmentSlot.HEAD).getItem()
				||owner.getItemBySlot(EquipmentSlot.CHEST).getItem()!=this.getRequiredArmor(EquipmentSlot.CHEST).getItem()
				||owner.getItemBySlot(EquipmentSlot.LEGS).getItem()!=this.getRequiredArmor(EquipmentSlot.LEGS).getItem()
				||owner.getItemBySlot(EquipmentSlot.FEET).getItem()!=this.getRequiredArmor(EquipmentSlot.FEET).getItem()) {
					this.setHealth(0);
					if (!this.SUMMON_ITEM.isEmpty()) this.spawnAtLocation(this.SUMMON_ITEM);
				}
			}
		}
		if (this.swinging) this.updateSwingTime();

		super.aiStep();
	}

	@Override
	public void die(DamageSource p_21809_) {
		this.setOwnerUUID(null);
		super.die(p_21809_);
		if (!this.SUMMON_ITEM.isEmpty() && !this.level().isClientSide()) this.spawnAtLocation(this.SUMMON_ITEM);
 
	}

    public void setMeleeOnly(boolean p_21840_) {
       this.swordgunMeleeOnly = p_21840_;
    }

    public boolean getMeleeOnly() {
       return this.swordgunMeleeOnly;
    }

    public void reassessWeaponGoal() {
       if (this.level() != null && !this.level().isClientSide) {
          this.goalSelector.removeGoal(this.meleeGoal);
          this.goalSelector.removeGoal(this.bowGoal);
          ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem));
          if (itemstack.getItem() instanceof BowItem) {
             this.bowGoal.setMinAttackInterval(30);
             this.goalSelector.addGoal(2, this.bowGoal);
          } else {
             this.goalSelector.addGoal(2, this.meleeGoal);
          }

       }
    }

    public void setSwordgunMelee(boolean melee) {
       if (this.level() != null && !this.level().isClientSide) {
         if (melee) {
           this.goalSelector.removeGoal(this.bowGoal);
           this.goalSelector.addGoal(2, this.meleeGoal);
         } else {
           int i = 30;

           this.bowGoal.setMinAttackInterval(i);
			  this.goalSelector.removeGoal(this.meleeGoal);
           this.goalSelector.addGoal(2, this.bowGoal);
         }
         swordgunMelee = melee;
		}
    }

   public void addAdditionalSaveData(CompoundTag p_30418_) {
      super.addAdditionalSaveData(p_30418_);
      this.addPersistentAngerSaveData(p_30418_);
      ListTag listtag = new ListTag();
      Iterator<ItemStack> var3 = this.REQUIRED_ARMOR.iterator();

      while(var3.hasNext()) {
         ItemStack itemstack = (ItemStack)var3.next();
         if (!itemstack.isEmpty()) {
            listtag.add(itemstack.save(this.registryAccess()));
         } else {
            listtag.add(new CompoundTag());
         }
      }

      p_30418_.put("RequiredArmorItems", listtag);
	  p_30418_.putBoolean("SwordgunMeleeOnly", this.swordgunMeleeOnly);
   }

   public void readAdditionalSaveData(CompoundTag p_30402_) {
      super.readAdditionalSaveData(p_30402_);
      this.readPersistentAngerSaveData(this.level(), p_30402_);
      if (p_30402_.contains("RequiredArmorItems", 9)) {
         ListTag listtag = p_30402_.getList("RequiredArmorItems", 10);

         for(int i = 0; i < this.REQUIRED_ARMOR.size(); ++i) {
            this.REQUIRED_ARMOR.set(i, ItemStack.parseOptional(this.registryAccess(), listtag.getCompound(i)));
         }
      }
	  this.reassessWeaponGoal();
	  this.swordgunMeleeOnly = p_30402_.getBoolean("SwordgunMeleeOnly");
   }

   public void setRequiredArmor() {
	  if ( this.getOwner() instanceof Player owner) {	
        this.REQUIRED_ARMOR.set(EquipmentSlot.HEAD.getIndex(), owner.getItemBySlot(EquipmentSlot.HEAD));
        this.REQUIRED_ARMOR.set(EquipmentSlot.CHEST.getIndex(), owner.getItemBySlot(EquipmentSlot.CHEST));
        this.REQUIRED_ARMOR.set(EquipmentSlot.LEGS.getIndex(), owner.getItemBySlot(EquipmentSlot.LEGS));
        this.REQUIRED_ARMOR.set(EquipmentSlot.FEET.getIndex(), owner.getItemBySlot(EquipmentSlot.FEET));
	  }
   }

   public ItemStack getRequiredArmor(EquipmentSlot p_21467_) {
      return this.REQUIRED_ARMOR.get(p_21467_.getIndex());
   }

   public void bindToPlayer(Player player) {
	  this.setTame(true, false);
	  this.setOwnerUUID(player.getUUID());
	  this.setRequiredArmor();
   }

   public void takeSummonItem(ItemStack stack) {
	this.SUMMON_ITEM = stack.copyWithCount(1);
	stack.shrink(1);
   }

	   protected SoundEvent getAmbientSound() {
		         return SoundEvents.VILLAGER_AMBIENT;
		   }
	
	protected void playStepSound(BlockPos p_30415_, BlockState p_30416_) {
		
	}

	protected SoundEvent getHurtSound(DamageSource p_30424_) {
		return SoundEvents.VILLAGER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.VILLAGER_HURT;
	}
	
    public void setItemSlot(EquipmentSlot p_32138_, ItemStack p_32139_) {
       super.setItemSlot(p_32138_, p_32139_);
       if (this.level() != null && !this.level().isClientSide) this.reassessWeaponGoal();
    }

    public void performRangedAttack(LivingEntity target, float distanceFactor) {
       ItemStack weapon = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> {
          return item instanceof BowItem;
       }));
       ItemStack itemstack1 = this.getProjectile(weapon);
       AbstractArrow abstractarrow = this.getArrow(itemstack1, distanceFactor, weapon);
       Item var7 = weapon.getItem();
       if (var7 instanceof ProjectileWeaponItem weaponItem) {
          abstractarrow = weaponItem.customArrow(abstractarrow, itemstack1, weapon);
       }
 
       double d0 = target.getX() - this.getX();
       double d1 = target.getY(0.3333333333333333) - abstractarrow.getY();
       double d2 = target.getZ() - this.getZ();
       double d3 = Math.sqrt(d0 * d0 + d2 * d2);
       abstractarrow.shoot(d0, d1 + d3 * 0.20000000298023224, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
       this.playSound(SoundEvents.BLAZE_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
       this.level().addFreshEntity(abstractarrow);
    }

    protected AbstractArrow getArrow(ItemStack arrow, float velocity, @Nullable ItemStack weapon) {
        return ProjectileUtil.getMobArrow(this, arrow, velocity, weapon);
    }

	public boolean canFireProjectileWeapon(ProjectileWeaponItem p_32144_) {
	   return p_32144_ instanceof BowItem;
	}

	   public boolean shouldDropExperience() {
		      return false;
		   }

	   public boolean isBaby() {
		      return false;
		   }
	   
	public boolean canMate(Animal p_30392_) {
	            return false;
	   }

	   @Nullable
	   public TamableAnimal getBreedOffspring(ServerLevel p_149088_, AgeableMob p_149089_) {
	
	      return null;
	   }

   public int getRemainingPersistentAngerTime() {
      return this.entityData.get(DATA_REMAINING_ANGER_TIME);
   }

   public void setRemainingPersistentAngerTime(int p_30404_) {
      this.entityData.set(DATA_REMAINING_ANGER_TIME, p_30404_);
   }

   public void startPersistentAngerTimer() {
      this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
   }

   @Nullable
   public UUID getPersistentAngerTarget() {
      return this.persistentAngerTarget;
   }

   public void setPersistentAngerTarget(@Nullable UUID p_30400_) {
      this.persistentAngerTarget = p_30400_;
   }
	   
	   public boolean isFood(ItemStack p_30440_) {
		      return false;
		   }
}
