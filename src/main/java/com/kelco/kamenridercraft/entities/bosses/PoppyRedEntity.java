package com.kelco.kamenridercraft.entities.bosses;

import java.util.Random;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Ex_Aid_Rider_Items;
import com.kelco.kamenridercraft.item.Ichigo_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PoppyRedEntity extends BaseHenchmenEntity {
	

	
    public PoppyRedEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="poppy";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Ex_Aid_Rider_Items.EX_AIDHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Ex_Aid_Rider_Items.EX_AIDCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Ex_Aid_Rider_Items.EX_AIDLEGGINGS.get()));

		ItemStack belt = new ItemStack(Ex_Aid_Rider_Items.GASHACON_BUGVISOR_II_POPPY.get());
		RiderDriverItem.set_Form_Item(belt, Ex_Aid_Rider_Items.TOKI_MEKI_CRISIS_GASHAT_RED_EYES.get(), 1);
	
        this.setItemSlot(EquipmentSlot.FEET,belt);
    }

 
    public void tick() {
		if (this.getHealth()<20) {
			
	        this.setItemSlot(EquipmentSlot.MAINHAND,new ItemStack(Ex_Aid_Rider_Items.GASHACON_BUGVISOR_II.get()));

		}
		super.tick();
	}
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 6.0D)
        		.add(Attributes.ARMOR, 3.0D)
        		.add(Attributes.MAX_HEALTH, 45.0D);
     }
    

}