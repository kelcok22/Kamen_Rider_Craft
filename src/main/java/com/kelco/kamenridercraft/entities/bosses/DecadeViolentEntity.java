package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Decade_Rider_Items;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DecadeViolentEntity extends BaseHenchmenEntity {



    public DecadeViolentEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="decade";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Decade_Rider_Items.DECADEHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Decade_Rider_Items.DECADECHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Decade_Rider_Items.DECADELEGGINGS.get()));

		ItemStack belt = new ItemStack(Decade_Rider_Items.DECADRIVER.get());
		RiderDriverItem.set_Form_Item(belt, Decade_Rider_Items.DECADE_VIOLENT_EMOTION_CARD.get(), 1);
	
        this.setItemSlot(EquipmentSlot.FEET,belt);
    }

 
    public void tick() {
		if (this.getHealth()<40) {
	        this.setItemSlot(EquipmentSlot.MAINHAND,new ItemStack(Decade_Rider_Items.RIDE_BOOKER.get()));
		}
		super.tick();
	}
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 50.0D);
     }
    

}