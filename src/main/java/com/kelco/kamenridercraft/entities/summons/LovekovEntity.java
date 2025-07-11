package com.kelco.kamenridercraft.entities.summons;

import org.joml.Vector3f;

import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class LovekovEntity extends BaseSummonEntity {

	public LovekovEntity(EntityType<? extends LovekovEntity> type, Level level) {
		super(type, level);
		NAME="lovekov";
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Revice_Rider_Items.REVICE_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Revice_Rider_Items.REVICE_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Revice_Rider_Items.REVICE_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Revice_Rider_Items.LOVEKOV_BELT.get()));
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Creeper.class, 24.0F, 1.5D, 1.5D));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
	}

	@Override
    public boolean shouldTryTeleportToOwner() {
        LivingEntity livingentity = this.getOwner();
        return livingentity != null && this.distanceToSqr(this.getOwner()) >= 256.0;
    }

	public void aiStep() {
		super.aiStep();

		if (this.getOwner() instanceof Player owner && (!(owner.getItemBySlot(EquipmentSlot.FEET).getItem()==Revice_Rider_Items.LIBERA_DRIVER.get())
		|| RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.KING_COBRA_VISTAMP.get()
		|| (owner.isHolding(Revice_Rider_Items.LOVEKOV_KUJAKU.get()) || owner.isHolding(Revice_Rider_Items.LOVEKOV_TURTLE.get()) || owner.isHolding(Revice_Rider_Items.LOVEKOV_HASHIBIROKO.get()) || owner.isHolding(Revice_Rider_Items.LOVEKOV_TRICERA.get())))) {
			owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.6f, 0.9f), 4f), this.getX(), this.getY()+0.5, this.getZ(), 0.0D, 0.0D, 0.0D);
			owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.6f, 0.9f), 4f), this.getX(), this.getY()+1.0, this.getZ(), 0.0D, 0.0D, 0.0D);
			owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.6f, 0.9f), 4f), this.getX(), this.getY()+1.5, this.getZ(), 0.0D, 0.0D, 0.0D);
			this.discard();
		}
	}


	@Override
	public void setTame(boolean p_30443_, boolean p_30444_) {
		super.setTame(p_30443_, p_30444_);
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
		this.setHealth(20.0F);
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
}