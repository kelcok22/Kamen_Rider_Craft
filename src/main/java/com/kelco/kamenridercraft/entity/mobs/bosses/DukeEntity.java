package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.heisei_phase_2.GaimRiderItems;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DukeEntity extends BaseHenchmenEntity {
   
    public DukeEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="duke";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GaimRiderItems.GAIM_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(GaimRiderItems.GAIM_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(GaimRiderItems.GAIM_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(GaimRiderItems.GENESIS_DRIVER_DUKE.get()));
	     this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaimRiderItems.SONIC_ARROW.get()));
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 60.0D);
     }
}