package com.kelco.kamenridercraft.item.BaseItems;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public class MaskItem extends BaseItem implements Equipable {

    public MaskItem(Properties prop) {
        super(prop);

    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}