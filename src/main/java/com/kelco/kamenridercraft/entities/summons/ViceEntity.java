package com.kelco.kamenridercraft.entities.summons;

import org.joml.Vector3f;

import com.kelco.kamenridercraft.entities.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.entities.footSoldiers.GiffJuniorEntity;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ViceEntity extends BaseSummonEntity {

	public ViceEntity(EntityType<? extends ViceEntity> type, Level level) {
		super(type, level);
		NAME="vice";
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Revice_Rider_Items.REVICE_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Revice_Rider_Items.REVICE_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Revice_Rider_Items.REVICE_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Revice_Rider_Items.BUDDY_BUCKLE.get()));
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Creeper.class, 24.0F, 1.5D, 1.5D));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 5.0F, 2.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, BaseAllyEntity.class, BaseSummonEntity.class)).setAlertOthers());
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, 5, false, false, (p_28879_) -> {
			if (isTame()) {
				return p_28879_ instanceof Enemy && !(p_28879_ instanceof NeutralMob neutral && !neutral.isAngry());
			}else return false;
		}));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, GiffJuniorEntity.class, false));
      	this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, true));

	}

	public void aiStep() {
		super.aiStep();

		if ( this.getOwner() instanceof Player owner && owner.getItemBySlot(EquipmentSlot.FEET).getItem()==Revice_Rider_Items.REVICE_DRIVER.get()) {
			if (RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1).getFormName(false) != RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1).getFormName(false)
			|| (RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.BARID_REX_VISTAMP.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) != Revice_Rider_Items.BARID_REX_VISTAMP_VICE.get())
			|| (RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.VOLCANO_VISTAMP.get() && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) != Revice_Rider_Items.VOLCANO_VISTAMP_VICE.get())) {
	        	switch (RiderDriverItem.get_Form_Item(owner.getItemBySlot(EquipmentSlot.FEET), 1).getFormName(false)) {
	        	    case "":
						RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.REX_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_eagle":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.EAGLE_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_mammoth":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.MAMMOTH_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_megalodon":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.MEGALODON_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_lion":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.LION_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_jackal":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.JACKAL_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_kong":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.KONG_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_kamakiri":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.KAMAKIRI_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_brachio":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.BRACHIO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_neo_batta":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.NEO_BATTA_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_kangaroo":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.KANGAROO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_kirin":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.KIRIN_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_niwatori":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.NIWATORI_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_funkorogashi":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.FUNKOROGASHI_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_condor":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.CONDOR_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_white_leo":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.WHITE_LEO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_barid_rex":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.BARID_REX_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_volcano_rex":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.VOLCANO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_ultimate":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.GIFFARD_REX_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_gold_spino":
					    RiderDriverItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), Revice_Rider_Items.GOLD_SPINO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    default:
						owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.7f, 0.9f), 4f), this.getX(), this.getY()+0.5, this.getZ(), 0.0D, 0.0D, 0.0D);
						owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.7f, 0.9f), 4f), this.getX(), this.getY()+1.0, this.getZ(), 0.0D, 0.0D, 0.0D);
						owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.7f, 0.9f), 4f), this.getX(), this.getY()+1.5, this.getZ(), 0.0D, 0.0D, 0.0D);
						this.discard();
	        	        break;
	        	}
				if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) != Revice_Rider_Items.JACKAL_VISTAMP_VICE.get()) this.ejectPassengers();
				this.setItemSlot(EquipmentSlot.OFFHAND, (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.BARID_REX_VISTAMP_VICE.get()
					|| RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.VOLCANO_VISTAMP_VICE.get()) ? new ItemStack(Revice_Rider_Items.BARID_SHIELD.get()) : ItemStack.EMPTY);
			}
		}
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.JACKAL_VISTAMP_VICE.get()
		||RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.NIWATORI_VISTAMP_VICE.get()) {
            player.setYRot(this.getYRot());
            player.setXRot(this.getXRot());
			player.startRiding(this);
		}

		return super.mobInteract(player, hand);
	}

	@Override
    public boolean shouldRiderSit() {
		return !(this.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem && RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.JACKAL_VISTAMP_VICE.get());
	}
    
	@Override
	public boolean canRiderInteract() {
        return false;
    }

    @Override
    protected void tickRidden(Player player, Vec3 travelVector) {
        super.tickRidden(player, travelVector);
        Vec2 vec2 = this.getRiddenRotation(player);
        this.setRot(vec2.y, vec2.x);
        this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
    }

    protected Vec2 getRiddenRotation(LivingEntity entity) {
        return new Vec2(entity.getXRot() * 0.5F, entity.getYRot());
    }

    @Override
    protected Vec3 getRiddenInput(Player player, Vec3 travelVector) {
        float f = player.xxa * 0.5F;
        float f1 = player.zza;
        if (f1 <= 0.0F) {
            f1 *= 0.25F;
        }

        return new Vec3((double)f, 0.0, (double)f1);
    }

    @Override
    protected float getRiddenSpeed(Player player) {
        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED);
    }

    @Override
    public LivingEntity getControllingPassenger() {
        return getFirstPassenger() instanceof Player player ? player : super.getControllingPassenger();
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
        if (this.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
			if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.JACKAL_VISTAMP_VICE.get()) {
				return super.getPassengerAttachmentPoint(entity, dimensions, partialTick)
        	    .add(
        	        new Vec3(0.0, -1.0 * (double)partialTick, 0)
        	            .yRot(-this.getYRot() * (float) (Math.PI / 180.0))
        	    );
			} else if (RiderDriverItem.get_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), 1) == Revice_Rider_Items.NIWATORI_VISTAMP_VICE.get()) {
				return super.getPassengerAttachmentPoint(entity, dimensions, partialTick)
        	    .add(
        	        new Vec3(0.0, -0.45 * (double)partialTick, -0.5)
        	            .yRot(-this.getYRot() * (float) (Math.PI / 180.0))
        	    );
			}
		}
        return super.getPassengerAttachmentPoint(entity, dimensions, partialTick);
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