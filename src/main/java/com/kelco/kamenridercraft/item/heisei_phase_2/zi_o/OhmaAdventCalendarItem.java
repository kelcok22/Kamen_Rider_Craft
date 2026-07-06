package com.kelco.kamenridercraft.item.heisei_phase_2.zi_o;


import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class OhmaAdventCalendarItem extends BaseItem {
    public OhmaAdventCalendarItem(Properties prop) {
        super(prop);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        Item belt = player.getItemBySlot(EquipmentSlot.FEET).getItem();
        boolean transformed = belt instanceof RiderDriverItem driver && driver.isTransformed(player);

        if (!level.isClientSide()) {
            if (!(transformed && player.isShiftKeyDown() && RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ZiORiderItems.ZI_O_TRINITY_RIDEWATCH.get())) {
                player.sendSystemMessage(transformed && RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ZiORiderItems.GEIZ_MAJESTY_RIDEWATCH.get() ? Component.translatable("message.kamenridercraft.iwae_2") : Component.translatable("message.kamenridercraft.iwae"));
            }
            if (transformed) {
                RiderFormChangeItem form = RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1);
                String adventMessage = switch (belt.toString().replace("kamenridercraft:", "")) {
                    case "ziku_driver_zi_o" -> {
                        if (form == ZiORiderItems.DECADE_EX_AID_RIDEWATCH_L.get() || form == ZiORiderItems.DECADE_EX_AID_RIDEWATCH_R.get()) {
                            yield "message.kamenridercraft.zi_o_decade_ex_aid";
                        } else if (!form.getFormName(false).isBlank() && !Component.translatable("message.kamenridercraft.zi_o" + form.getFormName(false)).getString().equals("message.kamenridercraft.zi_o" + form.getFormName(false))) {
                            yield "message.kamenridercraft.zi_o" + form.getFormName(false);
                        }
                        yield "message.kamenridercraft.zi_o";
                    }
                    case "ohma_zi_o_driver" -> "message.kamenridercraft.ohma_zi_o";
                    case "ziku_driver_geiz" -> {
                        if (form == ZiORiderItems.GEIZ_REVIVE_RIDEWATCH.get() || form == ZiORiderItems.GEIZ_REVIVE_SHIPPU_RIDEWATCH.get()) {
                            yield "message.kamenridercraft.geiz_revive";
                        } else if (form == ZiORiderItems.GEIZ_MAJESTY_RIDEWATCH.get()) {
                            yield "message.kamenridercraft.geiz_majesty";
                        }
                        yield "";
                    }
                    case "beyondriver" -> {
                        if (form == ZiORiderItems.GINGA_FINALY_MIRIDEWATCH.get() || form == ZiORiderItems.GINGA_TAIYO_MIRIDEWATCH.get() || form == ZiORiderItems.GINGA_MIRIDEWATCH.get()) {
                            yield "message.kamenridercraft.wozgingafinaly";
                        }
                        yield "message.kamenridercraft.woz";
                    }
                    case "hiden_zero_one_driver" -> "message.kamenridercraft.zero_one";
                    default -> "";
                };
                if (!adventMessage.isEmpty() && !Component.translatable(adventMessage).getString().equals(adventMessage)) {
                    player.sendSystemMessage(Component.translatable(adventMessage));
                }

                if (player.isCrouching() && !Component.translatable(adventMessage + "_2").getString().equals(adventMessage + "_2")) {
                    player.sendSystemMessage(Component.translatable(adventMessage + "_2"));
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}