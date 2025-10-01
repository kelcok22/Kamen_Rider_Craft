package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DarkDriveEntity extends BaseHenchmenEntity {

		public DarkDriveEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="dark_drive";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Drive_Rider_Items.DRIVE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Drive_Rider_Items.DRIVE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Drive_Rider_Items.DRIVE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Drive_Rider_Items.DRIVE_DRIVER_DARK_DRIVE.get()));
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Drive_Rider_Items.BLADE_GUNNER.get()));
    }


	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 7.0D)
        		.add(Attributes.MAX_HEALTH, 130.0D);
     }
    

}