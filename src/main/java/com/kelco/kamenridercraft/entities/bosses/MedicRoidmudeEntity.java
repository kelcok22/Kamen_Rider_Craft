package com.kelco.kamenridercraft.entities.bosses;


import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class MedicRoidmudeEntity extends BaseHenchmenEntity {



    public MedicRoidmudeEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="medic_roidmude";
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.2F)
        		.add(Attributes.ATTACK_DAMAGE, 8.0D)
        		.add(Attributes.ARMOR, 4.0D)
        		.add(Attributes.MAX_HEALTH, 80.0D);
     }
}