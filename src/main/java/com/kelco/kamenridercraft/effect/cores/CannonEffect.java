package com.kelco.kamenridercraft.effect.cores;

import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;


public class CannonEffect extends InstantenousMobEffect {


    public CannonEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide()) {
            if (pLivingEntity.level() instanceof ServerLevel level) {
                if (pLivingEntity instanceof Player player) {
                    ItemStack stack = pLivingEntity.getItemBySlot(EquipmentSlot.FEET);
                    if (stack.getItem() instanceof RiderDriverItem belt) {
                        if ( stack.has(DataComponents.CUSTOM_DATA)) {
                            CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
                            if (tag.getDouble("use_ability") != 0  & pAmplifier != 9) {
                                Vec3 vec3 = player.getLookAngle();
                                SmallFireball smallfireball = new SmallFireball(player.level(), player, vec3.normalize());
                                smallfireball.setPos(smallfireball.getX(), player.getY(0.5) + 0.5, smallfireball.getZ());
                                player.level().addFreshEntity(smallfireball);
                                player.addEffect(new MobEffectInstance(Effect_core.CANNON, 120, 9, false, false));
                            }

                        }
                    }
                }
            }
        }
        return true;
    }
}

