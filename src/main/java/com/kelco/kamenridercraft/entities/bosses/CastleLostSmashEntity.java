package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class CastleLostSmashEntity extends BaseHenchmenEntity {

    public CastleLostSmashEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
            NAME="castle_lost_smash";
        }


        public static AttributeSupplier.Builder setAttributes() {

            return Monster.createMonsterAttributes()
                    .add(Attributes.FOLLOW_RANGE, 35.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.2F)
                    .add(Attributes.ATTACK_DAMAGE, 10.0D)
                    .add(Attributes.ARMOR, 5.0D)
                    .add(Attributes.MAX_HEALTH, 80.0D);
        }
    }
