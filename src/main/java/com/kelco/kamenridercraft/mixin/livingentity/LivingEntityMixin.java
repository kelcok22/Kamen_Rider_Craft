package com.kelco.kamenridercraft.mixin.livingentity;

import com.kelco.kamenridercraft.world.attribute.AttributeRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.kelco.kamenridercraft.util.AnimationUtil.canPose;
import static com.kelco.kamenridercraft.util.AnimationUtil.stopPosing;

@Mixin(value = LivingEntity.class, priority = 899)
public class LivingEntityMixin {
    int oldBlockX = ((LivingEntity) (Object) this).getBlockX();
    int oldBlockZ = ((LivingEntity) (Object) this).getBlockZ();

    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        var rider = ((LivingEntity) (Object) this);
        if (rider.getAttribute(AttributeRegistry.POSING).getValue() == 1 && ((LivingEntity) (Object) this).level() instanceof ServerLevel) {
            if (!canPose(rider) || this.oldBlockX != rider.getBlockX() || this.oldBlockZ != rider.getBlockZ()) {
                stopPosing(rider);
            }
        } else if (rider.getAttribute(AttributeRegistry.POSE_COOLDOWN).getValue() > 0) {
            rider.getAttribute(AttributeRegistry.POSE_COOLDOWN).setBaseValue(rider.getAttribute(AttributeRegistry.POSE_COOLDOWN) .getBaseValue()- 1);
        }
        this.oldBlockX = rider.getBlockX();
        this.oldBlockZ = rider.getBlockZ();
    }
}
