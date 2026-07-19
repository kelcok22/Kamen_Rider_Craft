package com.kelco.kamenridercraft.util;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.EndAnimationPayload;
import com.kelco.kamenridercraft.network.payload.StartPosePayload;
import com.zigythebird.playeranim.animation.PlayerAnimResources;
import com.zigythebird.playeranimcore.animation.Animation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.getFormItem;
import static com.kelco.kamenridercraft.util.MiscUtil.oooComboCheck;
import static com.kelco.kamenridercraft.attachments.AttachmentTypes.*;

public class AnimationUtil {
    public static boolean canPose(LivingEntity poser) {
        return !poser.getItemBySlot(EquipmentSlot.FEET).toString().contains("supersentaicraft") && !poser.isVisuallyCrawling() && !poser.isSleeping() && !poser.isSwimming() && !poser.isPassenger() && !poser.walkAnimation.isMoving() && poser.onGround()
                && !poser.isCrouching() && !poser.onClimbable() && poser.getData(POSE_COOLDOWN) <= 0 &&
                poser.getData(USED_ABILITY).isEmpty();
    }

    public static void playPose(LivingEntity poser, String poseName) {
        if (poser instanceof Player && poser.level() instanceof ServerLevel) {
            PacketDistributor.sendToAllPlayers(new StartPosePayload(poseName.toLowerCase(), poser.getStringUUID()));
            poser.setData(IS_POSING, true);
        }
    }

    public static void stopPosing(LivingEntity poser) {
        if (poser instanceof Player && poser.level() instanceof ServerLevel) {
            poser.setData(IS_POSING, false);
            poser.setData(POSE_COOLDOWN, 20);
            PacketDistributor.sendToAllPlayers(new EndAnimationPayload(poser.getStringUUID(), "pose", false));
        }
    }

    public static void forceStopPosing(LivingEntity poser) {
        if (poser instanceof Player && poser.level() instanceof ServerLevel) {
            poser.setData(IS_POSING, false);
            poser.setData(POSE_COOLDOWN, 20);
            PacketDistributor.sendToAllPlayers(new EndAnimationPayload(poser.getStringUUID(), "pose", true));
        }
    }

    public static @Nullable Animation getAnim(String poseName) {
        return PlayerAnimResources.getAnimation(ResourceLocation.fromNamespaceAndPath(MOD_ID, poseName.toLowerCase()));
    }

    public static String getAnimRiderName(RiderDriverItem driverItem) {
        String riderName = driverItem.riderName.toLowerCase();
        return switch (riderName) {
            case "neo_decade", "neo_diend" -> riderName.replace("neo_", "");
            case "fake_ichigo", "fake_x", "fake_v3", "fake_skyrider", "fake_blade", "fake_drive" ->
                    riderName.replace("fake_", "");
            case "dark_ichigo", "dark_nigo", "dark_v3", "dark_riderman", "dark_x", "dark_amazon", "dark_stronger" ->
                    riderName.replace("dark_", "");
            case "robot_super_1" -> "super_1";
            case "powered_up_core" -> "core";
            case "eins", "sango" -> "ichigo";
            default -> riderName;
        };
    }

    public static @Nullable Animation getMaskPose(LivingEntity posingRider) {
        String helmet = posingRider.getItemBySlot(EquipmentSlot.HEAD).getItem().toString();
        return switch (helmet) {
            case "kamenridercraft:ferbus" -> getAnim("ferbus.dance");
            case "kamenridercraft:ichigo_mask" -> getAnim("tojima.pose");
            case "kamenridercraft:v3_mask" -> getAnim("ichiyo.pose");
            case "kamenridercraft:riderman_helmet" -> getAnim("mitsuba.pose");
            default -> null;
        };
    }

    public static @Nullable Animation oooAnimCheck(LivingEntity posingRider) {
        ItemStack belt = posingRider.getItemBySlot(EquipmentSlot.FEET);
        String medalOne = getFormItem(belt, 1).toString();
        String medalTwo = getFormItem(belt, 2).toString();
        String medalThree = getFormItem(belt, 3).toString();

        String pose = oooComboCheck(medalOne, medalTwo, medalThree);
        if (pose.isEmpty()) {
            pose = "pose";
        } else if (pose.contains("eternity")) {
            pose = "tajadol.pose";
        } else {
            pose = pose + ".pose";
        }
        return getAnim("ooo." + pose);
    }
}
