package com.kelco.kamenridercraft.item.heisei_phase_2.build;

import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class TransteamGunItem extends BaseBlasterItem {

    public TransteamGunItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, Atk, Spd, prop);
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
        super.releaseUsing(stack, level, livingEntity, timeLeft);
        if (livingEntity.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
            if (livingEntity.getOffhandItem().getItem() == BuildRiderItems.LOST_COBRA_FULL_BOTTLE.get())
                livingEntity.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuildRiderItems.TRANSTEAM_GUN_BLOOD_STALK.get(), 1));
            else
                livingEntity.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuildRiderItems.TRANSTEAM_GUN_NIGHT_ROGUE.get(), 1));
        }
    }
}