package com.kelco.kamenridercraft.entities.bosses;

import java.util.Random;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Ichigo_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShockerRidersEntity extends BaseHenchmenEntity {
	
	public static final Item[] belt = new Item[] {Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_1.get(),Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_2.get(),
			Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_3.get(), Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_4.get(),Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_5.get(),
			Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_6.get(),Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_7.get(),Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_8.get(),
			Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_9.get(),Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_10.get(),Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_11.get(),
			Ichigo_Rider_Items.TYPHOON_SHOCKER_RIDER_12.get()};

	
    public ShockerRidersEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="shocker_rider";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ichigo_Rider_Items.ICHIGOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ichigo_Rider_Items.ICHIGOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ichigo_Rider_Items.ICHIGOLEGGINGS.get()));
        Random generator = new Random();
		int rand = generator.nextInt(belt.length);
	
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(belt[rand]));
    }

 

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,0.3F)
        		.add(Attributes.ATTACK_DAMAGE, 7.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 45.0D);
     }
    

}