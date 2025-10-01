package com.kelco.kamenridercraft.entities.allies;


import com.kelco.kamenridercraft.entities.footSoldiers.YummyEntity;
import com.kelco.kamenridercraft.entities.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.OOO_Rider_Items;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;


public class KujakuCanEntity extends BaseAllyEntity implements GeoEntity , FlyingAnimal {

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public KujakuCanEntity(EntityType<? extends KujakuCanEntity> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new FlyingMoveControl(this, 20, true);
		if (level != null && !level.isClientSide) {
			this.registerGoals();
		}
		}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new TamableAnimalPanicGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0, true));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
			//if (isTame()) {
			//	return p_28879_ instanceof Enemy && !(p_28879_ instanceof Creeper) && !(p_28879_ instanceof AnkhCompleteEntity) && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			//}else
			return false;
		}));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, YummyEntity.class, false));
		this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F)
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D)
				.add(Attributes.FLYING_SPEED, 0.1F);
	}

	@Override
	protected PathNavigation createNavigation(Level level) {
		FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, level);
		flyingpathnavigation.setCanOpenDoors(false);
		flyingpathnavigation.setCanFloat(true);
		flyingpathnavigation.setCanPassDoors(true);
		return flyingpathnavigation;
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
						ItemStack itemstack2;
							InteractionResult interactionresult = super.mobInteract(player, hand);
							if (!interactionresult.consumesAction() && this.isOwnedBy(player)) {
								this.setOrderedToSit(!this.isOrderedToSit());
								this.jumping = false;
								this.navigation.stop();
								this.setTarget(null);
								return InteractionResult.SUCCESS_NO_ITEM_USED;
							} else {
								return interactionresult;
						}
				}
			}else if (itemstack.is(OOO_Rider_Items.CELL_MEDAL.get()) && !this.isAngry()) {
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
    @Override
    public void die(DamageSource p_21809_) {
        this.setOwnerUUID(null);
        super.die(p_21809_);
    }
	@Override
	protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
	}
	@Override
	public void travel(Vec3 travelVector) {
		if (this.isControlledByLocalInstance()) {
			if (this.isInWater()) {
				this.moveRelative(0.02F, travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.8F));
			} else if (this.isInLava()) {
				this.moveRelative(0.02F, travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.5));
			} else {
				this.moveRelative(this.getSpeed(), travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.91F));
			}
		}

		this.calculateEntityAnimation(false);
	}

	private void tryToTame(Player player) {
			this.tame(player);
			this.navigation.stop();
			this.setTarget(null);
			this.setOrderedToSit(true);
			this.level().broadcastEntityEvent(this, (byte)7);
	}

    /**
	   protected SoundEvent getAmbientSound() {
		         return SoundEvents.VILLAGER_AMBIENT;
		   }

	protected SoundEvent getHurtSound(DamageSource p_30424_) {
		return SoundEvents.IRON_GOLEM_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.IRON_GOLEM_DEATH;
	}
**/
	   public boolean isBaby() {
		      return false;
		   }
	   
	public boolean canMate(Animal p_30392_) {
	            return false;
	   }

	   
	   public boolean isFood(ItemStack p_30440_) {
		      Item item = p_30440_.getItem();
		      return item == OOO_Rider_Items.CELL_MEDAL.get();
		   }



	@Override
		public AnimatableInstanceCache getAnimatableInstanceCache() {
			return this.cache;
		}
		
		// Add our generic idle animation controller
		@Override
		public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
			
			RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.kujaku_can.idle");
			RawAnimation WALK = RawAnimation.begin().thenLoop("animation.kujaku_can.walk");
			RawAnimation SIT = RawAnimation.begin().thenPlay("animation.kujaku_can.sit");
			RawAnimation SUMMON = RawAnimation.begin().thenPlay("animation.kujaku_can.summon");
			RawAnimation RIP = RawAnimation.begin().thenPlay("animation.kujaku_can.death");

			controllers.add(new AnimationController<>(this, "Walk/Idle", 0, state -> state.setAndContinue(!isDeadOrDying() ? !isInSittingPose() ? state.isMoving() ? WALK : IDLE : SIT : RIP)));
		}

	@Override
	public boolean isFlying() {
		return !this.onGround();
	}
}
