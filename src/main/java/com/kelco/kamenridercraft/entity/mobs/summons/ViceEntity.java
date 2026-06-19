package com.kelco.kamenridercraft.entity.mobs.summons;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.entity.mobs.allies.BaseAllyEntity;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.GiffJuniorEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ReviceRiderItems;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

import java.util.Objects;

public class ViceEntity extends BaseSummonEntity {

	public ViceEntity(EntityType<? extends ViceEntity> type, Level level) {
		super(type, level);
		NAME="vice";
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ReviceRiderItems.REVICE_HELMET.get()));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ReviceRiderItems.REVICE_CHESTPLATE.get()));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ReviceRiderItems.REVICE_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ReviceRiderItems.BUDDY_BUCKLE.get()));
	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
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
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, GiffJuniorEntity.class, false));
      	this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, true));

	}

	public void aiStep() {
		super.aiStep();

		if ( this.getOwner() instanceof Player owner && owner.getItemBySlot(EquipmentSlot.FEET).getItem()== ReviceRiderItems.REVICE_DRIVER.get()) {
			if (!Objects.equals(RiderDriverItem.getFormItem(owner.getItemBySlot(EquipmentSlot.FEET), 1).getFormName(false), RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1).getFormName(false))
			|| (RiderDriverItem.getFormItem(owner.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.BARID_REX_VISTAMP.get() && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) != ReviceRiderItems.BARID_REX_VISTAMP_VICE.get())
			|| (RiderDriverItem.getFormItem(owner.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.VOLCANO_VISTAMP.get() && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) != ReviceRiderItems.VOLCANO_VISTAMP_VICE.get())) {
				this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ReviceRiderItems.BUDDY_BUCKLE.get()));
				switch (RiderDriverItem.getFormItem(owner.getItemBySlot(EquipmentSlot.FEET), 1).getFormName(false)) {
	        	    case "":
						RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.REX_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_eagle":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.EAGLE_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_mammoth":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.MAMMOTH_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_megalodon":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.MEGALODON_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_lion":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.LION_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_jackal":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.JACKAL_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_kong":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.KONG_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_kamakiri":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.KAMAKIRI_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_brachio":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.BRACHIO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_neo_batta":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.NEO_BATTA_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_kangaroo":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.KANGAROO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_kirin":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.KIRIN_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_niwatori":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.NIWATORI_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_funkorogashi":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.FUNKOROGASHI_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_condor":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.CONDOR_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_white_leo":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.WHITE_LEO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_barid_rex":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.BARID_REX_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_volcano_rex":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.VOLCANO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_ultimate":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.GIFFARD_REX_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    case "_gold_spino":
					    RiderDriverItem.setFormItem(this.getItemBySlot(EquipmentSlot.FEET), ReviceRiderItems.GOLD_SPINO_VISTAMP_VICE.get(), 1);
	        	        break;
	        	    default:
						owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.7f, 0.9f), 4f), this.getX(), this.getY()+0.5, this.getZ(), 0.0D, 0.0D, 0.0D);
						owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.7f, 0.9f), 4f), this.getX(), this.getY()+1.0, this.getZ(), 0.0D, 0.0D, 0.0D);
						owner.level().addParticle(new DustParticleOptions(new Vector3f(0.4f, 0.7f, 0.9f), 4f), this.getX(), this.getY()+1.5, this.getZ(), 0.0D, 0.0D, 0.0D);
						this.discard();
	        	        break;
	        	}
				if (RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) != ReviceRiderItems.JACKAL_VISTAMP_VICE.get()) this.ejectPassengers();
				this.setItemSlot(EquipmentSlot.OFFHAND, (RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.BARID_REX_VISTAMP_VICE.get()
					|| RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.VOLCANO_VISTAMP_VICE.get()) ? new ItemStack(ReviceRiderItems.BARID_SHIELD.get()) : ItemStack.EMPTY);
			}
		}
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.JACKAL_VISTAMP_VICE.get()
		||RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.NIWATORI_VISTAMP_VICE.get()) {
            player.setYRot(this.getYRot());
            player.setXRot(this.getXRot());
			player.startRiding(this);
		}

		return super.mobInteract(player, hand);
	}

	@Override
    public boolean shouldRiderSit() {
		return !(this.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem && RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.JACKAL_VISTAMP_VICE.get());
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

        return new Vec3(f, 0.0, f1);
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
			if (RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.JACKAL_VISTAMP_VICE.get()) {
				return super.getPassengerAttachmentPoint(entity, dimensions, partialTick)
        	    .add(
        	        new Vec3(0.0, -1.0 * (double)partialTick, 0)
        	            .yRot(-this.getYRot() * (float) (Math.PI / 180.0))
        	    );
			} else if (RiderDriverItem.getFormItem(this.getItemBySlot(EquipmentSlot.FEET), 1) == ReviceRiderItems.NIWATORI_VISTAMP_VICE.get()) {
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

}