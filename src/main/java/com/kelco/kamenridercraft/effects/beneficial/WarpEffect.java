package com.kelco.kamenridercraft.effects.beneficial;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.ItemStack;

public class WarpEffect extends InstantenousMobEffect {


    public WarpEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide() && livingEntity instanceof Player player) {
            ItemStack stack = livingEntity.getItemBySlot(EquipmentSlot.FEET);
            if (stack.getItem() instanceof RiderDriverItem) {
                if (stack.has(DataComponents.CUSTOM_DATA)) {
                    CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
                    if (tag.getDouble("use_ability") != 0 & amplifier != 9) {
                        ThrownEnderpearl pearl = new ThrownEnderpearl(player.level(), player);
                        pearl.setPos(pearl.getX(), player.getY(0.5D) + 0.5D, pearl.getZ());
                        pearl.addDeltaMovement(player.getLookAngle().scale(3));
                        player.level().addFreshEntity(pearl);
                        player.addEffect(new MobEffectInstance(EffectCore.WARP, 120, 9, false, false));
                    }
                }
            }
        }
        return true;
    }
}