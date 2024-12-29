package com.kelco.kamenridercraft.entities.footSoldiers;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import javax.annotation.Nullable;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class BaseHenchmenEntity extends  Monster implements RangedAttackMob {

    public int BOW_COOLDOWN = 40;
    public int HARD_BOW_COOLDOWN = 20;
    public double BOW_DISTANCE = 40.0D;
    private boolean swordgunMelee = false;
    private final RangedBowAttackGoal<RiotrooperEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
    private final MeleeAttackGoal meleeGoal = new  MeleeAttackGoal(this, 1.0D, false) {
        public void stop() {
            super.stop();
            BaseHenchmenEntity.this.setAggressive(false);
        }

        public void start() {
            super.start();
            BaseHenchmenEntity.this.setAggressive(true);
        }
    };

	public String NAME = "shocker_combatman";


	
    public BaseHenchmenEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        this.reassessWeaponGoal();
    }

    
    @Override
    protected void registerGoals() {
    	 this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
        
           }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseHenchmenEntity.class)).setAlertOthers(this.getClass()));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        //this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BaseSummonEntity.class, true));
     }


    public void aiStep() {
        ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof BowItem));
        if (this.getTarget() != null && itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/all_swordguns")))) {
            boolean swordgunMeleeCheck = (((this.getTarget() instanceof Player player && player.getAbilities().flying && player.distanceToSqr(this) < 10.0D)
                    || (this.getTarget() instanceof FlyingMob fly && fly.distanceToSqr(this) < 20.0D)
                    || this.getTarget().distanceToSqr(this) < BOW_DISTANCE));
            if (swordgunMelee != swordgunMeleeCheck) this.setSwordgunMelee(swordgunMeleeCheck);
        }
        super.aiStep();
        if (this.swinging) this.updateSwingTime();
    }

    public boolean canBreakDoors() {
        return true;
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 35.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 4.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 45.0D);
     }


    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
    	RandomSource randomsource = level.getRandom();
    
       float f = difficulty.getSpecialMultiplier();
       this.setCanPickUpLoot(randomsource.nextFloat() < 0.55F * f);

            spawnGroupData =  super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    if (this.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty()) {
       LocalDate localdate = LocalDate.now();
       int i = localdate.get(ChronoField.DAY_OF_MONTH);
       int j = localdate.get(ChronoField.MONTH_OF_YEAR);
       if (j == 6 && i == 22 && randomsource.nextFloat() < 0.25F) {
          this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack( Items.APPLE));
          this.armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.0F;
       }
    }
    return spawnGroupData;
 }


    
    public static boolean getSpawnAsBabyOdds(RandomSource p_219163_) {
        return false;
     }
    
    public boolean isBaby() {
        return false;
     }

    protected boolean isSunSensitive() {
        return false;
     }

    

    protected SoundEvent getAmbientSound() {
       return SoundEvents.PILLAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
       return SoundEvents.PILLAGER_HURT;
    }

    protected SoundEvent getDeathSound() {
       return SoundEvents.PILLAGER_DEATH;
    }

    protected SoundEvent getStepSound() {
       return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
       this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    public void reassessWeaponGoal() {
        if (this.level() != null && !this.level().isClientSide) {
            ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof BowItem));
            if (itemstack.getItem() instanceof BowItem) {
                this.bowGoal.setMinAttackInterval(this.level().getDifficulty() == Difficulty.HARD ? HARD_BOW_COOLDOWN : BOW_COOLDOWN);
                this.goalSelector.removeGoal(this.meleeGoal);
                this.goalSelector.addGoal(2, this.bowGoal);
            } else {
                this.goalSelector.removeGoal(this.bowGoal);
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
                this.bowGoal.setMinAttackInterval(this.level().getDifficulty() == Difficulty.HARD ? HARD_BOW_COOLDOWN : BOW_COOLDOWN);
                this.goalSelector.removeGoal(this.meleeGoal);
                this.goalSelector.addGoal(2, this.bowGoal);
            }
            swordgunMelee = melee;
        }
    }

    public boolean getSwordgunMelee() {
        return this.swordgunMelee;
    }

    public void readAdditionalSaveData(CompoundTag p_32152_) {
        super.readAdditionalSaveData(p_32152_);
        this.reassessWeaponGoal();
    }

    public void setItemSlot(EquipmentSlot p_32138_, ItemStack p_32139_) {
        super.setItemSlot(p_32138_, p_32139_);
        Level level = this.level();
        if (!level.isClientSide) this.reassessWeaponGoal();
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
}