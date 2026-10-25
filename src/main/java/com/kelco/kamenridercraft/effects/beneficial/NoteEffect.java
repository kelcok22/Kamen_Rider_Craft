package com.kelco.kamenridercraft.effects.beneficial;

import com.kelco.kamenridercraft.sounds.ModMusic;
import com.kelco.kamenridercraft.sounds.ModSounds;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;

public class NoteEffect extends MobEffect {


    public NoteEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Random rand = new Random();
        //livingEntity.level().playLocalSound(livingEntity, SoundEvents.UI_BUTTON_CLICK, SoundSource.RECORDS, 1, rand.nextInt(10));
        livingEntity.level().playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.NOTE_BLOCK_DIDGERIDOO, SoundSource.PLAYERS, 1.0F, rand.nextInt(10));

        if (livingEntity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() + rand.nextFloat(.3F), livingEntity.getEyeY(), livingEntity.getZ() + rand.nextFloat(.4F), 1, 0, 0, 0, 0.1);
            serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() + rand.nextFloat(.5F), livingEntity.getEyeY(), livingEntity.getZ() - rand.nextFloat(.8F), 1, 0, 0, 0, 0.1);
            serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() - rand.nextFloat(.7F), livingEntity.getEyeY(), livingEntity.getZ() + rand.nextFloat(.9F), 1, 0, 0, 0, 0.1);
        }
        return true;
    }
}