package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.reboots.ShinIchigoRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShinNo0Entity extends BaseHenchmenEntity {

    public ShinNo0Entity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="shin_no_0";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ShinIchigoRiderItems.SHIN_ICHIGO_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ShinIchigoRiderItems.SHIN_ICHIGO_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ShinIchigoRiderItems.SHIN_ICHIGO_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ShinIchigoRiderItems.ULTIMATE_HALF_TYPHOON.get()));
    }
    

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.4F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 4.0D)
        		.add(Attributes.MAX_HEALTH, 70.0D);
     }
}