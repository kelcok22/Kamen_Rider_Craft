package com.kelco.kamenridercraft.entities.projectile;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class WeaponProjectileEntity extends ThrowableItemProjectile{
	private float rotation;

	public WeaponProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}
	
	public WeaponProjectileEntity(Level pLevel) {
		super(MobsCore.WEAPON_PROJECTILE.get(), pLevel);
	}
	
	public WeaponProjectileEntity(Level pLevel, LivingEntity livingEntity) {
		super(MobsCore.WEAPON_PROJECTILE.get(), livingEntity, pLevel);
	}

	@Override
	protected Item getDefaultItem() {
		return Gaim_Rider_Items.ICHIGO_KUNAI.get();
	}
	
	protected void onHitEntity(EntityHitResult p_37404_) {
	      super.onHitEntity(p_37404_);
	      Entity entity = p_37404_.getEntity();
	      entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float)7);
	}

	protected void onHit(HitResult p_37406_) {
		super.onHit(p_37406_);
		if (!this.level().isClientSide) {
			this.level().broadcastEntityEvent(this, (byte)3);
			this.discard();
		}
	}

	protected double getDefaultGravity() {
		return 0.003;
	}
}