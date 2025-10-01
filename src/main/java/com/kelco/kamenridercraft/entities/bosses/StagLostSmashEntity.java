package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.MobsCore;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class StagLostSmashEntity extends BaseHenchmenEntity {

    public StagLostSmashEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
            NAME="stag_lost_smash";
        }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {

        BaseHenchmenEntity boss = MobsCore.OWL_LOST_SMASH.get().create(this.level());
        BaseHenchmenEntity boss2 = MobsCore.CASTLE_LOST_SMASH.get().create(this.level());
        if (boss != null) {
            boss.moveTo(this.getX(), this.getY(), this.getZ()-1, this.getYRot(), 0.0F);
            this.level().addFreshEntity(boss);
        }
        if (boss2 != null) {
            boss2.moveTo(this.getX(), this.getY(), this.getZ()+1, this.getYRot(), 0.0F);
            this.level().addFreshEntity(boss2);
        }
        spawnGroupData =  super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        return spawnGroupData;
    }

        public static AttributeSupplier.Builder setAttributes() {

            return Monster.createMonsterAttributes()
                    .add(Attributes.FOLLOW_RANGE, 35.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.2F)
                    .add(Attributes.ATTACK_DAMAGE, 12.0D)
                    .add(Attributes.ARMOR, 4.0D)
                    .add(Attributes.MAX_HEALTH, 80.0D);
        }
    }
