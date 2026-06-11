package com.kelco.kamenridercraft.effects.beneficial;

import com.kelco.kamenridercraft.sounds.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;

public class NoteEffect extends InstantenousMobEffect {


    public NoteEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Random rand = new Random();
        livingEntity.level().playLocalSound(livingEntity, ModSounds.MASKED_RIDER.get(), SoundSource.RECORDS, 1, rand.nextInt(10));

        if (livingEntity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() + rand.nextFloat(.3F), livingEntity.getEyeY(), livingEntity.getZ() + rand.nextFloat(.4F), 1, 0, 0, 0, 0.1);
            serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() + rand.nextFloat(.5F), livingEntity.getEyeY(), livingEntity.getZ() - rand.nextFloat(.8F), 1, 0, 0, 0, 0.1);
            serverLevel.sendParticles(ParticleTypes.NOTE, livingEntity.getX() - rand.nextFloat(.7F), livingEntity.getEyeY(), livingEntity.getZ() + rand.nextFloat(.9F), 1, 0, 0, 0, 0.1);
        }
        return true;
    }
}