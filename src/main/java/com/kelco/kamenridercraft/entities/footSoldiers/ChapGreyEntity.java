package com.kelco.kamenridercraft.entities.footSoldiers;


import com.kelco.kamenridercraft.block.Rider_Blocks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.time.LocalDate;

public class ChapGreyEntity extends BaseHenchmenEntity {
	
    public ChapGreyEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="chaps_grey";
        LocalDate localdate = LocalDate.now();
        int day = localdate.getDayOfMonth();
        if (localdate.getMonthValue() == 10 && day >= 24) {
            this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Rider_Blocks.FERBUS.get()));
        }
    }
}