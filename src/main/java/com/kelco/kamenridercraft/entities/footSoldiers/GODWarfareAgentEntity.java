package com.kelco.kamenridercraft.entities.footSoldiers;

import com.kelco.kamenridercraft.item.Faiz_Rider_Items;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GODWarfareAgentEntity extends BaseHenchmenEntity {
	
    public GODWarfareAgentEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME = "god_warfare_agents";
    }
}