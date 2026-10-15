package com.kelco.kamenridercraft.effects.beneficial;


import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.bosses.AnotherAgitoEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.AbstractVillager;

import java.util.Random;

import static com.kelco.kamenridercraft.effects.EffectCore.*;
import static com.kelco.kamenridercraft.item.heisei_phase_1.AgitoRiderItems.GILL_AGITO_ALTERING;
import static net.minecraft.world.effect.MobEffects.WEAVING;
import static net.minecraft.world.effect.MobEffects.WIND_CHARGED;


public class AgitoFactorEffect extends MobEffect {
    public AgitoFactorEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.level() instanceof ServerLevel level) {
            if (livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() == GILL_AGITO_ALTERING.get() && !livingEntity.hasEffect(FIRE_PUNCH)
                    && !livingEntity.hasEffect(LONG_ARM) && !livingEntity.hasEffect(ELECTRIC_PUNCH) && !livingEntity.hasEffect(WIND_CHARGED)
                    && !livingEntity.hasEffect(WEAVING)) {
                Random random = new Random();
                int randomEffect = random.nextInt(5);
                switch (randomEffect) {
                    case 0:
                        livingEntity.addEffect(new MobEffectInstance(FIRE_PUNCH, 500, 5));
                        break;
                    case 1:
                        livingEntity.addEffect(new MobEffectInstance(ELECTRIC_PUNCH, 500, 0));
                        break;
                    case 2:
                        livingEntity.addEffect(new MobEffectInstance(LONG_ARM, 500, 3));
                        break;
                    case 3:
                        livingEntity.addEffect(new MobEffectInstance(WIND_CHARGED, 500, 3));
                        break;
                    case 4:
                        livingEntity.addEffect(new MobEffectInstance(WEAVING, 500, 3));
                        break;
                }
            }
            Mob summonedAgito = null;
            if (livingEntity instanceof AbstractVillager || livingEntity instanceof Zombie || livingEntity instanceof Witch ||
                    livingEntity instanceof Pillager) {
                summonedAgito = MobsCore.GILL_AGITO.get().create(level);
            } else if (livingEntity instanceof AnotherAgitoEntity) {
                summonedAgito = MobsCore.SHINING_GILL_AGITO.get().create(level);
            }
            if (summonedAgito != null) {
                summonedAgito.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), livingEntity.getYRot(), 0.0F);
                summonedAgito.setYHeadRot(livingEntity.yHeadRot);
                summonedAgito.setXRot(livingEntity.getXRot());
                summonedAgito.setYRot(livingEntity.getYRot());
                summonedAgito.setYBodyRot(livingEntity.yBodyRot);
                summonedAgito.finalizeSpawn(level, level.getCurrentDifficultyAt(livingEntity.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
                level.addFreshEntity(summonedAgito);
                livingEntity.discard();
            }
        }
        return false;
    }
}