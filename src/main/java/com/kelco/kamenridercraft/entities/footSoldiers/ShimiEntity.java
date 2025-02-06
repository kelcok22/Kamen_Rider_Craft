package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.item.Saber_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShimiEntity extends BaseHenchmenEntity {

	
    public ShimiEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="shimi";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Saber_Rider_Items.SHIMI_LOT.get()));
    }


}