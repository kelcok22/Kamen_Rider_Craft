package com.kelco.kamenridercraft.util;

import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.portal.DimensionTransition;

import java.util.HashSet;
import java.util.Random;

public class DimensionUtil {
    public static void returnToSpawn(ServerLevel otherDim, ServerPlayer serverPlayer) {
        DimensionTransition respawn = serverPlayer.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);
        if (serverPlayer.isPassenger()) {
            serverPlayer.stopRiding();
        }
        serverPlayer.teleportTo(respawn.newLevel(), respawn.pos().x(), Mth.clamp(respawn.pos().y(), otherDim.getMinBuildHeight(), otherDim.getMinBuildHeight() + otherDim.getLogicalHeight() - 1), respawn.pos().z(), new HashSet<>(), 0, 0);
        while (!respawn.newLevel().noCollision(serverPlayer) || respawn.newLevel().containsAnyLiquid(serverPlayer.getBoundingBox())) {
            serverPlayer.teleportRelative(0.0, 2.0, 0.0);
        }
        serverPlayer.randomTeleport(serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), false);
    }

    public static void teleportToDreamDimension(ServerLevel otherDim, ServerPlayer serverPlayer) {
        ResourceKey<Level> dreamWorld = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:dream"));
        DimensionTransition respawn = serverPlayer.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);

        if (serverPlayer.isPassenger()) {
            serverPlayer.stopRiding();
        }
        if (otherDim.dimension() == dreamWorld && serverPlayer.level().dimension() == Level.OVERWORLD) {
            BlockPos blockpos;
            while (!otherDim.noCollision(serverPlayer) || otherDim.containsAnyLiquid(serverPlayer.getBoundingBox())) {
                serverPlayer.teleportRelative(0.0, 5.0, 0.0);
            }
            String[] structureList = new String[]{"nightmare_garden", "nightmare_prison", "nightmare_city"};
            Random rand = new Random();
            String structure = structureList[rand.nextInt(structureList.length)];
            if (serverPlayer.getInventory().countItem(ZeztzRiderItems.DUALMARE_CAPSEM.get()) != 0) structure = "nightmare_warehouse";
            if (serverPlayer.getInventory().countItem(ZeztzRiderItems.EXDREAMRISE_CAPSEM.get()) != 0) structure = "white_nightmare_garden";

            ItemStack ring = serverPlayer.getInventory().getItem(40);
            if (ring.getItem()==ZeztzRiderItems.AGENT_NUMBER_RING_ZERO.get())structure = "nightmare_warehouse";
            else if (ring.getItem()==ZeztzRiderItems.AGENT_NUMBER_RING_ONE.get())structure = "nightmare_prison";
            else if (ring.getItem()==ZeztzRiderItems.AGENT_NUMBER_RING_FOUR.get())structure = "nightmare_garden";
            else if (ring.getItem()==ZeztzRiderItems.AGENT_NUMBER_RING_SEVEN.get())structure = "nightmare_city";
            else if (ring.getItem()==ZeztzRiderItems.AGENT_NUMBER_RING_TWO.get())structure = "white_nightmare_garden";

            TagKey<Structure> tag = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("kamenridercraft", structure));

            blockpos = otherDim.findNearestMapStructure(tag, serverPlayer.blockPosition(), 100, false);
            serverPlayer.addEffect(new MobEffectInstance(EffectCore.DREAMING, 8400, 0, true, true));
            serverPlayer.teleportTo(otherDim, blockpos.getX(), 2, blockpos.getZ(), new HashSet<>(), 0, 0);
        } else {
            serverPlayer.teleportTo(otherDim, respawn.pos().x(), respawn.pos().y(), respawn.pos().z(), new HashSet<>(), 0, 0);
            while (!otherDim.noCollision(serverPlayer) || otherDim.containsAnyLiquid(serverPlayer.getBoundingBox())) {
                serverPlayer.teleportRelative(0.0, 5.0, 0.0);
            }
            serverPlayer.randomTeleport(respawn.pos().x(), respawn.pos().y(), respawn.pos().z(), false);
        }
    }
}
