package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.Hibiki_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class KabukiEntity extends BaseHenchmenEntity {

	public KabukiEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="kabuki";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Hibiki_Rider_Items.HIBIKIHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Hibiki_Rider_Items.HIBIKICHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Hibiki_Rider_Items.HIBIKILEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Hibiki_Rider_Items.KABUKIDRIVER.get()));
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Hibiki_Rider_Items.ECHO_SWORD_ONSAKEN.get()));
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 5.0D)
        		.add(Attributes.MAX_HEALTH, 100.0D);
     }
    

}