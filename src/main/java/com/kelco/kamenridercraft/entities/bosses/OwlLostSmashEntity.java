package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.ai.FlyingBossControl;
import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class OwlLostSmashEntity extends BaseHenchmenEntity {

    public OwlLostSmashEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
            NAME="owl_lost_smash";
        this.moveControl = new FlyingBossControl(this, 20);
        }

        public static AttributeSupplier.Builder setAttributes() {

            return Monster.createMonsterAttributes()
                    .add(Attributes.FOLLOW_RANGE, 35.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.3F)
                    .add(Attributes.FLYING_SPEED, 0.3F)
                    .add(Attributes.ATTACK_DAMAGE, 10.0D)
                    .add(Attributes.ARMOR, 4.0D)
                    .add(Attributes.MAX_HEALTH, 80.0D);
        }
    }
