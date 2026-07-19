package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.showa.IchigoRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ShockerRidersEntity extends BaseHenchmenEntity {
	
	public static final Item[] belt = new Item[] {IchigoRiderItems.TYPHOON_SHOCKER_RIDER_1.get(), IchigoRiderItems.TYPHOON_SHOCKER_RIDER_2.get(),
			IchigoRiderItems.TYPHOON_SHOCKER_RIDER_3.get(), IchigoRiderItems.TYPHOON_SHOCKER_RIDER_4.get(), IchigoRiderItems.TYPHOON_SHOCKER_RIDER_5.get(),
			IchigoRiderItems.TYPHOON_SHOCKER_RIDER_6.get(), IchigoRiderItems.TYPHOON_SHOCKER_RIDER_7.get(), IchigoRiderItems.TYPHOON_SHOCKER_RIDER_8.get(),
			IchigoRiderItems.TYPHOON_SHOCKER_RIDER_9.get(), IchigoRiderItems.TYPHOON_SHOCKER_RIDER_10.get(), IchigoRiderItems.TYPHOON_SHOCKER_RIDER_11.get(),
			IchigoRiderItems.TYPHOON_SHOCKER_RIDER_12.get()};

	
    public ShockerRidersEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="shocker_rider";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(IchigoRiderItems.ICHIGOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(IchigoRiderItems.ICHIGOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(IchigoRiderItems.ICHIGOLEGGINGS.get()));
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