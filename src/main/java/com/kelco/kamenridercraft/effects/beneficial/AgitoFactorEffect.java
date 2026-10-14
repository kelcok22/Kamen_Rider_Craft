package com.kelco.kamenridercraft.effects.beneficial;


import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.bosses.AnotherAgitoEntity;
import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.GillAgitoEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.npc.Villager;

import java.util.Random;


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
        if (!livingEntity.level().isClientSide()) {
            Random random = new Random();
            int bossChoice = random.nextInt(5);
            switch (bossChoice) {
                case 0:
                    livingEntity.addEffect(new MobEffectInstance(EffectCore.FIRE_PUNCH,500,5));
                    break;
                case 1:
                    livingEntity.addEffect(new MobEffectInstance(EffectCore.THUNDER_PUNCH,500,0));
                    break;
                case 2:
                    livingEntity.addEffect(new MobEffectInstance(EffectCore.LONG_ARM,500,3));
                    break;
                case 3:
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WIND_CHARGED,500,3));
                    break;
                case 4:
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAVING,500,3));
                    break;
            }
            if (livingEntity.level() instanceof ServerLevel level) {
                if (livingEntity instanceof Villager) {
                    GillAgitoEntity boss = MobsCore.GILL_AGITO.get().create(level);
                    boss.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), livingEntity.getYRot(), 0.0F);
                    boss.setYHeadRot(livingEntity.yHeadRot);
                    boss.setXRot(livingEntity.getXRot());
                    boss.setYRot(livingEntity.getYRot());
                    boss.setYBodyRot(livingEntity.yBodyRot);
                    boss.finalizeSpawn(level, level.getCurrentDifficultyAt(livingEntity.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
                    level.addFreshEntity(boss);
                    livingEntity.discard();
                } else  if (livingEntity instanceof AnotherAgitoEntity) {
                    LivingEntity boss = MobsCore.SHINING_GILL_AGITO.get().create(level);
                    boss.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), livingEntity.getYRot(), 0.0F);
                    boss.setYHeadRot(livingEntity.yHeadRot);
                    boss.setXRot(livingEntity.getXRot());
                    boss.setYRot(livingEntity.getYRot());
                    boss.setYBodyRot(livingEntity.yBodyRot);
                    level.addFreshEntity(boss);
                    livingEntity.discard();
                }
            }
        }
        return false;
    }
}