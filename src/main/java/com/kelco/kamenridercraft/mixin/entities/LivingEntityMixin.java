package com.kelco.kamenridercraft.mixin.entities;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.abilities.AbilityUtil;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.reiwa.ZeztzRiderItems;
import com.kelco.kamenridercraft.network.payload.EndAnimationPayload;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.portal.DimensionTransition;
import net.neoforged.neoforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.*;
import static com.kelco.kamenridercraft.util.AnimationUtil.canPose;
import static com.kelco.kamenridercraft.util.AnimationUtil.stopPosing;

@Mixin(value = LivingEntity.class, priority = 899)
public class LivingEntityMixin {
    double oldBlockX = ((LivingEntity) (Object) this).getX();
    double oldBlockZ = ((LivingEntity) (Object) this).getZ();
    boolean wasSitting = false;

    @Inject(method = "startSleeping", at = @At("HEAD"), cancellable = true)
    public void preSleeping(BlockPos bedPos, CallbackInfo ci) {
        LivingEntity livingEntity = ((LivingEntity) (Object) this);
        if (livingEntity instanceof ServerPlayer rider && !rider.hasEffect(EffectCore.INSOMNIA) && rider.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/can_dream")))) {
            rider.stopSleeping();
            Level level = rider.level();
            ResourceKey<Level> dreamDimension = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:dream"));

            MinecraftServer Server = rider.getServer();
            List<TamableAnimal> nearbyAllies = level.getEntitiesOfClass(TamableAnimal.class, rider.getBoundingBox().inflate(30), entity ->
                    (entity.getOwner() == rider && !entity.isOrderedToSit() && !entity.isSleeping()));
            if (level.dimension() == dreamDimension) {
                this.teleportToDimension(Server.overworld(), rider);
                for (LivingEntity ally : nearbyAllies)
                    ally.teleportTo(Server.overworld(), rider.getX(), rider.getY() + 1, rider.getZ(), new HashSet<>(), 0, 0);
            } else {
                this.teleportToDimension(Server.getLevel(dreamDimension), rider);
                for (LivingEntity ally : nearbyAllies)
                    ally.teleportTo(Objects.requireNonNull(Server.getLevel(dreamDimension)), rider.getX(), rider.getY() + 1, rider.getZ(), new HashSet<>(), 0, 0);
            }
            ci.cancel();
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        var rider = ((LivingEntity) (Object) this);

//        if (rider instanceof Player) {
//            if (this.wasSitting && rider.getControlledVehicle() == null) {
//                PacketDistributor.sendToAllPlayers(new EndAnimationPayload(rider.getStringUUID(), "position"));
//            }
//            this.wasSitting = rider.getControlledVehicle() != null;
//        }

        if (!(rider instanceof ArmorStand) && !rider.level().isClientSide()) {
            if (rider.getData(USED_ABILITY).isEmpty() && rider.getData(ABILITY_COOLDOWN) > 0) {
                rider.setData(ABILITY_COOLDOWN, rider.getData(ABILITY_COOLDOWN) - 1);
            }
            if (rider.getData(IS_POSING)) {
                if (!canPose(rider) || Math.abs(rider.getX() - this.oldBlockX) > 0.05 || Math.abs(rider.getZ() - this.oldBlockZ) > 0.05) {
                    stopPosing(rider);
                }
            } else if (rider.getData(POSE_COOLDOWN) > 0) {
                rider.setData(POSE_COOLDOWN, rider.getData(POSE_COOLDOWN) - 1);
            }
        }

        if (!rider.getData(USED_ABILITY).isEmpty()) {
            AbilityUtil.useAbility(rider);
        } else if (rider.getData(ABILITY_TICK) > 0) {
            rider.setData(ABILITY_TICK, 0);
        }

        if (rider.getData(DELAY_ANIMATION_END) && rider instanceof Player) {
            if (!(rider.getData(DELAY_ANIMATION_END_TICKS) > 1)) {
                rider.setData(DELAY_ANIMATION_END, false);
                PacketDistributor.sendToAllPlayers(new EndAnimationPayload(rider.getStringUUID(), "attack", false));
            } else {
                rider.setData(DELAY_ANIMATION_END_TICKS, rider.getData(DELAY_ANIMATION_END_TICKS) - 1);
            }
        }

        this.oldBlockX = rider.getX();
        this.oldBlockZ = rider.getZ();

        if (!(rider instanceof Player)) {
            if (rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                belt.beltTick(rider.getItemBySlot(EquipmentSlot.FEET), rider.level(), rider, 36);
                belt.giveEffects(rider);
            }
        }
    }

    public void teleportToDimension(ServerLevel otherDim, ServerPlayer entity) {
        ResourceKey<Level> dreamWorld = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:dream"));
        DimensionTransition respawn = entity.findRespawnPositionAndUseSpawnBlock(false, DimensionTransition.DO_NOTHING);

        if (entity.isPassenger()) {
            entity.stopRiding();
        }
        if (otherDim.dimension() == dreamWorld) {
            BlockPos blockpos;
            while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) {
                entity.teleportRelative(0.0, 5.0, 0.0);
            }

            String[] structureList = new String[]{"nightmare_garden", "nightmare_prison", "nightmare_city"};
            Random rand = new Random();
            String structure = structureList[rand.nextInt(structureList.length)];
            if (entity.getInventory().countItem(ZeztzRiderItems.DUALMARE_CAPSEM.get()) != 0)
                structure = "nightmare_warehouse";
            TagKey<Structure> tag = TagKey.create(Registries.STRUCTURE, ResourceLocation.fromNamespaceAndPath("kamenridercraft", structure));

            blockpos = otherDim.findNearestMapStructure(tag, entity.blockPosition(), 100, false);
            entity.addEffect(new MobEffectInstance(EffectCore.DREAMING, 8400, 0, true, true));
            entity.teleportTo(otherDim, blockpos.getX(), 2, blockpos.getZ(), new HashSet<>(), 0, 0);
        } else {
            entity.teleportTo(otherDim, respawn.pos().x(), respawn.pos().y(), respawn.pos().z(), new HashSet<>(), 0, 0);
            while (!otherDim.noCollision(entity) || otherDim.containsAnyLiquid(entity.getBoundingBox())) {
                entity.teleportRelative(0.0, 5.0, 0.0);
            }
            entity.randomTeleport(respawn.pos().x(), respawn.pos().y(), respawn.pos().z(), false);
        }
    }
}