package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Gaim_Rider_Items;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MarikaEntity extends BaseHenchmenEntity {
   
    public MarikaEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="marika";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gaim_Rider_Items.GAIM_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gaim_Rider_Items.GAIM_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gaim_Rider_Items.GAIM_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gaim_Rider_Items.GENESIS_DRIVER_MARIKA.get()));
	     this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gaim_Rider_Items.SONIC_ARROW.get()));
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