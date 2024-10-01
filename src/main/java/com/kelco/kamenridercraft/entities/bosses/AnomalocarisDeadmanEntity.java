package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Revice_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AnomalocarisDeadmanEntity extends BaseHenchmenEntity {




    public AnomalocarisDeadmanEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="anomalocaris_deadman";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Revice_Rider_Items.PARANEGRO.get()));
    }

 

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.4F)
        		.add(Attributes.ATTACK_DAMAGE, 12.0D)
        		.add(Attributes.ARMOR, 4.0D)
        		.add(Attributes.MAX_HEALTH, 120.0D);
     }
    

}