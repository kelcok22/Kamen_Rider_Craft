package com.kelco.kamenridercraft.mixin.livingentity;

import com.kelco.kamenridercraft.abilities.AbilityUtil;
import com.kelco.kamenridercraft.entity.vehicles.baseBikeEntity;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.EndAnimationPayload;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.kelco.kamenridercraft.util.AnimationUtil.canPose;
import static com.kelco.kamenridercraft.util.AnimationUtil.stopPosing;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.*;

@Mixin(value = LivingEntity.class, priority = 899)
public class LivingEntityMixin {
    int oldBlockX = ((LivingEntity) (Object) this).getBlockX();
    int oldBlockZ = ((LivingEntity) (Object) this).getBlockZ();
    boolean wasSitting = false;

    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        var rider = ((LivingEntity) (Object) this);

        if (rider instanceof Player) {
            if (this.wasSitting && rider.getControlledVehicle() == null) {
                PacketDistributor.sendToAllPlayers(new EndAnimationPayload(rider.getStringUUID(), "position"));
            }
            this.wasSitting = rider.getControlledVehicle() != null;
        }

        if (!(rider instanceof ArmorStand) && !rider.level().isClientSide()) {
            if (rider.getData(USED_ABILITY).isEmpty() && rider.getData(ABILITY_COOLDOWN) > 0) {
                rider.setData(ABILITY_COOLDOWN, rider.getData(ABILITY_COOLDOWN) - 1);
            }
            if (rider.getData(IS_POSING)) {
                if (!canPose(rider) || this.oldBlockX != rider.getBlockX() || this.oldBlockZ != rider.getBlockZ()) {
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
                PacketDistributor.sendToAllPlayers(new EndAnimationPayload(rider.getStringUUID(), "attack"));
            } else {
                rider.setData(DELAY_ANIMATION_END_TICKS, rider.getData(DELAY_ANIMATION_END_TICKS) - 1);
            }
        }

        this.oldBlockX = rider.getBlockX();
        this.oldBlockZ = rider.getBlockZ();

        if (!(rider instanceof Player)) {
            if (rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                belt.beltTick(rider.getItemBySlot(EquipmentSlot.FEET), rider.level(), rider, 36);
                belt.giveEffects(rider);
            }
        }
    }
}
