package com.kelco.kamenridercraft.item.reiwa.saber;

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


public class BookGateItem extends BaseItem {
    public BookGateItem(Properties properties) {
        super(properties);
    }

    public static void teleportToDimension(ItemStack itemstack, ServerLevel otherDim, ServerPlayer entity, int dim) {

        DimensionTransition respawn = entity.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);
        if (entity.isPassenger()) entity.stopRiding();

        if (dim == 1) {
            while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox()))
                entity.teleportRelative(0.0, 2.0, 0.0);
            BlockPos blockpos;

            if (getHasBase(itemstack)) {
                int X = (int) getXYZ(itemstack, "x1", respawn.pos().x());
                int Z = (int) getXYZ(itemstack, "z1", respawn.pos().z());
                blockpos = new BlockPos(X, 64, Z);
            } else {
                TagKey<Structure> tag = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("kamenridercraft", "northern_base"));
                blockpos = otherDim.findNearestMapStructure(tag, entity.blockPosition(), 100, false);

                assert blockpos != null;
                double X = blockpos.getX();
                double Y = blockpos.getY();
                double Z = blockpos.getZ();
                saveXYZ(itemstack, X, Y, Z, 1, entity.level().dimension());
            }


            entity.teleportTo(otherDim, blockpos.getX(), 64, blockpos.getZ(), new HashSet<>(), 0, 0);


        } else {

            double X = getXYZ(itemstack, "x0", respawn.pos().x());
            double Y = getXYZ(itemstack, "y0", respawn.pos().y());
            double Z = getXYZ(itemstack, "z0", respawn.pos().z());
            entity.teleportTo(otherDim, X, Y, Z, new HashSet<>(), 0, 0);
            while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox()))
                entity.teleportRelative(0.0, 2.0, 0.0);
            entity.randomTeleport(X, Y, Z, false);
        }
    }


    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:northern_base"));

        if (player instanceof ServerPlayer serverPlayer && !level.isClientSide()) {
            MinecraftServer Server = player.getServer();
            assert Server != null;

            List<TamableAnimal> nearbyAllies = level.getEntitiesOfClass(TamableAnimal.class, player.getBoundingBox().inflate(30), entity ->
                    (entity.getOwner() == player && !entity.isOrderedToSit() && !entity.isSleeping()));
            if (level.dimension() == MOON) {
                if (player.isShiftKeyDown()) {
                    teleportToDimension(itemstack, Server.overworld(), serverPlayer, 0);
                    for (LivingEntity ally : nearbyAllies)
                        ally.teleportTo(Server.overworld(), player.getX(), player.getY() + 1, player.getZ(), new HashSet<>(), 0, 0);
                } else {
                    teleportToDimension(itemstack, Server.getLevel(getReturnDimension(itemstack)), serverPlayer, 0);
                    for (LivingEntity ally : nearbyAllies)
                        ally.teleportTo(Objects.requireNonNull(Server.getLevel(getReturnDimension(itemstack))), player.getX(), player.getY() + 1, player.getZ(), new HashSet<>(), 0, 0);
                }
            } else {
                double X = player.position().x;
                double Y = player.position().y;
                double Z = player.position().z;
                saveXYZ(itemstack, X, Y, Z, 0, level.dimension());
                teleportToDimension(itemstack, Server.getLevel(MOON), serverPlayer, 1);
                for (LivingEntity ally : nearbyAllies)
                    ally.teleportTo(Objects.requireNonNull(Server.getLevel(MOON)), player.getX(), player.getY() + 1, player.getZ(), new HashSet<>(), 0, 0);
            }
            if (!player.isCreative()) player.getCooldowns().addCooldown(this, 10);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    public static boolean getHasBase(ItemStack itemstack) {
        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            return tag.getBoolean("has_base");
        }
        return false;
    }

    public static double getXYZ(ItemStack itemstack, String slot, double respawn) {
        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
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
            if (num == 1) form.putBoolean("has_base", true);
            form.putString("return_dimension", dimension.location().toString());
        };
        data.accept(tag);
        CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
    }
}