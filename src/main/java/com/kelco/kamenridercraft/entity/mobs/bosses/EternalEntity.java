package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.WRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class EternalEntity extends BaseHenchmenEntity {
	
	public static final Item[] belt = new Item[] {WRiderItems.ETERNAL_MEMORY.get(), WRiderItems.ETERNAL_T2_MEMORY.get()};

	
    public EternalEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="eternal";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(WRiderItems.WHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(WRiderItems.WCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(WRiderItems.WLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(WRiderItems.ETERNAL_EDGE.get()));
        Random generator = new Random();
		int rand = generator.nextInt(belt.length);
		
		RiderFormChangeItem Gimmick = ((RiderFormChangeItem)belt[rand]);
				
		ItemStack LOST_DRIVER = new ItemStack(WRiderItems.LOSTDRIVER_ETERNAL.get());
		
		RiderDriverItem.setFormItem(LOST_DRIVER,Gimmick, 1);
		
        this.setItemSlot(EquipmentSlot.FEET, LOST_DRIVER );
    }

 
    
    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 200.0D);
     }
    

}