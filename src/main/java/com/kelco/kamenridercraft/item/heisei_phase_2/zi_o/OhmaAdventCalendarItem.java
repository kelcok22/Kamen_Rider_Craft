package com.kelco.kamenridercraft.item.heisei_phase_2.zi_o;


import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.ZiORiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OhmaAdventCalendarItem extends BaseItem {

    public OhmaAdventCalendarItem(Properties prop) {
        super(prop);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        Item belt = player.getItemBySlot(EquipmentSlot.FEET).getItem();
        boolean transformed = belt instanceof RiderDriverItem driver && driver.isTransformed(player);

        if(!level.isClientSide()) {
            if (!(transformed && player.isShiftKeyDown() && RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ZiORiderItems.ZI_O_TRINITY_RIDEWATCH.get()))
                player.sendSystemMessage(transformed && RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1) == ZiORiderItems.GEIZ_MAJESTY_RIDEWATCH.get() ?
                                        Component.translatable("message.kamenridercraft.iwae_2") : Component.translatable("message.kamenridercraft.iwae"));
            if (transformed) {
                RiderFormChangeItem form = RiderDriverItem.getFormItem(player.getItemBySlot(EquipmentSlot.FEET), 1);
                if (belt == ZiORiderItems.ZIKU_DRIVER_ZI_O.get()) {
                    if (form == ZiORiderItems.ZI_O_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o"));
                        if (player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_2"));
                    } else if (form == ZiORiderItems.ZI_O_II_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ii"));
                        if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ii_2"));
                    } else if (form == ZiORiderItems.ZI_O_TRINITY_RIDEWATCH.get()) player.sendSystemMessage(player.isShiftKeyDown() ? Component.translatable("message.kamenridercraft.zi_o_trinity_2") : Component.translatable("message.kamenridercraft.zi_o_trinity"));
                    else if (form == ZiORiderItems.GRAND_ZI_O_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.grand_zi_o"));
                    else if (form == ZiORiderItems.OHMA_ZI_O_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ohma_form"));
                    else if (form == ZiORiderItems.BUILD_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_build"));
                        if (player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_build_2"));
                    } else {
                         if (form == ZiORiderItems.EX_AID_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ex_aid"));
                         else if (form == ZiORiderItems.GHOST_RIDEWATCH_ZI_O.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ghost"));
                         else if (form == ZiORiderItems.GAIM_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_gaim"));
                         else if (form == ZiORiderItems.WIZARD_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_wizard"));
                         else if (form == ZiORiderItems.FOURZE_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_fourze"));
                         else if (form == ZiORiderItems.OOO_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ooo"));
                         else if (form == ZiORiderItems.W_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_w"));
                         else if (form == ZiORiderItems.KIVA_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_kiva"));
                         else if (form == ZiORiderItems.DEN_O_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_den_o"));
                         else if (form == ZiORiderItems.KABUTO_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_kabuto"));
                         else if (form == ZiORiderItems.HIBIKI_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_hibiki"));
                         else if (form == ZiORiderItems.BLADE_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_blade"));
                         else if (form == ZiORiderItems.RYUKI_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ryuki"));
                         else if (form == ZiORiderItems.AGITO_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_agito"));
                         else if (form == ZiORiderItems.KUUGA_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_kuuga"));
                         else if (form == ZiORiderItems.DECADE_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade"));
                         else if (form == ZiORiderItems.DECADE_BUILD_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_build"));
                         else if (form == ZiORiderItems.DECADE_EX_AID_RIDEWATCH_L.get()||form == ZiORiderItems.DECADE_EX_AID_RIDEWATCH_R.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_ex_aid"));
                         else if (form == ZiORiderItems.DECADE_GHOST_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_ghost"));
                         else if (form == ZiORiderItems.DECADE_OOO_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_ooo"));
                         else if (form == ZiORiderItems.DECADE_FAIZ_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_faiz"));
                         else if (form == ZiORiderItems.DECADE_RYUKI_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_ryuki"));
                        if (player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_rider_2"));
                    }
                } else if (belt == ZiORiderItems.OHMA_ZI_O_DRIVER.get()) {
                    player.sendSystemMessage(Component.translatable("message.kamenridercraft.ohma_zi_o"));
                    if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.ohma_zi_o_2"));
                } else if (belt == ZiORiderItems.ZIKU_DRIVER_GEIZ.get()) {
                    if (form == ZiORiderItems.GEIZ_REVIVE_RIDEWATCH.get() || form == ZiORiderItems.GEIZ_REVIVE_SHIPPU_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.geiz_revive"));
                        if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.geiz_revive_2"));
                    } else if (form == ZiORiderItems.GEIZ_MAJESTY_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.geiz_majesty"));
                        if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.geiz_majesty_2"));
                    }
                } else if (belt == ZiORiderItems.BEYONDRIVER.get()) {
                    if (form == ZiORiderItems.GINGA_FINALY_MIRIDEWATCH.get() || form == ZiORiderItems.GINGA_TAIYO_MIRIDEWATCH.get() || form == ZiORiderItems.GINGA_MIRIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.wozgingafinaly"));
                    } else {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.woz"));
                        if (player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.woz_2"));
                    }
                //} else if (belt == Zi_O_Rider_Items.OHMA_ZIKU_DRIVER.get()) {
                //    player.sendSystemMessage(Component.translatable("message.kamenridercraft.ohma_zi_o"));
                //    if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.ohma_zi_o_2"));
                } else if (belt == ZeroOneRiderItems.HIDEN_ZERO_ONE_DRIVER.get()) {
                    player.sendSystemMessage(Component.translatable("message.kamenridercraft.zero_one"));
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}