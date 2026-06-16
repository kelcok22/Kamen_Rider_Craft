package com.kelco.kamenridercraft.item.heisei_phase_1.decade;

import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.DecadeRiderItems;
import com.kelco.kamenridercraft.item.reiwa.ZeroOneRiderItems;
import net.minecraft.network.chat.Component;
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


public class RidePlayerCardItem extends BaseItem {
    public RidePlayerCardItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack CARD = player.getItemInHand(usedHand);
        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!level.isClientSide() && BELT.getItem() == ZeroOneRiderItems.ZEIN_DRIVER.get() && ((RiderDriverItem) BELT.getItem()).isTransformed(player)) {
            CARD.shrink(1);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2, true, true));
            player.displayClientMessage(Component.translatable("attack.kamenridercraft.shikkou"), true);
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.isCreative()) {
                for (Item item : DecadeRiderItems.ZEIN_CARDS)
                    if (!player.getCooldowns().isOnCooldown(item)) player.getCooldowns().addCooldown(item, 60);
                player.getCooldowns().addCooldown(this, 60);
            }

            return InteractionResultHolder.sidedSuccess(player.getItemInHand(usedHand), level.isClientSide());
        }
        return InteractionResultHolder.fail(player.getItemInHand(usedHand));
    }
}