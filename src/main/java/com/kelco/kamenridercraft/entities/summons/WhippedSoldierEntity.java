package com.kelco.kamenridercraft.entities.summons;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.entities.variants.WhippedSoldierVariant;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
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
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;

public class WhippedSoldierEntity extends BaseSummonEntity {

    private static final EntityDataAccessor<Integer> VARIANT =
        SynchedEntityData.defineId(WhippedSoldierEntity.class, EntityDataSerializers.INT);
		private ItemStack ABSORBED_GOCHIZO = ItemStack.EMPTY;

	public WhippedSoldierEntity(EntityType<? extends WhippedSoldierEntity> type, Level level) {
		super(type, level);
		NAME="whipped_soldier";
        this.setVariant(WhippedSoldierVariant.NORMAL);
		this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Gavv_Rider_Items.WHIPPED_ROD.get()));
        this.reassessWeaponGoal();
		this.addRequiredForm((RiderFormChangeItem)Gavv_Rider_Items.CAKING_GOCHIZO.get(), 1);
		this.addRequiredForm((RiderFormChangeItem)Gavv_Rider_Items.BLIZZARDSORBEI_GOCHIZO.get(), 1);
	}

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT,0);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public WhippedSoldierVariant getVariant() {
        return WhippedSoldierVariant.byId(this.getTypeVariant() & 255);
    }

    public void setVariant(WhippedSoldierVariant variant) {
        this.entityData.set(VARIANT, variant.getId() & 255);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(VARIANT, compound.getInt("Variant"));
    }
	

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, -10.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 5.0F, 2.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, 5, false, false, (p_28879_) -> {
			if (isTame()) {
        		if (p_28879_ instanceof Creeper || p_28879_ instanceof Ghast) {
        		    if (this.getMainHandItem().getItem() instanceof BowItem) {
        		    	return !(this.getMainHandItem().getItem() instanceof SwordItem
        		    	|| this.getMainHandItem().is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "arsenal/all_swordguns")))) || !this.getMeleeOnly();
					}
					return false;
				}
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

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (this.isTame() && this.isOwnedBy(player) && this.getVariant() == WhippedSoldierVariant.NORMAL) {
			if (!this.level().isClientSide()) {
				if (itemstack.is(Gavv_Rider_Items.ZAKUZAKUCHIPS_GOCHIZO.get())) {
					player.displayClientMessage(Component.translatable("attack.kamenridercraft.zaku_decoration"), true);
					this.setVariant(WhippedSoldierVariant.ZAKU);
					this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Gavv_Rider_Items.ZAKUZAKUCHIPSLASHER.get()));
					this.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(Gavv_Rider_Items.ZAKUZAKUCHIPSLASHER.get()));
					if (!player.isCreative()) {
						this.ABSORBED_GOCHIZO = itemstack.copyWithCount(1);
						itemstack.shrink(1);
					}
				} else if (itemstack.is(Gavv_Rider_Items.CHOCODAN_GOCHIZO.get())) {
					player.displayClientMessage(Component.translatable("attack.kamenridercraft.choco_decoration"), true);
					this.setVariant(WhippedSoldierVariant.CHOCO);
					this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Gavv_Rider_Items.CHOCODANGUN.get()));
					this.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
					if (!player.isCreative()) {
						this.ABSORBED_GOCHIZO = itemstack.copyWithCount(1);
						itemstack.shrink(1);
					}
				}
			}
			return InteractionResult.SUCCESS;
		}
		return super.mobInteract(player, hand);
	}
   
	@Override
	public void despawn() {
		if (!this.ABSORBED_GOCHIZO.isEmpty() && !this.level().isClientSide()) this.spawnAtLocation(this.ABSORBED_GOCHIZO);
		super.despawn();
	}
   
	@Override
	public void die(DamageSource p_21809_) {
		if (!this.ABSORBED_GOCHIZO.isEmpty() && !this.level().isClientSide()) this.spawnAtLocation(this.ABSORBED_GOCHIZO);
		super.die(p_21809_);
	}
}