package com.kelco.kamenridercraft.item.base_items;

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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.portal.DimensionTransition;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


public class BaseCityItem extends BaseItem {
    public BaseCityItem(Properties properties) {
        super(properties);
    }

    public void teleportToDimension(ItemStack itemStack, ServerLevel otherDim, ServerPlayer entity) {
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

            if (getHasCity(itemStack)) {
                int X = (int) getXYZ(itemStack, "x1", respawn.pos().x());
                int Z = (int) getXYZ(itemStack, "z1", respawn.pos().z());
                blockpos = new BlockPos(X, 70, Z);
            } else {
                TagKey<Structure> tag = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("kamenridercraft", "city"));
                blockpos = otherDim.findNearestMapStructure(tag, entity.blockPosition(), 100, false);

                assert blockpos != null;
                saveXYZ(itemStack, blockpos.getX(), blockpos.getY(), blockpos.getZ(), 1, entity.level().dimension());
            }

            entity.teleportTo(otherDim, blockpos.getX(), 64, blockpos.getZ(), new HashSet<>(), 0, 0);
        } else {
            double X = getXYZ(itemStack, "x0", respawn.pos().x());
            double Y = getXYZ(itemStack, "y0", respawn.pos().y());
            double Z = getXYZ(itemStack, "z0", respawn.pos().z());

            entity.teleportTo(otherDim, X, Y, Z, new HashSet<>(), 0, 0);
            while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) {
                entity.teleportRelative(0.0, 5.0, 0.0);
            }
            entity.randomTeleport(X, Y, Z, false);
        }
    }


    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41130_) {
        ItemStack itemStack = player.getItemInHand(p_41130_);
        ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:city"));

        if (player instanceof ServerPlayer serverPlayer) {
            MinecraftServer Server = player.getServer();
            assert player.getServer() != null;
            assert Server != null;

            List<TamableAnimal> nearbyAllies = level.getEntitiesOfClass(TamableAnimal.class, player.getBoundingBox().inflate(30), entity ->
                    (entity.getOwner() == player && !entity.isOrderedToSit() && !entity.isSleeping()));
            if (level.dimension() == MOON) {
                if (player.isShiftKeyDown()) {
                    this.teleportToDimension(itemStack, Server.overworld(), serverPlayer);
                    for (LivingEntity ally : nearbyAllies)
                        ally.teleportTo(Server.overworld(), player.getX(), player.getY() + 1, player.getZ(), new HashSet<>(), 0, 0);
                } else {

                    this.teleportToDimension(itemStack, Server.getLevel(getReturnDimension(itemStack)), serverPlayer);
                    for (LivingEntity ally : nearbyAllies)
                        ally.teleportTo(Objects.requireNonNull(Server.getLevel(getReturnDimension(itemStack))), player.getX(), player.getY() + 1, player.getZ(), new HashSet<>(), 0, 0);
                }
            } else {
                double X = player.position().x;
                double Y = player.position().y;
                double Z = player.position().z;
                saveXYZ(itemStack, X, Y, Z, 0, level.dimension());
                this.teleportToDimension(itemStack, Server.getLevel(MOON), serverPlayer);
                for (LivingEntity ally : nearbyAllies)
                    ally.teleportTo(Objects.requireNonNull(Server.getLevel(MOON)), player.getX(), player.getY() + 1, player.getZ(), new HashSet<>(), 0, 0);
            }
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 10);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }

    public static boolean getHasCity(ItemStack itemStack) {
        if (itemStack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemStack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            return tag.getBoolean("has_city");
        }
        return false;
    }

    public static double getXYZ(ItemStack itemStack, String slot, double respawn) {
        if (itemStack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemStack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            return tag.getDouble(slot);
        }
        return respawn;
    }

    public static ResourceKey<Level> getReturnDimension(ItemStack itemStack) {
        if (itemStack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemStack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            return ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(tag.getString("return_dimension")));
        }
        return Level.OVERWORLD;
    }

    public static void saveXYZ(ItemStack itemStack, double x, double y, double z, int num, ResourceKey<Level> dimension) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        CompoundTag tag = new CompoundTag();
        Consumer<CompoundTag> data = form ->
        {
            form.putDouble("x" + num, x);
            form.putDouble("y" + num, y);
            form.putDouble("z" + num, z);
            if (num == 1) form.putBoolean("has_city", true);
            {
                form.putString("return_dimension", dimension.location().toString());
            }
        };
        data.accept(tag);
        CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
    }
}