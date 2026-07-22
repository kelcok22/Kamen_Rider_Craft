package com.kelco.kamenridercraft.abilities;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

import java.util.ArrayList;
import java.util.Comparator;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.getFormItem;

@Mod(value = KamenRiderCraftCore.MOD_ID, dist = Dist.CLIENT)
public class ClientAbilityUtil {
    public static ArrayList<String> clientGetAbility(int abilitySlot) {
        ArrayList<String> returnedAbility = new ArrayList<String>();
        ItemStack belt = null;
        Player user = Minecraft.getInstance().player;

        if (user.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem && ((RiderDriverItem) user.getItemBySlot(EquipmentSlot.FEET).getItem()).isTransformed(user)) {
            belt = user.getItemBySlot(EquipmentSlot.FEET);
        }
        if (belt != null) {
            var beltCheck = ((RiderDriverItem) user.getItemBySlot(EquipmentSlot.FEET).getItem());
            switch (abilitySlot) {
                case 2:
                    if (beltCheck.numBaseFormItems != 1) {
                        for (int n = 1; n <= beltCheck.numBaseFormItems; n++) {
                            if (getFormItem(belt, n) != null && getFormItem(belt, n) instanceof RiderFormChangeItem item && !item.getSlotOneAbility().isEmpty()) {
                                String priority = Integer.toString(RiderDriverItem.getFormItem(belt, 1).getSlotOneAbilityPriotiy());
                                returnedAbility.add(priority + getFormItem(belt, n).getSlotOneAbility());
                            }
                        }
                    } else {
                        String priority = Integer.toString(RiderDriverItem.getFormItem(belt, 1).getSlotOneAbilityPriotiy());
                        returnedAbility.add(priority + getFormItem(belt, 1).getSlotOneAbility());
                    }
                    break;
                case 1:
                    if (beltCheck.numBaseFormItems != 1) {
                        for (int n = 1; n <= beltCheck.numBaseFormItems; n++) {
                            if (getFormItem(belt, n) != null && getFormItem(belt, n) instanceof RiderFormChangeItem item && !item.getSlotTwoAbility().isEmpty()) {
                                String priority = Integer.toString(RiderDriverItem.getFormItem(belt, 1).getSlotTwoAbilityPriority());
                                returnedAbility.add(priority + getFormItem(belt, n).getSlotTwoAbility());
                            }
                        }
                    } else {
                        String priority = Integer.toString(RiderDriverItem.getFormItem(belt, 1).getSlotTwoAbilityPriority());
                        returnedAbility.add(priority + getFormItem(belt, 1).getSlotTwoAbility());
                    }
                    break;
            }
            if (!returnedAbility.isEmpty()) {
                returnedAbility.sort(Comparator.naturalOrder());
            }
            return returnedAbility;
        }
        return returnedAbility;
    }

    public static ResourceLocation returnAbilityIcon(String returnedAbility) {
        return switch (returnedAbility) {
            case "rider_punch", "ground_rider_punch" ->
                    ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/punch.png");
            case "rider_kick", "kabuto_kick", "flipped_rider_kick" ->
                    ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/rider_kick.png");
            case "kiva_kick" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/item/wakeupfuestle.png");
            case "wizard_kick_flame" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/item/kick_strike_ring.png");
            case "flight_boost" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/glide.png");
            case "clock_up" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/item/clock_up_pad.png");
            case "special_turbo" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/item/taiyaki_secret_weapon.png");
            case "joker_memory_kick" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/item/joker_memory.png");
            case "wonder_grow", "grow" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/big.png");
            case "wonder_shrink" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/small.png");
            case "gatling" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/gatling.png");
            case "cannon" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/cannon.png");
            case "fish" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/fish.png");
            case "warp" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/warp.png");
            default -> null;
        };
    }
}


