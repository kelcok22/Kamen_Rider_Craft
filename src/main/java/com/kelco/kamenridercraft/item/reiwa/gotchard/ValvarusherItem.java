package com.kelco.kamenridercraft.item.reiwa.gotchard;

import com.kelco.kamenridercraft.item.base_items.BaseBlasterItem;
import com.kelco.kamenridercraft.item.reiwa.GotchardRiderItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ValvarusherItem extends BaseBlasterItem {

    public ValvarusherItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(toolTier, Atk, Spd, prop);
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeLeft) {
        super.releaseUsing(stack, level, livingEntity, timeLeft);
        if (livingEntity instanceof Player player && player.getItemBySlot(EquipmentSlot.FEET) == ItemStack.EMPTY) {
            if (player.getOffhandItem().getItem() == GotchardRiderItems.MADWHEEL_REPLI_CHEMY_CARD.get())
                player.setItemSlot(EquipmentSlot.FEET, new ItemStack(GotchardRiderItems.VALVARADRAW_BUCKLE_LACHESIS.get(), 1));
            else player.setItemSlot(EquipmentSlot.FEET, new ItemStack(GotchardRiderItems.VALVARADRAW_BUCKLE.get(), 1));
        }
    }
}