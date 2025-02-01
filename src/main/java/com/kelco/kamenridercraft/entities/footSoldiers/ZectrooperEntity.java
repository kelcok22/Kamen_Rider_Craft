package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.item.Kabuto_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ZectrooperEntity extends BaseHenchmenEntity {

	
    public ZectrooperEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="zectrooper";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Kabuto_Rider_Items.KABUTOHELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Kabuto_Rider_Items.KABUTOCHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Kabuto_Rider_Items.KABUTOLEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Kabuto_Rider_Items.ZECTROOPER_BELT.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Kabuto_Rider_Items.MACHINEGUN_BLADE.get()));
        this.setMeleeOnSpawn(50.0D);
    }


}