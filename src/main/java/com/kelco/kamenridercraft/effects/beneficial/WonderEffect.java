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
import net.minecraft.world.item.ItemStack;

public class WonderEffect extends InstantenousMobEffect {


    public WonderEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide() && livingEntity instanceof Player player) {
            ItemStack stack = livingEntity.getItemBySlot(EquipmentSlot.FEET);
            if (stack.getItem() instanceof RiderDriverItem && stack.has(DataComponents.CUSTOM_DATA)) {
                CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
                if (tag.getDouble("use_ability") != 0 & amplifier != 2) {
                    int small = 0;
                    int big = 0;
                    if (player.hasEffect(EffectCore.SMALL))
                        small = player.getEffect(EffectCore.SMALL).getAmplifier();
                    if (player.hasEffect(EffectCore.BIG))
                        big = player.getEffect(EffectCore.BIG).getAmplifier();
                    if (player.isShiftKeyDown()) {
                        big = big - 1;
                        small = small + 1;
                    } else {
                        big = big + 1;
                        small = small - 1;
                    }
                    player.removeEffect(EffectCore.SMALL);
                    player.removeEffect(EffectCore.BIG);

                    if (big > -1)
                        player.addEffect(new MobEffectInstance(EffectCore.BIG, 120, big, false, false));
                    if (small > -1)
                        player.addEffect(new MobEffectInstance(EffectCore.SMALL, 120, small, false, false));
                    player.addEffect(new MobEffectInstance(EffectCore.WONDER, 10, 2, false, false));
                }
            }
        }
        return true;
    }
}