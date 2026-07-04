package com.kelco.kamenridercraft.item.heisei_phase_2.build;

import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class NebulasteamGunItem extends BaseBlasterItem {

    public NebulasteamGunItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, Atk, Spd, prop);
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
        super.releaseUsing(stack, level, livingEntity, timeLeft);
        if (livingEntity instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
            if (player.getOffhandItem().getItem() == BuildRiderItems.GEAR_ENGINE.get() || player.getOffhandItem().getItem() == BuildRiderItems.GEAR_REMOCON.get()) {
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuildRiderItems.NEBULA_STEAM_GUN_HELL_BROS.get(), 1));
                player.getOffhandItem().use(level, player, InteractionHand.OFF_HAND);
            } else {
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuildRiderItems.NEBULA_STEAM_GUN_KAISER.get(), 1));
                if (player.getOffhandItem().getItem() == BuildRiderItems.GEAR_ENGINE_RED.get() || player.getOffhandItem().getItem() == BuildRiderItems.GEAR_REMOCON_BLUE.get())
                    player.getOffhandItem().use(level, player, InteractionHand.OFF_HAND);
            }
        }
    }
}