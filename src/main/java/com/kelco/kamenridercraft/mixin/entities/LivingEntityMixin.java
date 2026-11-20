package com.kelco.kamenridercraft.mixin.entities;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.abilities.AbilityUtil;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.AnimPayload;
import com.kelco.kamenridercraft.network.payload.EndAnimationPayload;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.*;
import static com.kelco.kamenridercraft.effects.EffectCore.SD;
import static com.kelco.kamenridercraft.util.AnimationUtil.canPose;
import static com.kelco.kamenridercraft.util.AnimationUtil.stopPosing;
import static com.kelco.kamenridercraft.util.DimensionUtil.teleportToDreamDimension;

@Mixin(value = LivingEntity.class, priority = 899)
public class LivingEntityMixin {
    double oldBlockX = ((LivingEntity) (Object) this).getX();
    double oldBlockZ = ((LivingEntity) (Object) this).getZ();
    LivingEntity livingEntity = ((LivingEntity) (Object) this);
    boolean wasSitting = false;

    @Inject(method = "startSleeping", at = @At("HEAD"), cancellable = true)
    public void preSleeping(BlockPos bedPos, CallbackInfo ci) {
        if (livingEntity instanceof ServerPlayer rider &&
                (rider.level().dimension() == Level.OVERWORLD && !rider.hasEffect(EffectCore.INSOMNIA) && !rider.isCreative() || rider.isCreative()) &&
                rider.getItemBySlot(EquipmentSlot.FEET).is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(KamenRiderCraftCore.MOD_ID, "gear/can_dream")))) {
            rider.stopSleeping();
            Level level = rider.level();
            ResourceKey<Level> dreamDimension = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:dream"));

            MinecraftServer Server = rider.getServer();
            List<TamableAnimal> nearbyAllies = level.getEntitiesOfClass(TamableAnimal.class, rider.getBoundingBox().inflate(30), entity ->
                    (entity.getOwner() == rider && !entity.isOrderedToSit() && !entity.isSleeping()));
            if (level.dimension() == dreamDimension) {
                teleportToDreamDimension(Server.overworld(), rider);
                for (LivingEntity ally : nearbyAllies)
                    ally.teleportTo(Server.overworld(), rider.getX(), rider.getY() + 1, rider.getZ(), new HashSet<>(), 0, 0);
            } else {
                teleportToDreamDimension(Server.getLevel(dreamDimension), rider);
                for (LivingEntity ally : nearbyAllies)
                    ally.teleportTo(Objects.requireNonNull(Server.getLevel(dreamDimension)), rider.getX(), rider.getY() + 1, rider.getZ(), new HashSet<>(), 0, 0);
            }
            ci.cancel();
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.hasEffect(SD)) {
                PacketDistributor.sendToAllPlayers(
                        new AnimPayload("sd.modifier", "sd", true, livingEntity.getStringUUID()));
            }

            if (livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem &&
                    driverItem.isTransformed(livingEntity)) {
                if (!livingEntity.isCrouching() && livingEntity.getAttribute(KRCAttributes.WINGS_OUT).getValue() > 0 && driverItem.getFlyingPosition() != null
                        && !livingEntity.isCrouching() && !(driverItem.getFlyingPosition().equals("blank") || driverItem.getFlyingPosition().isEmpty())) {
                    PacketDistributor.sendToAllPlayers(
                            new AnimPayload(driverItem.getFlyingPosition(), "flying", true, livingEntity.getStringUUID()));
                }
                if (livingEntity.isFallFlying() && !livingEntity.isCrouching() && driverItem.getGlidingPosition() != null
                        && !(driverItem.getGlidingPosition().equals("blank") || driverItem.getGlidingPosition().isEmpty())) {
                    PacketDistributor.sendToAllPlayers(
                            new AnimPayload(driverItem.getGlidingPosition(), "gliding", true, livingEntity.getStringUUID()));
                }
                if (driverItem.getModifiedPositionData() != null && !driverItem.getModifiedPositionData().isEmpty()) {
                    for (List<List<String>> formItemDataList : driverItem.getModifiedPositionData()) {
                        if (formItemDataList.get(0) == null || formItemDataList.get(0).isEmpty()) {
                            break;
                        }
                        if (formItemDataList.get(1) == null || formItemDataList.get(1).isEmpty()) {
                            break;
                        }
                        boolean canTakePose = true;
                        if (formItemDataList.get(2) != null && !formItemDataList.get(2).isEmpty()) {
                            for (String condition : formItemDataList.get(2)) {
                                switch (condition) {
                                    case "in_air":
                                        if (livingEntity.onGround() || livingEntity.isInWater()) {
                                            canTakePose = false;
                                        }
                                        break;
                                    case "in_water":
                                        if (condition.equalsIgnoreCase("in_water")) {
                                            if (!livingEntity.isInWater()) {
                                                canTakePose = false;
                                            }
                                        }
                                        break;
                                    case "on_ground":
                                        if (condition.equalsIgnoreCase("on_ground")) {
                                            if (!livingEntity.onGround()) {
                                                canTakePose = false;
                                            }
                                        }
                                        break;
                                }
                            }
                        }
                        if (canTakePose && !formItemDataList.get(0).getFirst().isEmpty()) {
                            PacketDistributor.sendToAllPlayers
                                    (new AnimPayload(formItemDataList.get(0).getFirst().toLowerCase(),
                                            formItemDataList.get(1).getFirst().toLowerCase(), true, livingEntity.getStringUUID()));
                        }
                    }
                }
            }
        }

        if (!(livingEntity instanceof ArmorStand) && !livingEntity.level().isClientSide()) {
            if (livingEntity.getData(USED_ABILITY).isEmpty() && livingEntity.getData(ABILITY_COOLDOWN) > 0) {
                livingEntity.setData(ABILITY_COOLDOWN, livingEntity.getData(ABILITY_COOLDOWN) - 1);
            }
            if (livingEntity.getData(IS_POSING)) {
                if (!canPose(livingEntity) || Math.abs(livingEntity.getX() - this.oldBlockX) > 0.05 || Math.abs(livingEntity.getZ() - this.oldBlockZ) > 0.05) {
                    stopPosing(livingEntity);
                }
            } else if (livingEntity.getData(POSE_COOLDOWN) > 0) {
                livingEntity.setData(POSE_COOLDOWN, livingEntity.getData(POSE_COOLDOWN) - 1);
            }
        }

        if (!livingEntity.getData(USED_ABILITY).isEmpty()) {
            AbilityUtil.useAbility(livingEntity);
        } else if (livingEntity.getData(ABILITY_TICK) > 0) {
            livingEntity.setData(ABILITY_TICK, 0);
        }

        if (livingEntity.getData(DELAY_ANIMATION_END) && livingEntity instanceof Player) {
            if (!(livingEntity.getData(DELAY_ANIMATION_END_TICKS) > 1)) {
                livingEntity.setData(DELAY_ANIMATION_END, false);
                PacketDistributor.sendToAllPlayers(new EndAnimationPayload(livingEntity.getStringUUID(), "attack", false));
            } else {
                livingEntity.setData(DELAY_ANIMATION_END_TICKS, livingEntity.getData(DELAY_ANIMATION_END_TICKS) - 1);
            }
        }

        this.oldBlockX = livingEntity.getX();
        this.oldBlockZ = livingEntity.getZ();

        if (!(livingEntity instanceof Player)) {
            if (livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                belt.beltTick(livingEntity.getItemBySlot(EquipmentSlot.FEET), livingEntity.level(), livingEntity, 36);
                belt.giveEffects(livingEntity);
            }
        }
    }
}