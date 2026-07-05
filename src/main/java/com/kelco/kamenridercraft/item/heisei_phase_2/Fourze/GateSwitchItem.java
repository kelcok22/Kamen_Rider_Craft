package com.kelco.kamenridercraft.item.heisei_phase_2.Fourze;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.portal.DimensionTransition;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.function.Consumer;


public class GateSwitchItem extends BaseItem {
    public GateSwitchItem(Properties properties) {
        super(properties);
    }

    public static void teleportToDimension(ItemStack itemstack, ServerLevel otherDim, ServerPlayer serverPlayer, int dim) {
        DimensionTransition respawn = serverPlayer.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);
        if (serverPlayer.isPassenger()){
			serverPlayer.stopRiding();
		}

        if (dim == 1) {
            while (!otherDim.noCollision(serverPlayer) || otherDim.containsAnyLiquid(serverPlayer.getBoundingBox()))
				serverPlayer.teleportRelative(0.0, 2.0, 0.0);
            BlockPos blockpos;

            if (getHasMoon(itemstack)) {
                int X = (int) getXYZ(itemstack, "x1", respawn.pos().x());
                int Z = (int) getXYZ(itemstack, "z1", respawn.pos().z());
                blockpos = new BlockPos(X, 65, Z);
            } else {
                TagKey<Structure> tag = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("kamenridercraft", "rabbit_hutch"));
                blockpos = otherDim.findNearestMapStructure(tag, serverPlayer.blockPosition(), 100, false);

                assert blockpos != null;
                double X = blockpos.getX();
                double Y = blockpos.getY();
                double Z = blockpos.getZ();
                saveXYZ(itemstack, X, Y, Z, 1, serverPlayer.level().dimension());
            }
			serverPlayer.teleportTo(otherDim, blockpos.getX(), 65, blockpos.getZ(), new HashSet<>(), 0, 0);

        } else {

            double X = getXYZ(itemstack, "x0", respawn.pos().x());
            double Y = getXYZ(itemstack, "y0", respawn.pos().y());
            double Z = getXYZ(itemstack, "z0", respawn.pos().z());
			serverPlayer.teleportTo(otherDim, X, Y, Z, new HashSet<>(), 0, 0);
            while (!otherDim.noCollision(serverPlayer) || otherDim.containsAnyLiquid(serverPlayer.getBoundingBox())) {
				serverPlayer.teleportRelative(0.0, 2.0, 0.0);
			}
			serverPlayer.randomTeleport(X, Y, Z, false);
        }
    }


    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:moon"));

        if (player instanceof ServerPlayer serverPlayer && !level.isClientSide()) {
            MinecraftServer Server = player.getServer();
            assert Server != null;
            if (level.dimension() == MOON) {
                if (player.isShiftKeyDown()) {
                    teleportToDimension(itemstack, Server.overworld(), serverPlayer, 0);
                } else {
                    teleportToDimension(itemstack, Server.getLevel(getReturnDimension(itemstack)), serverPlayer, 0);
                }
            } else {
                saveXYZ(itemstack, player.position().x, player.position().y, player.position().z, 0, level.dimension());
                teleportToDimension(itemstack, Server.getLevel(MOON), serverPlayer, 1);
            }
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 10);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    public static boolean getHasMoon(ItemStack itemstack) {
        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            return tag.getBoolean("has_moon");
        }
        return false;
    }

    public static double getXYZ(ItemStack itemstack, String slot, double respawn) {
        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            return tag.getDouble(slot);
        }
        return respawn;
    }

    public static ResourceKey<Level> getReturnDimension(ItemStack itemstack) {
        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            return ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(tag.getString("return_dimension")));
        }
        return Level.OVERWORLD;
    }

    public static void saveXYZ(ItemStack itemstack, double X, double Y, double Z, int num, ResourceKey<Level> dimension) {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        CompoundTag tag = new CompoundTag();
        Consumer<CompoundTag> data = form ->
        {
            form.putDouble("x" + num, X);
            form.putDouble("y" + num, Y);
            form.putDouble("z" + num, Z);
            if (num == 1) form.putBoolean("has_moon", true);
            form.putString("return_dimension", dimension.location().toString());
        };
        data.accept(tag);
        CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
    }
}