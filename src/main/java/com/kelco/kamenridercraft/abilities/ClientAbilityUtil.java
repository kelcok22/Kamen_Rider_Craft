package com.kelco.kamenridercraft.abilities;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationFactory;
import com.zigythebird.playeranimcore.enums.PlayState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import java.util.ArrayList;
import java.util.Comparator;

import static com.kelco.kamenridercraft.KamenRiderCraftCore.MOD_ID;
import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.getFormItem;

@Mod(value = KamenRiderCraftCore.MOD_ID, dist = Dist.CLIENT)
public class ClientAbilityUtil {
    public static ArrayList<String> clientGetAbility(LivingEntity user, int abilitySlot) {
        ArrayList<String> returnedAbility = new ArrayList<String>();
        ItemStack belt = null;

        if (user.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem && ((RiderDriverItem) user.getItemBySlot(EquipmentSlot.FEET).getItem()).isTransformed(user)) {
            belt = user.getItemBySlot(EquipmentSlot.FEET);
        }
        if (true) {
            if (belt != null) {
                var beltCheck = ((RiderDriverItem) user.getItemBySlot(EquipmentSlot.FEET).getItem());
                switch (abilitySlot) {
                    case 1:
                        if (beltCheck.Num_Base_Form_Item != 1) {
                            for (int n = 0; n < beltCheck.Num_Base_Form_Item - 1; n++) {
                                if (getFormItem(belt, n).getSlotOneAbility().isEmpty()) {
                                    String priority = Integer.toString(RiderDriverItem.getFormItem(belt, 1).getSlotOneAbilityPriotiy());
                                    returnedAbility.add(priority + getFormItem(belt, n).getSlotOneAbility());
                                }
                            }
                        } else {
                            String priority = Integer.toString(RiderDriverItem.getFormItem(belt, 1).getSlotOneAbilityPriotiy());
                            returnedAbility.add(priority + getFormItem(belt, 1).getSlotOneAbility());
                        }
                        break;
                    case 2:
                        if (beltCheck.Num_Base_Form_Item != 1) {
                            for (int n = 0; n < beltCheck.Num_Base_Form_Item - 1; n++) {
                                if (getFormItem(belt, n).getSlotOneAbility().isEmpty()) {
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
                if (returnedAbility.getFirst() != null) {
                    returnedAbility.sort(Comparator.naturalOrder());
                }
                return returnedAbility;
            }
        }
        return returnedAbility;
    }

    public static ResourceLocation returnAbilityIcon (String returnedAbility){
        return switch (returnedAbility) {
            case "rider_punch", "tojima_punch" ->
                    ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/punch.png");
            case "rider_kick","kabuto_kick" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/rider_kick.png");
            case "flight_boost" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/glide.png");
            case "clock_up" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/item/clock_up_pad.png");
            case "grow" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/mob_effect/big.png");
            case "kiva_kick" -> ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/item/wakeupfuestle.png");
            default -> null;
        };
    }
}


