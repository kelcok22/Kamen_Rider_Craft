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


public class WonderEffect extends InstantenousMobEffect {


    public WonderEffect(MobEffectCategory mobEffectCategory, int color) {
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
                            if (tag.getDouble("use_ability") != 0& pAmplifier != 2) {
                                int small= 0;
                                int big= 0;
                                if (player.hasEffect(Effect_core.SMALL))small=player.getEffect(Effect_core.SMALL).getAmplifier();
                                if (player.hasEffect(Effect_core.BIG))big=player.getEffect(Effect_core.BIG).getAmplifier();
                                if (player.isShiftKeyDown()){
                                    big= big-1;
                                    small=small+1;
                                }else {
                                    big= big+1;
                                    small=small-1;
                                }
                                player.removeEffect(Effect_core.SMALL);
                                player.removeEffect(Effect_core.BIG);

                                if (big>-1)player.addEffect(new MobEffectInstance(Effect_core.BIG, 120, big, false, false));
                                if (small>-1)player.addEffect(new MobEffectInstance(Effect_core.SMALL, 120, small, false, false));
                                player.addEffect(new MobEffectInstance(Effect_core.WONDER, 10, 2, false, false));
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

