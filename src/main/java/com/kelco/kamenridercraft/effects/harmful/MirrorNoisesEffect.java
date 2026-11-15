package com.kelco.kamenridercraft.effects.harmful;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.heisei_phase_1.AgitoRiderItems;
import com.kelco.kamenridercraft.sounds.ModSounds;
import com.kelco.kamenridercraft.util.MiscUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

import static com.kelco.kamenridercraft.effects.EffectCore.MIRROR_NOISES;


public class MirrorNoisesEffect extends MobEffect {
    public MirrorNoisesEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.getEffect(MIRROR_NOISES).getDuration() > 200) {
            livingEntity.level().playLocalSound(livingEntity, ModSounds.MIRROR_NOISES.get(), SoundSource.RECORDS, 1, new Random().nextInt(10));
        }
        if (livingEntity.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() != Difficulty.PEACEFUL
                && (livingEntity.getEffect(MIRROR_NOISES).getDuration() < 2)) {
            BaseHenchmenEntity boss = MobsCore.MIRROR_RIDER.get().create(livingEntity.level());
            if (livingEntity.hasEffect(EffectCore.AGITO_FACTOR)) {
                boss.setItemSlot(EquipmentSlot.FEET, new ItemStack(AgitoRiderItems.ALTERING_MIRACLE_WORLD.asItem()));
            }
            MiscUtil.spawnEnemy(livingEntity, boss, 10);
            livingEntity.removeEffect(MIRROR_NOISES);
        }
        return true;
    }
}