package com.kelco.kamenridercraft.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.level.portal.DimensionTransition;

import java.util.HashSet;

public class DimensionUtil {

    public static void returnToSpawn(ServerLevel otherDim, ServerPlayer entity) {
        DimensionTransition respawn = entity.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);
        if (entity.isPassenger()) {
            entity.stopRiding();
        }
        entity.teleportTo(respawn.newLevel(), respawn.pos().x(), Mth.clamp(respawn.pos().y(), otherDim.getMinBuildHeight(), otherDim.getMinBuildHeight() + otherDim.getLogicalHeight() - 1), respawn.pos().z(), new HashSet<>(), 0, 0);
        while (!respawn.newLevel().noCollision(entity) || respawn.newLevel().containsAnyLiquid(entity.getBoundingBox())) {
            entity.teleportRelative(0.0, 2.0, 0.0);
        }
        entity.randomTeleport(entity.getX(), entity.getY(), entity.getZ(), false);
    }

}
