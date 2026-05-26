package com.kelco.kamenridercraft.mixin.livingentity;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.AttributeChangePayload;
import com.kelco.kamenridercraft.world.attribute.AttributeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.kelco.kamenridercraft.util.AnimationUtil.canPose;
import static com.kelco.kamenridercraft.util.AnimationUtil.stopPosing;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypeRegistry.IS_POSING;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypeRegistry.POSE_COOLDOWN;

@Mixin(value = LivingEntity.class, priority = 899)
public class LivingEntityMixin {
    int oldBlockX = ((LivingEntity) (Object) this).getBlockX();
    int oldBlockZ = ((LivingEntity) (Object) this).getBlockZ();

    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        var rider = ((LivingEntity) (Object) this);
        if (rider.getData(IS_POSING)  && ((LivingEntity) (Object) this).level() instanceof ServerLevel) {
            if (!canPose(rider) || this.oldBlockX != rider.getBlockX() || this.oldBlockZ != rider.getBlockZ()) {
                stopPosing(rider);
            }
        } else if (rider.getData(POSE_COOLDOWN) > 0 && ((LivingEntity) (Object) this).level() instanceof ServerLevel) {
            rider.setData(POSE_COOLDOWN, rider.getData(POSE_COOLDOWN) - 1);
        }
        this.oldBlockX = rider.getBlockX();
        this.oldBlockZ = rider.getBlockZ();

        if (rider instanceof Player) {
            if (rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                belt.riderKickTick(rider.getItemBySlot(EquipmentSlot.FEET), rider.level(), rider, 36);
            }
        }

        if (!(rider instanceof Player)) {
            if (rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
                belt.beltTick(rider.getItemBySlot(EquipmentSlot.FEET), rider.level(), rider, 36);
                belt.riderKickTick(rider.getItemBySlot(EquipmentSlot.FEET), rider.level(), rider, 36);
                belt.giveEffects(rider);
            }
        }

    }
}
