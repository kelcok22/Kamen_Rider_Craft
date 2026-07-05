package com.kelco.kamenridercraft.item.heisei_phase_2.gaim;


import com.kelco.kamenridercraft.item.base_items.BaseItem;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class RouletteLockseedItem extends BaseItem {
    public RouletteLockseedItem(Properties properties) {
        super(properties);
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);

        if (!level.isClientSide()) {
            Random generator = new Random();
            int rand = generator.nextInt(6);

            player.getCooldowns().addCooldown(this, 100);
            player.sendSystemMessage(Component.literal(Component.translatable("message.kamenridercraft.roulette").getString() + (rand + 1)));
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}