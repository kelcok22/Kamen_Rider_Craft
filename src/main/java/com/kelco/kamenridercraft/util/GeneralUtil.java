package com.kelco.kamenridercraft.util;

import com.kelco.kamenridercraft.entity.base_entities.BaseEffectEntity;
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

public class GeneralUtil {
    public static void spawnEntity(LivingEntity livingEntity, String effectEntityName) {
        BaseEffectEntity effectEntity = new BaseEffectEntity(livingEntity.level(), 32, livingEntity);
        effectEntity.setData(MOB_STATE, effectEntityName);
        effectEntity.setEntity();
        effectEntity.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 0, 0.0F);
        livingEntity.level().addFreshEntity(effectEntity);
    }

    public static void addParticle(LivingEntity livingEntity, String particle, int particleAmount, float particleXOffset, float particleYOffset,
                                   float particleZOffset, float particleSpeed) {
        if (BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.parse(particle)) != null && livingEntity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(Objects.requireNonNull((SimpleParticleType) BuiltInRegistries.PARTICLE_TYPE
                            .get(ResourceLocation.parse(particle))),
                    livingEntity.getX(), livingEntity.getY(),
                    livingEntity.getZ(), particleAmount, particleXOffset, particleYOffset, particleZOffset, particleSpeed);
        }
    }

    public static void addEffect(LivingEntity livingEntity, String mobEffect, int effectDuration, int effectAmplifier) {
        if (BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(mobEffect)) != null) {
            Holder<MobEffect> holder = BuiltInRegistries.MOB_EFFECT.wrapAsHolder(
                    Objects.requireNonNull(BuiltInRegistries.MOB_EFFECT.get(ResourceLocation.parse(mobEffect))));
            livingEntity.addEffect(new MobEffectInstance(holder, effectDuration, effectAmplifier, true, false));
        }
    }

    public static void playSound(LivingEntity livingEntity, String sound, float volume, float pitch) {
        if (livingEntity.level() instanceof ServerLevel serverLevel && BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse(sound)) != null) {
            SoundEvent soundEvent = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse(sound));
            serverLevel.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), soundEvent, SoundSource.PLAYERS, volume, pitch);
        }
    }

    public static void sendMessage(LivingEntity sender, String messageType, String translatableKey) {
        List<ServerPlayer> nearbyPlayers = sender.level().getEntitiesOfClass(ServerPlayer.class, sender.getBoundingBox().inflate(10));
        switch (messageType.toLowerCase()) {
            case "client_chat":
                if (sender instanceof ServerPlayer player) {
                    player.displayClientMessage(Component.translatable(translatableKey), false);
                }
                break;
            case "actionbar":
                if (sender instanceof ServerPlayer player) {
                    player.displayClientMessage(Component.translatable(translatableKey), true);
                }
                break;
            case "as_user":
                sender.getServer().getPlayerList().broadcastSystemMessage(
                        Component.literal("<").append(sender.getName()).append(Component.literal("> "))
                                .append(Component.translatable(translatableKey)), false);
                break;
            case "vicinity_chat":
                for (ServerPlayer player : nearbyPlayers) {
                    player.displayClientMessage(Component.translatable(translatableKey), false);
                }
                break;
            case "vicinity_actionbar":
                for (ServerPlayer nearbyPlayer : nearbyPlayers) {
                    nearbyPlayer.displayClientMessage(Component.translatable(translatableKey), true);
                }
                break;
            case "vicinity_actionbar_as_user":
                for (ServerPlayer nearbyPlayer : nearbyPlayers) {
                    nearbyPlayer.displayClientMessage(Component.literal("<").append(sender.getName()).append(Component.literal("> ")).
                            append(Component.translatable(translatableKey)), true);
                }
                break;
            case "vicinity_chat_as_user":
                for (ServerPlayer nearbyPlayer : nearbyPlayers) {
                    nearbyPlayer.displayClientMessage(Component.literal("<").append(sender.getName()).append(Component.literal("> ")).
                            append(Component.translatable(translatableKey)), false);
                }
                break;
            case "global":
                sender.getServer().getPlayerList().broadcastSystemMessage(Component.translatable(translatableKey), false);
                break;
        }
    }
}
