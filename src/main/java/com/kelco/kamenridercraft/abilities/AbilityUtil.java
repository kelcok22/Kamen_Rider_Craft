package com.kelco.kamenridercraft.abilities;

import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.EndAttackAnimationPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.Comparator;

import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.getFormItem;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.*;

public class AbilityUtil {
    public static void cancelAbility(LivingEntity user) {
        if (!user.level().isClientSide()) {
            user.setData(USED_ABILITY, "");
            user.setData(ABILITY_TICK, 0);
            user.setInvulnerable(false);
            PacketDistributor.sendToAllPlayers(new EndAttackAnimationPayload(user.getStringUUID()));
        }
    }

    public static void calculateAbility(LivingEntity user, String ability) {
        if (!user.level().isClientSide() && user.getData(ABILITY_TICK) == 0 && user.getData(ABILITY_COOLDOWN) == 0) {
            AttributeInstance abilityMeter = user.getAttribute(Attributes.ABILITY_METER);
            boolean costMeter = (!(user instanceof Player player) || !player.isCreative()) && (!(user.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) || !driverItem.isTransformed(user) || !driverItem.Rider.toLowerCase().contains("ohma"));
            switch (ability) {
                case "rider_punch":
                    if (!user.isFallFlying()) {
                        if (costMeter && abilityMeter.getValue() >= 100) {
                            abilityMeter.setBaseValue(abilityMeter.getValue() - 100);
                            user.setData(USED_ABILITY, "rider_punch");
                        } else if (!costMeter) {
                            user.setData(USED_ABILITY, "rider_punch");
                        }
                    }
                    break;
                case "tojima_punch":
                    if (!user.isFallFlying()) {
                        if (costMeter && abilityMeter.getValue() >= 100) {
                            abilityMeter.setBaseValue(abilityMeter.getValue() - 100);
                            user.setData(USED_ABILITY, "tojima_punch");
                        } else if (!costMeter) {
                            user.setData(USED_ABILITY, "tojima_punch");
                        }
                    }
                    break;
                case "rider_kick":
                    if (!user.isFallFlying()) {
                        if (costMeter && abilityMeter.getValue() >= 150) {
                            abilityMeter.setBaseValue(abilityMeter.getValue() - 150);
                            user.setData(USED_ABILITY, "rider_kick");
                        } else if (!costMeter) {
                            user.setData(USED_ABILITY, "rider_kick");
                        }
                    }
                    break;
                case "flight_boost":
                    if (costMeter && abilityMeter.getValue() >= 30) {
                        abilityMeter.setBaseValue(abilityMeter.getValue() - 30);
                        user.setData(USED_ABILITY, "flight_boost");
                    } else if (!costMeter) {
                        user.setData(USED_ABILITY, "flight_boost");
                    }
                    break;
                case "clock_up":
                    if (costMeter && abilityMeter.getValue() >= 100) {
                        abilityMeter.setBaseValue(abilityMeter.getValue() - 100);
                        user.setData(USED_ABILITY, "clock_up");
                    } else if (!costMeter) {
                        user.setData(USED_ABILITY, "clock_up");
                    }
                    break;
            }
        }
    }


    public static void useAbility(LivingEntity user) {
        if (!user.level().isClientSide()) {
            switch (user.getData(USED_ABILITY).toLowerCase()) {
                case "rider_punch":
                    RiderPunch.genericRiderPunch(user);
                    break;
                case "tojima_punch":
                    RiderPunch.tojimaPunch(user);
                    break;
                case "rider_kick":
                    RiderKick.genericRiderKick(user);
                    break;
                case "flight_boost":
                    MiscAbilities.flightBoost(user);
                    break;
                case "clock_up":
                    MiscAbilities.clockUp(user);
                    break;
            }
        }
    }

    public static ArrayList<String> getAbility(LivingEntity user, int abilitySlot) {
        ArrayList<String> returnedAbility = new ArrayList<String>();
        if (!user.level().isClientSide()) {
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
        }
        return returnedAbility;
    }
}