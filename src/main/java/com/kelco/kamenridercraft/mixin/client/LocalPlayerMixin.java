package com.kelco.kamenridercraft.mixin.client;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.AttributeChangePayload;
import com.kelco.kamenridercraft.network.payload.ClimbCollisionPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(value = LocalPlayer.class, priority = 899)
public class LocalPlayerMixin {
    @Inject(method = "isCrouching", at = @At("HEAD"), cancellable = true)
    public void isCrouching(CallbackInfoReturnable<Boolean> cir) {
        var rider = ((LocalPlayer) (Object) this);
        if (rider.getAttribute(Attributes.IS_TRANSFORMING).getValue() > 0) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        var rider = ((LocalPlayer) (Object) this);
        if (rider.horizontalCollision && Objects.requireNonNull(rider.getAttribute(Attributes.CLIMBING)).getValue() != 0) {
            PacketDistributor.sendToServer(new ClimbCollisionPayload(rider.getStringUUID()));
        }

        if (Minecraft.getInstance().level != null && Minecraft.getInstance().level.isClientSide()) {
            float X = rider.xxa;
            float Z = rider.zza;
            if (rider instanceof Player pl && (pl.getAbilities().flying || rider.isFallFlying())) {
                Objects.requireNonNull(rider.getAttribute(Attributes.WINGS_OUT)).setBaseValue(1);
                PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), "wing_out", 1.0));
            } else {
                Objects.requireNonNull(rider.getAttribute(Attributes.WINGS_OUT)).setBaseValue(0);
                PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), "wing_out", (double) 0));
            }

            Objects.requireNonNull(rider.getAttribute(Attributes.BALL_ROT_OLD)).setBaseValue(Objects.requireNonNull(rider.getAttribute(Attributes.BALL_ROT)).getBaseValue());
            Objects.requireNonNull(rider.getAttribute(Attributes.WHEEL_ROT_OLD)).setBaseValue(Objects.requireNonNull(rider.getAttribute(Attributes.WHEEL_ROT)).getBaseValue());
            Objects.requireNonNull(rider.getAttribute(Attributes.CAPE_ROT_OLD)).setBaseValue(Objects.requireNonNull(rider.getAttribute(Attributes.CAPE_ROT)).getBaseValue());

            if (rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {

                if (belt.hasCape(rider.getItemBySlot(EquipmentSlot.FEET))) {

                    float cape = (float) Objects.requireNonNull(rider.getAttribute(Attributes.CAPE_ROT)).getBaseValue();
                    float ball = 0;
                    if (Z > 0 & cape > -0.7 & !rider.isSwimming()) {
                        cape = cape - 0.01f - (rider.getSpeed() / 10);
                    } else if (Z > 0 & cape > -0.7 & !rider.isSwimming()) {
                        cape = 0;
                    } else if (X == 0 & Z < 0 & cape < 0) {
                        cape = cape + 0.2f;
                    } else if (X == 0 & Z == 0 & cape < 0 & X == 0 || X == 0 & Z == 0 & cape < -0.7 || X == 0 & cape < 0 & rider.isSwimming()) {
                        cape = cape + 0.02f;
                    }
                    if (X > 0) {
                        if (Z == 0 & cape > -0.7) {
                            cape = cape - 0.02f - (rider.getSpeed() / 10);
                        }
                    }
                    if (X < 0) {
                        ball = -0.2f;
                        if (Z == 0 & cape > -0.7) {
                            cape = cape - 0.02f - (rider.getSpeed() / 10);
                        }
                    }
                    if (rider.fallDistance > 0 & !rider.isSwimming() & cape > -2) {
                        cape = cape - 0.05f;
                    }

                    Objects.requireNonNull(rider.getAttribute(Attributes.BALL_ROT)).setBaseValue(ball);
                    Objects.requireNonNull(rider.getAttribute(Attributes.CAPE_ROT)).setBaseValue(cape);

                    PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), "ball_rot", Objects.requireNonNull(rider.getAttribute(Attributes.BALL_ROT)).getBaseValue()));
                    PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), "cape_rot", Objects.requireNonNull(rider.getAttribute(Attributes.CAPE_ROT)).getBaseValue()));
                }
                if (RiderDriverItem.getFormItem(rider.getItemBySlot(EquipmentSlot.FEET), 1).getIsBike()) {
                    float wheel = 0;
                    if (Z > 0) {
                        wheel = -0.1f;
                    }
                    if (Z < 0) {
                        wheel = 0.1f;
                    }
                    Objects.requireNonNull(rider.getAttribute(Attributes.WHEEL_ROT)).setBaseValue(Objects.requireNonNull(rider.getAttribute(Attributes.WHEEL_ROT)).getBaseValue() + wheel);
                    PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), "wheel_rot", Objects.requireNonNull(rider.getAttribute(Attributes.WHEEL_ROT)).getBaseValue()));
                    float ball = 0;
                    if (X > 0) {
                        ball = 0.5f;
                        if (Z == 0) {
                            wheel = -0.1f;
                        }
                    }
                    if (X < 0) {
                        ball = -0.5f;
                        if (Z == 0) {
                            wheel = -0.1f;
                        }
                    }
                    Objects.requireNonNull(rider.getAttribute(Attributes.BALL_ROT)).setBaseValue(ball);
                    PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), "ball_rot", (double) ball));

                    Objects.requireNonNull(rider.getAttribute(Attributes.WHEEL_ROT)).setBaseValue(Objects.requireNonNull(rider.getAttribute(Attributes.WHEEL_ROT)).getBaseValue() + wheel);
                    PacketDistributor.sendToServer(new AttributeChangePayload(rider.getStringUUID(), "wheel_rot", Objects.requireNonNull(rider.getAttribute(Attributes.WHEEL_ROT)).getBaseValue()));
                }
            }
        }
    }
}