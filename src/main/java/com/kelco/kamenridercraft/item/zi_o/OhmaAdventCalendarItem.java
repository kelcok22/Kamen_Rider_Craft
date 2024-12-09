package com.kelco.kamenridercraft.item.zi_o;


import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import com.kelco.kamenridercraft.item.Zi_O_Rider_Items;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;

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
            if (!(transformed && player.isShiftKeyDown() && RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Zi_O_Rider_Items.ZI_O_TRINITY_RIDEWATCH.get()))
                player.sendSystemMessage(transformed && RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1) == Zi_O_Rider_Items.GEIZ_MAJESTY_RIDEWATCH.get() ?
                                        Component.translatable("message.kamenridercraft.iwae_2") : Component.translatable("message.kamenridercraft.iwae"));
            if (transformed) {
                RiderFormChangeItem form = RiderDriverItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), 1);
                if (belt == Zi_O_Rider_Items.ZIKU_DRIVER_ZI_O.get()) {
                    if (form == Zi_O_Rider_Items.ZI_O_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o"));
                        if (player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_2"));
                    } else if (form == Zi_O_Rider_Items.ZI_O_II_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ii"));
                        if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ii_2"));
                    } else if (form == Zi_O_Rider_Items.ZI_O_TRINITY_RIDEWATCH.get()) {
                        player.sendSystemMessage(player.isShiftKeyDown() ? Component.translatable("message.kamenridercraft.zi_o_trinity_2") : Component.translatable("message.kamenridercraft.zi_o_trinity"));
                    } else if (form == Zi_O_Rider_Items.GRAND_ZI_O_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.grand_zi_o"));
                    } else if (form == Zi_O_Rider_Items.OHMA_ZI_O_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ohma_form"));
                    } else if (form == Zi_O_Rider_Items.BUILD_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_build"));
                        if (player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_build_2"));
                    } else {
                         if (form == Zi_O_Rider_Items.EX_AID_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ex_aid"));
                         else if (form == Zi_O_Rider_Items.GHOST_RIDEWATCH_ZI_O.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ghost"));
                         else if (form == Zi_O_Rider_Items.GAIM_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_gaim"));
                         else if (form == Zi_O_Rider_Items.WIZARD_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_wizard"));
                         else if (form == Zi_O_Rider_Items.FOURZE_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_fourze"));
                         else if (form == Zi_O_Rider_Items.OOO_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ooo"));
                         else if (form == Zi_O_Rider_Items.W_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_w"));
                         else if (form == Zi_O_Rider_Items.KIVA_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_kiva"));
                         else if (form == Zi_O_Rider_Items.DEN_O_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_den_o"));
                         else if (form == Zi_O_Rider_Items.KABUTO_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_kabuto"));
                         else if (form == Zi_O_Rider_Items.HIBIKI_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_hibiki"));
                         else if (form == Zi_O_Rider_Items.BLADE_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_blade"));
                         else if (form == Zi_O_Rider_Items.RYUKI_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_ryuki"));
                         else if (form == Zi_O_Rider_Items.AGITO_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_agito"));
                         else if (form == Zi_O_Rider_Items.KUUGA_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_kuuga"));
                         else if (form == Zi_O_Rider_Items.DECADE_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade"));
                         else if (form == Zi_O_Rider_Items.DECADE_BUILD_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_build"));
                         else if (form == Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_L.get()||form == Zi_O_Rider_Items.DECADE_EX_AID_RIDEWATCH_R.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_ex_aid"));
                         else if (form == Zi_O_Rider_Items.DECADE_GHOST_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_ghost"));
                         else if (form == Zi_O_Rider_Items.DECADE_OOO_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_ooo"));
                         else if (form == Zi_O_Rider_Items.DECADE_FAIZ_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_faiz"));
                         else if (form == Zi_O_Rider_Items.DECADE_RYUKI_RIDEWATCH.get()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_decade_ryuki"));
                        if (player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.zi_o_rider_2"));
                    }
                } else if (belt == Zi_O_Rider_Items.ZIKU_DRIVER_GEIZ.get()) {
                    if (form == Zi_O_Rider_Items.GEIZ_REVIVE_RIDEWATCH.get() || form == Zi_O_Rider_Items.GEIZ_REVIVE_SHIPPU_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.geiz_revive"));
                        if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.geiz_revive_2"));
                    } else if (form == Zi_O_Rider_Items.GEIZ_MAJESTY_RIDEWATCH.get()) {
                        player.sendSystemMessage(Component.translatable("message.kamenridercraft.geiz_majesty"));
                        if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.geiz_majesty_2"));
                    }
                //} else if (belt == Zi_O_Rider_Items.OHMA_ZIKU_DRIVER.get()) {
                //    player.sendSystemMessage(Component.translatable("message.kamenridercraft.ohma_zi_o"));
                //    if (!player.isShiftKeyDown()) player.sendSystemMessage(Component.translatable("message.kamenridercraft.ohma_zi_o_2"));
                } else if (belt == Zero_One_Rider_Items.HIDEN_ZERO_ONE_DRIVER.get()) {
                    player.sendSystemMessage(Component.translatable("message.kamenridercraft.zero_one"));
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}