package com.kelco.kamenridercraft.entity.mobs.allies;


import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BattaAugmentEntity;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.ShockerCombatmanEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.BaseSummonEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.showa.IchigoRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class TojimaTakoyakiEntity extends BaseAllyEntity {

	public TojimaTakoyakiEntity(EntityType<? extends TojimaTakoyakiEntity> entityType, Level level) {
		super(entityType, level);
		NAME = "rider_summon";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(IchigoRiderItems.ICHIGOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(IchigoRiderItems.ICHIGOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(IchigoRiderItems.ICHIGOLEGGINGS.get()));
        ItemStack belt = new ItemStack(IchigoRiderItems.TYPHOON_ICHIGO.get());
        RiderDriverItem.setFormItem(belt, IchigoRiderItems.TAKOYAKI_TYPHOON_CORE.get(), 1);
        this.setItemSlot(EquipmentSlot.FEET,belt);
		this.setPersistenceRequired();
		
		}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, -10.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new AllyPanicGoal(1.4D));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 5.0F, 2.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (p_28879_) -> {
			if (isTame()) {
        		if (p_28879_ instanceof Creeper || p_28879_ instanceof Ghast) {
					return this.getMainHandItem().getItem() instanceof BowItem;
				}
				return p_28879_ instanceof Enemy && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			}else return false;
		}));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ShockerCombatmanEntity.class, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, BattaAugmentEntity.class, false));
		this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

	}

    public boolean canMate(Animal p_30392_) {
	            return false;
	   }
}
