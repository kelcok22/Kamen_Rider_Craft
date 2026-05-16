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
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypeRegistry.*;

@Mixin(value = LivingEntity.class, priority = 899)
public class LivingEntityMixin {
    int oldBlockX = ((LivingEntity) (Object) this).getBlockX();
    int oldBlockZ = ((LivingEntity) (Object) this).getBlockZ();

    @Inject(method = "tick", at = @At("TAIL"))
    public void post_Tick(CallbackInfo ci) {
        var rider = ((LivingEntity) (Object) this);
        if (rider.getData(IS_POSING)  && ((LivingEntity) (Object) this).level() instanceof ServerLevel) {
            if (!canPose(rider) || this.oldBlockX != rider.getBlockX() || this.oldBlockZ != rider.getBlockZ()) {
                System.out.println("CANCELED! The rider is_posing: " + rider.getData(IS_POSING));
                stopPosing(rider);
            }
        } else if (rider.getData(POSE_COOLDOWN) > 0 && ((LivingEntity) (Object) this).level() instanceof ServerLevel) {
            rider.setData(POSE_COOLDOWN, rider.getData(POSE_COOLDOWN) - 1);
        }
        this.oldBlockX = rider.getBlockX();
        this.oldBlockZ = rider.getBlockZ();


        if (rider instanceof LivingEntity player ) {

            if (player.level().isClientSide) {
                float X = 0;
                float Y = 0;
                float Z = 0;
                boolean isPlayer = false;
                if (player instanceof Player) {

                    X = player.xxa;
                    Y = player.yya;
                    Z = player.zza;
                    if ( Minecraft.getInstance().player != null)isPlayer = Minecraft.getInstance().player.is(player);
                } else if (player instanceof Mob mob) {
                    if (player.getDeltaMovement().x != 0 || player.getDeltaMovement().z != 0) {
                        X = mob.getViewXRot(1);
                        Vec3 look = player.getLookAngle();
                        if (look.x > 0 & player.getDeltaMovement().x > 0) Z = 1;
                        else if (look.z > 0 & player.getDeltaMovement().z > 0) Z = 1;
                        else if (look.x < 0 & player.getDeltaMovement().x < 0) Z = 1;
                        else if (look.z < 0 & player.getDeltaMovement().z < 0) Z = 1;
                        else Z = -1;
                    }
                }

                 if (isPlayer||player instanceof Mob) {

                     if (rider instanceof Player pl && (pl.getAbilities().flying || player.isFallFlying())){
                         rider.setData(WINGS_OUT, true);
                         PacketDistributor.sendToServer(new AttributeChangePayload(player.getStringUUID(), "wing_out", 1.0));
                     }else{
                         rider.setData(WINGS_OUT, false);
                         PacketDistributor.sendToServer(new AttributeChangePayload(player.getStringUUID(), "wing_out", (double) 0));
                     }

                     player.getAttribute(AttributeRegistry.BALL_ROT_OLD).setBaseValue(player.getAttribute(AttributeRegistry.BALL_ROT).getBaseValue());
                     player.getAttribute(AttributeRegistry.WHEEL_ROT_OLD).setBaseValue(player.getAttribute(AttributeRegistry.WHEEL_ROT).getBaseValue());
                     player.getAttribute(AttributeRegistry.CAPE_ROT_OLD).setBaseValue(player.getAttribute(AttributeRegistry.CAPE_ROT).getBaseValue());

                if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {

                    if (belt.HasCpae(player.getItemBySlot(EquipmentSlot.FEET))) {

                        float cape = (float) player.getAttribute(AttributeRegistry.CAPE_ROT).getBaseValue();
                        float ball = 0;
                        if (Z > 0 & cape > -0.7 & !player.isSwimming())
                            cape = cape - 0.01f - (player.getSpeed() / 10);
                        else if (X == 0 & Z < 0 & cape < 0) cape = cape + 0.2f;
                        else if (X == 0 & Z == 0 & cape < 0 & X == 0 || X == 0 & Z == 0 & cape < -0.7 || X == 0 & cape < 0 & player.isSwimming())
                            cape = cape + 0.02f;
                        if (X > 0) {
                            ball = 0.2f;
                            if (isPlayer & Z == 0 & cape > -0.7) cape = cape - 0.02f - (player.getSpeed() / 10);
                        }
                        if (X < 0) {
                            ball = -0.2f;
                            if (isPlayer & Z == 0 & cape > -0.7) cape = cape - 0.02f - (player.getSpeed() / 10);
                        }
                        if (player.fallDistance > 0 & !player.isSwimming() & cape > -2.5) cape = cape - 0.05f;

                        player.getAttribute(AttributeRegistry.BALL_ROT).setBaseValue(ball);
                        player.getAttribute(AttributeRegistry.CAPE_ROT).setBaseValue(cape);

                        PacketDistributor.sendToServer(new AttributeChangePayload(player.getStringUUID(), "ball_rot", player.getAttribute(AttributeRegistry.BALL_ROT).getBaseValue()));
                        PacketDistributor.sendToServer(new AttributeChangePayload(player.getStringUUID(), "cape_rot", player.getAttribute(AttributeRegistry.CAPE_ROT).getBaseValue()));
                    }
                    if (RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1).get_is_Bike()) {
                        float wheel = 0;
                        if (Z > 0) wheel = -0.1f;
                        if (Z < 0) wheel = 0.1f;
                        player.getAttribute(AttributeRegistry.WHEEL_ROT).setBaseValue(player.getAttribute(AttributeRegistry.WHEEL_ROT).getBaseValue() + wheel);
                        PacketDistributor.sendToServer(new AttributeChangePayload(player.getStringUUID(), "wheel_rot", player.getAttribute(AttributeRegistry.WHEEL_ROT).getBaseValue()));
                        float ball = 0;
                        if (X > 0) {
                            ball = 0.5f;
                            if (Z == 0) wheel = -0.1f;
                        }
                        if (X < 0) {
                            ball = -0.5f;
                            if (Z == 0) wheel = -0.1f;
                        }
                        player.getAttribute(AttributeRegistry.BALL_ROT).setBaseValue(ball);
                        PacketDistributor.sendToServer(new AttributeChangePayload(player.getStringUUID(), "ball_rot", (double) ball));

                        player.getAttribute(AttributeRegistry.WHEEL_ROT).setBaseValue(player.getAttribute(AttributeRegistry.WHEEL_ROT).getBaseValue() + wheel);
                        PacketDistributor.sendToServer(new AttributeChangePayload(player.getStringUUID(), "wheel_rot", player.getAttribute(AttributeRegistry.WHEEL_ROT).getBaseValue()));
                    }
                    }
                }
            }
        }
    }
}
