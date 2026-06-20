package com.kelco.kamenridercraft.abilities;

import com.kelco.kamenridercraft.abilities.kicks.GenericRiderKicks;
import com.kelco.kamenridercraft.abilities.kicks.KabutoRiderKicks;
import com.kelco.kamenridercraft.abilities.kicks.KivaRiderKicks;
import com.kelco.kamenridercraft.abilities.kicks.WizardRiderKicks;
import com.kelco.kamenridercraft.abilities.misc_abilities.MiscAbilities;
import com.kelco.kamenridercraft.abilities.punches.GenericRiderPunches;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.network.payload.AttackAnimPayload;
import com.kelco.kamenridercraft.network.payload.EndAttackAnimationPayload;
import com.kelco.kamenridercraft.world.attribute.Attributes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.Comparator;

import static com.kelco.kamenridercraft.item.base_items.RiderDriverItem.getFormItem;
import static com.kelco.kamenridercraft.world.attribute.Attributes.CHANGE_KICK_MODEL;
import static com.kelco.kamenridercraft.world.data_attachments.AttachmentTypes.*;

public class AbilityUtil {
    public static void calculateAbility(LivingEntity user, String ability) {
        if (!user.level().isClientSide() && user.getData(ABILITY_TICK) == 0 && user.getData(ABILITY_COOLDOWN) == 0 && !user.isSleeping()) {
            AttributeInstance abilityMeter = user.getAttribute(Attributes.ABILITY_METER);
            boolean costMeter = (!(user instanceof Player player) || !player.isCreative()) && (!(user.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem driverItem) || !driverItem.isTransformed(user) || !driverItem.Rider.toLowerCase().contains("ohma"));
            switch (ability) {
                case "rider_punch", "ground_rider_punch":
                    if (!user.isFallFlying()) {
                        if (costMeter && abilityMeter.getValue() >= 100) {
                            abilityMeter.setBaseValue(abilityMeter.getValue() - 100);
                            user.setData(USED_ABILITY, ability);
                        } else if (!costMeter) {
                            user.setData(USED_ABILITY, ability);
                        }
                    }
                    break;
                case "rider_kick", "kiva_kick", "kabuto_kick", "wizard_kick_flame", "flipped_rider_kick", "special_turbo":
                    if (!user.isFallFlying() && user.onGround() && !user.isInWater()) {
                        if (costMeter && abilityMeter.getValue() >= 150) {
                            abilityMeter.setBaseValue(abilityMeter.getValue() - 150);
                            user.setData(USED_ABILITY, ability);
                        } else if (!costMeter) {
                            user.setData(USED_ABILITY, ability);
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
                case "clock_up", "grow":
                    if (costMeter && abilityMeter.getValue() >= 100) {
                        abilityMeter.setBaseValue(abilityMeter.getValue() - 100);
                        user.setData(USED_ABILITY, ability);
                    } else if (!costMeter) {
                        user.setData(USED_ABILITY, ability);
                    }
                    break;
            }
        }
    }


    public static void useAbility(LivingEntity user) {
        if (!user.level().isClientSide()) {
            switch (user.getData(USED_ABILITY).toLowerCase()) {
                case "rider_punch":
                    GenericRiderPunches.genericRiderPunch(user);
                    break;
                case "ground_rider_punch":
                    GenericRiderPunches.groundRiderPunch(user);
                    break;
                case "rider_kick", "flipped_rider_kick":
                    GenericRiderKicks.genericRiderKick(user);
                    break;
                case "kabuto_kick":
                    KabutoRiderKicks.kabutoKick(user);
                    break;
                case "kiva_kick":
                    KivaRiderKicks.kivaRiderKick(user);
                    break;
                case "wizard_kick_flame":
                    WizardRiderKicks.flameWizardKick(user);
                    break;
                case "flight_boost":
                    MiscAbilities.flightBoost(user);
                    break;
                case "clock_up":
                    MiscAbilities.clockUp(user);
                    break;
                case "grow":
                    MiscAbilities.grow(user);
                    break;
                case "special_turbo":
                    MiscAbilities.specialTurbo(user);
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

    public static void cancelAbility(LivingEntity user, String afterAnimation, int delayAnimationEndTicks) {
        if (!user.level().isClientSide()) {
            user.setData(USED_ABILITY, "");
            user.setData(ABILITY_TICK, 0);
            user.setInvulnerable(false);
            if (user.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem) {
                user.getAttribute(CHANGE_KICK_MODEL).setBaseValue(0);
            }
            if (delayAnimationEndTicks == 0 && user instanceof Player) {
                PacketDistributor.sendToAllPlayers(new EndAttackAnimationPayload(user.getStringUUID()));
            } else {
                user.setData(DELAY_ANIMATION_END, true);
                user.setData(DELAY_ANIMATION_END_TICKS, delayAnimationEndTicks);
            }
            if (!afterAnimation.isEmpty() && user instanceof Player) {
                PacketDistributor.sendToAllPlayers(new EndAttackAnimationPayload(user.getStringUUID()));
                PacketDistributor.sendToAllPlayers(new AttackAnimPayload(afterAnimation, user.getStringUUID()));
                user.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 2, true, false));
            }
        }
    }
}