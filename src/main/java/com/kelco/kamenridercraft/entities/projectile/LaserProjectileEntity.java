package com.kelco.kamenridercraft.entities.projectile;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.item.Miscellaneous_Rider_Items;
import com.sun.jna.WString;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.Level;

public class LaserProjectileEntity extends AbstractArrow {
    public Vec2 groundedOffset;
    public int damageModifier = 0;

    public LaserProjectileEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public LaserProjectileEntity(LivingEntity shooter, Level level) {
        super(MobsCore.LASER_PROJECTILE.get(), shooter, level, new ItemStack(Items.APPLE), new ItemStack(Items.BOW));

    }

    public boolean isGrounded() {return inGround;};

    public int setDamageModifier(int mod) {
        damageModifier = damageModifier + mod;
        return damageModifier;
    }

    public String setColorModifier(String mod) { return mod.toLowerCase();}

    @Override
    protected void onHitEntity(EntityHitResult result){
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().arrow(this, this.getOwner()), (4 + damageModifier));
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return null;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.discard();
    }
}
