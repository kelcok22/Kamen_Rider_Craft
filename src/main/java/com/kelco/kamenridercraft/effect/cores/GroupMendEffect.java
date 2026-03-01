package com.kelco.kamenridercraft.effect.cores;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;

import java.util.List;
import java.util.Random;


public class GroupMendEffect extends InstantenousMobEffect {


    public GroupMendEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Random rand = new Random();
        if ((pAmplifier < 50 ? rand.nextInt(500 - (pAmplifier * 10)) : 0) == 0) {
            if (!pLivingEntity.level().isClientSide() && pLivingEntity.level() instanceof ServerLevel level && pLivingEntity instanceof Player player) {
                List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(5), entity -> (entity instanceof Player && entity != player) || (entity instanceof Mob));
                for (LivingEntity buddy : nearbyEntities) {
                    if (!(buddy instanceof ArmorStand)) {
                        if (buddy instanceof Player || buddy.isAlliedTo(player)) {
                            buddy.getItemBySlot(EquipmentSlot.HEAD).setDamageValue(buddy.getItemBySlot(EquipmentSlot.HEAD).getDamageValue() - 1);
                            buddy.getItemBySlot(EquipmentSlot.CHEST).setDamageValue(buddy.getItemBySlot(EquipmentSlot.CHEST).getDamageValue() - 1);
                            buddy.getItemBySlot(EquipmentSlot.LEGS).setDamageValue(buddy.getItemBySlot(EquipmentSlot.LEGS).getDamageValue() - 1);
                            buddy.getItemBySlot(EquipmentSlot.FEET).setDamageValue(buddy.getItemBySlot(EquipmentSlot.FEET).getDamageValue() - 1);
                            buddy.getItemBySlot(EquipmentSlot.MAINHAND).setDamageValue(buddy.getItemBySlot(EquipmentSlot.MAINHAND).getDamageValue() - 1);
                            buddy.getItemBySlot(EquipmentSlot.OFFHAND).setDamageValue(buddy.getItemBySlot(EquipmentSlot.OFFHAND).getDamageValue() - 1);
                        }
                    }
                }
            }
        }
        return true;
    }
}


