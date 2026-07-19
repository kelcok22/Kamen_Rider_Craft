package com.kelco.kamenridercraft.network;

import com.kelco.kamenridercraft.abilities.AbilityUtil;
import com.kelco.kamenridercraft.entity.mobs.summons.CompleteSummonEntity;
import com.kelco.kamenridercraft.entity.mobs.summons.LegendarySummonEntity;
import com.kelco.kamenridercraft.entity.vehicles.baseBikeEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.*;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.Objects;
import java.util.UUID;

import static com.kelco.kamenridercraft.attachments.AttachmentTypes.*;
import static com.kelco.kamenridercraft.util.AnimationUtil.canPose;
import static com.kelco.kamenridercraft.util.AnimationUtil.stopPosing;

public class ServerPayloadHandler {
    public static void handlePoseKeyPress(final PoseKeyPayload data, final IPayloadContext context) {
        Player rider = context.player();
        if (rider.getData(IS_POSING)) {
            rider.setData(IS_POSING, false);
            stopPosing(rider);
        } else {
            if (canPose(rider) && !(rider.walkAnimation.isMoving()) && !(Math.abs(rider.getX() - rider.xOld) > 0.05 || Math.abs(rider.getZ() - rider.zOld) > 0.05)) {
                rider.setData(IS_POSING, true);
                if (Objects.requireNonNull(rider.getAttribute(Attributes.POSE_MODEL_MODIFIER)).getValue() < 1) {
                    Objects.requireNonNull(rider.getAttribute(Attributes.POSE_MODEL_MODIFIER)).setBaseValue(1);
                } else {
                    Objects.requireNonNull(rider.getAttribute(Attributes.POSE_MODEL_MODIFIER)).setBaseValue(0);
                }
                PacketDistributor.sendToAllPlayers(new StartPosePayload("", rider.getStringUUID()));
            }
        }
    }

    public static void handleBikeMove(final BikeMovePayload data, final IPayloadContext context) {
        if (context.player().level().getEntity(data.id()) != null) {
            if (context.player().level().getEntity(data.id()) instanceof baseBikeEntity bike) {
                bike.yRotO = bike.getYRot();
                bike.xRotO = bike.getXRot();
                bike.yBodyRot = data.yBody();
                bike.yHeadRot = data.yHead();
                if (data.speed() != 0){
                    context.player().level().playSound(bike, bike.blockPosition(), SoundEvents.BOAT_PADDLE_LAND, SoundSource.PLAYERS, 0.25F, (bike.getRandom().nextFloat() - bike.getRandom().nextFloat()) * 0.1F + 1.0F);
                if (context.player().level() instanceof ServerLevel sl) {
                    if (data.speed() < 0.2) {
                        sl.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                                bike.getX(), bike.getY(),
                                bike.getZ(), 10, 0, 0, 0, 0);
                    }
                    //this.playSound(SoundEvents.ALLAY_THROW, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                 else if (data.speed() > 0.6) {
                        context.player().level().playSound(bike, bike.blockPosition(), SoundEvents.BOAT_PADDLE_LAND, SoundSource.PLAYERS, 0.25F, (bike.getRandom().nextFloat() - bike.getRandom().nextFloat()) * 0.2F + 1.0F);
                        sl.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, bike.getX(), bike.getY(), bike.getZ(), 10, 0, 0, 0, 0);
                    }
                }
                }
            }
        }
    }

    public static void handleAttributeChange(final AttributeChangePayload data, final IPayloadContext context) {
        if (context.player().level().getPlayerByUUID(UUID.fromString(data.id())) != null) {
            if (context.player().getStringUUID().equals(data.id())) {
                PacketDistributor.sendToAllPlayers(new AttributeChangeClientPayload(data.id(), data.attributeName(), data.valueChange()));
            }
        }
    }

    public static void handleBeltKeyPress(final BeltKeyPayload data, final IPayloadContext context) {
        Player player = context.player();
        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
            if (belt.hasInventory && player.getItemBySlot(EquipmentSlot.FEET).getDamageValue() != player.getItemBySlot(EquipmentSlot.FEET).getMaxDamage() - 1) {
                belt.openInventory((ServerPlayer) player, player.getUsedItemHand(), player.getItemBySlot(EquipmentSlot.FEET));
            }
        }
    }

    public static void handleAbilityKeyPress(final AbilityKeyPayload data, final IPayloadContext context) {
        Player player = context.player();
        switch (data.key()) {
            case 1:
                player.getAttribute(Attributes.HELD_ABILITY_KEY_ONE).setBaseValue(1);
                break;
            case 2:
                player.getAttribute(Attributes.HELD_ABILITY_KEY_TWO).setBaseValue(1);
                break;
            case 3:
                player.getAttribute(Attributes.HELD_ABILITY_KEY_ONE).setBaseValue(0);
                return;
            case 4:
                player.getAttribute(Attributes.HELD_ABILITY_KEY_TWO).setBaseValue(0);
                return;
        }

        boolean costMeter = (!player.isCreative()) && (!(player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) || !driverItem.isTransformed(player) || !driverItem.riderName.toLowerCase().contains("ohma"));
        if (!player.level().isClientSide() && player.getData(USED_ABILITY).isEmpty() && player.getData(ABILITY_COOLDOWN) < 1 && (player.getAttribute(Attributes.ABILITY_METER).getValue() > 0) || !costMeter) {
            var abilityList = AbilityUtil.getAbility(player, data.key());
            if (!abilityList.isEmpty()) {
                String ability = abilityList.getFirst().toLowerCase().substring(1);
                AbilityUtil.calculateAbility(player, ability);
            }
        }
    }

    public static void handleClimbing(final ClimbCollisionPayload data, final IPayloadContext context) {
        if (context.player().level().getPlayerByUUID(UUID.fromString(data.id())) instanceof LivingEntity entity) {
            Vec3 initialVec = entity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.1D * (entity.getAttribute(Attributes.CLIMBING).getValue()), initialVec.z);
            entity.setDeltaMovement(climbVec.scale(0.97D));
            entity.hurtMarked = true;
        }
    }

    // Decade Complete summon swing mimicry
    public static void handleCompleteSwing(final CompleteSwingPayload data, final IPayloadContext context) {
        Player player = context.player();
        int hand = data.hand();
        for (CompleteSummonEntity complete : player.level().getEntitiesOfClass(CompleteSummonEntity.class, player.getBoundingBox().inflate(10), entity -> (entity.getOwner() == player))) {
            complete.mimicSwing(player, hand == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
        for (LegendarySummonEntity legend : player.level().getEntitiesOfClass(LegendarySummonEntity.class, player.getBoundingBox().inflate(10), entity -> (entity.getOwner() == player && entity.getTarget() == null))) {
            legend.mimicSwing(player, hand == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
        }
    }
}