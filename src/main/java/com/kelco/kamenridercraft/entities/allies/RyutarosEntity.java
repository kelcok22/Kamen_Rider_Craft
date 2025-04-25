package com.kelco.kamenridercraft.entities.allies;


import javax.annotation.Nullable;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.ServerConfig;
import com.kelco.kamenridercraft.entities.footSoldiers.NewMoleImaginSandEntity;
import com.kelco.kamenridercraft.entities.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.Den_O_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.BaseItems.BaseBlasterItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Difficulty;
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
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.event.EventHooks;


public class RyutarosEntity extends BaseAllyEntity implements RangedAttackMob {
   private final RangedBowAttackGoal<RyutarosEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 20, 15.0F);
   private final MeleeAttackGoal meleeGoal = new MeleeAttackGoal(this, 1.2D, false) {
      public void stop() {
         super.stop();
         RyutarosEntity.this.stopBeingAngry();
         RyutarosEntity.this.startPersistentAngerTimer();
		 RyutarosEntity.this.setAggressive(false);
      }

      public void start() {
         super.start();
		 RyutarosEntity.this.setAggressive(true);
      }
   };
	
	public RyutarosEntity(EntityType<? extends RyutarosEntity> entityType, Level level) {
		super(entityType, level);
		NAME = "ryutaros";
		this.setPersistenceRequired();
        this.reassessWeaponGoal();
        
		}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new AllyPanicGoal(1.4D));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 5.0F, 2.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		//this.targetSelector.addGoal(3, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this, BaseAllyEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
			if (isTame()) {
				return p_28879_ instanceof Enemy && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			}else return false;
		}));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, NewMoleImaginSandEntity.class, false));
		this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

	}

    public void tame(Player p_21829_) {
	   super.tame(p_21829_);
	   this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0D);
	   this.setHealth(40.0F);
	   this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Den_O_Rider_Items.RYUVOLVER.get()));
	   this.reassessWeaponGoal();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
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
					if (itemstack.is(Den_O_Rider_Items.RIDER_PASS.get())) {
						player.sendSystemMessage(Component.literal("<" + this.getName().getString() + "> " + Component.translatable("henshin.kamenridercraft.henshin").getString()));
						player.sendSystemMessage(Component.translatable("henshin.kamenridercraft.den_o_gun_1"));
						player.sendSystemMessage(Component.literal("<" + this.getName().getString() + "> " + Component.translatable("henshin.kamenridercraft.den_o_gun_2").getString()));
						this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Den_O_Rider_Items.DEN_OHELMET.get()));
						this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Den_O_Rider_Items.DEN_OCHESTPLATE.get()));
						this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Den_O_Rider_Items.DEN_OLEGGINGS.get()));
						this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Den_O_Rider_Items.DEN_O_BELT.get()));
						this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Den_O_Rider_Items.DEN_GASHER_GUN.get()));
						RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Den_O_Rider_Items.RIDER_TICKET_GUN.get(), 1);
						if (!player.getAbilities().instabuild) {
						   itemstack.shrink(1);
						}
						return InteractionResult.SUCCESS;
					}
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
            } else if (itemstack.is(Modded_item_core.VIENNA_COFFEE) && !this.isAngry()) {
                itemstack.consume(1, player);
                this.tryToTame(player);
                return InteractionResult.SUCCESS;
            } else {
                return super.mobInteract(player, hand);
            }
        } else {
            boolean flag = this.isOwnedBy(player) || this.isTame() || itemstack.is(Modded_item_core.VIENNA_COFFEE) && !this.isTame() && !this.isAngry();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        }
    }

    private void tryToTame(Player player) {
        if (this.random.nextInt(3) == 0  && !net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, player)) {
            this.tame(player);
            this.navigation.stop();
            this.setTarget(null);
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

    public void reassessWeaponGoal() {
       if (this.level() != null && !this.level().isClientSide) {
          this.goalSelector.removeGoal(this.meleeGoal);
          this.goalSelector.removeGoal(this.bowGoal);
          ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem));
          if (itemstack.getItem() instanceof BowItem) {
             this.goalSelector.addGoal(3, this.bowGoal);
          } else {
             this.goalSelector.addGoal(3, this.meleeGoal);
          }

       }
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
	   if (weapon.getItem() instanceof BaseBlasterItem blaster && blaster.getProjectile() != BaseBlasterItem.BlasterProjectile.ARROW)
	   	blaster.getProjectile().fire(this, this.getLookAngle());
	   else {
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
          this.level().addFreshEntity(abstractarrow);
	   }
	   this.playSound(SoundEvents.BLAZE_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
    }

    protected AbstractArrow getArrow(ItemStack arrow, float velocity, @Nullable ItemStack weapon) {
        return ProjectileUtil.getMobArrow(this, arrow, velocity, weapon);
    }

   public boolean canFireProjectileWeapon(ProjectileWeaponItem p_32144_) {
      return p_32144_ instanceof BowItem;
   }

	   public boolean isBaby() {
		      return false;
		   }
	   
	public boolean canMate(Animal p_30392_) {
	            return false;
	   }
	   
	   public boolean isFood(ItemStack p_30440_) {
        return p_30440_.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "food_for/taros")));
		}
}
