package com.kelco.kamenridercraft.animation;

import com.kelco.kamenridercraft.entity.base_entities.BaseEffectEntity;
import com.kelco.kamenridercraft.util.GeneralUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;
import java.util.Objects;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.MOB_STATE;

public class AnimationInstructionData {
    public int startTick = 0;
    public int endTick = 0;

    public String effectEntityName = "";

    public String particle = "";
    public int particleAmount = 1;
    public float particleXOffset = 0F;
    public float particleYOffset = 0F;
    public float particleZOffset = 0F;
    public float particleSpeed = 1F;

    public String mobEffect = "";
    public int effectAmplifier = 0;
    public int effectDuration = 0;

    public String sound;
    public float volume = 1;
    public float pitch = 1;

    public String translatableKey = "";
    public String messageType = "";

    public String ability = "";
    public boolean triggerCost = true;


    //add ability, render layer, logic setting, and new animation info

    public void process (LivingEntity livingEntity) {
        if (livingEntity.tickCount == startTick) {
            if (!effectEntityName.isEmpty()) {
                GeneralUtil.spawnEntity(livingEntity, effectEntityName);
            }
            if (!particle.isEmpty()) {
                GeneralUtil.addParticle(livingEntity, particle, particleAmount, particleXOffset, particleYOffset, particleZOffset, particleSpeed);
            }
            if (!mobEffect.isEmpty()) {
                GeneralUtil.addEffect(livingEntity, mobEffect, effectDuration, effectAmplifier);
            }
            if (!sound.isEmpty()) {
                GeneralUtil.playSound(livingEntity, sound, volume, pitch);
            }
            if (!messageType.isEmpty() && !translatableKey.isEmpty()) {
                GeneralUtil.sendMesssage(livingEntity, messageType, translatableKey);
            }
        }
    }
}