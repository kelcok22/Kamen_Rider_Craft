package com.kelco.kamenridercraft.entities.allies;


import com.kelco.kamenridercraft.entities.footSoldiers.NewMoleImaginSandEntity;
import com.kelco.kamenridercraft.entities.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.Den_O_Rider_Items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.event.EventHooks;


public class MomotarosEntity extends BaseAllyEntity {
	
	public MomotarosEntity(EntityType<? extends MomotarosEntity> entityType, Level level) {
		super(entityType, level);
		NAME = "momotaros";
		
		}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new AllyPanicGoal(1.4D));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
			if (isTame()) {
				return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper) && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			}else return false;
		}));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, NewMoleImaginSandEntity.class, false));
		this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

	}

    public void tame(Player p_21829_) {
	   super.tame(p_21829_);
	   this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0D);
	   this.setHealth(40.0F);
	   this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Den_O_Rider_Items.MOMOTAROSWORD.get()));
    }
	
	public final InteractionResult mobInteract(Player p_30412_, InteractionHand p_30413_) {
	      ItemStack itemstack = p_30412_.getItemInHand(p_30413_);
		  Level level = this.level();
		  if (level.isClientSide) {
	         boolean flag = this.isOwnedBy(p_30412_) || this.isTame() || (itemstack.is(Items.PUMPKIN_PIE) && !this.isTame() && !this.isAngry());
	         return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
	      } else if (this.isTame()) {
	         if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
	            this.heal((float)itemstack.getFoodProperties(this).nutrition());
	            if (!p_30412_.getAbilities().instabuild) {
	               itemstack.shrink(1);
	            }

	            this.gameEvent(GameEvent.EAT, this);
	            return InteractionResult.SUCCESS;
	         } else {
	            if (itemstack.is(Den_O_Rider_Items.RIDER_PASS.get())) {
	            	p_30412_.sendSystemMessage(Component.translatable("<Momotaros> Henshin!").withStyle(ChatFormatting.RED));
	            	p_30412_.sendSystemMessage(Component.translatable("Sword Form!").withStyle(ChatFormatting.RED));
	            	p_30412_.sendSystemMessage(Component.translatable("<Momotaros> I... have arrived!").withStyle(ChatFormatting.RED));
	            	this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Den_O_Rider_Items.DEN_OHELMET.get()));
	            	this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Den_O_Rider_Items.DEN_OCHESTPLATE.get()));
	            	this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Den_O_Rider_Items.DEN_OLEGGINGS.get()));
	            	this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Den_O_Rider_Items.DEN_O_BELT.get()));
	            	this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Den_O_Rider_Items.DEN_GASHER_SWORD.get()));
					if (!p_30412_.getAbilities().instabuild) {
					   itemstack.shrink(1);
					}
					return InteractionResult.SUCCESS;
	            }
	            InteractionResult interactionresult = super.mobInteract(p_30412_, p_30413_);
	            if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(p_30412_)) {
	               this.setOrderedToSit(!this.isOrderedToSit());
	               this.jumping = false;
	               this.navigation.stop();
	               this.setTarget((LivingEntity)null);
	               return InteractionResult.SUCCESS;
	            } else {
	               return interactionresult;
	            }
	         }
	      } else if (itemstack.is(Items.PUMPKIN_PIE) && !this.isAngry()) {
	         if (!p_30412_.getAbilities().instabuild) {
	            itemstack.shrink(1);
	         }

	         if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, p_30412_)) {
	            this.tame(p_30412_);
	            this.navigation.stop();
	            this.setTarget((LivingEntity)null);
	            this.setOrderedToSit(true);
	            this.level().broadcastEntityEvent(this, (byte)7);
	         } else {
	            this.level().broadcastEntityEvent(this, (byte)6);
	         }

	         return InteractionResult.SUCCESS;
	      } else {
	         return super.mobInteract(p_30412_, p_30413_);
	      }
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

	   public boolean isBaby() {
		      return false;
		   }
	   
	public boolean canMate(Animal p_30392_) {
	            return false;
	   }
	   
	   public boolean isFood(ItemStack p_30440_) {
		      Item item = p_30440_.getItem();

		      return item ==Items.PUMPKIN_PIE;
		   }
}
