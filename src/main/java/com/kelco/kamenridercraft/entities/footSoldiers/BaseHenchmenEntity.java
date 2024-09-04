package com.kelco.kamenridercraft.entities.footSoldiers;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class BaseHenchmenEntity extends  Monster {
	
	public String NAME = "shocker_combatman";

	public int Scale=1;
	
    public BaseHenchmenEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
    }

    
    @Override
    protected void registerGoals() {
    	 this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
        
           }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseHenchmenEntity.class)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        //this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, BaseSummonEntity.class, true));
     }

	public void aiStep() {
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
    
    @Override
    public float getScale() {
        return Scale;
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


}