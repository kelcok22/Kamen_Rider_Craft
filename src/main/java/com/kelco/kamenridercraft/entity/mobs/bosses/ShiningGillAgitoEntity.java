package com.kelco.kamenridercraft.entity.mobs.bosses;

import com.kelco.kamenridercraft.entity.mobs.foot_soldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.heisei_phase_1.AgitoRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShiningGillAgitoEntity extends BaseHenchmenEntity {

    public ShiningGillAgitoEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="another_agito";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(AgitoRiderItems.AGITOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(AgitoRiderItems.AGITOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(AgitoRiderItems.AGITOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(AgitoRiderItems.GILL_AGITO_SHINING_ALTERING.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(AgitoRiderItems.SHINING_CALIBER_TWIN.get()));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(AgitoRiderItems.SHINING_CALIBER_TWIN.get()));
    }



    public static AttributeSupplier.Builder setAttributes() {
        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 135.0D)
        		.add(Attributes.MOVEMENT_SPEED, 0.23F)
        		.add(Attributes.ATTACK_DAMAGE, 10.0D)
        		.add(Attributes.ARMOR, 5.0D)
        		.add(Attributes.MAX_HEALTH, 250.0D);
     }
}