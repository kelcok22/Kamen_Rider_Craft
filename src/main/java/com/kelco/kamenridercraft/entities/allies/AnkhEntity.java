package com.kelco.kamenridercraft.entities.allies;


import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.EventHooks;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;


public class AnkhEntity extends BaseAllyEntity implements GeoEntity {
	
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	
	public AnkhEntity(EntityType<? extends AnkhEntity> entityType, Level level) {
		super(entityType, level);
		if (level != null && !level.isClientSide) {
			this.registerGoals();
		}
		}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new TamableAnimal.TamableAnimalPanicGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0, true));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		//this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
			//if (isTame()) {
			//	return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper) && !(p_28879_ instanceof AnkhCompleteEntity) && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			//}else
			return false;
		}));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		//this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, YummyEntity.class, false));
		this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

	}



	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (!this.level().isClientSide || this.isBaby() && this.isFood(itemstack)) {
			if (this.isTame()) {
				if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
					FoodProperties foodproperties = itemstack.getFoodProperties(this);
					float f = foodproperties != null ? (float)foodproperties.nutrition() : 1.0F;
					this.heal(2.0F * f);
					itemstack.consume(1, player);
					this.gameEvent(GameEvent.EAT);
					return InteractionResult.sidedSuccess(this.level().isClientSide());
				} else {

					if (itemstack.is(OOO_Rider_Items.GREEED_BLET_ANKH_LOST.get()) && this.isOwnedBy(player) &&!this.isBaby()) {
						player.sendSystemMessage(Component.translatable("TEST NOT FINISHED").withStyle(ChatFormatting.YELLOW));
						/**
						BaseHenchmenEntity boss = MobsCore.ANKHCOMPLETE.get().create(this.level());
						if (boss != null) {
							boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
							this.level().addFreshEntity(boss);
						}
						 **/
						this.discard();
						return InteractionResult.SUCCESS;
					} else {
						ItemStack itemstack2;
							InteractionResult interactionresult = super.mobInteract(player, hand);
							if (!interactionresult.consumesAction() && this.isOwnedBy(player)) {
								this.setOrderedToSit(!this.isOrderedToSit());
								this.jumping = false;
								this.navigation.stop();
								this.setTarget((LivingEntity)null);
								return InteractionResult.SUCCESS_NO_ITEM_USED;
							} else {
								return interactionresult;
						}
					}
				}
			}else if ((itemstack.is(Modded_item_core.ICE_POP.get())
	    		  ||itemstack.is(Modded_item_core.ICE_POP2.get())
	    		  ||itemstack.is(Modded_item_core.ICE_POP3.get())) && !this.isAngry()) {
			  itemstack.consume(1, player);
			  this.tryToTame(player);
			  return InteractionResult.SUCCESS;
		  } else {
			  return super.mobInteract(player, hand);
		  }
	} else {
		boolean flag = this.isOwnedBy(player) || this.isTame() || itemstack.is(Items.BONE) && !this.isTame() && !this.isAngry();
		return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
	}
}

	private void tryToTame(Player player) {
		if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, player)) {
			this.tame(player);
			this.navigation.stop();
			this.setTarget((LivingEntity)null);
			this.setOrderedToSit(true);
			this.level().broadcastEntityEvent(this, (byte)7);
		} else {
			this.level().broadcastEntityEvent(this, (byte)6);
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

	   
	   public static boolean checkAnkhSpawnRules(EntityType<AnkhEntity> p_218256_, LevelAccessor p_218257_, MobSpawnType p_218258_, BlockPos p_218259_, RandomSource p_218260_) {
		      return p_218257_.getBlockState(p_218259_.below()).is(Blocks.SAND) && isBrightEnoughToSpawn(p_218257_, p_218259_);
		   }
	   
	   public boolean isFood(ItemStack p_30440_) {
		      Item item = p_30440_.getItem();
		      return item ==Modded_item_core.ICE_POP.get()||item ==Modded_item_core.ICE_POP2.get()||item == Modded_item_core.ICE_POP3.get();
		   }



	@Override
		public AnimatableInstanceCache getAnimatableInstanceCache() {
			return this.cache;
		}
		
		// Add our generic idle animation controller
		@Override
		public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
			
			RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.ankh.idle");
			RawAnimation WALK = RawAnimation.begin().thenLoop("animation.ankh.walk");
			RawAnimation SIT = RawAnimation.begin().thenPlay("animation.ankh.sit");
			
			controllers.add(new AnimationController<AnkhEntity>(this, "Walk/Idle", 0, state -> state.setAndContinue(!isInSittingPose()? state.isMoving() ? WALK : IDLE :SIT)));
		}
}
