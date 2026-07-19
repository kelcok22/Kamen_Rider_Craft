package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
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
        NAME="decade_violent_emotion";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(DecadeRiderItems.DECADEHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(DecadeRiderItems.DECADECHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(DecadeRiderItems.DECADELEGGINGS.get()));

		ItemStack belt = new ItemStack(DecadeRiderItems.DECADRIVER.get());
        RiderDriverItem.setUpdateForm(belt);
		RiderDriverItem.setFormItem(belt, DecadeRiderItems.DECADE_VIOLENT_EMOTION_CARD.get(), 1);
	
        this.setItemSlot(EquipmentSlot.FEET,belt);
    }

 
    public void tick() {
		if (this.getHealth()<40) {
	        this.setItemSlot(EquipmentSlot.MAINHAND,new ItemStack(DecadeRiderItems.RIDE_BOOKER.get()));
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
