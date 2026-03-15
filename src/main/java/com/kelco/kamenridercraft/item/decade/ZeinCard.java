package com.kelco.kamenridercraft.item.decade;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public interface ZeinCard {
    void activateCard(Level level, LivingEntity living, ItemStack stack);
}