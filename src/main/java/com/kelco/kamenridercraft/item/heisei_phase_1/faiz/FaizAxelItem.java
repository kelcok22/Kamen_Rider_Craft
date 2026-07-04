package com.kelco.kamenridercraft.item.heisei_phase_1.faiz;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.FaizRiderItems;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class FaizAxelItem extends BaseItem {
    public FaizAxelItem(Properties properties) {
        super(properties);
    }

    public void startCooldown(Player player) {
        if (!player.isCreative()) {
            player.getCooldowns().addCooldown(this, 1400);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        Item driverItem = player.getItemBySlot(EquipmentSlot.FEET).getItem();

        if (!level.isClientSide() && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RiderDriverItem belt) {
            if (driverItem == FaizRiderItems.FAIZ_DRIVER.get()) {
                FaizRiderItems.FAIZ_AXEL_FORM.asItem().use(level, player, usedHand);
                startCooldown(player);
            } else if (driverItem == FaizRiderItems.FAIZ_DRIVER_NEXT.get()) {
                FaizRiderItems.NEXT_FAIZ_AXEL_MISSION_MEMORY.asItem().use(level, player, usedHand);
                startCooldown(player);
            } else if (driverItem == FaizRiderItems.NEXT_KAIXA_DRIVER.get()) {
                FaizRiderItems.NEXT_KAIXA_AXEL_MISSION_MEMORY.asItem().use(level, player, usedHand);
                startCooldown(player);
            } else if (driverItem == FaizRiderItems.DELTA_DRIVER.get() && belt.isTransformed(player)) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 5, true, false));
                startCooldown(player);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}