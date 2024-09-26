package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RaiderEntity extends BaseHenchmenEntity {
	

	
    public RaiderEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="raider_horseshoe_crab";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Zero_One_Rider_Items.ZERO_ONE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.RAIDRISER_BATTLE.get()));
		switch (this.getRandom().nextInt(7)) {
			case 0:
				NAME="raider_buffalo";
				this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.RAIDRISER_BUFFALO.get()));
				break;
			case 1:
				NAME="raider_whale";
				this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.RAIDRISER_WHALE.get()));
				break;
			case 2:
				NAME="raider_lion";
				this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.RAIDRISER_LION.get()));
				break;
			case 3:
				NAME="raider_penguin";
				this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.RAIDRISER_PENGUIN.get()));
				break;
			case 4:
				NAME="raider_panda";
				this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.RAIDRISER_PANDA.get()));
				break;
			case 5:
				NAME="raider_jackal";
				this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Zero_One_Rider_Items.RAIDRISER_JACKAL.get()));
				break;
		  }
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 40.0D);
     }
}