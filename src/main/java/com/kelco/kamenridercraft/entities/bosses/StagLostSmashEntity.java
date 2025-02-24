package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StagLostSmashEntity extends BaseHenchmenEntity {

    public StagLostSmashEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
            NAME="stag_lost_smash";
        }


        public static AttributeSupplier.Builder setAttributes() {

            return Monster.createMonsterAttributes()
                    .add(Attributes.FOLLOW_RANGE, 35.0D)
                    .add(Attributes.MOVEMENT_SPEED,(double)0.2F)
                    .add(Attributes.ATTACK_DAMAGE, 12.0D)
                    .add(Attributes.ARMOR, 4.0D)
                    .add(Attributes.MAX_HEALTH, 80.0D);
        }
    }
