package com.kelco.kamenridercraft.item.reiwa.geats;

import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.item.reiwa.GeatsRiderItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class LaserRaiseRiserItem extends BaseBlasterItem {

    public LaserRaiseRiserItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, Atk, Spd, prop);
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
        super.releaseUsing(stack, level, livingEntity, timeLeft);
        if (livingEntity instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
            if (player.getOffhandItem().getItem() == GeatsRiderItems.KEKERA_RAISE_RISER_CARD.get() || player.getOffhandItem().getItem() == GeatsRiderItems.KEKERA_BLACK_RAISE_RISER_CARD.get()) {
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(GeatsRiderItems.RAISE_RISER_BELT_KEKERA.get(), 1));
                player.getOffhandItem().use(level, player, InteractionHand.OFF_HAND);
            } else if (player.getOffhandItem().getItem() == GeatsRiderItems.KYUUN_RAISE_RISER_CARD.get())
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(GeatsRiderItems.RAISE_RISER_BELT_KYUUN.get(), 1));
            else if (player.getOffhandItem().getItem() == GeatsRiderItems.BEROBA_RAISE_RISER_CARD.get() || player.getOffhandItem().getItem() == GeatsRiderItems.BEROBA_BLACK_RAISE_RISER_CARD.get()) {
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(GeatsRiderItems.RAISE_RISER_BELT_BEROBA.get(), 1));
                player.getOffhandItem().use(level, player, InteractionHand.OFF_HAND);
            } else
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(GeatsRiderItems.RAISE_RISER_BELT_ZIIN.get(), 1));
        }
    }
}