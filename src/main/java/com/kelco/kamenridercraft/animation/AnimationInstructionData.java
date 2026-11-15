package com.kelco.kamenridercraft.animation;

import com.kelco.kamenridercraft.util.GeneralUtil;
import net.minecraft.world.entity.LivingEntity;

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
                GeneralUtil.sendMessage(livingEntity, messageType, translatableKey);
            }
        }
    }
}