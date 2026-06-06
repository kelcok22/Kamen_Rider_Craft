package com.kelco.kamenridercraft.util;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

public class MiscUtil {
    public static boolean canSpawnBoss (Player player) {
       return (player.level() instanceof ServerLevel serverLevel && serverLevel.getDifficulty() == Difficulty.HARD) || (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driver && driver.isTransformed(player));
    }
}
