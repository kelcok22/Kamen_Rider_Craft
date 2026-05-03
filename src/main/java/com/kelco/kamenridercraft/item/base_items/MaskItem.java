package com.kelco.kamenridercraft.item.base_items;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;

public class MaskItem extends BaseItem implements Equipable {

    public MaskItem(Properties prop) {
        super(prop);

    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}