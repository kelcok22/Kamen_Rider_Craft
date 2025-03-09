package com.kelco.kamenridercraft.entities.summons;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class RiderSummonEntity extends BaseSummonEntity {
	public RiderSummonEntity(EntityType<? extends RiderSummonEntity> type, Level level) {
		super(type, level);
		NAME="rider_summon";
        this.reassessWeaponGoal();
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, -10.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 20.0F, 2.0F));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
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

    @Override
    public void bindToPlayer(Player player) {
      if (player instanceof ServerPlayer serverplayer) CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, this);
      super.bindToPlayer(player);
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
        } else if (this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof BowItem) {
            if (this.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof SwordItem
            || this.getItemBySlot(EquipmentSlot.MAINHAND).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/all_swordguns")))) return !this.getMeleeOnly();
            else return true;
        } else return false;
	}

	public boolean isBaby() {
		return false;
	}

	public boolean canMate(Animal p_30392_) {
		return false;
	}
}