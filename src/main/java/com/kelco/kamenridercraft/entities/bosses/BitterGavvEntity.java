package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Gavv_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BitterGavvEntity extends BaseHenchmenEntity {

		public BitterGavvEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="bitter_gavv";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Gavv_Rider_Items.GAVV_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Gavv_Rider_Items.GAVV_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Gavv_Rider_Items.GAVV_LEGGINGS.get()));
		//this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Gavv_Rider_Items.BITTER_GAVVGABLADE.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Gavv_Rider_Items.HENSHIN_BELT_BITTER_GAVV.get()));
    }


	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}