package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.item.heisei_phase_1.AgitoRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.KabutoRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_1.RyukiRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import com.kelco.kamenridercraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

import static com.kelco.kamenridercraft.util.MiscUtil.canSpawnBoss;

public class GillAgitoEntity extends BaseHenchmenEntity {

    public GillAgitoEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "gill_agito";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(AgitoRiderItems.AGITOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(AgitoRiderItems.AGITOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(AgitoRiderItems.AGITOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(AgitoRiderItems.GILL_AGITO_ALTERING.get()));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor Level, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData) {
        int bossChoice = random.nextInt(5);
        switch (bossChoice) {
            case 0:
              addEffect(new MobEffectInstance(EffectCore.FIRE_PUNCH,-1,5));
                break;
            case 1:
                addEffect(new MobEffectInstance(EffectCore.THUNDER_PUNCH,-1,0));
                break;
            case 2:
                addEffect(new MobEffectInstance(EffectCore.LONG_ARM,-1,3));
                break;
            case 3:
                addEffect(new MobEffectInstance(MobEffects.WIND_CHARGED,-1,3));
                break;
            case 4:
                addEffect(new MobEffectInstance(MobEffects.WEAVING,-1,3));
                break;
        }
        return super.finalizeSpawn(Level, difficultyInstance, mobSpawnType,spawnGroupData);
    }

}