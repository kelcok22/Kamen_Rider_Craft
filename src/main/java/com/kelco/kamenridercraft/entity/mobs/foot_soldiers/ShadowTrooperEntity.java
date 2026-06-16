package com.kelco.kamenridercraft.entity.mobs.foot_soldiers;

import com.kelco.kamenridercraft.item.heisei_phase_1.KabutoRiderItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShadowTrooperEntity extends BaseHenchmenEntity {

    public ShadowTrooperEntity(EntityType<? extends BaseHenchmenEntity > type, Level level) {
        super(type, level);
        NAME="shadow_trooper";
		BOW_COOLDOWN=30;
		HARD_BOW_COOLDOWN=10;
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KabutoRiderItems.KABUTOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KabutoRiderItems.KABUTOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(KabutoRiderItems.KABUTOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(KabutoRiderItems.SHADOW_TROOPER_BELT.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(KabutoRiderItems.MACHINEGUN_BLADE.get()));
        this.setMeleeOnSpawn(50.0D);
    }
}