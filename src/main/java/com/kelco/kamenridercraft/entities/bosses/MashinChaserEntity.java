package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MashinChaserEntity extends BaseHenchmenEntity {

		public MashinChaserEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="mashin_chaser";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Drive_Rider_Items.DRIVE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Drive_Rider_Items.DRIVE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Drive_Rider_Items.DRIVE_LEGGINGS.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Drive_Rider_Items.BREAK_GUNNER.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Drive_Rider_Items.BREAK_GUNNER_BELT.get()));
    }


	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}