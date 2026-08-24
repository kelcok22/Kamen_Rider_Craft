package com.kelco.kamenridercraft.item.reiwa.zeztz;

import com.kelco.kamenridercraft.effects.EffectCore;
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
import net.minecraft.world.effect.MobEffectInstance;
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

public class DreamTestItem extends BaseItem {
        public DreamTestItem(Properties properties) {
            super(properties);
        }

        public void teleportToDimension(ItemStack itemStack, ServerLevel otherDim, ServerPlayer entity) {
            ResourceKey<Level> CITY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:dream"));
            DimensionTransition respawn = entity.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);

            if (entity.isPassenger()) {
                entity.stopRiding();
            }
            if (otherDim.dimension() == CITY) {
                BlockPos blockpos;
                while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) {
                    entity.teleportRelative(0.0, 5.0, 0.0);
                }
                    TagKey<Structure> tag = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("kamenridercraft", "nightmare_garden"));
                    blockpos =otherDim.findNearestMapStructure(tag, entity.blockPosition(), 100, true);
                    assert blockpos != null;
                    entity.addEffect(new MobEffectInstance(EffectCore.DREAMING, 8400,0,true,true));
                entity.teleportTo(otherDim, blockpos.getX(), 1, blockpos.getZ(), new HashSet<>(), 0, 0);
            } else {
                double X = respawn.pos().x();
                double Y = respawn.pos().y();
                double Z =  respawn.pos().z();
                entity.teleportTo(otherDim, X, Y, Z, new HashSet<>(), 0, 0);
                while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) {
                    entity.teleportRelative(0.0, 5.0, 0.0);
                }
                entity.randomTeleport(X, Y, Z, false);
            }
        }


        public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:dream"));

            if (player instanceof ServerPlayer serverPlayer) {
                MinecraftServer Server = player.getServer();
                assert player.getServer() != null;
                assert Server != null;

                List<TamableAnimal> nearbyAllies = level.getEntitiesOfClass(TamableAnimal.class, player.getBoundingBox().inflate(30), entity ->
                        (entity.getOwner() == player && !entity.isOrderedToSit() && !entity.isSleeping()));
                if (level.dimension() == MOON) {
                        this.teleportToDimension(itemStack, Server.overworld(), serverPlayer);
                        for (LivingEntity ally : nearbyAllies)
                            ally.teleportTo(Server.overworld(), player.getX(), player.getY() + 1, player.getZ(), new HashSet<>(), 0, 0);
                } else {
                    double X = player.position().x;
                    double Y = player.position().y;
                    double Z = player.position().z;
                    this.teleportToDimension(itemStack, Server.getLevel(MOON), serverPlayer);
                    for (LivingEntity ally : nearbyAllies)
                        ally.teleportTo(Objects.requireNonNull(Server.getLevel(MOON)), player.getX(), player.getY() + 1, player.getZ(), new HashSet<>(), 0, 0);
                }
                if (!player.isCreative()) player.getCooldowns().addCooldown(this, 10);
            }

            return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
        }
    }