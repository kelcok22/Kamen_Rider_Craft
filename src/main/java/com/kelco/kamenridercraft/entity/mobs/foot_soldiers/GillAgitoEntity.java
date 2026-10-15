package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.heisei_phase_1.AgitoRiderItems;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class GillAgitoEntity extends BaseHenchmenEntity {
    public GillAgitoEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "gill_agito";
        setItemSlot(EquipmentSlot.HEAD, new ItemStack(AgitoRiderItems.AGITOHELMET.get()));
        setItemSlot(EquipmentSlot.CHEST, new ItemStack(AgitoRiderItems.AGITOCHESTPLATE.get()));
        setItemSlot(EquipmentSlot.LEGS, new ItemStack(AgitoRiderItems.AGITOLEGGINGS.get()));
        setItemSlot(EquipmentSlot.FEET, new ItemStack(AgitoRiderItems.GILL_AGITO_ALTERING.get()));
    }

    protected void addBehaviourGoals() {
        super.addBehaviourGoals();
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Pillager.class, true));
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Witch.class, true));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor Level, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType,
                                        @Nullable SpawnGroupData spawnGroupData) {
        int bossChoice = random.nextInt(5);
        switch (bossChoice) {
            case 0:
                addEffect(new MobEffectInstance(EffectCore.FIRE_PUNCH, -1, 5));
                break;
            case 1:
                addEffect(new MobEffectInstance(EffectCore.ELECTRIC_PUNCH, -1, 0));
                break;
            case 2:
                addEffect(new MobEffectInstance(EffectCore.LONG_ARM, -1, 3));
                break;
            case 3:
                addEffect(new MobEffectInstance(MobEffects.WIND_CHARGED, -1, 3));
                break;
            case 4:
                addEffect(new MobEffectInstance(MobEffects.WEAVING, -1, 3));
                break;
        }
        return super.finalizeSpawn(Level, difficultyInstance, mobSpawnType, spawnGroupData);
    }

    public boolean doHurtTarget(@NotNull Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof LivingEntity potentialAgito && potentialAgito.getHealth() < 10) {
                if (entity instanceof Zombie || entity instanceof AbstractVillager || entity instanceof Witch || entity instanceof Pillager) {
                    potentialAgito.addEffect(new MobEffectInstance(EffectCore.AGITO_FACTOR, 1, 0), this);
                }
            }
            return true;
        } else {
            return false;
        }
    }
}