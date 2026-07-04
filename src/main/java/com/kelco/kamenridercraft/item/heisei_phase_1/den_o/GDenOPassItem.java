package com.kelco.kamenridercraft.item.heisei_phase_1.den_o;

import com.kelco.kamenridercraft.item.base_items.BaseCityItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.portal.DimensionTransition;

import java.util.HashSet;

public class GDenOPassItem extends BaseCityItem {
    public GDenOPassItem(Properties properties) {
        super(properties);
    }

    @Override
    public void teleportToDimension(ItemStack itemstack, ServerLevel otherDim, ServerPlayer entity) {
        ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));
        DimensionTransition respawn = entity.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);

        if (entity.isPassenger()) {
            entity.stopRiding();
        }

        if (otherDim.dimension() == CITY) {
            BlockPos blockpos;

            while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) {
                entity.teleportRelative(0.0, 5.0, 0.0);
            }

            if (getHasCity(itemstack)) {
                int X = (int) getXYZ(itemstack, "x1", respawn.pos().x());
                int Z = (int) getXYZ(itemstack, "z1", respawn.pos().z());
                blockpos = new BlockPos(X, 70, Z);
            } else {
                TagKey<Structure> tag = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("kamenridercraft", "chiba_city"));
                blockpos = otherDim.findNearestMapStructure(tag, entity.blockPosition(), 100, false);

                assert blockpos != null;
                saveXYZ(itemstack, blockpos.getX(), blockpos.getY(), blockpos.getZ(), 1, entity.level().dimension());
            }

            entity.teleportTo(otherDim, blockpos.getX(), 64, blockpos.getZ(), new HashSet<>(), 0, 0);
        } else {
            double X = getXYZ(itemstack, "x0", respawn.pos().x());
            double Y = getXYZ(itemstack, "y0", respawn.pos().y());
            double Z = getXYZ(itemstack, "z0", respawn.pos().z());

            entity.teleportTo(otherDim, X, Y, Z, new HashSet<>(), 0, 0);
            while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) {
                entity.teleportRelative(0.0, 5.0, 0.0);
            }
            entity.randomTeleport(X, Y, Z, false);
        }
    }
}